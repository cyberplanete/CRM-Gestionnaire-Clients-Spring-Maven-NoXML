package crm.erreurs;

public class ClientNonTrouveException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientNonTrouveException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientNonTrouveException(String message) {
		super(message);
	}

	public ClientNonTrouveException(Throwable cause) {
		super(cause);
	}
	
}
