package net.minecraft;

import java.util.Random;

public class blc extends blb {

	private int o;

	public blc() {
	}

	public blc(BlockFace var1, blf var2, Random var3) {
		super(1, var1, var2, 1, 1, 1);
		this.o = var3.nextInt(3);
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.k.a / 25 > 0) {
			this.a(var1, var3, 0, 0, this.k.c[BlockFace.DOWN.getId()]);
		}

		if (this.k.b[BlockFace.UP.getId()] == null) {
			this.a(var1, var3, 1, 4, 1, 6, 4, 6, a);
		}

		boolean var4 = this.o != 0 && var2.nextBoolean() && !this.k.c[BlockFace.DOWN.getId()] && !this.k.c[BlockFace.UP.getId()] && this.k.c() > 1;
		if (this.o == 0) {
			this.a(var1, var3, 0, 1, 0, 2, 1, 2, b, b, false);
			this.a(var1, var3, 0, 3, 0, 2, 3, 2, b, b, false);
			this.a(var1, var3, 0, 2, 0, 0, 2, 2, a, a, false);
			this.a(var1, var3, 1, 2, 0, 2, 2, 0, a, a, false);
			this.a(var1, e, 1, 2, 1, var3);
			this.a(var1, var3, 5, 1, 0, 7, 1, 2, b, b, false);
			this.a(var1, var3, 5, 3, 0, 7, 3, 2, b, b, false);
			this.a(var1, var3, 7, 2, 0, 7, 2, 2, a, a, false);
			this.a(var1, var3, 5, 2, 0, 6, 2, 0, a, a, false);
			this.a(var1, e, 6, 2, 1, var3);
			this.a(var1, var3, 0, 1, 5, 2, 1, 7, b, b, false);
			this.a(var1, var3, 0, 3, 5, 2, 3, 7, b, b, false);
			this.a(var1, var3, 0, 2, 5, 0, 2, 7, a, a, false);
			this.a(var1, var3, 1, 2, 7, 2, 2, 7, a, a, false);
			this.a(var1, e, 1, 2, 6, var3);
			this.a(var1, var3, 5, 1, 5, 7, 1, 7, b, b, false);
			this.a(var1, var3, 5, 3, 5, 7, 3, 7, b, b, false);
			this.a(var1, var3, 7, 2, 5, 7, 2, 7, a, a, false);
			this.a(var1, var3, 5, 2, 7, 6, 2, 7, a, a, false);
			this.a(var1, e, 6, 2, 6, var3);
			if (this.k.c[BlockFace.SOUTH.getId()]) {
				this.a(var1, var3, 3, 3, 0, 4, 3, 0, b, b, false);
			} else {
				this.a(var1, var3, 3, 3, 0, 4, 3, 1, b, b, false);
				this.a(var1, var3, 3, 2, 0, 4, 2, 0, a, a, false);
				this.a(var1, var3, 3, 1, 0, 4, 1, 1, b, b, false);
			}

			if (this.k.c[BlockFace.NORTH.getId()]) {
				this.a(var1, var3, 3, 3, 7, 4, 3, 7, b, b, false);
			} else {
				this.a(var1, var3, 3, 3, 6, 4, 3, 7, b, b, false);
				this.a(var1, var3, 3, 2, 7, 4, 2, 7, a, a, false);
				this.a(var1, var3, 3, 1, 6, 4, 1, 7, b, b, false);
			}

			if (this.k.c[BlockFace.WEST.getId()]) {
				this.a(var1, var3, 0, 3, 3, 0, 3, 4, b, b, false);
			} else {
				this.a(var1, var3, 0, 3, 3, 1, 3, 4, b, b, false);
				this.a(var1, var3, 0, 2, 3, 0, 2, 4, a, a, false);
				this.a(var1, var3, 0, 1, 3, 1, 1, 4, b, b, false);
			}

			if (this.k.c[BlockFace.EAST.getId()]) {
				this.a(var1, var3, 7, 3, 3, 7, 3, 4, b, b, false);
			} else {
				this.a(var1, var3, 6, 3, 3, 7, 3, 4, b, b, false);
				this.a(var1, var3, 7, 2, 3, 7, 2, 4, a, a, false);
				this.a(var1, var3, 6, 1, 3, 7, 1, 4, b, b, false);
			}
		} else if (this.o == 1) {
			this.a(var1, var3, 2, 1, 2, 2, 3, 2, b, b, false);
			this.a(var1, var3, 2, 1, 5, 2, 3, 5, b, b, false);
			this.a(var1, var3, 5, 1, 5, 5, 3, 5, b, b, false);
			this.a(var1, var3, 5, 1, 2, 5, 3, 2, b, b, false);
			this.a(var1, e, 2, 2, 2, var3);
			this.a(var1, e, 2, 2, 5, var3);
			this.a(var1, e, 5, 2, 5, var3);
			this.a(var1, e, 5, 2, 2, var3);
			this.a(var1, var3, 0, 1, 0, 1, 3, 0, b, b, false);
			this.a(var1, var3, 0, 1, 1, 0, 3, 1, b, b, false);
			this.a(var1, var3, 0, 1, 7, 1, 3, 7, b, b, false);
			this.a(var1, var3, 0, 1, 6, 0, 3, 6, b, b, false);
			this.a(var1, var3, 6, 1, 7, 7, 3, 7, b, b, false);
			this.a(var1, var3, 7, 1, 6, 7, 3, 6, b, b, false);
			this.a(var1, var3, 6, 1, 0, 7, 3, 0, b, b, false);
			this.a(var1, var3, 7, 1, 1, 7, 3, 1, b, b, false);
			this.a(var1, a, 1, 2, 0, var3);
			this.a(var1, a, 0, 2, 1, var3);
			this.a(var1, a, 1, 2, 7, var3);
			this.a(var1, a, 0, 2, 6, var3);
			this.a(var1, a, 6, 2, 7, var3);
			this.a(var1, a, 7, 2, 6, var3);
			this.a(var1, a, 6, 2, 0, var3);
			this.a(var1, a, 7, 2, 1, var3);
			if (!this.k.c[BlockFace.SOUTH.getId()]) {
				this.a(var1, var3, 1, 3, 0, 6, 3, 0, b, b, false);
				this.a(var1, var3, 1, 2, 0, 6, 2, 0, a, a, false);
				this.a(var1, var3, 1, 1, 0, 6, 1, 0, b, b, false);
			}

			if (!this.k.c[BlockFace.NORTH.getId()]) {
				this.a(var1, var3, 1, 3, 7, 6, 3, 7, b, b, false);
				this.a(var1, var3, 1, 2, 7, 6, 2, 7, a, a, false);
				this.a(var1, var3, 1, 1, 7, 6, 1, 7, b, b, false);
			}

			if (!this.k.c[BlockFace.WEST.getId()]) {
				this.a(var1, var3, 0, 3, 1, 0, 3, 6, b, b, false);
				this.a(var1, var3, 0, 2, 1, 0, 2, 6, a, a, false);
				this.a(var1, var3, 0, 1, 1, 0, 1, 6, b, b, false);
			}

			if (!this.k.c[BlockFace.EAST.getId()]) {
				this.a(var1, var3, 7, 3, 1, 7, 3, 6, b, b, false);
				this.a(var1, var3, 7, 2, 1, 7, 2, 6, a, a, false);
				this.a(var1, var3, 7, 1, 1, 7, 1, 6, b, b, false);
			}
		} else if (this.o == 2) {
			this.a(var1, var3, 0, 1, 0, 0, 1, 7, b, b, false);
			this.a(var1, var3, 7, 1, 0, 7, 1, 7, b, b, false);
			this.a(var1, var3, 1, 1, 0, 6, 1, 0, b, b, false);
			this.a(var1, var3, 1, 1, 7, 6, 1, 7, b, b, false);
			this.a(var1, var3, 0, 2, 0, 0, 2, 7, c, c, false);
			this.a(var1, var3, 7, 2, 0, 7, 2, 7, c, c, false);
			this.a(var1, var3, 1, 2, 0, 6, 2, 0, c, c, false);
			this.a(var1, var3, 1, 2, 7, 6, 2, 7, c, c, false);
			this.a(var1, var3, 0, 3, 0, 0, 3, 7, b, b, false);
			this.a(var1, var3, 7, 3, 0, 7, 3, 7, b, b, false);
			this.a(var1, var3, 1, 3, 0, 6, 3, 0, b, b, false);
			this.a(var1, var3, 1, 3, 7, 6, 3, 7, b, b, false);
			this.a(var1, var3, 0, 1, 3, 0, 2, 4, c, c, false);
			this.a(var1, var3, 7, 1, 3, 7, 2, 4, c, c, false);
			this.a(var1, var3, 3, 1, 0, 4, 2, 0, c, c, false);
			this.a(var1, var3, 3, 1, 7, 4, 2, 7, c, c, false);
			if (this.k.c[BlockFace.SOUTH.getId()]) {
				this.a(var1, var3, 3, 1, 0, 4, 2, 0, f, f, false);
			}

			if (this.k.c[BlockFace.NORTH.getId()]) {
				this.a(var1, var3, 3, 1, 7, 4, 2, 7, f, f, false);
			}

			if (this.k.c[BlockFace.WEST.getId()]) {
				this.a(var1, var3, 0, 1, 3, 0, 2, 4, f, f, false);
			}

			if (this.k.c[BlockFace.EAST.getId()]) {
				this.a(var1, var3, 7, 1, 3, 7, 2, 4, f, f, false);
			}
		}

		if (var4) {
			this.a(var1, var3, 3, 1, 3, 4, 1, 4, b, b, false);
			this.a(var1, var3, 3, 2, 3, 4, 2, 4, a, a, false);
			this.a(var1, var3, 3, 3, 3, 4, 3, 4, b, b, false);
		}

		return true;
	}
}
