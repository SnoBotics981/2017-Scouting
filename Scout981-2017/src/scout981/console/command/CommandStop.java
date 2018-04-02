package scout981.console.command;

import scout981.Main;
import scout981.csv.CSVWriter;

public class CommandStop implements CommandExecutor {

	@Override
	public void executeCommand(CommandSender sender, String cmd, String[] args) {
		CSVWriter.saveDataInCSV(true);
		Main.getInstance().stopApp();
	}

}
