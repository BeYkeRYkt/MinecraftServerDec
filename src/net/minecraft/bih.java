package net.minecraft;

import java.util.Random;

public class bih extends bhp {

	public boolean b(World var1, Random var2, Position var3) {
		for (int var4 = 0; var4 < 64; ++var4) {
			Position var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var5) && var1.p(var5.b()).getBlock() == Blocks.GRASS && Blocks.PUMPKIN.c(var1, var5)) {
				var1.a(var5, Blocks.PUMPKIN.P().a(BlockPumpkin.N, en.a.a(var2)), 2);
			}
		}

		return true;
	}
}
