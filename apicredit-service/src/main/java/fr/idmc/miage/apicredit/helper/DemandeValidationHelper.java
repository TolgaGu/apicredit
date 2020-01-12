package fr.idmc.miage.apicredit.helper;

import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.EtatAction;
import fr.idmc.miage.apicredit.entity.EtatDemande;
import fr.idmc.miage.apicredit.entity.NomAction;
import fr.idmc.miage.apicredit.exception.DemandeValidationException;
import fr.idmc.miage.apicredit.input.InputDemande;
import org.springframework.stereotype.Component;

@Component
public class DemandeValidationHelper {
    public void validate(InputDemande demande) {
        if (demande == null)
            throw new DemandeValidationException("La demande ne peut pas être null");
        if (demande.getClient() == null)
            throw new DemandeValidationException("Le client ne peut pas être null");
        if (demande.getDuree_en_mois() <= 0)
            throw new DemandeValidationException("la duree du credit doit être supérieur à 0");
        if (demande.getMontant_credit() <= 0)
            throw new DemandeValidationException("le montant du credit doit être supérieur à 0");
        if (demande.getRevenus_sur_trois_annees() <= 0)
            throw new DemandeValidationException("le total des revenus sur 3 ans doivent être supérieurs à 0");

    }

    public EtatDemande getEtatDemandeCorrespondantAEtatAction(EtatDemande etatDemande) {

        EtatDemande newDemande = null;

        if (etatDemande == null) {

            newDemande = EtatDemande.DEBUT;
        } else {
            switch (etatDemande) {
                case DEBUT:
                    newDemande = EtatDemande.ETUDE;
                    break;
                case ETUDE:
                    newDemande = EtatDemande.DECISION;
                    break;
                case DECISION:
                    newDemande = EtatDemande.ACCEPTATION;
                    break;
                case ACCEPTATION:
                    newDemande = EtatDemande.FIN;
                    break;
                default:
                    break;
            }
        }

        return newDemande;
    }
}
