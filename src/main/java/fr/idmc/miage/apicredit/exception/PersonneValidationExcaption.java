package fr.idmc.miage.apicredit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PersonneValidationExcaption extends RuntimeException {
    public PersonneValidationExcaption(String message) {
        super(message);
    }
}
