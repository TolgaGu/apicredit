package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Action;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActionRepository extends CrudRepository<Action,String> {

    List<Action> findActionsByDemandeId(String id);
}
