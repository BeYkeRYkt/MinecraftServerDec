package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Random;

public class bif extends bhp {

	private final bec a;
	private final int b;
	private final Predicate c;

	public bif(bec var1, int var2) {
		this(var1, var2, bep.a(aty.b));
	}

	public bif(bec var1, int var2, Predicate var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public boolean b(World var1, Random var2, Position var3) {
		float var4 = var2.nextFloat() * 3.1415927F;
		double var5 = (double) ((float) (var3.getX() + 8) + DataTypesConverter.a(var4) * (float) this.b / 8.0F);
		double var7 = (double) ((float) (var3.getX() + 8) - DataTypesConverter.a(var4) * (float) this.b / 8.0F);
		double var9 = (double) ((float) (var3.getZ() + 8) + DataTypesConverter.b(var4) * (float) this.b / 8.0F);
		double var11 = (double) ((float) (var3.getZ() + 8) - DataTypesConverter.b(var4) * (float) this.b / 8.0F);
		double var13 = (double) (var3.getY() + var2.nextInt(3) - 2);
		double var15 = (double) (var3.getY() + var2.nextInt(3) - 2);

		for (int var17 = 0; var17 < this.b; ++var17) {
			float var18 = (float) var17 / (float) this.b;
			double var19 = var5 + (var7 - var5) * (double) var18;
			double var21 = var13 + (var15 - var13) * (double) var18;
			double var23 = var9 + (var11 - var9) * (double) var18;
			double var25 = var2.nextDouble() * (double) this.b / 16.0D;
			double var27 = (double) (DataTypesConverter.a(3.1415927F * var18) + 1.0F) * var25 + 1.0D;
			double var29 = (double) (DataTypesConverter.a(3.1415927F * var18) + 1.0F) * var25 + 1.0D;
			int var31 = DataTypesConverter.toFixedPointInt(var19 - var27 / 2.0D);
			int var32 = DataTypesConverter.toFixedPointInt(var21 - var29 / 2.0D);
			int var33 = DataTypesConverter.toFixedPointInt(var23 - var27 / 2.0D);
			int var34 = DataTypesConverter.toFixedPointInt(var19 + var27 / 2.0D);
			int var35 = DataTypesConverter.toFixedPointInt(var21 + var29 / 2.0D);
			int var36 = DataTypesConverter.toFixedPointInt(var23 + var27 / 2.0D);

			for (int var37 = var31; var37 <= var34; ++var37) {
				double var38 = ((double) var37 + 0.5D - var19) / (var27 / 2.0D);
				if (var38 * var38 < 1.0D) {
					for (int var40 = var32; var40 <= var35; ++var40) {
						double var41 = ((double) var40 + 0.5D - var21) / (var29 / 2.0D);
						if (var38 * var38 + var41 * var41 < 1.0D) {
							for (int var43 = var33; var43 <= var36; ++var43) {
								double var44 = ((double) var43 + 0.5D - var23) / (var27 / 2.0D);
								if (var38 * var38 + var41 * var41 + var44 * var44 < 1.0D) {
									Position var46 = new Position(var37, var40, var43);
									if (this.c.apply(var1.p(var46))) {
										var1.a(var46, this.a, 2);
									}
								}
							}
						}
					}
				}
			}
		}

		return true;
	}
}
