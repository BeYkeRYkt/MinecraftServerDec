package net.minecraft;

import java.util.Random;

public class bkv extends blb {

	public bkv() {
	}

	public bkv(BlockFace var1, blf var2, Random var3) {
		super(1, var1, var2, 2, 2, 1);
	}

	public boolean a(World var1, Random var2, bjb var3) {
		blf var4 = this.k.b[BlockFace.f.a()];
		blf var5 = this.k;
		blf var6 = var5.b[BlockFace.b.a()];
		blf var7 = var4.b[BlockFace.b.a()];
		if (this.k.a / 25 > 0) {
			this.a(var1, var3, 8, 0, var4.c[BlockFace.a.a()]);
			this.a(var1, var3, 0, 0, var5.c[BlockFace.a.a()]);
		}

		if (var6.b[BlockFace.b.a()] == null) {
			this.a(var1, var3, 1, 8, 1, 7, 8, 6, a);
		}

		if (var7.b[BlockFace.b.a()] == null) {
			this.a(var1, var3, 8, 8, 1, 14, 8, 6, a);
		}

		for (int var8 = 1; var8 <= 7; ++var8) {
			bec var9 = b;
			if (var8 == 2 || var8 == 6) {
				var9 = a;
			}

			this.a(var1, var3, 0, var8, 0, 0, var8, 7, var9, var9, false);
			this.a(var1, var3, 15, var8, 0, 15, var8, 7, var9, var9, false);
			this.a(var1, var3, 1, var8, 0, 15, var8, 0, var9, var9, false);
			this.a(var1, var3, 1, var8, 7, 14, var8, 7, var9, var9, false);
		}

		this.a(var1, var3, 2, 1, 3, 2, 7, 4, b, b, false);
		this.a(var1, var3, 3, 1, 2, 4, 7, 2, b, b, false);
		this.a(var1, var3, 3, 1, 5, 4, 7, 5, b, b, false);
		this.a(var1, var3, 13, 1, 3, 13, 7, 4, b, b, false);
		this.a(var1, var3, 11, 1, 2, 12, 7, 2, b, b, false);
		this.a(var1, var3, 11, 1, 5, 12, 7, 5, b, b, false);
		this.a(var1, var3, 5, 1, 3, 5, 3, 4, b, b, false);
		this.a(var1, var3, 10, 1, 3, 10, 3, 4, b, b, false);
		this.a(var1, var3, 5, 7, 2, 10, 7, 5, b, b, false);
		this.a(var1, var3, 5, 5, 2, 5, 7, 2, b, b, false);
		this.a(var1, var3, 10, 5, 2, 10, 7, 2, b, b, false);
		this.a(var1, var3, 5, 5, 5, 5, 7, 5, b, b, false);
		this.a(var1, var3, 10, 5, 5, 10, 7, 5, b, b, false);
		this.a(var1, b, 6, 6, 2, var3);
		this.a(var1, b, 9, 6, 2, var3);
		this.a(var1, b, 6, 6, 5, var3);
		this.a(var1, b, 9, 6, 5, var3);
		this.a(var1, var3, 5, 4, 3, 6, 4, 4, b, b, false);
		this.a(var1, var3, 9, 4, 3, 10, 4, 4, b, b, false);
		this.a(var1, e, 5, 4, 2, var3);
		this.a(var1, e, 5, 4, 5, var3);
		this.a(var1, e, 10, 4, 2, var3);
		this.a(var1, e, 10, 4, 5, var3);
		if (var5.c[BlockFace.d.a()]) {
			this.a(var1, var3, 3, 1, 0, 4, 2, 0, f, f, false);
		}

		if (var5.c[BlockFace.c.a()]) {
			this.a(var1, var3, 3, 1, 7, 4, 2, 7, f, f, false);
		}

		if (var5.c[BlockFace.e.a()]) {
			this.a(var1, var3, 0, 1, 3, 0, 2, 4, f, f, false);
		}

		if (var4.c[BlockFace.d.a()]) {
			this.a(var1, var3, 11, 1, 0, 12, 2, 0, f, f, false);
		}

		if (var4.c[BlockFace.c.a()]) {
			this.a(var1, var3, 11, 1, 7, 12, 2, 7, f, f, false);
		}

		if (var4.c[BlockFace.f.a()]) {
			this.a(var1, var3, 15, 1, 3, 15, 2, 4, f, f, false);
		}

		if (var6.c[BlockFace.d.a()]) {
			this.a(var1, var3, 3, 5, 0, 4, 6, 0, f, f, false);
		}

		if (var6.c[BlockFace.c.a()]) {
			this.a(var1, var3, 3, 5, 7, 4, 6, 7, f, f, false);
		}

		if (var6.c[BlockFace.e.a()]) {
			this.a(var1, var3, 0, 5, 3, 0, 6, 4, f, f, false);
		}

		if (var7.c[BlockFace.d.a()]) {
			this.a(var1, var3, 11, 5, 0, 12, 6, 0, f, f, false);
		}

		if (var7.c[BlockFace.c.a()]) {
			this.a(var1, var3, 11, 5, 7, 12, 6, 7, f, f, false);
		}

		if (var7.c[BlockFace.f.a()]) {
			this.a(var1, var3, 15, 5, 3, 15, 6, 4, f, f, false);
		}

		return true;
	}
}
