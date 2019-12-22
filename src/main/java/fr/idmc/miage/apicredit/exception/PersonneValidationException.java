package fr.idmc.miage.apicredit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PersonneValidationException extends RuntimeException {
    public PersonneValidationException(String message) {
        super(message);
    }
}
