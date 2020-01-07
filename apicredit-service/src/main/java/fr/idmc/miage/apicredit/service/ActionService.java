package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.*;
import fr.idmc.miage.apicredit.exception.ActionNotFoundException;
import fr.idmc.miage.apicredit.exception.DemandeNotFoundException;
import fr.idmc.miage.apicredit.exception.PersonneNotFoundException;
import fr.idmc.miage.apicredit.helper.ActionValidationHelper;
import fr.idmc.miage.apicredit.helper.DemandeValidationHelper;
import fr.idmc.miage.apicredit.repository.ActionRepository;
import fr.idmc.miage.apicredit.repository.DemandeRepository;
import fr.idmc.miage.apicredit.repository.PersonneRepository;
import lombok.AllArgsConstructor;
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
    private PersonneRepository personneRepository;

    private final ActionValidationHelper actionValidationHelper;
    private final DemandeValidationHelper demandeValidationHelper;

    public Page<Action> getAllActionsFromDemande(String id, Pageable pageable) {
        return actionRepository.findActionsByDemandeId(id, pageable);

    }

    public Page<Action> getAllActionsFromPersonne(String id, Pageable pageable) {
        return actionRepository.findActionsByPersonneId(id, pageable);

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

    public void rejectDemandeAction(String demandeId, Personne personne) {
        Demande demande = demandeRepository.findById(demandeId).orElseThrow(() -> new DemandeNotFoundException(demandeId));
        Action newAction = new Action();
        newAction.setNom_action(NomAction.REJET);
        newAction.setEtat_action(EtatAction.TERMINEE);
        newAction.setDemande(demande);
        newAction.setDate_execution(new Timestamp(System.currentTimeMillis()));
        newAction.setPersonne(personne);
        actionRepository.save(newAction);

    }


    public Action finishAction(Personne personne, String demandeId, String actionId) {

        Demande demande = demandeRepository.findById(demandeId).orElseThrow(() -> new DemandeNotFoundException(demandeId));
        Action a = actionRepository.findById(actionId).orElseThrow(() -> new ActionNotFoundException(actionId));
        Personne p = personneRepository.findById(personne.getId()).orElseThrow(() -> new PersonneNotFoundException(personne.getId()));

        NomAction nomAction = actionValidationHelper.getNextActionNameCorrespondingToEtatDemande(demande);
        Action newAction = null;
        if (nomAction != null) {

            newAction = new Action();
            newAction.setNom_action(nomAction);
            newAction.setEtat_action(EtatAction.ENCOURS);
            newAction.setDemande(demande);
            actionRepository.save(newAction);
        }

        a.setPersonne(p);
        a.setEtat_action(EtatAction.TERMINEE);
        a.setDate_execution(new Timestamp(System.currentTimeMillis()));
        actionRepository.save(a);

        EtatDemande etatDemande = demandeValidationHelper.getEtatDemandeCorrespondantAEtatAction(demande.getEtat_demande());
        demande.setEtat_demande(etatDemande);
        demandeRepository.save(demande);

        return newAction;

    }
}
