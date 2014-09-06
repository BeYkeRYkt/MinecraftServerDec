package net.minecraft;

import java.util.Random;

public class bhf extends bhc {

	private boolean a;

	public bhf(boolean var1, boolean var2) {
		super(var1);
		this.a = var2;
	}

	public boolean b(World var1, Random var2, Position var3) {
		int var4 = var2.nextInt(3) + 5;
		if (this.a) {
			var4 += var2.nextInt(7);
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
					var7 = 2;
				}

				for (var8 = var3.getX() - var7; var8 <= var3.getX() + var7 && var5; ++var8) {
					for (var9 = var3.getZ() - var7; var9 <= var3.getZ() + var7 && var5; ++var9) {
						if (var6 >= 0 && var6 < 256) {
							if (!this.a(var1.p(new Position(var8, var6, var9)).getBlock())) {
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
				Block var16 = var1.p(var3.b()).getBlock();
				if ((var16 == aty.c || var16 == aty.d || var16 == aty.ak) && var3.getY() < 256 - var4 - 1) {
					this.a(var1, var3.b());

					int var17;
					for (var17 = var3.getY() - 3 + var4; var17 <= var3.getY() + var4; ++var17) {
						var8 = var17 - (var3.getY() + var4);
						var9 = 1 - var8 / 2;

						for (int var10 = var3.getX() - var9; var10 <= var3.getX() + var9; ++var10) {
							int var11 = var10 - var3.getX();

							for (int var12 = var3.getZ() - var9; var12 <= var3.getZ() + var9; ++var12) {
								int var13 = var12 - var3.getZ();
								if (Math.abs(var11) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var8 != 0) {
									Position var14 = new Position(var10, var17, var12);
									Block var15 = var1.p(var14).getBlock();
									if (var15.r() == Material.AIR || var15.r() == Material.LEAVES) {
										this.a(var1, var14, aty.t, ayx.c.a());
									}
								}
							}
						}
					}

					for (var17 = 0; var17 < var4; ++var17) {
						Block var18 = var1.p(var3.b(var17)).getBlock();
						if (var18.r() == Material.AIR || var18.r() == Material.LEAVES) {
							this.a(var1, var3.b(var17), aty.r, ayx.c.a());
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
}
