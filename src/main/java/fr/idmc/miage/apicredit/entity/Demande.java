package fr.idmc.miage.apicredit.entity;

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

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Action> actions;

    public Demande(String id){
        this.id=id;
    }
}
