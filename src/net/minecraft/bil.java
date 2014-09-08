package net.minecraft;

import java.util.Random;

public class bil extends bhc {

	public bil(boolean var1) {
		super(var1);
	}

	public boolean b(World var1, Random var2, Position var3) {
		int var4 = var2.nextInt(3) + var2.nextInt(3) + 5;
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
					var7 = 2;
				}

				for (var8 = var3.getX() - var7; var8 <= var3.getX() + var7 && var5; ++var8) {
					for (var9 = var3.getZ() - var7; var9 <= var3.getZ() + var7 && var5; ++var9) {
						if (var6 >= 0 && var6 < 256) {
							if (!this.a(var1.getBlockState(new Position(var8, var6, var9)).getBlock())) {
								var5 = false;
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
				Block var20 = var1.getBlockState(var3.b()).getBlock();
				if ((var20 == Blocks.GRASS || var20 == Blocks.DIRT) && var3.getY() < 256 - var4 - 1) {
					this.a(var1, var3.b());
					BlockFace var21 = en.a.a(var2);
					var8 = var4 - var2.nextInt(4) - 1;
					var9 = 3 - var2.nextInt(3);
					int var10 = var3.getX();
					int var11 = var3.getZ();
					int var12 = 0;

					int var14;
					for (int var13 = 0; var13 < var4; ++var13) {
						var14 = var3.getY() + var13;
						if (var13 >= var8 && var9 > 0) {
							var10 += var21.g();
							var11 += var21.i();
							--var9;
						}

						Position var15 = new Position(var10, var14, var11);
						Material var16 = var1.getBlockState(var15).getBlock().getMaterial();
						if (var16 == Material.AIR || var16 == Material.LEAVES) {
							this.a(var1, var15, Blocks.LOG2, ayx.e.a() - 4);
							var12 = var14;
						}
					}

					Position var22 = new Position(var10, var12, var11);

					int var24;
					for (var14 = -3; var14 <= 3; ++var14) {
						for (var24 = -3; var24 <= 3; ++var24) {
							if (Math.abs(var14) != 3 || Math.abs(var24) != 3) {
								this.b(var1, var22.a(var14, 0, var24));
							}
						}
					}

					var22 = var22.a();

					for (var14 = -1; var14 <= 1; ++var14) {
						for (var24 = -1; var24 <= 1; ++var24) {
							this.b(var1, var22.a(var14, 0, var24));
						}
					}

					this.b(var1, var22.g(2));
					this.b(var1, var22.f(2));
					this.b(var1, var22.e(2));
					this.b(var1, var22.d(2));
					var10 = var3.getX();
					var11 = var3.getZ();
					BlockFace var23 = en.a.a(var2);
					if (var23 != var21) {
						var14 = var8 - var2.nextInt(2) - 1;
						var24 = 1 + var2.nextInt(3);
						var12 = 0;

						int var17;
						for (int var25 = var14; var25 < var4 && var24 > 0; --var24) {
							if (var25 >= 1) {
								var17 = var3.getY() + var25;
								var10 += var23.g();
								var11 += var23.i();
								Position var18 = new Position(var10, var17, var11);
								Material var19 = var1.getBlockState(var18).getBlock().getMaterial();
								if (var19 == Material.AIR || var19 == Material.LEAVES) {
									this.a(var1, var18, Blocks.LOG2, ayx.e.a() - 4);
									var12 = var17;
								}
							}

							++var25;
						}

						if (var12 > 0) {
							Position var26 = new Position(var10, var12, var11);

							int var27;
							for (var17 = -2; var17 <= 2; ++var17) {
								for (var27 = -2; var27 <= 2; ++var27) {
									if (Math.abs(var17) != 2 || Math.abs(var27) != 2) {
										this.b(var1, var26.a(var17, 0, var27));
									}
								}
							}

							var26 = var26.a();

							for (var17 = -1; var17 <= 1; ++var17) {
								for (var27 = -1; var27 <= 1; ++var27) {
									this.b(var1, var26.a(var17, 0, var27));
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

	private void b(World var1, Position var2) {
		Material var3 = var1.getBlockState(var2).getBlock().getMaterial();
		if (var3 == Material.AIR || var3 == Material.LEAVES) {
			this.a(var1, var2, Blocks.LEAVES2, 0);
		}

	}
}
