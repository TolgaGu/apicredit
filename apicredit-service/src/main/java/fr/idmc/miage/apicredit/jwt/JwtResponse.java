package fr.idmc.miage.apicredit.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String access_token;

    public JwtResponse(String access_token) {
        this.access_token = access_token;
    }

    public String getToken() {
        return this.access_token;
    }
}