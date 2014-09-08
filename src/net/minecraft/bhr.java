package net.minecraft;

import java.util.Random;

public class bhr extends bir {

	private int a;
	private int b;

	public bhr(int var1, int var2) {
		super(false);
		this.b = var1;
		this.a = var2;
	}

	public boolean b(World var1, Random var2, Position var3) {
		Block var4;
		while (((var4 = var1.getBlockState(var3).getBlock()).getMaterial() == Material.AIR || var4.getMaterial() == Material.LEAVES) && var3.getY() > 0) {
			var3 = var3.b();
		}

		Block var5 = var1.getBlockState(var3).getBlock();
		if (var5 == Blocks.DIRT || var5 == Blocks.GRASS) {
			var3 = var3.a();
			this.a(var1, var3, Blocks.LOG, this.b);

			for (int var6 = var3.getY(); var6 <= var3.getY() + 2; ++var6) {
				int var7 = var6 - var3.getY();
				int var8 = 2 - var7;

				for (int var9 = var3.getX() - var8; var9 <= var3.getX() + var8; ++var9) {
					int var10 = var9 - var3.getX();

					for (int var11 = var3.getZ() - var8; var11 <= var3.getZ() + var8; ++var11) {
						int var12 = var11 - var3.getZ();
						if (Math.abs(var10) != var8 || Math.abs(var12) != var8 || var2.nextInt(2) != 0) {
							Position var13 = new Position(var9, var6, var11);
							if (!var1.getBlockState(var13).getBlock().m()) {
								this.a(var1, var13, Blocks.LEAVES, this.a);
							}
						}
					}
				}
			}
		}

		return true;
	}
}
