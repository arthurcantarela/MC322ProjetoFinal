package exceptions;

public class ReservaIndisponivelException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReservaIndisponivelException(String message) {
        super(message);
    }
}