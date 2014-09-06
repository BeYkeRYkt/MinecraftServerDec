package net.minecraft;

import java.util.Random;

class bko implements bks {

	private bko() {
	}

	public boolean a(blf var1) {
		return var1.c[BlockFace.c.a()] && !var1.b[BlockFace.c.a()].d;
	}

	public blb a(BlockFace var1, blf var2, Random var3) {
		blf var4 = var2;
		if (!var2.c[BlockFace.c.a()] || var2.b[BlockFace.c.a()].d) {
			var4 = var2.b[BlockFace.d.a()];
		}

		var4.d = true;
		var4.b[BlockFace.c.a()].d = true;
		return new bky(var1, var4, var3);
	}

	// $FF: synthetic method
	bko(bkj var1) {
		this();
	}
}
