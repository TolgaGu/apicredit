package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.exception.ActionNotFoundException;
import fr.idmc.miage.apicredit.exception.DemandeNotFoundException;
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

    public Page<Action> getAllActionsFromDemande(String id, Pageable pageable) {
        return actionRepository.findActionsByDemandeId(id,pageable);

    }

    public Page<Action> getAllActionsFromPersonne(String id, Pageable pageable) {
        return actionRepository.findActionsByPersonneId(id,pageable);

    }

    public Optional<Action> getAction(String id) {
        return actionRepository.findById(id);
    }

    public Optional<Action> addAction(Action action, String demandeId) {
        action.setDemande(new Demande(demandeId));
        return actionRepository.findById(actionRepository.save(action).getId());
    }

    public Action update(Action action, String demandeId, String id) {

        Demande e = demandeRepository.findById(demandeId).orElseThrow(() -> new DemandeNotFoundException(demandeId));
        Action a = actionRepository.findById(id).orElseThrow(() -> new ActionNotFoundException(id));
        action.setDemande(e);
        action.setId(a.getId());
        return actionRepository.save(action);

    }
}
