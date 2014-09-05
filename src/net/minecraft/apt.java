package net.minecraft;

public class apt extends apf {

	public apt(int var1, BlockNameInfo var2, int var3) {
		super(var1, var2, var3, apg.f);
		this.c("oxygen");
	}

	public int a(int var1) {
		return 10 * var1;
	}

	public int b(int var1) {
		return this.a(var1) + 30;
	}

	public int b() {
		return 3;
	}
}
