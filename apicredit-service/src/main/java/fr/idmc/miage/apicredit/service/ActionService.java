package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.*;
import fr.idmc.miage.apicredit.exception.ActionNotFoundException;
import fr.idmc.miage.apicredit.exception.DemandeNotFoundException;
import fr.idmc.miage.apicredit.exception.PersonneNotFoundException;
import fr.idmc.miage.apicredit.helper.ActionValidationHelper;
import fr.idmc.miage.apicredit.repository.ActionRepository;
import fr.idmc.miage.apicredit.repository.DemandeRepository;
import fr.idmc.miage.apicredit.repository.PersonneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActionService {

    @Autowired
    private final ActionRepository actionRepository;
    @Autowired
    private final DemandeRepository demandeRepository;
    @Autowired
    private final PersonneRepository personneRepository;

    private final ActionValidationHelper actionValidationHelper;

    public Page<Action> getAllActionsFromDemande(String id, Pageable pageable) {
        return actionRepository.findActionsByDemandeId(id,pageable);

    }

    public Page<Action> getAllActionsFromPersonne(String id, Pageable pageable) {
        return actionRepository.findActionsByPersonneId(id,pageable);

    }

    public Optional<Action> getAction(String id) {
        return actionRepository.findById(id);
    }

    public void addAction(String demandeId) {

        Demande e = demandeRepository.findById(demandeId).orElseThrow(() -> new DemandeNotFoundException(demandeId));

        Action newAction = new Action();
        newAction.setNom_action(NomAction.VALIDATION_DE_DEMANDE);
        newAction.setEtat_action(EtatAction.ENCOURS);
        newAction.setDemande(e);

        actionRepository.save(newAction);
    }

    public Action update(Action action, String demandeId, String id) {

        Demande e = demandeRepository.findById(demandeId).orElseThrow(() -> new DemandeNotFoundException(demandeId));
        Action a = actionRepository.findById(id).orElseThrow(() -> new ActionNotFoundException(id));
        action.setDemande(e);
        action.setId(a.getId());
        return actionRepository.save(action);

    }

    public Action finishAction(Personne p, String demandeId, String actionId) {

        Demande demande = demandeRepository.findById(demandeId).orElseThrow(() -> new DemandeNotFoundException(demandeId));
        Action a = actionRepository.findById(actionId).orElseThrow(() -> new ActionNotFoundException(actionId));

        NomAction nomAction = actionValidationHelper.getNextActionNameCorrespondingToEtatDemande(demande);

        Action newAction = new Action();
        newAction.setNom_action(nomAction);
        newAction.setEtat_action(EtatAction.ENCOURS);
        newAction.setDemande(demande);

        a.setPersonne(p);
        a.setEtat_action(EtatAction.TERMINEE);
        a.setDate_execution(new Timestamp(System.currentTimeMillis()));

        actionRepository.save(a);
        return actionRepository.save(newAction);

    }
}
