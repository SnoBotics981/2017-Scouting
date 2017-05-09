package scout981.csv;

import java.util.HashMap;

import scout981.Team;

public class DataCache {
	private static HashMap<Integer, Integer> red1GearCount = new HashMap<>();
	private static HashMap<Integer, Integer> red2GearCount = new HashMap<>();
	private static HashMap<Integer, Integer> red3GearCount = new HashMap<>();
	private static HashMap<Integer, Integer> blu1GearCount = new HashMap<>();
	private static HashMap<Integer, Integer> blu2GearCount = new HashMap<>();
	private static HashMap<Integer, Integer> blu3GearCount = new HashMap<>();
	private static HashMap<Integer, Integer> red1DefenseRating = new HashMap<>();
	private static HashMap<Integer, Integer> red2DefenseRating = new HashMap<>();
	private static HashMap<Integer, Integer> red3DefenseRating = new HashMap<>();
	private static HashMap<Integer, Integer> blu1DefenseRating = new HashMap<>();
	private static HashMap<Integer, Integer> blu2DefenseRating = new HashMap<>();
	private static HashMap<Integer, Integer> blu3DefenseRating = new HashMap<>();
	private static HashMap<Integer, String> red1RopeClimb = new HashMap<>();
	private static HashMap<Integer, String> red2RopeClimb = new HashMap<>();
	private static HashMap<Integer, String> red3RopeClimb = new HashMap<>();
	private static HashMap<Integer, String> blu1RopeClimb = new HashMap<>();
	private static HashMap<Integer, String> blu2RopeClimb = new HashMap<>();
	private static HashMap<Integer, String> blu3RopeClimb = new HashMap<>();
	
	/**
	 * Get the defense rating of a specific team of a specific match
	 * @param team The team you want to get data from
	 * @param match The Match(key) to get data from
	 * @return Returns defense rating
	 */
	public static int getDefenseRating(Team team, int match) {
		if(team.getTeamName().equals("red1")) {
			if(red1DefenseRating.containsKey(match)) return red1DefenseRating.get(match);
		}
		if(team.getTeamName().equals("red2")) {
			if(red2DefenseRating.containsKey(match)) return red2DefenseRating.get(match);
		}
		if(team.getTeamName().equals("red3")) {
			if(red3DefenseRating.containsKey(match)) return red3DefenseRating.get(match);
		}
		if(team.getTeamName().equals("blu1")) {
			if(blu1DefenseRating.containsKey(match)) return blu1DefenseRating.get(match);
		}
		if(team.getTeamName().equals("blu2")) {
			if(blu2DefenseRating.containsKey(match)) return blu2DefenseRating.get(match);
		}
		if(team.getTeamName().equals("blu3")) {
			if(blu3DefenseRating.containsKey(match)) return blu3DefenseRating.get(match);
		}
		return 0;
	}
	
	/**
	 * Increments the defense rating of a specific team with the currently selected match
	 * @param team Which team's data you want to alter
	 */
	public static void incrementDefenseRating(Team team) {
		int match = Team.getMatch(team);
		int value = getDefenseRating(team, match);
		if(value < 5) value++;
		else return;
		
		if(team.getTeamName().equals("red1")) red1DefenseRating.put(match, value);
		if(team.getTeamName().equals("red2")) red2DefenseRating.put(match, value);
		if(team.getTeamName().equals("red3")) red3DefenseRating.put(match, value);
		if(team.getTeamName().equals("blu1")) blu1DefenseRating.put(match, value);
		if(team.getTeamName().equals("blu2")) blu2DefenseRating.put(match, value);
		if(team.getTeamName().equals("blu3")) blu3DefenseRating.put(match, value);
	}
	
	/**
	 * Decrement the defense rating of a specific team with the currently selected match
	 * @param team Which team's data you want to alter
	 */
	public static void decrementDefenseRating(Team team) {
		int match = Team.getMatch(team);
		int value = getDefenseRating(team, match);
		if(value > 0) value--;
		else return;
		
		if(team.getTeamName().equals("red1")) red1DefenseRating.put(match, value);
		if(team.getTeamName().equals("red2")) red2DefenseRating.put(match, value);
		if(team.getTeamName().equals("red3")) red3DefenseRating.put(match, value);
		if(team.getTeamName().equals("blu1")) blu1DefenseRating.put(match, value);
		if(team.getTeamName().equals("blu2")) blu2DefenseRating.put(match, value);
		if(team.getTeamName().equals("blu3")) blu3DefenseRating.put(match, value);
	}
	
	/**
	 * Gets the gear count of a specific team of a specific match.
	 * @param team Which team you want get data from
	 * @param match Which Match(key) to get data from
	 * @return Returns gear count for team
	 */
	public static int getGearCount(Team team, int match) {
		if(team.getTeamName().equals("red1")) {
			if(red1GearCount.containsKey(match)) {
				return red1GearCount.get(match);
			}
		}
		if(team.getTeamName().equals("red2")) {
			if(red2GearCount.containsKey(match)) {
				return red2GearCount.get(match);
			}
		}
		if(team.getTeamName().equals("red3")) {
			if(red3GearCount.containsKey(match)) {
				return red3GearCount.get(match);
			}
		}
		if(team.getTeamName().equals("blu1")) {
			if(blu1GearCount.containsKey(match)) {
				return blu1GearCount.get(match);
			}
		}
		if(team.getTeamName().equals("blu2")) {
			if(blu2GearCount.containsKey(match)) {
				return blu2GearCount.get(match);
			}
		}
		if(team.getTeamName().equals("blu3")) {
			if(blu3GearCount.containsKey(match)) {
				return blu3GearCount.get(match);
			}
		}
		return 0;
	}
	
	/**
	 * Increment the gear count of the currently selected team
	 * @param team Which team's data you want to alter
	 */
	public static void incrementGearCount(Team team) {
		final int match = Team.getMatch(team);
		int gearCount = getGearCount(team, match);
		gearCount++;
		if(team.getTeamName().equals("red1")) {
			red1GearCount.put(match, gearCount);
		}
		if(team == Team.RED2) {
			red2GearCount.put(match, gearCount);
		}
		if(team == Team.RED3) {
			red3GearCount.put(match, gearCount);
		}
		if(team == Team.BLU1) {
			blu1GearCount.put(match, gearCount);
		}
		if(team == Team.BLU2) {
			blu2GearCount.put(match, gearCount);
		}
		if(team == Team.BLU3) {
			blu3GearCount.put(match, gearCount);
		}
	}
	
	/**
	 * Decrement the gear count of the currently selected team
	 * @param team Which team's data you want to alter
	 */
	public static void decrementGearCount(Team team) {
		int row = Team.getMatch(team);
		int gearCount = getGearCount(team, Team.getMatch(team));
		if(gearCount <= 0) {
			return;
		}
		gearCount--;
		switch(team.getTeamName()) {
		case "red1":
			red1GearCount.put(row, gearCount);
			break;
		case "red2":
			red2GearCount.put(row, gearCount);
			break;
		case "red3":
			red3GearCount.put(row, gearCount);
			break;
		case "blu1":
			blu1GearCount.put(row, gearCount);
			break;
		case "blu2":
			blu2GearCount.put(row, gearCount);
			break;
		case "blu3":
			blu3GearCount.put(row, gearCount);
			break;
		}
	}
	
	/**
	 * Give data on a robot's rope climber
	 * @param team Which team's data you want to alter
	 * @param string Data on a team's rope climber
	 */
	public static void setRopeClimb(Team team, String string) {
		switch(team.getTeamName()) {
		case "red1":
			red1RopeClimb.put(Team.getMatch(team), string);
			break;
		case "red2":
			red2RopeClimb.put(Team.getMatch(team), string);
			break;
		case "red3":
			red3RopeClimb.put(Team.getMatch(team), string);
			break;
		case "blu1":
			blu1RopeClimb.put(Team.getMatch(team), string);
			break;
		case "blu2":
			blu2RopeClimb.put(Team.getMatch(team), string);
			break;
		case "blu3":
			blu3RopeClimb.put(Team.getMatch(team), string);
			break;
		}
	}
	
	/**
	 * 
	 * @param team Which team's data you want to alter
	 * @param match Which Match(key) you want to alter
	 * @return Match comment
	 */
	public static String getRopeClimb(Team team, int match) {
		switch(team.getTeamName()) {
		case "red1":
			if(red1RopeClimb.containsKey(match)) return red1RopeClimb.get(match);
			break;
		case "red2":
			if(red2RopeClimb.containsKey(match)) return red2RopeClimb.get(match);
			break;
		case "red3":
			if(red3RopeClimb.containsKey(match)) return red3RopeClimb.get(match);
			break;
		case "blu1":
			if(blu1RopeClimb.containsKey(match)) return blu1RopeClimb.get(match);
			break;
		case "blu2":
			if(blu2RopeClimb.containsKey(match)) return blu2RopeClimb.get(match);
			break;
		case "blu3":
			if(blu3RopeClimb.containsKey(match)) return blu3RopeClimb.get(match);
			break;
		}
		
		return "No";
	}
}
