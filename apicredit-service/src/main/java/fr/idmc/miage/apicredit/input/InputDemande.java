package fr.idmc.miage.apicredit.input;

import fr.idmc.miage.apicredit.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InputDemande {

    @NotNull
    private Client client;
    @NotNull
    private int revenus_sur_trois_annees;
    @NotNull
    private int montant_credit;
    @NotNull
    private int duree_en_mois;

}
