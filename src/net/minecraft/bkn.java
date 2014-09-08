package net.minecraft;

import java.util.Random;

class bkn implements bks {

	private bkn() {
	}

	public boolean a(blf var1) {
		if (var1.c[BlockFace.NORTH.getId()] && !var1.b[BlockFace.NORTH.getId()].d && var1.c[BlockFace.UP.getId()] && !var1.b[BlockFace.UP.getId()].d) {
			blf var2 = var1.b[BlockFace.NORTH.getId()];
			return var2.c[BlockFace.UP.getId()] && !var2.b[BlockFace.UP.getId()].d;
		} else {
			return false;
		}
	}

	public blb a(BlockFace var1, blf var2, Random var3) {
		var2.d = true;
		var2.b[BlockFace.NORTH.getId()].d = true;
		var2.b[BlockFace.UP.getId()].d = true;
		var2.b[BlockFace.NORTH.getId()].b[BlockFace.UP.getId()].d = true;
		return new bkx(var1, var2, var3);
	}

	// $FF: synthetic method
	bkn(bkj var1) {
		this();
	}
}
