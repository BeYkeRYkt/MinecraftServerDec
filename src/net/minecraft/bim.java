package net.minecraft;

import java.util.Random;

public class bim extends bhp {

	private atr a;

	public bim(atr var1) {
		this.a = var1;
	}

	public boolean b(World var1, Random var2, dt var3) {
		if (var1.d(var3) && var1.p(var3.b()).c() == this.a) {
			int var4 = var2.nextInt(32) + 6;
			int var5 = var2.nextInt(4) + 1;

			int var6;
			int var7;
			int var8;
			int var9;
			for (var6 = var3.n() - var5; var6 <= var3.n() + var5; ++var6) {
				for (var7 = var3.p() - var5; var7 <= var3.p() + var5; ++var7) {
					var8 = var6 - var3.n();
					var9 = var7 - var3.p();
					if (var8 * var8 + var9 * var9 <= var5 * var5 + 1 && var1.p(new dt(var6, var3.o() - 1, var7)).c() != this.a) {
						return false;
					}
				}
			}

			for (var6 = var3.o(); var6 < var3.o() + var4 && var6 < 256; ++var6) {
				for (var7 = var3.n() - var5; var7 <= var3.n() + var5; ++var7) {
					for (var8 = var3.p() - var5; var8 <= var3.p() + var5; ++var8) {
						var9 = var7 - var3.n();
						int var10 = var8 - var3.p();
						if (var9 * var9 + var10 * var10 <= var5 * var5 + 1) {
							var1.a(new dt(var7, var6, var8), aty.Z.P(), 2);
						}
					}
				}
			}

			ada var11 = new ada(var1);
			var11.b((double) ((float) var3.n() + 0.5F), (double) (var3.o() + var4), (double) ((float) var3.p() + 0.5F), var2.nextFloat() * 360.0F, 0.0F);
			var1.d((Entity) var11);
			var1.a(var3.b(var4), aty.h.P(), 2);
			return true;
		} else {
			return false;
		}
	}
}
