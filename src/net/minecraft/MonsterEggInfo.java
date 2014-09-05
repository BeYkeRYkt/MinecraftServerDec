package net.minecraft;

public class MonsterEggInfo {

	public final int fixedId;
	public final int b;
	public final int c;
	public final Statistic killEntityStatistic;
	public final Statistic e;

	public MonsterEggInfo(int fixedEntityId, int var2, int var3) {
		this.fixedId = fixedEntityId;
		this.b = var2;
		this.c = var3;
		this.killEntityStatistic = StatisticList.loadKilledEntityCount(this);
		this.e = StatisticList.loadKilledByEntityCount(this);
	}

}
