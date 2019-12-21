package fr.idmc.miage.apicredit.helper;

import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.exception.PersonneValidationExcaption;
import org.springframework.stereotype.Component;

@Component
public class PersonneValidationHelper {
    public void validate(Personne personne){
        if (personne==null)
            throw new PersonneValidationExcaption("Personne ne pa peut être null");
        if (personne.getNom().isBlank())
            throw new PersonneValidationExcaption("Le nom ne peut pas être null");
        if (personne.getPrenom().isBlank())
            throw new PersonneValidationExcaption("Le prenom ne peut pas être null");

    }
}
