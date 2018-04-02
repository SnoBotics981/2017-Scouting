package scout981.exception;

@Deprecated
/**
 * This class was created with the intent to throw an error when a command could not be found.
 * It was originally going to be used for debug but now currently has not use and will likely be
 * deleted in the future
 * @author Adam Snover
 *
 */
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
