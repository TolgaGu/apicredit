package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.Client;
import fr.idmc.miage.apicredit.exception.ClientAuthenticationCreatingException;
import fr.idmc.miage.apicredit.exception.ClientNotFoundException;
import fr.idmc.miage.apicredit.input.InputClient;
import fr.idmc.miage.apicredit.repository.ClientRepository;
import fr.idmc.miage.apicredit.synchronize.SynchronizeDatabase;
import fr.idmc.miage.apicredit.worker.AuthenticationWorker;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Client create(InputClient inputClient) throws ClientAuthenticationCreatingException {

        boolean synchronize =true;
        HttpResponse<String> res=null;
        int status=0;

        if (inputClient.getPrivate_id() == null){
            int length = 25;
            boolean useLetters = true;
            boolean useNumbers = true;
            synchronize=false;
            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
            inputClient.setPrivate_id(generatedString);
            Client client1 = new Client(inputClient);
            res = Unirest.post("http://localhost:9191/user")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer "+ AuthenticationWorker.ACCES_TOKEN)
                    .body("{\"username\": \""+client1.getPrivate_id()+"\",\"password\": \""+inputClient.getPassword()+"\"}")
                    .asString();
            status = res.getStatus();

            if(status!=201){
                throw new ClientAuthenticationCreatingException(res.toString());
            }
        }

        Client client = new Client(inputClient);
        client = clientRepository.save(client);

        if(!synchronize){
            SynchronizeDatabase.syncClient(inputClient);
        }

        return client;
    }

    public Page<Client> findByNomOrPrenom(String recherche, Pageable pageable) {
        return clientRepository.findByNomOrPrenomContains(recherche,pageable);
    }
    public Optional<Client> findById(String id) {
        boolean b = clientRepository.findById(id).isEmpty();
        if (b){
            return clientRepository.findByPrivateId(id);
        }
        return clientRepository.findById(id);
    }
    public Client put(String id, Client client) {
        Client e = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        client.setId(e.getId());
        return clientRepository.save(client);
    }
}
