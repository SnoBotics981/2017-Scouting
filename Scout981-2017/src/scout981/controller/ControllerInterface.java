package scout981.controller;

import java.util.HashMap;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import scout981.Main;
import scout981.Team;
import scout981.csv.DataCache;

public class ControllerInterface {
	private static HashMap<Integer, Controller> foundControllers = new HashMap<Integer, Controller>();

	public ControllerInterface() {
		Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

		int count = 0;
		for (int i = 0; i < controllers.length; i++) {
			Controller controller = controllers[i];
			if (controller.getType() == Controller.Type.STICK || controller.getType() == Controller.Type.GAMEPAD
					|| controller.getType() == Controller.Type.WHEEL
					|| controller.getType() == Controller.Type.FINGERSTICK) {
				foundControllers.put(count, controller);
				count++;
			}
		}
	}

	public void update() {
		Team team = null;
		for (int i = 0; i < foundControllers.size(); i++) {
			Controller controller = foundControllers.get(i);
			controller.poll();
			EventQueue eventQueue = controller.getEventQueue();
			Event event = new Event();
			while (eventQueue.getNextEvent(event)) {
				Component component = event.getComponent();

				switch (i) {
				case 0:
					team = Team.RED1;
					break;
				case 1:
					team = Team.BLU1;
					break;
				case 2:
					team = Team.RED2;
					break;
				case 3:
					team = Team.BLU2;
					break;
				case 4:
					team = Team.RED3;
					break;
				case 5:
					team = Team.BLU3;
					break;
				default:
					break;
				}
				//Main.logInfo(component.getName() + " " + event.getValue() + controller.getName());
				if (controller.getName().contains("XBOX"))
					XboxController.handleButtonInput(team, component, event);
				if (controller.getName().contains("Saitek"))
					SaitekController.handleButtonInput(team, component, event);
			}
		}
	}

	public HashMap<Integer, Controller> getControllers() {
		return foundControllers.size() == 0 ? null : foundControllers;
	}

	static class XboxController {
		public static void handleButtonInput(Team team, Component component, Event event) {
			if (component.getName().equals("Hat Switch")) {
				if (event.getValue() == 0.375f || event.getValue() == 0.25f || event.getValue() == 0.125f) {
					DataCache.setRopeClimb(team, "Yes");
					Main.logInfo(team.getTeamName() + " Rope Climber set to "
							+ DataCache.getRopeClimb(team, Team.getMatch(team)));
				}
				if (event.getValue() == 0.875f || event.getValue() == 0.75f || event.getValue() == 0.625f) {
					DataCache.setRopeClimb(team, "No");
					Main.logInfo(team.getTeamName() + " Rope Climber set to "
							+ DataCache.getRopeClimb(team, Team.getMatch(team)));
				}
			}
			if (!component.isAnalog()) {
				if (event.getValue() == 1.0f) {
					switch (component.getName()) {
					case "Button 0":
						DataCache.incrementGearCount(team);
						Main.logInfo(team.getTeamName() + " Gear count increased to "
								+ DataCache.getGearCount(team, Team.getMatch(team)));
						break;
					case "Button 1":
						DataCache.decrementGearCount(team);
						Main.logInfo(team.getTeamName() + " Gear count decreased to "
								+ DataCache.getGearCount(team, Team.getMatch(team)));
						break;
					case "Button 2":
						Team.incrementMatch(team);
						Main.logInfo(team.getTeamName() + " changed to Q-" + Team.getMatch(team));
						break;
					case "Button 3":
						Team.decrementMatch(team);
						Main.logInfo(team.getTeamName() + " changed to Q-" + Team.getMatch(team));
						break;
					case "Button 5":
						DataCache.incrementDefenseRating(team);
						Main.logInfo(team.getTeamName() + " Defensive Rating for Q-" + Team.getMatch(team)
								+ " changed to " + DataCache.getDefenseRating(team, Team.getMatch(team)));
						break;
					case "Button 4":
						DataCache.decrementDefenseRating(team);
						Main.logInfo(team.getTeamName() + " Defensive Rating for Q-" + Team.getMatch(team)
								+ " changed to " + DataCache.getDefenseRating(team, Team.getMatch(team)));
						break;
					default:
						return;
					}
				}
			}
		}
	}

	static class SaitekController {
		public static void handleButtonInput(Team team, Component component, Event event) {
			if (component.getName().equals("Hat Switch")) {
				if (event.getValue() == 0.375f || event.getValue() == 0.25f || event.getValue() == 0.125f) {
					DataCache.setRopeClimb(team, "Yes");
					Main.logInfo(team.getTeamName() + " Rope Climber set to "
							+ DataCache.getRopeClimb(team, Team.getMatch(team)));
				}
				if (event.getValue() == 0.875f || event.getValue() == 0.75f || event.getValue() == 0.625f) {
					DataCache.setRopeClimb(team, "No");
					Main.logInfo(team.getTeamName() + " Rope Climber set to "
							+ DataCache.getRopeClimb(team, Team.getMatch(team)));
				}

				if (!component.isAnalog()) {
					if (event.getValue() == 1.0f) {
						switch (component.getName()) {
						case "Button 1":
							DataCache.incrementGearCount(team);
							Main.logInfo(team + " Gear count increased to "
									+ DataCache.getGearCount(team, Team.getMatch(team)));
							break;
						case "Button 2":
							DataCache.decrementGearCount(team);
							Main.logInfo(team + " Gear count decreased to "
									+ DataCache.getGearCount(team, Team.getMatch(team)));
							break;
						case "Button 0":
							Team.incrementMatch(team);
							Main.logInfo(team.getTeamName() + " changed to Q-" + Team.getMatch(team));
							break;
						case "Button 3":
							Team.decrementMatch(team);
							Main.logInfo(team.getTeamName() + " changed to Q-" + Team.getMatch(team));
							break;
						case "Button 5":
							DataCache.incrementDefenseRating(team);
							Main.logInfo(team.getTeamName() + " Defensive Rating for Q-" + Team.getMatch(team)
									+ " changed to " + DataCache.getDefenseRating(team, Team.getMatch(team)));
							break;
						case "Button 4":
							DataCache.decrementDefenseRating(team);
							Main.logInfo(team.getTeamName() + " Defensive Rating for Q-" + Team.getMatch(team)
									+ " changed to " + DataCache.getDefenseRating(team, Team.getMatch(team)));
							break;
						default:
							return;
						}
					}
				}
			}
		}
	}
}
