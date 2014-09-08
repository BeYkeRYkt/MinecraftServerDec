package net.minecraft;

import java.util.Random;

public class bku extends blb {

	public bku() {
	}

	public bku(BlockFace var1, blf var2, Random var3) {
		super(1, var1, var2, 2, 1, 1);
	}

	public boolean a(World var1, Random var2, bjb var3) {
		blf var4 = this.k.b[BlockFace.EAST.getId()];
		blf var5 = this.k;
		if (this.k.a / 25 > 0) {
			this.a(var1, var3, 8, 0, var4.c[BlockFace.DOWN.getId()]);
			this.a(var1, var3, 0, 0, var5.c[BlockFace.DOWN.getId()]);
		}

		if (var5.b[BlockFace.UP.getId()] == null) {
			this.a(var1, var3, 1, 4, 1, 7, 4, 6, a);
		}

		if (var4.b[BlockFace.UP.getId()] == null) {
			this.a(var1, var3, 8, 4, 1, 14, 4, 6, a);
		}

		this.a(var1, var3, 0, 3, 0, 0, 3, 7, b, b, false);
		this.a(var1, var3, 15, 3, 0, 15, 3, 7, b, b, false);
		this.a(var1, var3, 1, 3, 0, 15, 3, 0, b, b, false);
		this.a(var1, var3, 1, 3, 7, 14, 3, 7, b, b, false);
		this.a(var1, var3, 0, 2, 0, 0, 2, 7, a, a, false);
		this.a(var1, var3, 15, 2, 0, 15, 2, 7, a, a, false);
		this.a(var1, var3, 1, 2, 0, 15, 2, 0, a, a, false);
		this.a(var1, var3, 1, 2, 7, 14, 2, 7, a, a, false);
		this.a(var1, var3, 0, 1, 0, 0, 1, 7, b, b, false);
		this.a(var1, var3, 15, 1, 0, 15, 1, 7, b, b, false);
		this.a(var1, var3, 1, 1, 0, 15, 1, 0, b, b, false);
		this.a(var1, var3, 1, 1, 7, 14, 1, 7, b, b, false);
		this.a(var1, var3, 5, 1, 0, 10, 1, 4, b, b, false);
		this.a(var1, var3, 6, 2, 0, 9, 2, 3, a, a, false);
		this.a(var1, var3, 5, 3, 0, 10, 3, 4, b, b, false);
		this.a(var1, e, 6, 2, 3, var3);
		this.a(var1, e, 9, 2, 3, var3);
		if (var5.c[BlockFace.SOUTH.getId()]) {
			this.a(var1, var3, 3, 1, 0, 4, 2, 0, f, f, false);
		}

		if (var5.c[BlockFace.NORTH.getId()]) {
			this.a(var1, var3, 3, 1, 7, 4, 2, 7, f, f, false);
		}

		if (var5.c[BlockFace.WEST.getId()]) {
			this.a(var1, var3, 0, 1, 3, 0, 2, 4, f, f, false);
		}

		if (var4.c[BlockFace.SOUTH.getId()]) {
			this.a(var1, var3, 11, 1, 0, 12, 2, 0, f, f, false);
		}

		if (var4.c[BlockFace.NORTH.getId()]) {
			this.a(var1, var3, 11, 1, 7, 12, 2, 7, f, f, false);
		}

		if (var4.c[BlockFace.EAST.getId()]) {
			this.a(var1, var3, 15, 1, 3, 15, 2, 4, f, f, false);
		}

		return true;
	}
}
