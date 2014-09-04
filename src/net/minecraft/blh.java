package net.minecraft;

import java.util.Random;

public class blh extends bmv {

	public blh() {
	}

	public blh(World var1, Random var2, int var3, int var4) {
		super(var3, var4);
		arm var5 = var1.b(new dt(var3 * 16 + 8, 0, var4 * 16 + 8));
		if (var5 != arm.K && var5 != arm.L) {
			if (var5 == arm.v) {
				blo var7 = new blo(var2, var3 * 16, var4 * 16);
				this.a.add(var7);
			} else if (var5 == arm.r || var5 == arm.G) {
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
