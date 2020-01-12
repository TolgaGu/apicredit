package fr.idmc.miage.apicredit.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PersonneNotFoundException extends RuntimeException {
    public PersonneNotFoundException(String id) {
        super("Personne introuvable : "+id);
    }
}
