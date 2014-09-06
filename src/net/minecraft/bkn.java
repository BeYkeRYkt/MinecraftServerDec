package net.minecraft;

import java.util.Random;

class bkn implements bks {

	private bkn() {
	}

	public boolean a(blf var1) {
		if (var1.c[BlockFace.c.a()] && !var1.b[BlockFace.c.a()].d && var1.c[BlockFace.b.a()] && !var1.b[BlockFace.b.a()].d) {
			blf var2 = var1.b[BlockFace.c.a()];
			return var2.c[BlockFace.b.a()] && !var2.b[BlockFace.b.a()].d;
		} else {
			return false;
		}
	}

	public blb a(BlockFace var1, blf var2, Random var3) {
		var2.d = true;
		var2.b[BlockFace.c.a()].d = true;
		var2.b[BlockFace.b.a()].d = true;
		var2.b[BlockFace.c.a()].b[BlockFace.b.a()].d = true;
		return new bkx(var1, var2, var3);
	}

	// $FF: synthetic method
	bkn(bkj var1) {
		this();
	}
}
