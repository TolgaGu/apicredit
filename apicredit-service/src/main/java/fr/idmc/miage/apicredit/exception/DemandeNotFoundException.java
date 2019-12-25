package fr.idmc.miage.apicredit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DemandeNotFoundException extends RuntimeException {
    public DemandeNotFoundException(String id) {
        super("Demande introuvable : "+id);
    }
}
