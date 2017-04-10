package scout981.csv;

import java.io.IOException;
import java.io.PrintWriter;

import scout981.Main;
import scout981.Team;

public class CSVWriter extends DataCache {

	private static volatile String fileName = "latest_scout";

	public static void saveDataInCSV(boolean exit) {
		StringBuffer buffer = new StringBuffer();
		String data = null;
		try {
			PrintWriter writer = new PrintWriter(fileName + ".csv", "UTF-8");
			buffer.append(
					"Match #, Red 1 Gears, Red 2 Gears, Red 3 Gears, Blue 1 Gears, Blue 2 Gears, Blue 3 Gears, Red 1 Defense, Red 2 Defense, Red3 Defense, Blue 1 Defense, Blue 2 Defense, Blue 3 Defense, Red 1 Rope Climber, Red 2 Rope Climber, Red 3 Rope Climber, Blue 1 Rope Climber, Blue 2 Rope Climber, Blue 3 Rope Climber\n");
			for (int i = 0; i < Team.getBiggestMatchNumber(); i++) {
				int match = i + 1;
				buffer.append(i + "," + DataCache.getGearCount(Team.RED1, match) + ","
						+ DataCache.getGearCount(Team.RED2, match) + "," + DataCache.getGearCount(Team.RED3, match)
						+ "," + DataCache.getGearCount(Team.BLU1, match) + ","
						+ DataCache.getGearCount(Team.BLU2, match) + "," + DataCache.getGearCount(Team.BLU3, match)
						+ "," + DataCache.getDefenseRating(Team.RED1, match) + ","
						+ DataCache.getDefenseRating(Team.RED2, match) + ","
						+ DataCache.getDefenseRating(Team.RED3, match) + ","
						+ DataCache.getDefenseRating(Team.BLU1, match) + ","
						+ DataCache.getDefenseRating(Team.BLU2, match) + ","
						+ DataCache.getDefenseRating(Team.BLU3, match) + "," + DataCache.getRopeClimb(Team.RED1, match)
						+ "," + DataCache.getRopeClimb(Team.RED2, match) + ","
						+ DataCache.getRopeClimb(Team.RED3, match) + "," + DataCache.getRopeClimb(Team.BLU1, match)
						+ "," + DataCache.getRopeClimb(Team.BLU2, match) + ","
						+ DataCache.getRopeClimb(Team.BLU3, match) + "\n");
			}
			data = buffer.toString();
			writer.print(data);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.logInfo("Scouting data saved as " + fileName + ".csv");
		if (exit) {
			Main.getInstance().stopApp();
		}
	}

	public static void setFileName(String name) {
		fileName = name;
	}

	public static String getFileName() {
		return fileName;
	}
}
