package fr.idmc.miage.apicredit.entity;

import fr.idmc.miage.apicredit.input.InputDemande;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Demande  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String nom;
    private String prenom;
    private String adresse;
    private String date_de_naissance;
    private int revenus_sur_trois_annees;
    private int montant_credit;
    private int duree_en_mois;
    private EtatDemande etat_demande;

    public Demande(String id){
        this.id=id;
    }

    public Demande(InputDemande inputDemande){
        this.nom = inputDemande.getNom();
        this.prenom = inputDemande.getPrenom();
        this.adresse = inputDemande.getAdresse();
        this.date_de_naissance = inputDemande.getDate_de_naissance();
        this.revenus_sur_trois_annees = inputDemande.getRevenus_sur_trois_annees();
        this.montant_credit = inputDemande.getMontant_credit();
        this.duree_en_mois = inputDemande.getDuree_en_mois();
    }
}
