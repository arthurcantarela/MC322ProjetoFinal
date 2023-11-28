package exceptions;

public class IntervaloDatasInvalidoException extends TenteNovamenteException {
    public IntervaloDatasInvalidoException() {
        super("A data final deve ser posterior a data de início.");
    }

}
