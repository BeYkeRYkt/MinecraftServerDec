package net.minecraft;

import java.util.List;

public class ScoreboardKillCriteria implements IScoreboardCriteria {

	private final String j;

	public ScoreboardKillCriteria(String var1, EnumChatFormat var2) {
		this.j = var1 + var2.getEnumLCName();
		IScoreboardCriteria.byName.put(this.j, this);
	}

	public String getName() {
		return this.j;
	}

	public int getScoreModifier(List var1) {
		return 0;
	}

	public boolean isReadOnly() {
		return false;
	}

	public ScoreboardObjectiveType getType() {
		return ScoreboardObjectiveType.INTEGER;
	}

}
