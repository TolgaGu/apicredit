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

    public Action addAction(Action action, String demandeId) {

        Demande e = demandeRepository.findById(demandeId).orElseThrow(() -> new DemandeNotFoundException(demandeId));
        Personne p = personneRepository.findById(action.getPersonne().getId()).orElseThrow(() -> new PersonneNotFoundException(action.getPersonne().getId()));
        action.setDemande(e);
        actionValidationHelper.validate(action);

        EtatDemande etatDemande = actionValidationHelper.isCoherent(action);
        demandeRepository.setEtatDemande(demandeId,etatDemande);

        action.setDate_execution(new Timestamp(System.currentTimeMillis()));
        action.setEtat_action(EtatAction.ENCOURS);
        actionRepository.setPreviousEtatActionTermineByDemandeId(demandeId);

        return actionRepository.save(action);
    }

    public Action update(Action action, String demandeId, String id) {

        Demande e = demandeRepository.findById(demandeId).orElseThrow(() -> new DemandeNotFoundException(demandeId));
        Action a = actionRepository.findById(id).orElseThrow(() -> new ActionNotFoundException(id));
        action.setDemande(e);
        action.setId(a.getId());
        return actionRepository.save(action);

    }
}
