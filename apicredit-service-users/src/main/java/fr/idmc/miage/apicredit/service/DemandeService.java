package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.*;
import fr.idmc.miage.apicredit.exception.ClientAuthenticationCreatingException;
import fr.idmc.miage.apicredit.exception.ClientNotFoundException;
import fr.idmc.miage.apicredit.exception.DemandeNotFoundException;
import fr.idmc.miage.apicredit.exception.DemandeUnauthorizedException;
import fr.idmc.miage.apicredit.helper.DemandeValidationHelper;
import fr.idmc.miage.apicredit.input.InputDemande;
import fr.idmc.miage.apicredit.repository.ClientRepository;
import fr.idmc.miage.apicredit.repository.DemandeRepository;
import fr.idmc.miage.apicredit.synchronize.SynchronizeDatabase;
import fr.idmc.miage.apicredit.worker.AuthenticationWorker;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandeService {

    @Autowired
    private final DemandeRepository demandeRepository;

    @Autowired
    private final ClientRepository clientRepository;

    private final DemandeValidationHelper demandeValidationHekper;

    /*public Page<Demande> findAll(Pageable pageable){
        return demandeRepository.findAll(pageable);
    }*/

    public Demande create(InputDemande demande) {

        Client client = clientRepository.findByPrivateId(demande.getClient()).orElseThrow(() -> new ClientNotFoundException(demande.getClient()));

        boolean synchronize =true;

        if (demande.getPrivate_id() == null){
            int length = 25;
            boolean useLetters = true;
            boolean useNumbers = true;
            synchronize=false;
            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
            demande.setPrivate_id(generatedString);
        }

        demandeValidationHekper.validate(demande);
        Demande d = new Demande(demande);
        d.setEtat_demande(EtatDemande.VERIFICATION_DEMANDE);
        d = demandeRepository.save(d);

        if(!synchronize){
            SynchronizeDatabase.syncDemande(d);
        }
        return d;
    }

    public Optional<Demande> findById(String id, String userid) {

        boolean b = demandeRepository.findById(id).isEmpty();
        Demande d =null;
        if (b){
            d= demandeRepository.findByPrivateId(id).orElseThrow(() -> new DemandeNotFoundException(id));
        }else{
            d=demandeRepository.findById(id).get();
        }

        if (!d.getClient().equals(userid)) {
            throw new DemandeUnauthorizedException("Vous ne possedez pas les droits pour cette demande");
        }
        return demandeRepository.findById(id);
    }

    public Demande put(String id, Demande demande) {
        Demande e = demandeRepository.findByPrivateId(id).orElseThrow(() -> new DemandeNotFoundException(id));
        demande.setId(e.getId());
        return demandeRepository.save(demande);
    }

}
