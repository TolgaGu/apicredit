package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.exception.DemandeNotFoundException;
import fr.idmc.miage.apicredit.exception.PersonneNotFoundException;
import fr.idmc.miage.apicredit.helper.PersonneValidationHelper;
import fr.idmc.miage.apicredit.repository.PersonneRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonneService {

    private PersonneRepository personneRepository;
    private PersonneValidationHelper personneValidationHelper;

    public Page<Personne> findAll(Pageable pageable){
        return personneRepository.findAll(pageable);
    }

    public Personne create(Personne personne){
        personneValidationHelper.validate(personne);
        return personneRepository.save(personne);
    }

    public Optional<Personne> findById(String id) {
        return personneRepository.findById(id);
    }

    public Page<Personne> findByNomOrPrenom(String recherche, Pageable pageable) {
            return personneRepository.findByNomOrPrenomContains(recherche,pageable);
    }

    public Personne put(String id, Personne personne) {
        Personne e = personneRepository.findById(id).orElseThrow(() -> new PersonneNotFoundException(id));
        personne.setId(e.getId());
        return personneRepository.save(personne);
    }
}
