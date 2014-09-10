package net.minecraft;

import java.util.Random;

public class asi extends BiomeBase {

	private boolean aD;

	public asi(int var1, boolean var2) {
		super(var1);
		this.aD = var2;
		if (var2) {
			this.as.A = 2;
		} else {
			this.as.A = 50;
		}

		this.as.C = 25;
		this.as.B = 4;
		if (!var2) {
			this.at.add(new arq(EntityOcelot.class, 2, 1, 1));
		}

		this.au.add(new arq(EntityChicken.class, 10, 4, 4));
	}

	public bhc a(Random var1) {
		return (bhc) (var1.nextInt(10) == 0 ? this.aB : (var1.nextInt(2) == 0 ? new bhr(ayx.d.a(), ayx.a.a()) : (!this.aD && var1.nextInt(3) == 0 ? new bia(false, 10, 20, ayx.d.a(), ayx.d.a()) : new bir(false, 4 + var1.nextInt(7), ayx.d.a(), ayx.d.a(), true))));
	}

	public bhp b(Random var1) {
		return var1.nextInt(4) == 0 ? new biq(bbi.c) : new biq(bbi.b);
	}

	public void a(World var1, Random var2, Position var3) {
		super.a(var1, var2, var3);
		int var4 = var2.nextInt(16) + 8;
		int var5 = var2.nextInt(16) + 8;
		int var6 = var2.nextInt(var1.m(var3.a(var4, 0, var5)).getY() * 2);
		(new bid()).b(var1, var2, var3.a(var4, var6, var5));
		bis var9 = new bis();

		for (var5 = 0; var5 < 50; ++var5) {
			var6 = var2.nextInt(16) + 8;
			boolean var7 = true;
			int var8 = var2.nextInt(16) + 8;
			var9.b(var1, var2, var3.a(var6, 128, var8));
		}

	}
}
