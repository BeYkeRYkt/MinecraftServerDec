package net.minecraft;

import java.util.Random;

public class asr extends asl {

	public asr(int var1, arm var2) {
		super(var1, var2);
		this.as.A = 2;
		this.as.B = 2;
		this.as.C = 5;
	}

	public void a(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
		this.ak = aty.c.P();
		this.al = aty.d.P();
		if (var6 > 1.75D) {
			this.ak = aty.b.P();
			this.al = aty.b.P();
		} else if (var6 > -0.5D) {
			this.ak = aty.d.P().a(BlockDirt.a, avd.b);
		}

		this.b(var1, var2, var3, var4, var5, var6);
	}

	public void a(World var1, Random var2, Position var3) {
		this.as.a(var1, var2, this, var3);
	}
}
