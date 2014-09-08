package net.minecraft;

import java.util.Random;

public class bkz extends blb {

	public bkz() {
	}

	public bkz(BlockFace var1, blf var2) {
		super(1, var1, var2, 1, 1, 1);
	}

	public boolean a(World var1, Random var2, bjb var3) {
		this.a(var1, var3, 0, 3, 0, 2, 3, 7, b, b, false);
		this.a(var1, var3, 5, 3, 0, 7, 3, 7, b, b, false);
		this.a(var1, var3, 0, 2, 0, 1, 2, 7, b, b, false);
		this.a(var1, var3, 6, 2, 0, 7, 2, 7, b, b, false);
		this.a(var1, var3, 0, 1, 0, 0, 1, 7, b, b, false);
		this.a(var1, var3, 7, 1, 0, 7, 1, 7, b, b, false);
		this.a(var1, var3, 0, 1, 7, 7, 3, 7, b, b, false);
		this.a(var1, var3, 1, 1, 0, 2, 3, 0, b, b, false);
		this.a(var1, var3, 5, 1, 0, 6, 3, 0, b, b, false);
		if (this.k.c[BlockFace.NORTH.getId()]) {
			this.a(var1, var3, 3, 1, 7, 4, 2, 7, f, f, false);
		}

		if (this.k.c[BlockFace.WEST.getId()]) {
			this.a(var1, var3, 0, 1, 3, 1, 2, 4, f, f, false);
		}

		if (this.k.c[BlockFace.EAST.getId()]) {
			this.a(var1, var3, 6, 1, 3, 7, 2, 4, f, f, false);
		}

		return true;
	}
}
