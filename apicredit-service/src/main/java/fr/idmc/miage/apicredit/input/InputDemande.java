package fr.idmc.miage.apicredit.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InputDemande {

    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String adresse;
    @NotNull
    private String date_de_naissance;
    @NotNull
    private int revenus_sur_trois_annees;
    @NotNull
    private int montant_credit;
    @NotNull
    private int duree_en_mois;

}
