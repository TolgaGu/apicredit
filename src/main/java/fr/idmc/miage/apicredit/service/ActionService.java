package fr.idmc.miage.apicredit.service;

import fr.idmc.miage.apicredit.entity.Action;
import fr.idmc.miage.apicredit.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActionService {

    @Autowired
    private final ActionRepository actionRepository;

    public List<Action> getAllActions(String id) {
        List<Action> res = new ArrayList<>();
        //actionRepository.findActionsByDemandeId(id).forEach(res::add);
        return res;
    }

    public Optional<Action> getAction(String id) {
        return actionRepository.findById(id);
    }
}
