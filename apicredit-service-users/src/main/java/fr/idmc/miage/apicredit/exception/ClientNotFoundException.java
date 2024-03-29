package fr.idmc.miage.apicredit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String id) {
        super("Client introuvable : "+id);
    }
}
