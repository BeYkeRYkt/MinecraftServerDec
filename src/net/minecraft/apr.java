package net.minecraft;

public class apr extends apf {

	protected apr(int var1, BlockNameInfo var2, int var3) {
		super(var1, var2, var3, apg.g);
		this.c("knockback");
	}

	public int a(int var1) {
		return 5 + 20 * (var1 - 1);
	}

	public int b(int var1) {
		return super.a(var1) + 50;
	}

	public int b() {
		return 2;
	}
}
