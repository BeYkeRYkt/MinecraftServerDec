package net.minecraft;

import java.util.Random;

public class WorldGenSwampTree extends WorldGenTreeAbstract {

	public WorldGenSwampTree() {
		super(false);
	}

	public boolean b(World var1, Random var2, Position var3) {
		int var4;
		for (var4 = var2.nextInt(4) + 5; var1.getBlockState(var3.getDown()).getBlock().getMaterial() == Material.WATER; var3 = var3.getDown()) {
			;
		}

		boolean var5 = true;
		if (var3.getY() >= 1 && var3.getY() + var4 + 1 <= 256) {
			int var8;
			int var9;
			for (int var6 = var3.getY(); var6 <= var3.getY() + 1 + var4; ++var6) {
				byte var7 = 1;
				if (var6 == var3.getY()) {
					var7 = 0;
				}

				if (var6 >= var3.getY() + 1 + var4 - 2) {
					var7 = 3;
				}

				for (var8 = var3.getX() - var7; var8 <= var3.getX() + var7 && var5; ++var8) {
					for (var9 = var3.getZ() - var7; var9 <= var3.getZ() + var7 && var5; ++var9) {
						if (var6 >= 0 && var6 < 256) {
							Block var10 = var1.getBlockState(new Position(var8, var6, var9)).getBlock();
							if (var10.getMaterial() != Material.AIR && var10.getMaterial() != Material.LEAVES) {
								if (var10 != Blocks.WATER && var10 != Blocks.FLOWING_WATER) {
									var5 = false;
								} else if (var6 > var3.getY()) {
									var5 = false;
								}
							}
						} else {
							var5 = false;
						}
					}
				}
			}

			if (!var5) {
				return false;
			} else {
				Block var17 = var1.getBlockState(var3.getDown()).getBlock();
				if ((var17 == Blocks.GRASS || var17 == Blocks.DIRT) && var3.getY() < 256 - var4 - 1) {
					this.a(var1, var3.getDown());

					int var11;
					Position var14;
					int var18;
					int var20;
					for (var18 = var3.getY() - 3 + var4; var18 <= var3.getY() + var4; ++var18) {
						var8 = var18 - (var3.getY() + var4);
						var9 = 2 - var8 / 2;

						for (var20 = var3.getX() - var9; var20 <= var3.getX() + var9; ++var20) {
							var11 = var20 - var3.getX();

							for (int var12 = var3.getZ() - var9; var12 <= var3.getZ() + var9; ++var12) {
								int var13 = var12 - var3.getZ();
								if (Math.abs(var11) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var8 != 0) {
									var14 = new Position(var20, var18, var12);
									if (!var1.getBlockState(var14).getBlock().m()) {
										this.a(var1, var14, Blocks.LEAVES);
									}
								}
							}
						}
					}

					for (var18 = 0; var18 < var4; ++var18) {
						Block var19 = var1.getBlockState(var3.b(var18)).getBlock();
						if (var19.getMaterial() == Material.AIR || var19.getMaterial() == Material.LEAVES || var19 == Blocks.FLOWING_WATER || var19 == Blocks.WATER) {
							this.a(var1, var3.b(var18), Blocks.LOG);
						}
					}

					for (var18 = var3.getY() - 3 + var4; var18 <= var3.getY() + var4; ++var18) {
						var8 = var18 - (var3.getY() + var4);
						var9 = 2 - var8 / 2;

						for (var20 = var3.getX() - var9; var20 <= var3.getX() + var9; ++var20) {
							for (var11 = var3.getZ() - var9; var11 <= var3.getZ() + var9; ++var11) {
								Position var21 = new Position(var20, var18, var11);
								if (var1.getBlockState(var21).getBlock().getMaterial() == Material.LEAVES) {
									Position var22 = var21.getWest();
									var14 = var21.getEast();
									Position var15 = var21.getNorth();
									Position var16 = var21.getSouth();
									if (var2.nextInt(4) == 0 && var1.getBlockState(var22).getBlock().getMaterial() == Material.AIR) {
										this.a(var1, var22, BlockVine.S);
									}

									if (var2.nextInt(4) == 0 && var1.getBlockState(var14).getBlock().getMaterial() == Material.AIR) {
										this.a(var1, var14, BlockVine.T);
									}

									if (var2.nextInt(4) == 0 && var1.getBlockState(var15).getBlock().getMaterial() == Material.AIR) {
										this.a(var1, var15, BlockVine.Q);
									}

									if (var2.nextInt(4) == 0 && var1.getBlockState(var16).getBlock().getMaterial() == Material.AIR) {
										this.a(var1, var16, BlockVine.R);
									}
								}
							}
						}
					}

					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	private void a(World var1, Position var2, int var3) {
		this.a(var1, var2, Blocks.VINE, var3);
		int var4 = 4;

		for (var2 = var2.getDown(); var1.getBlockState(var2).getBlock().getMaterial() == Material.AIR && var4 > 0; --var4) {
			this.a(var1, var2, Blocks.VINE, var3);
			var2 = var2.getDown();
		}

	}
}
