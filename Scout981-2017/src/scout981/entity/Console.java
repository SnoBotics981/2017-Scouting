package scout981.entity;

import scout981.Main;
import scout981.console.command.CommandSender;

/**
 * A command sender
 * @author Adam Snover
 *
 */
public class Console implements CommandSender {

	@Override
	public void sendMessage(String message) {
		Main.logInfo(message);
	}

}
