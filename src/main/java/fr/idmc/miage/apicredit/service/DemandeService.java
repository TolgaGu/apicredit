package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.EtatDemande;
import fr.idmc.miage.apicredit.helper.DemandeValidationHekper;
import fr.idmc.miage.apicredit.repository.DemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemandeService {
    private final DemandeRepository demandeRepository;
    private final DemandeValidationHekper demandeValidationHekper;
    public Iterable<Demande> findAll(){
        return demandeRepository.findAll();
    }

    public Demande create(Demande demande){
        demandeValidationHekper.validate(demande);
        demande.setEtat_demande(EtatDemande.DEBUT);
        return demandeRepository.save(demande);
    }
}
