package org.miage.oauthservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Constraint;


@Entity
@Getter
public class Account {


    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private boolean active;

    public Account() {// JPA !
    }

    public Account(String username, String password, boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }

}