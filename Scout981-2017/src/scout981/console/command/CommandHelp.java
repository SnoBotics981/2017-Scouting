package scout981.console.command;

import scout981.Main;

public class CommandHelp implements CommandExecutor {

	@Override
	public void executeCommand(CommandSender sender, String cmd, String[] args) {
		Main.logInfo("\nstop - Stops program\nfilename - Name of the file to save. If no name is set, it will be named latest_scout.csv Usage: filename <name>\nsave - Saves current scouting information. Data WILL be overwritten if a file with the same name exists.");
	}

}
