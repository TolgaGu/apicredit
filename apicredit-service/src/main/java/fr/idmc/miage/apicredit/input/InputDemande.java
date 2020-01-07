package fr.idmc.miage.apicredit.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InputDemande {

    private String nom;
    private String prenom;
    private String adresse;
    private String date_de_naissance;
    private int revenus_sur_trois_annees;
    private int montant_credit;
    private int duree_en_mois;

}
