package net.minecraft;

public class bpi extends bpa {

	private bpa c;
	private bpa d;

	public bpi(long var1, bpa var3, bpa var4) {
		super(var1);
		this.c = var3;
		this.d = var4;
	}

	public void a(long var1) {
		this.c.a(var1);
		this.d.a(var1);
		super.a(var1);
	}

	public int[] a(int var1, int var2, int var3, int var4) {
		int[] var5 = this.c.a(var1, var2, var3, var4);
		int[] var6 = this.d.a(var1, var2, var3, var4);
		int[] var7 = IntCache.allocate(var3 * var4);

		for (int var8 = 0; var8 < var3 * var4; ++var8) {
			if (var5[var8] != BiomeBase.OCEAN.az && var5[var8] != BiomeBase.DEEP_OCEAN.az) {
				if (var6[var8] == BiomeBase.RIVER.az) {
					if (var5[var8] == BiomeBase.ICE_PLAINS.az) {
						var7[var8] = BiomeBase.FROZEN_RIVER.az;
					} else if (var5[var8] != BiomeBase.MUSHROOM_ISLAND.az && var5[var8] != BiomeBase.MUSHROOM_SHORE.az) {
						var7[var8] = var6[var8] & 255;
					} else {
						var7[var8] = BiomeBase.MUSHROOM_SHORE.az;
					}
				} else {
					var7[var8] = var5[var8];
				}
			} else {
				var7[var8] = var5[var8];
			}
		}

		return var7;
	}
}
