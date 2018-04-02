package scout981.console.command;

import java.util.HashMap;

import scout981.Main;

public class CommandRegistrar {
	
	private static HashMap<String, CommandExecutor> commandList = new HashMap<String, CommandExecutor>();
	
	public static void registerCommand(String command, CommandExecutor executor) {
		registerCommand(command, executor, false);
	}
	
	public static void registerCommand(String command, CommandExecutor executor, boolean verbose) {
		commandList.put(command, executor);
		if(verbose) Main.logInfo("Registered Command: " + command);
	}
	
	public static CommandExecutor retrieveExecutor(String command) {
		if(!commandList.containsKey(command)) {
			Main.logError("Command does not exist or is not registered!!!");
			return null;
		}
		return commandList.get(command);
	}

}
