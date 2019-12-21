package fr.idmc.miage.apicredit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String nom_action;

    @ManyToOne
    private Personne personne_en_charge;

    @ManyToOne
    private Demande demande;
    private EtatAction etat_action;

    @CreatedDate
    private Timestamp date_execution;
}
