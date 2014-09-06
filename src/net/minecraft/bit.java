package net.minecraft;

import java.util.Random;

public class bit extends bhp {

	public boolean b(World var1, Random var2, Position var3) {
		for (int var4 = 0; var4 < 10; ++var4) {
			int var5 = var3.getX() + var2.nextInt(8) - var2.nextInt(8);
			int var6 = var3.getY() + var2.nextInt(4) - var2.nextInt(4);
			int var7 = var3.getZ() + var2.nextInt(8) - var2.nextInt(8);
			if (var1.d(new Position(var5, var6, var7)) && Blocks.WATER_LILY.c(var1, new Position(var5, var6, var7))) {
				var1.a(new Position(var5, var6, var7), Blocks.WATER_LILY.P(), 2);
			}
		}

		return true;
	}
}
