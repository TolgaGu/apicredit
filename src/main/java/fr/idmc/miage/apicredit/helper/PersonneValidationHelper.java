package fr.idmc.miage.apicredit.helper;

import fr.idmc.miage.apicredit.entity.Personne;
import fr.idmc.miage.apicredit.exception.PersonneValidationException;
import org.springframework.stereotype.Component;

@Component
public class PersonneValidationHelper {
    public void validate(Personne personne){
        if (personne==null)
            throw new PersonneValidationException("Personne ne pa peut être null");
        if (personne.getNom().isBlank())
            throw new PersonneValidationException("Le nom ne peut pas être null");
        if (personne.getPrenom().isBlank())
            throw new PersonneValidationException("Le prenom ne peut pas être null");

    }
}
