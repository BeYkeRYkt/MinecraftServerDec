package net.minecraft;

import com.google.common.collect.Maps;

import java.util.Map;

public enum ScoreboardTeamNameTagVisibility {

	ALWAYS("always", 0), 
	NEVER("never", 1), 
	HIDE_FOR_OTHER_TEAMS("hideForOtherTeams", 2), 
	HIDE_FOR_OWN_TEAM("hideForOwnTeam", 3);

	private static Map<String, ScoreboardTeamNameTagVisibility> byName = Maps.newHashMap();
	static {
		ScoreboardTeamNameTagVisibility[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			ScoreboardTeamNameTagVisibility var3 = var0[var2];
			byName.put(var3.name, var3);
		}

	}

	public static String[] getNames() {
		return byName.keySet().toArray(new String[byName.size()]);
	}

	public static ScoreboardTeamNameTagVisibility getByName(String name) {
		return byName.get(name);
	}

	public final String name;
	public final int id;

	private ScoreboardTeamNameTagVisibility(String name, int id) {
		this.name = name;
		this.id = id;
	}

}
