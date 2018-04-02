package scout981.exception;

@Deprecated
public class CommandNotFoundException extends Exception {

	private static final long serialVersionUID = 3364035997047053033L;
	
	public CommandNotFoundException() {
		super();
	}
	
	public CommandNotFoundException(String message) {
		super(message);
	}
	
	public CommandNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public CommandNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
