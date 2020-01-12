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
public class InputClient {

    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String adresse;
    @NotNull
    private String date_de_naissance;
    @NotNull
    private String password;
}
