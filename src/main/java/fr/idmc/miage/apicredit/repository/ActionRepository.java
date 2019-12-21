package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Action;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActionRepository extends CrudRepository<Action,String> {

    Page<Action> findActionsByDemandeId(String id, Pageable pageable);
}
