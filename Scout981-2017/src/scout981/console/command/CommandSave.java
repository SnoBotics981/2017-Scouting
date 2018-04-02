package scout981.console.command;

import scout981.csv.CSVWriter;

public class CommandSave implements CommandExecutor {

	@Override
	public void executeCommand(CommandSender sender, String cmd, String[] args) {
		CSVWriter.saveDataInCSV(false);
	}

}
