package scout981;

public enum Team {
	RED1("red1"),
	RED2("red2"),
	RED3("red3"),
	BLU1("blu1"),
	BLU2("blu1"),
	BLU3("blu1");
	
	private String teamName;
	private static volatile int red1Match = 1, red2Match = 1 , red3Match = 1, blu1Match = 1, blu2Match = 1, blu3Match = 1, biggest;
	
	private Team(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public static void incrementMatch(Team team) {
		switch(team.getTeamName()) {
		case "red1":
			red1Match++;
			break;
		case "red2":
			red2Match++;
			break;
		case "red3":
			red3Match++;
			break;
		case "blu1":
			blu1Match++;
			break;
		case "blu2":
			blu2Match++;
			break;
		case "blu3":
			blu3Match++;
			break;
		}
	}
	
	public static void decrementMatch(Team team) {
		switch(team.getTeamName()) {
		case "red1":
			if(red1Match != 1) {
				red1Match--;
			}
			break;
		case "red2":
			if(red2Match != 1) {
				red2Match--;
			}
			break;
		case "red3":
			if(red3Match != 1) {
				red3Match--;
			}
			break;
		case "blu1":
			if(blu1Match != 1) {
				blu1Match--;
			}
			break;
		case "blu2":
			if(blu2Match != 1) {
				blu2Match--;
			}
			break;
		case "blu3":
			if(blu3Match != 1) {
				blu3Match--;
			}
			break;
		}
	}
	
	public static int getMatch(Team team) {
		switch(team.getTeamName()) {
		case "red1":
			return red1Match;
		case "red2":
			return red2Match;
		case "red3":
			return red3Match;
		case "blu1":
			return blu1Match;
		case "blu2":
			return blu2Match;
		case "blu3":
			return blu3Match;
		}
		return 0;
	}
	
	public static int getBiggestMatchNumber() {
		if(red1Match > biggest) biggest = red1Match;
		if(red2Match > biggest) biggest = red2Match;
		if(red3Match > biggest) biggest = red3Match;
		if(blu1Match > biggest) biggest = blu1Match;
		if(blu2Match > biggest) biggest = blu2Match;
		if(blu3Match > biggest) biggest = blu3Match;
		return biggest;
	}
}
