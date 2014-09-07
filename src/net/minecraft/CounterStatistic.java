package net.minecraft;

public class CounterStatistic extends Statistic {

	public CounterStatistic(String var1, IChatBaseComponent var2, Counter var3) {
		super(var1, var2, var3);
	}

	public CounterStatistic(String var1, IChatBaseComponent var2) {
		super(var1, var2);
	}

	public Statistic h() {
		super.h();
		StatisticList.c.add(this);
		return this;
	}
}
