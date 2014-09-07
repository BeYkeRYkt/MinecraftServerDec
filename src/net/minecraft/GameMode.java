package net.minecraft;

public enum GameMode {

	NOT_SET(-1, ""), 
	SURVIVAL(0, "survival"), 
	CREATIVE(1, "creative"), 
	ADVENTURE(2, "adventure"), 
	SPECTATOR(3, "spectator");

	private int id;
	private String name;

	private GameMode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setGameModeProperties(PlayerProperties var1) {
		if (this == CREATIVE) {
			var1.mayfly = true;
			var1.instabuild = true;
			var1.invulnerable = true;
		} else if (this == SPECTATOR) {
			var1.mayfly = true;
			var1.instabuild = false;
			var1.invulnerable = true;
			var1.flying = true;
		} else {
			var1.mayfly = false;
			var1.instabuild = false;
			var1.invulnerable = false;
			var1.flying = false;
		}

		var1.maybuild = !this.buildDisallowed();
	}

	public boolean buildDisallowed() {
		return this == ADVENTURE || this == SPECTATOR;
	}

	public boolean isCreative() {
		return this == CREATIVE;
	}

	public boolean isSurvivalOrAdventure() {
		return this == SURVIVAL || this == ADVENTURE;
	}

	public static GameMode getById(int id) {
		GameMode[] modes = values();
		for (int i = 0; i < modes.length; i++) {
			GameMode mode = modes[i];
			if (mode.id == id) {
				return mode;
			}
		}
		return SURVIVAL;
	}

}
