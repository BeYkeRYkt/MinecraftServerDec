package net.minecraft;

import java.util.Random;

public class blh extends StructureStart {

	public blh() {
	}

	public blh(World var1, Random var2, int var3, int var4) {
		super(var3, var4);
		BiomeBase var5 = var1.b(new Position(var3 * 16 + 8, 0, var4 * 16 + 8));
		if (var5 != BiomeBase.JUNGLE && var5 != BiomeBase.JUNGLE_HILLS) {
			if (var5 == BiomeBase.SWAMPLAND) {
				blo var7 = new blo(var2, var3 * 16, var4 * 16);
				this.a.add(var7);
			} else if (var5 == BiomeBase.DESERT || var5 == BiomeBase.DESERT_HILLS) {
				blk var8 = new blk(var2, var3 * 16, var4 * 16);
				this.a.add(var8);
			}
		} else {
			bll var6 = new bll(var2, var3 * 16, var4 * 16);
			this.a.add(var6);
		}

		this.c();
	}
}
