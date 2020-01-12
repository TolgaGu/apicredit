package fr.idmc.miage.apicredit.entity;

import fr.idmc.miage.apicredit.input.InputDemande;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.CacheMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Demande  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;


    private String private_id;

    private String client;

    private int revenus_sur_trois_annees;
    private int montant_credit;
    private int duree_en_mois;
    private EtatDemande etat_demande;

    public Demande(String id){
        this.private_id =id;
    }

    public Demande(InputDemande inputDemande){
        this.client = inputDemande.getClient();
        this.revenus_sur_trois_annees = inputDemande.getRevenus_sur_trois_annees();
        this.montant_credit = inputDemande.getMontant_credit();
        this.duree_en_mois = inputDemande.getDuree_en_mois();
    }
}
