package net.minecraft;

import java.util.Random;

public class bhw extends bhp {

	private Block a;
	private int b;

	public bhw(int var1) {
		this.a = Blocks.PACKED_ICE;
		this.b = var1;
	}

	public boolean b(World var1, Random var2, Position var3) {
		while (var1.d(var3) && var3.getY() > 2) {
			var3 = var3.b();
		}

		if (var1.p(var3).getBlock() != Blocks.SNOW) {
			return false;
		} else {
			int var4 = var2.nextInt(this.b - 2) + 2;
			byte var5 = 1;

			for (int var6 = var3.getX() - var4; var6 <= var3.getX() + var4; ++var6) {
				for (int var7 = var3.getZ() - var4; var7 <= var3.getZ() + var4; ++var7) {
					int var8 = var6 - var3.getX();
					int var9 = var7 - var3.getZ();
					if (var8 * var8 + var9 * var9 <= var4 * var4) {
						for (int var10 = var3.getY() - var5; var10 <= var3.getY() + var5; ++var10) {
							Position var11 = new Position(var6, var10, var7);
							Block var12 = var1.p(var11).getBlock();
							if (var12 == Blocks.DIRT || var12 == Blocks.SNOW || var12 == Blocks.ICE) {
								var1.a(var11, this.a.P(), 2);
							}
						}
					}
				}
			}

			return true;
		}
	}
}
