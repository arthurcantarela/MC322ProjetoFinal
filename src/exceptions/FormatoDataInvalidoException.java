package exceptions;

public class FormatoDataInvalidoException extends TenteNovamenteException {
    public FormatoDataInvalidoException() {
        super("Formato de data inválido. Use o formato DD/MM/AAAA.");
    }

}
