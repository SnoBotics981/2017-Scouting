package scout981.console.command;

public interface CommandSender {

	/**
	 * Send a message the person who sent the command
	 * @param message Message to send to the sender
	 */
	public void sendMessage(String message);
	
}
