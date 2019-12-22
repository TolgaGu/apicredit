package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Action;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ActionRepository extends CrudRepository<Action,String> {

    Page<Action> findActionsByDemandeId(String id, Pageable pageable);

    Page<Action> findActionsByPersonneId(String id, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Action action SET action.etat_action = 1 where action.demande.id = :demandeId and action.etat_action = 0")
    void setPreviousEtatActionTermineByDemandeId(String demandeId);
}
