package net.minecraft;

import java.util.Random;

public class WorldGenLakes extends WorldGenerator {

	private Block a;

	public WorldGenLakes(Block var1) {
		this.a = var1;
	}

	public boolean b(World var1, Random var2, Position var3) {
		for (var3 = var3.a(-8, 0, -8); var3.getY() > 5 && var1.d(var3); var3 = var3.b()) {
			;
		}

		if (var3.getY() <= 4) {
			return false;
		} else {
			var3 = var3.c(4);
			boolean[] var4 = new boolean[2048];
			int var5 = var2.nextInt(4) + 4;

			int var6;
			for (var6 = 0; var6 < var5; ++var6) {
				double var7 = var2.nextDouble() * 6.0D + 3.0D;
				double var9 = var2.nextDouble() * 4.0D + 2.0D;
				double var11 = var2.nextDouble() * 6.0D + 3.0D;
				double var13 = var2.nextDouble() * (16.0D - var7 - 2.0D) + 1.0D + var7 / 2.0D;
				double var15 = var2.nextDouble() * (8.0D - var9 - 4.0D) + 2.0D + var9 / 2.0D;
				double var17 = var2.nextDouble() * (16.0D - var11 - 2.0D) + 1.0D + var11 / 2.0D;

				for (int var19 = 1; var19 < 15; ++var19) {
					for (int var20 = 1; var20 < 15; ++var20) {
						for (int var21 = 1; var21 < 7; ++var21) {
							double var22 = ((double) var19 - var13) / (var7 / 2.0D);
							double var24 = ((double) var21 - var15) / (var9 / 2.0D);
							double var26 = ((double) var20 - var17) / (var11 / 2.0D);
							double var28 = var22 * var22 + var24 * var24 + var26 * var26;
							if (var28 < 1.0D) {
								var4[(var19 * 16 + var20) * 8 + var21] = true;
							}
						}
					}
				}
			}

			int var8;
			int var30;
			boolean var32;
			for (var6 = 0; var6 < 16; ++var6) {
				for (var30 = 0; var30 < 16; ++var30) {
					for (var8 = 0; var8 < 8; ++var8) {
						var32 = !var4[(var6 * 16 + var30) * 8 + var8] && (var6 < 15 && var4[((var6 + 1) * 16 + var30) * 8 + var8] || var6 > 0 && var4[((var6 - 1) * 16 + var30) * 8 + var8] || var30 < 15 && var4[(var6 * 16 + var30 + 1) * 8 + var8] || var30 > 0 && var4[(var6 * 16 + (var30 - 1)) * 8 + var8] || var8 < 7 && var4[(var6 * 16 + var30) * 8 + var8 + 1] || var8 > 0 && var4[(var6 * 16 + var30) * 8 + (var8 - 1)]);
						if (var32) {
							Material var10 = var1.getBlockState(var3.a(var6, var8, var30)).getBlock().getMaterial();
							if (var8 >= 4 && var10.isLiquid()) {
								return false;
							}

							if (var8 < 4 && !var10.isBuildable() && var1.getBlockState(var3.a(var6, var8, var30)).getBlock() != this.a) {
								return false;
							}
						}
					}
				}
			}

			for (var6 = 0; var6 < 16; ++var6) {
				for (var30 = 0; var30 < 16; ++var30) {
					for (var8 = 0; var8 < 8; ++var8) {
						if (var4[(var6 * 16 + var30) * 8 + var8]) {
							var1.a(var3.a(var6, var8, var30), var8 >= 4 ? Blocks.AIR.getBlockState() : this.a.getBlockState(), 2);
						}
					}
				}
			}

			for (var6 = 0; var6 < 16; ++var6) {
				for (var30 = 0; var30 < 16; ++var30) {
					for (var8 = 4; var8 < 8; ++var8) {
						if (var4[(var6 * 16 + var30) * 8 + var8]) {
							Position var33 = var3.a(var6, var8 - 1, var30);
							if (var1.getBlockState(var33).getBlock() == Blocks.DIRT && var1.b(arf.a, var3.a(var6, var8, var30)) > 0) {
								BiomeBase var34 = var1.b(var33);
								if (var34.ak.getBlock() == Blocks.MYCELIUM) {
									var1.a(var33, Blocks.MYCELIUM.getBlockState(), 2);
								} else {
									var1.a(var33, Blocks.GRASS.getBlockState(), 2);
								}
							}
						}
					}
				}
			}

			if (this.a.getMaterial() == Material.LAVA) {
				for (var6 = 0; var6 < 16; ++var6) {
					for (var30 = 0; var30 < 16; ++var30) {
						for (var8 = 0; var8 < 8; ++var8) {
							var32 = !var4[(var6 * 16 + var30) * 8 + var8] && (var6 < 15 && var4[((var6 + 1) * 16 + var30) * 8 + var8] || var6 > 0 && var4[((var6 - 1) * 16 + var30) * 8 + var8] || var30 < 15 && var4[(var6 * 16 + var30 + 1) * 8 + var8] || var30 > 0 && var4[(var6 * 16 + (var30 - 1)) * 8 + var8] || var8 < 7 && var4[(var6 * 16 + var30) * 8 + var8 + 1] || var8 > 0 && var4[(var6 * 16 + var30) * 8 + (var8 - 1)]);
							if (var32 && (var8 < 4 || var2.nextInt(2) != 0) && var1.getBlockState(var3.a(var6, var8, var30)).getBlock().getMaterial().isBuildable()) {
								var1.a(var3.a(var6, var8, var30), Blocks.STONE.getBlockState(), 2);
							}
						}
					}
				}
			}

			if (this.a.getMaterial() == Material.WATER) {
				for (var6 = 0; var6 < 16; ++var6) {
					for (var30 = 0; var30 < 16; ++var30) {
						byte var31 = 4;
						if (var1.v(var3.a(var6, var31, var30))) {
							var1.a(var3.a(var6, var31, var30), Blocks.ICE.getBlockState(), 2);
						}
					}
				}
			}

			return true;
		}
	}
}
