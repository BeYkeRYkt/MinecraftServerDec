package net.minecraft;

// $FF: synthetic class
class ek {

	// $FF: synthetic field
	static final int[] a;
	// $FF: synthetic field
	static final int[] b;
	// $FF: synthetic field
	static final int[] c = new int[UniverseDirection.values().length];

	static {
		try {
			c[UniverseDirection.HORIZONTAL.ordinal()] = 1;
		} catch (NoSuchFieldError var11) {
			;
		}

		try {
			c[UniverseDirection.VERTICAL.ordinal()] = 2;
		} catch (NoSuchFieldError var10) {
			;
		}

		b = new int[BlockFace.values().length];

		try {
			b[BlockFace.NORTH.ordinal()] = 1;
		} catch (NoSuchFieldError var9) {
			;
		}

		try {
			b[BlockFace.EAST.ordinal()] = 2;
		} catch (NoSuchFieldError var8) {
			;
		}

		try {
			b[BlockFace.SOUTH.ordinal()] = 3;
		} catch (NoSuchFieldError var7) {
			;
		}

		try {
			b[BlockFace.WEST.ordinal()] = 4;
		} catch (NoSuchFieldError var6) {
			;
		}

		try {
			b[BlockFace.UP.ordinal()] = 5;
		} catch (NoSuchFieldError var5) {
			;
		}

		try {
			b[BlockFace.DOWN.ordinal()] = 6;
		} catch (NoSuchFieldError var4) {
			;
		}

		a = new int[el.values().length];

		try {
			a[el.a.ordinal()] = 1;
		} catch (NoSuchFieldError var3) {
			;
		}

		try {
			a[el.b.ordinal()] = 2;
		} catch (NoSuchFieldError var2) {
			;
		}

		try {
			a[el.c.ordinal()] = 3;
		} catch (NoSuchFieldError var1) {
			;
		}

	}
}
