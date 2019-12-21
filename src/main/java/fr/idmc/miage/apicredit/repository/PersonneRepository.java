package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.Personne;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonneRepository extends JpaRepository<Personne,String> {


    @Query("SELECT personne FROM Personne personne " +
            "WHERE CONCAT(LOWER(personne.nom), ' ', LOWER(personne.prenom)) LIKE LOWER(CONCAT('%', :recherche,'%'))" +
            "OR CONCAT(LOWER(personne.prenom), ' ', LOWER(personne.nom)) LIKE LOWER(CONCAT('%', :recherche,'%'))")
    Page<Personne> findByNomOrPrenomContains(String recherche, Pageable pageable);
}
