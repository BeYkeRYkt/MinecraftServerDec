package net.minecraft;

public class tn extends Statistic {

	public tn(String var1, IJSONComponent var2, tv var3) {
		super(var1, var2, var3);
	}

	public tn(String var1, IJSONComponent var2) {
		super(var1, var2);
	}

	public Statistic h() {
		super.h();
		StatisticList.c.add(this);
		return this;
	}
}
