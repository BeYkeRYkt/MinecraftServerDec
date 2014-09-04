package net.minecraft;

import java.util.Random;

public class axp extends atr {

	protected axp() {
		super(bof.C);
		this.a(akf.b);
	}

	public alq a(bec var1, Random var2, int var3) {
		return amk.bf;
	}

	public int a(Random var1) {
		return 3 + var1.nextInt(5);
	}

	public int a(int var1, Random var2) {
		return Math.min(9, this.a(var2) + var2.nextInt(1 + var1));
	}
}
