package scout981;

import scout981.console.ConsoleInput;
import scout981.console.command.CommandFileName;
import scout981.console.command.CommandHelp;
import scout981.console.command.CommandRegistrar;
import scout981.console.command.CommandSave;
import scout981.console.command.CommandStop;
import scout981.controller.ControllerInterface;

public final class Main extends Thread {
	public static ControllerInterface ci;
	public static final String VERSION = "Starting Scout-981 2.0 Prototype...";
	
	private static Main instance;
	private static ConsoleInput c;
	private static volatile boolean running, debugging;
	private static volatile String system;
	
	private Main() {
		super("[Scout Client]");
		if(instance == null) {
			ci = new ControllerInterface();
			system = System.getProperty("os.name");
			System.out.println(this.getName() + " [INFO] " + "Computer running: " + system);
			System.out.println(this.getName() + " [WARNING] " + "No ConsoleInput instance. Creating new one.");
			System.out.println(this.getName() + " [INFO] " + "There is no problem if you just started the program");
		} else {
			return;
		}
	}
	
	public void check() {
		if(ci.getControllers() == null) {
			Main.logWarning("No controllers were found!!");
			System.exit(0);
		}
	}
	
	public static void logInfo(final String message) {
		System.out.println(Main.getInstance().getName() +" [INFO] " + message);
	}
	
	public static void logWarning(final String message) {
		System.out.println(Main.getInstance().getName() + " [WARNING] " + message);
	}
	
	public static void logError(final String message) {
		System.out.println(Main.getInstance().getName() + " [ERROR] " + message);
	}
	
	public static Main getInstance() {
		if(instance == null) instance = new Main();
		return instance;
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		Main.running = running;
	}
	
	public static boolean isDebugging() {
		return debugging;
	}
	
	public static void setDebugging(boolean b) {
		debugging = b;
	}
	
	public static String getSystem() {
		return system;
	}
	
	@Override
	public void run() {
		Main.logInfo(System.getProperty("user.dir"));
		Main.logWarning("DO NOT close the console to exit the program! Use the \"stop\" command to properly shutdown the software and save scouting data.\nType \"help\" for a full list of commands\n");
		Main.logInfo("Registering Commands...");
		
		CommandRegistrar.registerCommand("filename", new CommandFileName(), debugging);
		CommandRegistrar.registerCommand("help", new CommandHelp(), debugging);
		CommandRegistrar.registerCommand("save", new CommandSave(), debugging);
		CommandRegistrar.registerCommand("stop", new CommandStop(), debugging);
		
		Main.logInfo("Commands Registered.");
		
		while(isRunning()) {
			ci.update();
		}
		stopApp();
	}
	
	public synchronized void start() {
		if(isRunning()) {
			return;
		}
		setRunning(true);
		ConsoleInput.setRunning(true);
		super.start();
		ConsoleInput.getInstance().start();
	}
	
	public synchronized void stopApp() {
		if(isRunning()) {
			setRunning(false);
		}
		Main.logInfo("Stopping Application...");
		Runtime.getRuntime().halt(0);
	}
	
	public static void main(String[] args) {
		Main main = Main.getInstance();
		c = ConsoleInput.getInstance();
		
		//You can remove or comment out this check method if you don't
		//want to plug in controllers for whatever reason.
		main.check();
		main.start();
		c.start();
	}
}
