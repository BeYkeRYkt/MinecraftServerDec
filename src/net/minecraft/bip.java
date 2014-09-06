package net.minecraft;

import java.util.Random;

public class bip extends bhc {

	public bip() {
		super(false);
	}

	public boolean b(World var1, Random var2, Position var3) {
		int var4;
		for (var4 = var2.nextInt(4) + 5; var1.p(var3.b()).getBlock().r() == Material.WATER; var3 = var3.b()) {
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
							Block var10 = var1.p(new Position(var8, var6, var9)).getBlock();
							if (var10.r() != Material.AIR && var10.r() != Material.LEAVES) {
								if (var10 != aty.j && var10 != aty.i) {
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
				Block var17 = var1.p(var3.b()).getBlock();
				if ((var17 == aty.c || var17 == aty.d) && var3.getY() < 256 - var4 - 1) {
					this.a(var1, var3.b());

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
									if (!var1.p(var14).getBlock().m()) {
										this.a(var1, var14, aty.t);
									}
								}
							}
						}
					}

					for (var18 = 0; var18 < var4; ++var18) {
						Block var19 = var1.p(var3.b(var18)).getBlock();
						if (var19.r() == Material.AIR || var19.r() == Material.LEAVES || var19 == aty.i || var19 == aty.j) {
							this.a(var1, var3.b(var18), aty.r);
						}
					}

					for (var18 = var3.getY() - 3 + var4; var18 <= var3.getY() + var4; ++var18) {
						var8 = var18 - (var3.getY() + var4);
						var9 = 2 - var8 / 2;

						for (var20 = var3.getX() - var9; var20 <= var3.getX() + var9; ++var20) {
							for (var11 = var3.getZ() - var9; var11 <= var3.getZ() + var9; ++var11) {
								Position var21 = new Position(var20, var18, var11);
								if (var1.p(var21).getBlock().r() == Material.LEAVES) {
									Position var22 = var21.e();
									var14 = var21.f();
									Position var15 = var21.c();
									Position var16 = var21.d();
									if (var2.nextInt(4) == 0 && var1.p(var22).getBlock().r() == Material.AIR) {
										this.a(var1, var22, BlockVine.S);
									}

									if (var2.nextInt(4) == 0 && var1.p(var14).getBlock().r() == Material.AIR) {
										this.a(var1, var14, BlockVine.T);
									}

									if (var2.nextInt(4) == 0 && var1.p(var15).getBlock().r() == Material.AIR) {
										this.a(var1, var15, BlockVine.Q);
									}

									if (var2.nextInt(4) == 0 && var1.p(var16).getBlock().r() == Material.AIR) {
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
		this.a(var1, var2, aty.bn, var3);
		int var4 = 4;

		for (var2 = var2.b(); var1.p(var2).getBlock().r() == Material.AIR && var4 > 0; --var4) {
			this.a(var1, var2, aty.bn, var3);
			var2 = var2.b();
		}

	}
}
