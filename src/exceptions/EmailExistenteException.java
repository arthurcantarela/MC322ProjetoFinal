package exceptions;

public class EmailExistenteException extends TenteNovamenteException {
    public EmailExistenteException() {
        super("Email já existe.");
    }
}
