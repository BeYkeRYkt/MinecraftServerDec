package net.minecraft;

import java.util.Random;

class bkk implements bks {

	private bkk() {
	}

	public boolean a(blf var1) {
		return var1.c[BlockFace.EAST.getId()] && !var1.b[BlockFace.EAST.getId()].d;
	}

	public blb a(BlockFace var1, blf var2, Random var3) {
		var2.d = true;
		var2.b[BlockFace.EAST.getId()].d = true;
		return new bku(var1, var2, var3);
	}

	// $FF: synthetic method
	bkk(bkj var1) {
		this();
	}
}
