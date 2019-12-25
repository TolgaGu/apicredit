package fr.idmc.miage.apicredit.helper;

import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.exception.DemandeValidationException;
import org.springframework.stereotype.Component;

@Component
public class DemandeValidationHelper {
    public void validate(Demande demande){
        if (demande == null )
            throw new DemandeValidationException("La demande ne peut pas être null");
        if (demande.getNom().isBlank())
            throw new DemandeValidationException("Le nom ne peut pas être null");
        if (demande.getPrenom().isBlank())
            throw new DemandeValidationException("Le prenom ne peut pas être null");
        if (demande.getAdresse().isBlank())
            throw new DemandeValidationException("L'adresse ne peut pas être null");
        if (demande.getDate_de_naissance().isBlank())
            throw new DemandeValidationException("La date de naissance ne peut pas être null");
        if (demande.getDuree_en_mois() <= 0)
            throw new DemandeValidationException("la duree du credit doit être supérieur à 0");
        if (demande.getMontant_credit() <= 0)
            throw new DemandeValidationException("le montant du credit doit être supérieur à 0");
        if (demande.getRevenus_sur_trois_annees() <= 0)
            throw new DemandeValidationException("le total des revenus sur 3 ans doivent être supérieurs à 0");

    }
}
