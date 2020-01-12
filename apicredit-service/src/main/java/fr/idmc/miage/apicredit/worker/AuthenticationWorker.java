package fr.idmc.miage.apicredit.worker;


import fr.idmc.miage.apicredit.jwt.JwtResponse;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import lombok.NoArgsConstructor;

import java.util.logging.Level;
import java.util.logging.Logger;


@NoArgsConstructor
public class AuthenticationWorker implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationWorker.class.getName());

    public static String ACCES_TOKEN;

    @Override
    public void run() {

        HttpResponse<JwtResponse> response = Unirest.post("http://localhost:9191/oauth/token")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .header("Authorization", "Basic YXBpY3JlZGl0OmFwaXByb2plY3RzZWNyZXQ=")
                .field("username", "miage")
                .field("password", "sidsarethebest")
                .field("grant_type", "password")
                .connectTimeout(0)
                .asObject(JwtResponse.class);

        ACCES_TOKEN = response.getBody().getToken();
        LOGGER.log(Level.INFO,"New token generated");
    }
}

