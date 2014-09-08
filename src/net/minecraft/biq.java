package net.minecraft;

import java.util.Random;

public class biq extends bhp {

	private final BlockState a;

	public biq(bbi var1) {
		this.a = Blocks.TALLGRASS.getBlockState().a(BlockLongGrass.a, var1);
	}

	public boolean b(World var1, Random var2, Position var3) {
		Block var4;
		while (((var4 = var1.getBlockState(var3).getBlock()).getMaterial() == Material.AIR || var4.getMaterial() == Material.LEAVES) && var3.getY() > 0) {
			var3 = var3.b();
		}

		for (int var5 = 0; var5 < 128; ++var5) {
			Position var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
			if (var1.d(var6) && Blocks.TALLGRASS.f(var1, var6, this.a)) {
				var1.a(var6, this.a, 2);
			}
		}

		return true;
	}
}
