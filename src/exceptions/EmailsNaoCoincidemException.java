package exceptions;

public class EmailsNaoCoincidemException extends TenteNovamenteException {
    public EmailsNaoCoincidemException() {
        super("Emails não coincidem.");
    }
}
