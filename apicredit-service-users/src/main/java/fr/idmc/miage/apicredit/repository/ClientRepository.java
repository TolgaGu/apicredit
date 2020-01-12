package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,String> {

    @Query("SELECT client FROM Client client " +
            "WHERE CONCAT(LOWER(client.nom), ' ', LOWER(client.prenom)) LIKE LOWER(CONCAT('%', :recherche,'%'))" +
            "OR CONCAT(LOWER(client.prenom), ' ', LOWER(client.nom)) LIKE LOWER(CONCAT('%', :recherche,'%'))")
    Page<Client> findByNomOrPrenomContains(String recherche, Pageable pageable);

    @Query("SELECT client FROM Client client " +
            "WHERE client.private_id = :id")
    Optional<Client> findByPrivateId(String id);
}
