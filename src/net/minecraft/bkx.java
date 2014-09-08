package net.minecraft;

import java.util.Random;

public class bkx extends blb {

	public bkx() {
	}

	public bkx(BlockFace var1, blf var2, Random var3) {
		super(1, var1, var2, 1, 2, 2);
	}

	public boolean a(World var1, Random var2, bjb var3) {
		blf var4 = this.k.b[BlockFace.NORTH.getId()];
		blf var5 = this.k;
		blf var6 = var4.b[BlockFace.UP.getId()];
		blf var7 = var5.b[BlockFace.UP.getId()];
		if (this.k.a / 25 > 0) {
			this.a(var1, var3, 0, 8, var4.c[BlockFace.DOWN.getId()]);
			this.a(var1, var3, 0, 0, var5.c[BlockFace.DOWN.getId()]);
		}

		if (var7.b[BlockFace.UP.getId()] == null) {
			this.a(var1, var3, 1, 8, 1, 6, 8, 7, a);
		}

		if (var6.b[BlockFace.UP.getId()] == null) {
			this.a(var1, var3, 1, 8, 8, 6, 8, 14, a);
		}

		int var8;
		bec var9;
		for (var8 = 1; var8 <= 7; ++var8) {
			var9 = b;
			if (var8 == 2 || var8 == 6) {
				var9 = a;
			}

			this.a(var1, var3, 0, var8, 0, 0, var8, 15, var9, var9, false);
			this.a(var1, var3, 7, var8, 0, 7, var8, 15, var9, var9, false);
			this.a(var1, var3, 1, var8, 0, 6, var8, 0, var9, var9, false);
			this.a(var1, var3, 1, var8, 15, 6, var8, 15, var9, var9, false);
		}

		for (var8 = 1; var8 <= 7; ++var8) {
			var9 = c;
			if (var8 == 2 || var8 == 6) {
				var9 = e;
			}

			this.a(var1, var3, 3, var8, 7, 4, var8, 8, var9, var9, false);
		}

		if (var5.c[BlockFace.SOUTH.getId()]) {
			this.a(var1, var3, 3, 1, 0, 4, 2, 0, f, f, false);
		}

		if (var5.c[BlockFace.EAST.getId()]) {
			this.a(var1, var3, 7, 1, 3, 7, 2, 4, f, f, false);
		}

		if (var5.c[BlockFace.WEST.getId()]) {
			this.a(var1, var3, 0, 1, 3, 0, 2, 4, f, f, false);
		}

		if (var4.c[BlockFace.NORTH.getId()]) {
			this.a(var1, var3, 3, 1, 15, 4, 2, 15, f, f, false);
		}

		if (var4.c[BlockFace.WEST.getId()]) {
			this.a(var1, var3, 0, 1, 11, 0, 2, 12, f, f, false);
		}

		if (var4.c[BlockFace.EAST.getId()]) {
			this.a(var1, var3, 7, 1, 11, 7, 2, 12, f, f, false);
		}

		if (var7.c[BlockFace.SOUTH.getId()]) {
			this.a(var1, var3, 3, 5, 0, 4, 6, 0, f, f, false);
		}

		if (var7.c[BlockFace.EAST.getId()]) {
			this.a(var1, var3, 7, 5, 3, 7, 6, 4, f, f, false);
			this.a(var1, var3, 5, 4, 2, 6, 4, 5, b, b, false);
			this.a(var1, var3, 6, 1, 2, 6, 3, 2, b, b, false);
			this.a(var1, var3, 6, 1, 5, 6, 3, 5, b, b, false);
		}

		if (var7.c[BlockFace.WEST.getId()]) {
			this.a(var1, var3, 0, 5, 3, 0, 6, 4, f, f, false);
			this.a(var1, var3, 1, 4, 2, 2, 4, 5, b, b, false);
			this.a(var1, var3, 1, 1, 2, 1, 3, 2, b, b, false);
			this.a(var1, var3, 1, 1, 5, 1, 3, 5, b, b, false);
		}

		if (var6.c[BlockFace.NORTH.getId()]) {
			this.a(var1, var3, 3, 5, 15, 4, 6, 15, f, f, false);
		}

		if (var6.c[BlockFace.WEST.getId()]) {
			this.a(var1, var3, 0, 5, 11, 0, 6, 12, f, f, false);
			this.a(var1, var3, 1, 4, 10, 2, 4, 13, b, b, false);
			this.a(var1, var3, 1, 1, 10, 1, 3, 10, b, b, false);
			this.a(var1, var3, 1, 1, 13, 1, 3, 13, b, b, false);
		}

		if (var6.c[BlockFace.EAST.getId()]) {
			this.a(var1, var3, 7, 5, 11, 7, 6, 12, f, f, false);
			this.a(var1, var3, 5, 4, 10, 6, 4, 13, b, b, false);
			this.a(var1, var3, 6, 1, 10, 6, 3, 10, b, b, false);
			this.a(var1, var3, 6, 1, 13, 6, 3, 13, b, b, false);
		}

		return true;
	}
}
