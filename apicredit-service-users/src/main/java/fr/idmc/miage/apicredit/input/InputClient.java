package fr.idmc.miage.apicredit.input;


import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InputClient {


    private String private_id;
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
