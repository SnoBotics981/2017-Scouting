package scout981.console.command;

public interface CommandExecutor {
	public void executeCommand(CommandSender sender, String cmd, String[] args);
}
