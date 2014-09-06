package net.minecraft;

import java.util.Random;

public class bhi extends bhp {

	private auc a;

	public bhi(auc var1) {
		this.a = var1;
	}

	public boolean b(World var1, Random var2, Position var3) {
		for (int var4 = 0; var4 < 64; ++var4) {
			Position var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5) && (!var1.worldProvider.noSkyLight() || var5.getY() < 255) && this.a.f(var1, var5, this.a.P())) {
				var1.a(var5, this.a.P(), 2);
			}
		}

		return true;
	}
}
