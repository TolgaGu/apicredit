package fr.idmc.miage.apicredit.helper;

import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.entity.EtatDemande;
import fr.idmc.miage.apicredit.exception.ActionValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActionValidationHelper {

    public void validate(Action action){
        if(action == null)
            throw new ActionValidationException("Une action en peut pas être null");
        if (action.getNom_action() == null )
            throw new ActionValidationException("Le nom de l'action action doit être un chiffre entre 0 et 4");
    }

    /**
     * Si l'action courante est conforme à l'etat actuel de la demande
     * ex : une demande ne peut passer de DEBUT à ACCEPTATION
     * @param action
     */
    public EtatDemande isCoherent(Action action) {


        EtatDemande currentEtat = action.getDemande().getEtat_demande();
        EtatDemande newEtat=null;


        switch (action.getNom_action()){
            case REJET:
                if(currentEtat != EtatDemande.DECISION)
                    throw new ActionValidationException("Une demande ne peut passer en REJET qu'uniquement lorsqu'elle a un état DECISION");
                newEtat=EtatDemande.REJET;
                break;
            case NOTIFICATION:
                if(currentEtat != EtatDemande.DECISION)
                    throw new ActionValidationException("Une demande ne peut passer en ACCEPTATION qu'uniquement lorsqu'elle a un état DECISION");
                newEtat=EtatDemande.ACCEPTATION;
                break;
            case REVUS_EN_COURS:
                if(currentEtat != EtatDemande.DEBUT)
                    throw new ActionValidationException("Une demande ne peut passer en ETUDE qu'uniquement lorsqu'elle a un état DEBUT");
                newEtat=EtatDemande.ETUDE;
                break;
            case EN_ATTENTE_D_ATTRIBUTION:
                if(currentEtat != null)
                    throw new ActionValidationException("Une demande ne peut passer en DEBUT qu'uniquement lorsqu'elle n'a pas d'état");
                newEtat=EtatDemande.DEBUT;
                break;
            case DECISION_EN_ATTENTE_DE_VALIDATION:
                if(currentEtat != EtatDemande.ETUDE)
                    throw new ActionValidationException("Une demande ne peut passer en DECISION qu'uniquement lorsqu'elle a un état ETUDE");
                newEtat=EtatDemande.DECISION;
                break;
            default:
                break;
        }
        return newEtat;
    }
}
