package fr.idmc.miage.apicredit.service;

import com.google.gson.Gson;
import fr.idmc.miage.apicredit.entity.Client;
import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.exception.ClientAuthenticationCreatingException;
import fr.idmc.miage.apicredit.exception.ClientNotFoundException;
import fr.idmc.miage.apicredit.exception.PersonneNotFoundException;
import fr.idmc.miage.apicredit.input.Account;
import fr.idmc.miage.apicredit.input.InputClient;
import fr.idmc.miage.apicredit.jwt.JwtResponse;
import fr.idmc.miage.apicredit.repository.ClientRepository;
import fr.idmc.miage.apicredit.worker.AuthenticationWorker;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.http.HttpHeaders;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Client create(InputClient inputClient) throws ClientAuthenticationCreatingException {

        Client client = new Client(inputClient);
        client = clientRepository.save(client);

        HttpResponse<String> res = Unirest.post("http://localhost:9191/user")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+ AuthenticationWorker.ACCES_TOKEN)
                .body("{\"username\": \""+client.getId()+"\",\"password\": \""+inputClient.getPassword()+"\"}")
                .asString();

        int status = res.getStatus();

        if(status!=201){
            throw new ClientAuthenticationCreatingException(res.toString());
        }

        return client;
    }

    public Page<Client> findByNomOrPrenom(String recherche, Pageable pageable) {
        return clientRepository.findByNomOrPrenomContains(recherche,pageable);
    }

    public Optional<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    public Client put(String id, Client client) {
        Client e = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        client.setId(e.getId());
        return clientRepository.save(client);
    }
}
