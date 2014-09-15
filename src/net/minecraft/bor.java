package net.minecraft;

public class bor extends bpa {

	public bor(long var1, bpa var3) {
		super(var1);
		this.a = var3;
	}

	public int[] a(int var1, int var2, int var3, int var4) {
		int[] var5 = this.a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
		int[] var6 = boy.a(var3 * var4);

		for (int var7 = 0; var7 < var4; ++var7) {
			for (int var8 = 0; var8 < var3; ++var8) {
				this.a((long) (var8 + var1), (long) (var7 + var2));
				int var9 = var5[var8 + 1 + (var7 + 1) * (var3 + 2)];
				if (!this.a(var5, var6, var8, var7, var3, var9, BiomeBase.EXTREME_HILLS.az, BiomeBase.SMALL_MOUNTAINS.az) && !this.b(var5, var6, var8, var7, var3, var9, BiomeBase.MESA_PLATEAU_F.az, BiomeBase.MESA.az) && !this.b(var5, var6, var8, var7, var3, var9, BiomeBase.MESA_PLATEAU.az, BiomeBase.MESA.az) && !this.b(var5, var6, var8, var7, var3, var9, BiomeBase.MEGA_TAIGA.az, BiomeBase.TAIGA.az)) {
					int var10;
					int var11;
					int var12;
					int var13;
					if (var9 == BiomeBase.DESERT.az) {
						var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
						var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
						var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
						var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
						if (var10 != BiomeBase.ICE_PLAINS.az && var11 != BiomeBase.ICE_PLAINS.az && var12 != BiomeBase.ICE_PLAINS.az && var13 != BiomeBase.ICE_PLAINS.az) {
							var6[var8 + var7 * var3] = var9;
						} else {
							var6[var8 + var7 * var3] = BiomeBase.EXTREME_HILLS_PLUS.az;
						}
					} else if (var9 == BiomeBase.SWAMPLAND.az) {
						var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
						var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
						var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
						var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
						if (var10 != BiomeBase.DESERT.az && var11 != BiomeBase.DESERT.az && var12 != BiomeBase.DESERT.az && var13 != BiomeBase.DESERT.az && var10 != BiomeBase.COLD_TAIGA.az && var11 != BiomeBase.COLD_TAIGA.az && var12 != BiomeBase.COLD_TAIGA.az && var13 != BiomeBase.COLD_TAIGA.az && var10 != BiomeBase.ICE_PLAINS.az && var11 != BiomeBase.ICE_PLAINS.az && var12 != BiomeBase.ICE_PLAINS.az && var13 != BiomeBase.ICE_PLAINS.az) {
							if (var10 != BiomeBase.JUNGLE.az && var13 != BiomeBase.JUNGLE.az && var11 != BiomeBase.JUNGLE.az && var12 != BiomeBase.JUNGLE.az) {
								var6[var8 + var7 * var3] = var9;
							} else {
								var6[var8 + var7 * var3] = BiomeBase.JUNGLE_EDGE.az;
							}
						} else {
							var6[var8 + var7 * var3] = BiomeBase.PLAINS.az;
						}
					} else {
						var6[var8 + var7 * var3] = var9;
					}
				}
			}
		}

		return var6;
	}

	private boolean a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (!a(var6, var7)) {
			return false;
		} else {
			int var9 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
			int var10 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
			int var11 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
			int var12 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
			if (this.b(var9, var7) && this.b(var10, var7) && this.b(var11, var7) && this.b(var12, var7)) {
				var2[var3 + var4 * var5] = var6;
			} else {
				var2[var3 + var4 * var5] = var8;
			}

			return true;
		}
	}

	private boolean b(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (var6 != var7) {
			return false;
		} else {
			int var9 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
			int var10 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
			int var11 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
			int var12 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
			if (a(var9, var7) && a(var10, var7) && a(var11, var7) && a(var12, var7)) {
				var2[var3 + var4 * var5] = var6;
			} else {
				var2[var3 + var4 * var5] = var8;
			}

			return true;
		}
	}

	private boolean b(int var1, int var2) {
		if (a(var1, var2)) {
			return true;
		} else {
			BiomeBase var3 = BiomeBase.e(var1);
			BiomeBase var4 = BiomeBase.e(var2);
			if (var3 != null && var4 != null) {
				EnumBiomeTemperature var5 = var3.m();
				EnumBiomeTemperature var6 = var4.m();
				return var5 == var6 || var5 == EnumBiomeTemperature.c || var6 == EnumBiomeTemperature.c;
			} else {
				return false;
			}
		}
	}
}
