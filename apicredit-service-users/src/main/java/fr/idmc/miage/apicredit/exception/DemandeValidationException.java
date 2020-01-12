package fr.idmc.miage.apicredit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DemandeValidationException extends RuntimeException {
    public DemandeValidationException(String message) {
        super(message);
    }
}
