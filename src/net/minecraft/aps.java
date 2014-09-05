package net.minecraft;

public class aps extends apf {

	protected aps(int var1, BlockNameInfo var2, int var3, apg var4) {
		super(var1, var2, var3, var4);
		if (var4 == apg.h) {
			this.c("lootBonusDigger");
		} else if (var4 == apg.i) {
			this.c("lootBonusFishing");
		} else {
			this.c("lootBonus");
		}

	}

	public int a(int var1) {
		return 15 + (var1 - 1) * 9;
	}

	public int b(int var1) {
		return super.a(var1) + 50;
	}

	public int b() {
		return 3;
	}

	public boolean a(apf var1) {
		return super.a(var1) && var1.B != s.B;
	}
}
