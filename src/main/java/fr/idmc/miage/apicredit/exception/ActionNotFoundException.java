package fr.idmc.miage.apicredit.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ActionNotFoundException extends RuntimeException {
    public ActionNotFoundException(String id) {
            super("Acton introuvable : "+id);
    }
}
