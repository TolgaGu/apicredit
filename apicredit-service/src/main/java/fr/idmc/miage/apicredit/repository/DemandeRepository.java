package fr.idmc.miage.apicredit.repository;

import fr.idmc.miage.apicredit.entity.Demande;
import fr.idmc.miage.apicredit.entity.EtatDemande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DemandeRepository extends JpaRepository<Demande, String> {

    @Query("Select demande From Demande demande where UPPER(demande.etat_demande) like UPPER(:recherche)")
    Page<Demande> findByStatusEquals(String recherche, Pageable pageable);

/*
    @Modifying
    @Transactional
    @Query("UPDATE Demande demande SET demande.etat_demande = :etatDemande where demande.id = :demandeId")
    void setEtatDemande(String demandeId,EtatDemande etatDemande);*/
}
