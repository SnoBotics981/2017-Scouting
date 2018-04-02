package scout981.console.command;

public interface CommandExecutor {
	
	/**
	 * Execute command with Overridden method
	 * @param sender The person who typed the command
	 * @param cmd The command that was typed
	 * @param args The command arguments
	 */
	public void executeCommand(CommandSender sender, String cmd, String[] args);
}
