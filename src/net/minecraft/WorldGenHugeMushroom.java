package net.minecraft;

import java.util.Random;

public class WorldGenHugeMushroom extends WorldGenerator {

	private int a = -1;

	public WorldGenHugeMushroom(int var1) {
		super(true);
		this.a = var1;
	}

	public WorldGenHugeMushroom() {
		super(false);
	}

	public boolean b(World var1, Random var2, Position var3) {
		int var4 = var2.nextInt(2);
		if (this.a >= 0) {
			var4 = this.a;
		}

		int var5 = var2.nextInt(3) + 4;
		boolean var6 = true;
		if (var3.getY() >= 1 && var3.getY() + var5 + 1 < 256) {
			int var9;
			int var10;
			for (int var7 = var3.getY(); var7 <= var3.getY() + 1 + var5; ++var7) {
				byte var8 = 3;
				if (var7 <= var3.getY() + 3) {
					var8 = 0;
				}

				for (var9 = var3.getX() - var8; var9 <= var3.getX() + var8 && var6; ++var9) {
					for (var10 = var3.getZ() - var8; var10 <= var3.getZ() + var8 && var6; ++var10) {
						if (var7 >= 0 && var7 < 256) {
							Block var11 = var1.getBlockState(new Position(var9, var7, var10)).getBlock();
							if (var11.getMaterial() != Material.AIR && var11.getMaterial() != Material.LEAVES) {
								var6 = false;
							}
						} else {
							var6 = false;
						}
					}
				}
			}

			if (!var6) {
				return false;
			} else {
				Block var15 = var1.getBlockState(var3.getDown()).getBlock();
				if (var15 != Blocks.DIRT && var15 != Blocks.GRASS && var15 != Blocks.MYCELIUM) {
					return false;
				} else {
					int var16 = var3.getY() + var5;
					if (var4 == 1) {
						var16 = var3.getY() + var5 - 3;
					}

					for (var9 = var16; var9 <= var3.getY() + var5; ++var9) {
						var10 = 1;
						if (var9 < var3.getY() + var5) {
							++var10;
						}

						if (var4 == 0) {
							var10 = 3;
						}

						for (int var18 = var3.getX() - var10; var18 <= var3.getX() + var10; ++var18) {
							for (int var12 = var3.getZ() - var10; var12 <= var3.getZ() + var10; ++var12) {
								int var13 = 5;
								if (var18 == var3.getX() - var10) {
									--var13;
								}

								if (var18 == var3.getX() + var10) {
									++var13;
								}

								if (var12 == var3.getZ() - var10) {
									var13 -= 3;
								}

								if (var12 == var3.getZ() + var10) {
									var13 += 3;
								}

								if (var4 == 0 || var9 < var3.getY() + var5) {
									if ((var18 == var3.getX() - var10 || var18 == var3.getX() + var10) && (var12 == var3.getZ() - var10 || var12 == var3.getZ() + var10)) {
										continue;
									}

									if (var18 == var3.getX() - (var10 - 1) && var12 == var3.getZ() - var10) {
										var13 = 1;
									}

									if (var18 == var3.getX() - var10 && var12 == var3.getZ() - (var10 - 1)) {
										var13 = 1;
									}

									if (var18 == var3.getX() + (var10 - 1) && var12 == var3.getZ() - var10) {
										var13 = 3;
									}

									if (var18 == var3.getX() + var10 && var12 == var3.getZ() - (var10 - 1)) {
										var13 = 3;
									}

									if (var18 == var3.getX() - (var10 - 1) && var12 == var3.getZ() + var10) {
										var13 = 7;
									}

									if (var18 == var3.getX() - var10 && var12 == var3.getZ() + (var10 - 1)) {
										var13 = 7;
									}

									if (var18 == var3.getX() + (var10 - 1) && var12 == var3.getZ() + var10) {
										var13 = 9;
									}

									if (var18 == var3.getX() + var10 && var12 == var3.getZ() + (var10 - 1)) {
										var13 = 9;
									}
								}

								if (var13 == 5 && var9 < var3.getY() + var5) {
									var13 = 0;
								}

								if (var13 != 0 || var3.getY() >= var3.getY() + var5 - 1) {
									Position var14 = new Position(var18, var9, var12);
									if (!var1.getBlockState(var14).getBlock().m()) {
										this.a(var1, var14, Block.getBlockById(Block.getBlockId(Blocks.BROWN_MUSHROOM_BLOCK) + var4), var13);
									}
								}
							}
						}
					}

					for (var9 = 0; var9 < var5; ++var9) {
						Block var17 = var1.getBlockState(var3.getUp(var9)).getBlock();
						if (!var17.m()) {
							this.a(var1, var3.getUp(var9), Block.getBlockById(Block.getBlockId(Blocks.BROWN_MUSHROOM_BLOCK) + var4), 10);
						}
					}

					return true;
				}
			}
		} else {
			return false;
		}
	}
}
