package net.minecraft;

public class aoy extends apf {

	public aoy(int var1, oa var2, int var3) {
		super(var1, var2, var3, apg.k);
		this.c("arrowDamage");
	}

	public int a(int var1) {
		return 1 + (var1 - 1) * 10;
	}

	public int b(int var1) {
		return this.a(var1) + 15;
	}

	public int b() {
		return 5;
	}
}
