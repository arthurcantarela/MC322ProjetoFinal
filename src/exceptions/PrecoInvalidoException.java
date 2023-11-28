package exceptions;

public class PrecoInvalidoException extends TenteNovamenteException {
    public PrecoInvalidoException() {
        super("Preço precisa ser um valor numérico positivo.");
    }

}
