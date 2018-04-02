package scout981.console.command;

import scout981.csv.CSVWriter;

public class CommandFileName implements CommandExecutor {

	@Override
	public void executeCommand(CommandSender sender, String cmd, String[] args) {
		if(args.length < 0) {
			sender.sendMessage("Not enough arguments!\\nUsage: filename <name>");
			return;
		}
		
		CSVWriter.setFileName(args[0]);
		sender.sendMessage("Scouting file name changed to " + CSVWriter.getFileName() + ".csv");
	}

}
