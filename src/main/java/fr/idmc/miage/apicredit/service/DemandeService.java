package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.EtatDemande;
import fr.idmc.miage.apicredit.exception.DemandeNotFoundException;
import fr.idmc.miage.apicredit.helper.DemandeValidationHelper;
import fr.idmc.miage.apicredit.repository.ActionRepository;
import fr.idmc.miage.apicredit.repository.DemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandeService {

    @Autowired
    private final DemandeRepository demandeRepository;
    private final DemandeValidationHelper demandeValidationHekper;

    public Page<Demande> findAll(Pageable pageable){
        return demandeRepository.findAll(pageable);
    }

    public Demande create(Demande demande){
        demandeValidationHekper.validate(demande);
        return demandeRepository.save(demande);
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


}
