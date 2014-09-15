package net.minecraft;

import com.google.common.collect.Maps;

import java.util.Map;

public enum ScoreboardObjectiveType {

	INTEGER("integer"), 
	HEARTS("hearts");

	private static final Map<String, ScoreboardObjectiveType> byName = Maps.newHashMap();
	static {
		for (ScoreboardObjectiveType type : values()) {
			byName.put(type.getName(), type);
		}
	}

	public static ScoreboardObjectiveType getByName(String var0) {
		ScoreboardObjectiveType var1 = (ScoreboardObjectiveType) byName.get(var0);
		return var1 == null ? INTEGER : var1;
	}

	private final String name;

	private ScoreboardObjectiveType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
