package exceptions;

public class OpcaoInvalidaException extends TenteNovamenteException {
	public OpcaoInvalidaException() {
		super("Selecione uma opção válida.");
	}
}
