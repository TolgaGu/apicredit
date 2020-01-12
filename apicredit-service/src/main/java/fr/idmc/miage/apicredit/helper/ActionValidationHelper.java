package fr.idmc.miage.apicredit.helper;

import fr.idmc.miage.apicredit.entity.*;
import fr.idmc.miage.apicredit.exception.ActionValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActionValidationHelper {

    public void validate(Action action) {
        if (action == null)
            throw new ActionValidationException("Une action en peut pas être null");
        if (action.getNom_action() == null)
            throw new ActionValidationException("Le nom de l'action action doit être un chiffre entre 0 et 4");
    }

    /**
     * en fonction de l'état actuel de la demande, on fourni l'état de la nouvelle action
     *
     * @param demande
     */
    public NomAction getNextActionNameCorrespondingToEtatDemande(Demande demande) {


        EtatDemande currentEtat = demande.getEtat_demande();
        NomAction newAction = null;
        if (currentEtat == EtatDemande.VERIFICATION_DEMANDE) {
            newAction = NomAction.EN_ATTENTE_D_ATTRIBUTION;
        } else {
            switch (currentEtat) {
                case DEBUT:
                    newAction = NomAction.REVUS_EN_COURS;
                    break;
                case ETUDE:
                    newAction = NomAction.DECISION_EN_ATTENTE_DE_VALIDATION;
                    break;
                case DECISION:
                    newAction = NomAction.NOTIFICATION;
                    break;
                case ACCEPTATION:
                    newAction = NomAction.CLOTURATION;
                    break;
                case FIN:
                    break;
                default:
                    break;
            }
        }

        return newAction;
    }
}
