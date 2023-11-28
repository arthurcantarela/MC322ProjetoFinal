package exceptions;

public class TenteNovamenteException extends Exception {
    public TenteNovamenteException(String message) {
        super(message + " Tente novamente.");
    }
}
