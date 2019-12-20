package fr.idmc.miage.apicredit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Action {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String nom_action;
    private String personne_en_charge;



    @ManyToOne
    @JoinColumn(name = "demande")
    private Demande demande;
    private EtatAction etat_action;

    private Timestamp date_execution;
}
