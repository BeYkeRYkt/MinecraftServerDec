package net.minecraft;

import java.util.List;

public class ScoreboardScore {

	public static final ScoreboardComparator scoreboardComparator = new ScoreboardComparator();
	private final Scoreboard scoreboard;
	private final ScoreboardObjective objective;
	private final String playerName;
	private int score;
	private boolean locked;
	private boolean newScoreboard;

	public ScoreboardScore(Scoreboard scoreboard, ScoreboardObjective objective, String playerName) {
		this.scoreboard = scoreboard;
		this.objective = objective;
		this.playerName = playerName;
		this.newScoreboard = true;
	}

	public void addScore(int add) {
		if (this.objective.getCriteria().isReadOnly()) {
			throw new IllegalStateException("Cannot modify read-only score");
		} else {
			this.setScore(this.getScore() + add);
		}
	}

	public void removeScore(int remove) {
		if (this.objective.getCriteria().isReadOnly()) {
			throw new IllegalStateException("Cannot modify read-only score");
		} else {
			this.setScore(this.getScore() - remove);
		}
	}

	public void incrementScore() {
		if (this.objective.getCriteria().isReadOnly()) {
			throw new IllegalStateException("Cannot modify read-only score");
		} else {
			this.addScore(1);
		}
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int newScore) {
		int tempScore = this.score;
		this.score = newScore;
		if (newScore != tempScore || this.newScoreboard) {
			this.newScoreboard = false;
			this.getScoreboard().handleScoreChanged(this);
		}

	}

	public ScoreboardObjective getObjective() {
		return this.objective;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public Scoreboard getScoreboard() {
		return this.scoreboard;
	}

	public boolean isLocked() {
		return this.locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void updateForList(List<EntityHuman> humans) {
		this.setScore(this.objective.getCriteria().getScoreModifier(humans));
	}

}
