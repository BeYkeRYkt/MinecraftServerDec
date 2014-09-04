package net.minecraft;

import java.util.Random;

public class vs {

	private static final Random a = new Random();

	public static void a(World var0, dt var1, vq var2) {
		a(var0, (double) var1.n(), (double) var1.o(), (double) var1.p(), var2);
	}

	public static void a(World var0, Entity var1, vq var2) {
		a(var0, var1.s, var1.t, var1.u, var2);
	}

	private static void a(World var0, double var1, double var3, double var5, vq var7) {
		for (int var8 = 0; var8 < var7.n_(); ++var8) {
			amj var9 = var7.a(var8);
			if (var9 != null) {
				a(var0, var1, var3, var5, var9);
			}
		}

	}

	private static void a(World var0, double var1, double var3, double var5, amj var7) {
		float var8 = a.nextFloat() * 0.8F + 0.1F;
		float var9 = a.nextFloat() * 0.8F + 0.1F;
		float var10 = a.nextFloat() * 0.8F + 0.1F;

		while (var7.b > 0) {
			int var11 = a.nextInt(21) + 10;
			if (var11 > var7.b) {
				var11 = var7.b;
			}

			var7.b -= var11;
			adw var12 = new adw(var0, var1 + (double) var8, var3 + (double) var9, var5 + (double) var10, new amj(var7.b(), var11, var7.i()));
			if (var7.n()) {
				var12.l().d((NBTCompoundTag) var7.o().getCopy());
			}

			float var13 = 0.05F;
			var12.v = a.nextGaussian() * (double) var13;
			var12.w = a.nextGaussian() * (double) var13 + 0.20000000298023224D;
			var12.x = a.nextGaussian() * (double) var13;
			var0.d((Entity) var12);
		}

	}

}
