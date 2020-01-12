package fr.idmc.miage.apicredit.exception;


public class ClientAuthenticationCreatingException extends Throwable {
    public ClientAuthenticationCreatingException(String s) {
        super("Erreur lors de la creation du client : "+s);
    }
}
