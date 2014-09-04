package net.minecraft;

public enum Difficulty {

	PEACEFUL(0, "options.difficulty.peaceful"), 
	EASY(1, "options.difficulty.easy"), 
	NORMAL(2, "options.difficulty.normal"), 
	HARD(3, "options.difficulty.hard");

	private final int id;
	private final String name;

	private Difficulty(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public static Difficulty clampAndGetById(int id) {
		return values()[id % values().length];
	}

	public String getName() {
		return this.name;
	}

}
