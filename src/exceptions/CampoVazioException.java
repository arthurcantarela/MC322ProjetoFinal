package exceptions;

public class CampoVazioException extends TenteNovamenteException {
    public CampoVazioException(String campo) {
        super("O campo " + campo + " não pode ser vazio.");
    }

}
