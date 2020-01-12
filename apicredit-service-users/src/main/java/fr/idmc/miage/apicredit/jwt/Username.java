package fr.idmc.miage.apicredit.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Username implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String user_name;

}
