package fr.idmc.miage.apicredit.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class DemandeUnauthorizedException extends RuntimeException {
    public DemandeUnauthorizedException(String message) {
        super(message);
    }
}
