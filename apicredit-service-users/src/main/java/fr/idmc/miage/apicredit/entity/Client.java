package fr.idmc.miage.apicredit.entity;

import fr.idmc.miage.apicredit.input.InputClient;
import fr.idmc.miage.apicredit.input.InputDemande;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {



    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String nom;
    private String prenom;
    private String adresse;
    private String date_de_naissance;

    private String private_id;

    public Client(String id){
        this.id = id;
    }

    public Client(InputClient inputClient){
        this.nom=inputClient.getNom();
        this.prenom=inputClient.getPrenom();
        this.adresse=inputClient.getAdresse();
        this.date_de_naissance=inputClient.getDate_de_naissance();
        this.private_id=inputClient.getPrivate_id();
    }
}
