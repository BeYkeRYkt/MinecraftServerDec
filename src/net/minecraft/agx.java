package net.minecraft;

import java.util.Random;

class agx extends vi {

	public agx(int var1, int var2) {
		super(Integer.valueOf(var1), Integer.valueOf(var2));
	}

	public int a(Random var1) {
		return ((Integer) this.a()).intValue() >= ((Integer) this.b()).intValue() ? ((Integer) this.a()).intValue() : ((Integer) this.a()).intValue() + var1.nextInt(((Integer) this.b()).intValue() - ((Integer) this.a()).intValue() + 1);
	}
}
