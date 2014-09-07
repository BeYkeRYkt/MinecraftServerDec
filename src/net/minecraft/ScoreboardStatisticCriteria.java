package net.minecraft;

public class ScoreboardStatisticCriteria extends ScoreboardBaseCriteria {

	private final Statistic j;

	public ScoreboardStatisticCriteria(Statistic var1) {
		super(var1.name);
		this.j = var1;
	}
}
