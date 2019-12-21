package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.exception.ActionNotFoundException;
import fr.idmc.miage.apicredit.exception.DemandeNotFoundException;
import fr.idmc.miage.apicredit.helper.ActionValidationHelper;
import fr.idmc.miage.apicredit.repository.ActionRepository;
import fr.idmc.miage.apicredit.repository.DemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActionService {

    @Autowired
    private final ActionRepository actionRepository;
    @Autowired
    private final DemandeRepository demandeRepository;
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
        action.setDemande(e);
        actionValidationHelper.validate(action);
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
