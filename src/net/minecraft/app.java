package net.minecraft;

public class app extends apf {

	protected app(int var1, oa var2, int var3) {
		super(var1, var2, var3, apg.g);
		this.c("fire");
	}

	public int a(int var1) {
		return 10 + 20 * (var1 - 1);
	}

	public int b(int var1) {
		return super.a(var1) + 50;
	}

	public int b() {
		return 2;
	}
}
