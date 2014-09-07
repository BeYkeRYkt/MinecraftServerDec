package net.minecraft;

import java.util.List;

public class ScoreboardBaseCriteria implements IScoreboardCriteria {

	private final String j;

	public ScoreboardBaseCriteria(String var1) {
		this.j = var1;
		IScoreboardCriteria.byName.put(var1, this);
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

	public bsl c() {
		return bsl.a;
	}
}
