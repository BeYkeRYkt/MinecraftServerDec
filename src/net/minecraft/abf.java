package net.minecraft;

import java.util.Random;

public class abf {

	private static Vec3D a = new Vec3D(0.0D, 0.0D, 0.0D);

	public static Vec3D a(EntityCreature var0, int var1, int var2) {
		return c(var0, var1, var2, (Vec3D) null);
	}

	public static Vec3D a(EntityCreature var0, int var1, int var2, Vec3D var3) {
		a = var3.a(var0.locationX, var0.locationY, var0.locationZ);
		return c(var0, var1, var2, a);
	}

	public static Vec3D b(EntityCreature var0, int var1, int var2, Vec3D var3) {
		a = (new Vec3D(var0.locationX, var0.locationY, var0.locationZ)).d(var3);
		return c(var0, var1, var2, a);
	}

	private static Vec3D c(EntityCreature var0, int var1, int var2, Vec3D var3) {
		Random var4 = var0.bb();
		boolean var5 = false;
		int var6 = 0;
		int var7 = 0;
		int var8 = 0;
		float var9 = -99999.0F;
		boolean var10;
		if (var0.ci()) {
			double var11 = var0.cf().c((double) MathHelper.toFixedPointInt(var0.locationX), (double) MathHelper.toFixedPointInt(var0.locationY), (double) MathHelper.toFixedPointInt(var0.locationZ)) + 4.0D;
			double var13 = (double) (var0.cg() + (float) var1);
			var10 = var11 < var13 * var13;
		} else {
			var10 = false;
		}

		for (int var17 = 0; var17 < 10; ++var17) {
			int var12 = var4.nextInt(2 * var1 + 1) - var1;
			int var18 = var4.nextInt(2 * var2 + 1) - var2;
			int var14 = var4.nextInt(2 * var1 + 1) - var1;
			if (var3 == null || (double) var12 * var3.x + (double) var14 * var3.z >= 0.0D) {
				Position var15;
				if (var0.ci() && var1 > 1) {
					var15 = var0.cf();
					if (var0.locationX > (double) var15.getX()) {
						var12 -= var4.nextInt(var1 / 2);
					} else {
						var12 += var4.nextInt(var1 / 2);
					}

					if (var0.locationZ > (double) var15.getZ()) {
						var14 -= var4.nextInt(var1 / 2);
					} else {
						var14 += var4.nextInt(var1 / 2);
					}
				}

				var12 += MathHelper.toFixedPointInt(var0.locationX);
				var18 += MathHelper.toFixedPointInt(var0.locationY);
				var14 += MathHelper.toFixedPointInt(var0.locationZ);
				var15 = new Position(var12, var18, var14);
				if (!var10 || var0.d(var15)) {
					float var16 = var0.a(var15);
					if (var16 > var9) {
						var9 = var16;
						var6 = var12;
						var7 = var18;
						var8 = var14;
						var5 = true;
					}
				}
			}
		}

		if (var5) {
			return new Vec3D((double) var6, (double) var7, (double) var8);
		} else {
			return null;
		}
	}

}
