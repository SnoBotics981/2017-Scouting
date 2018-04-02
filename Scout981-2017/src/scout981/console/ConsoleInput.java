package scout981.console;

import java.io.Console;

import scout981.console.command.CommandRegistrar;
/**
 * This class handles all command input
 * It runs on a separate thread to prevent
 * lockups while attempting to get the next line of console input.
 * @author Adam Snover
 *
 */
public class ConsoleInput extends Thread {

	private static volatile boolean running;
	private static final scout981.entity.Console sender = new scout981.entity.Console();
	private static class Holder {
		static final ConsoleInput INSTANCE = new ConsoleInput();
	}

	//Prevent Instantiation
	private ConsoleInput() {}

	@Override
	public void run() {
		Console c = System.console();
		
		//This keeps looping until the thread is interrupted or the @running bool is set to false
		while (ConsoleInput.isRunning()) {
			String[] commandString = c.readLine().split(" ");
			String[] args = new String[commandString.length - 1];
			String command = commandString[0];
			for(int i = 1; i < commandString.length; i++) {
				args[i - 1] = commandString[i];
			}
			
			CommandRegistrar.retrieveExecutor(command).executeCommand(sender, command, args);
			
			c.flush();
		}
	}

	/**
	 * @return Returns a permanent single instance of this class
	 */
	public static ConsoleInput getInstance() {
		return Holder.INSTANCE;
	}
	
	/**
	 * @return Returns the current running state of this thread.
	 */
	public static boolean isRunning() {
		return running;
	}
	
	/**
	 * @param _running
	 *        Setting the boolean to false will end this thread.
	 */
	public static void setRunning(boolean _running) {
		running = _running;
	}
}
