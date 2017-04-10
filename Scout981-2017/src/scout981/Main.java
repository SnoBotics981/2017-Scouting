package scout981;

import scout981.controller.ControllerInterface;

public final class Main extends Thread {
	public static ControllerInterface ci;
	
	private static Main instance;
	private static ConsoleInput c;
	private static volatile boolean running, debugging;
	private static volatile String system;
	
	private Main() {
		super("[Scout Client]");
		if(instance == null) {
			ci = new ControllerInterface();
			system = System.getProperty("os.name");
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
	
	public static void logInfo(String message) {
		System.out.println(Main.getInstance().getName() +" [INFO] " + message);
	}
	
	public static void logWarning(String message) {
		System.out.println(Main.getInstance().getName() + " [WARNING] " + message);
	}
	
	public static void logError(String message) {
		System.out.println(Main.getInstance().getName() + " [ERROR] " + message);
	}
	
	public static Main getInstance() {
		if(instance == null) instance =  new Main();
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
		Main.logInfo("Starting Scout-981 1.7 Release...");
		Main.logWarning("DO NOT close the console to exit the program! Use the \"stop\" command to properly shutdown the software and save scouting data.\nType \"help\" for a full list of commands\n");
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
		super.start();
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
		
		main.check();
		main.start();
		c.start();
	}
}
