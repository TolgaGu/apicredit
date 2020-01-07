package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.*;
import fr.idmc.miage.apicredit.exception.DemandeNotFoundException;
import fr.idmc.miage.apicredit.helper.DemandeValidationHelper;
import fr.idmc.miage.apicredit.input.InputDemande;
import fr.idmc.miage.apicredit.repository.ActionRepository;
import fr.idmc.miage.apicredit.repository.DemandeRepository;
import lombok.RequiredArgsConstructor;
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

    private final ActionService actionService;

    private final DemandeValidationHelper demandeValidationHekper;

    public Page<Demande> findAll(Pageable pageable){
        return demandeRepository.findAll(pageable);
    }

    public Demande create(InputDemande demande){
        demandeValidationHekper.validate(demande);
        Demande d = new Demande(demande);
        d = demandeRepository.save(d);
        actionService.addAction(d.getId());
        return d;
    }

    public Optional<Demande> findById(String id) {
        return demandeRepository.findById(id);
    }

    public Page<Demande> findByStatus(String recherche, Pageable pageable) {
        return demandeRepository.findByStatusEquals(recherche,pageable);
    }
    public Demande put(String id, Demande demande) {
        Demande e = demandeRepository.findById(id).orElseThrow(() -> new DemandeNotFoundException(id));
        demande.setId(e.getId());
        return demandeRepository.save(demande);
    }

    public Demande delete(String demandeId, Personne personne) {
        Demande e = demandeRepository.findById(demandeId).orElseThrow(() -> new DemandeNotFoundException(demandeId));
        e.setEtat_demande(EtatDemande.REJET);
        actionService.rejectDemandeAction(demandeId,personne);
        return demandeRepository.save(e);
    }

    /*
    public void updateEtatDemande(String idDemande){
        Demande e = demandeRepository.findById(idDemande).orElseThrow(() -> new DemandeNotFoundException(idDemande));
        EtatDemande etatDemande = demandeValidationHekper.getEtatDemandeCorrespondantAEtatAction(e.getEtat_demande());
        e.setEtat_demande(etatDemande);
        demandeRepository.save(e);
    }*/
}
