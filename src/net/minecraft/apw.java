package net.minecraft;

public class apw extends apf {

	protected apw(int var1, BlockNameInfo var2, int var3) {
		super(var1, var2, var3, apg.h);
		this.c("untouching");
	}

	public int a(int var1) {
		return 15;
	}

	public int b(int var1) {
		return super.a(var1) + 50;
	}

	public int b() {
		return 1;
	}

	public boolean a(apf var1) {
		return super.a(var1) && var1.B != u.B;
	}

	public boolean a(ItemStack var1) {
		return var1.getItem() == amk.be ? true : super.a(var1);
	}
}
