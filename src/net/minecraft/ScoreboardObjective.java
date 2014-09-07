package net.minecraft;

public class ScoreboardObjective {

	private final Scoreboard scoreboard;
	private final String name;
	private final IScoreboardCriteria criteria;
	private ScoreboardObjectiveType type;
	private String displayName;

	public ScoreboardObjective(Scoreboard scoreboard, String name, IScoreboardCriteria criteria) {
		this.scoreboard = scoreboard;
		this.name = name;
		this.criteria = criteria;
		this.displayName = name;
		this.type = criteria.getType();
	}

	public String getName() {
		return this.name;
	}

	public IScoreboardCriteria getCriteria() {
		return this.criteria;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
		this.scoreboard.b(this);
	}

	public ScoreboardObjectiveType getType() {
		return this.type;
	}

	public void setType(ScoreboardObjectiveType type) {
		this.type = type;
		this.scoreboard.b(this);
	}

}
