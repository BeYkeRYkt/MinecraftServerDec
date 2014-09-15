package net.minecraft;

import java.util.Random;

class bkq implements bks {

	private bkq() {
	}

	public boolean a(blf var1) {
		return !var1.c[BlockFace.WEST.getId()] && !var1.c[BlockFace.EAST.getId()] && !var1.c[BlockFace.NORTH.getId()] && !var1.c[BlockFace.SOUTH.getId()] && !var1.c[BlockFace.UP.getId()];
	}

	public blb a(BlockFace var1, blf var2, Random var3) {
		var2.d = true;
		return new bld(var1, var2, var3);
	}

	// $FF: synthetic method
	bkq(bkj var1) {
		this();
	}
}
