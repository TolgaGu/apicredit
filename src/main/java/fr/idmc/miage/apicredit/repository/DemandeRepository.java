package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Demande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface DemandeRepository extends JpaRepository<Demande, String> {

    @Query("Select demande From Demande demande where UPPER(etat_demande) like UPPER(:recherche)")
    Page<Demande> findByStatusEquals(String recherche, Pageable pageable);

}
