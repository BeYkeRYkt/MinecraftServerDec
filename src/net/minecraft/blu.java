package net.minecraft;

// $FF: synthetic class
class blu {

	// $FF: synthetic field
	static final int[] a;
	// $FF: synthetic field
	static final int[] b = new int[BlockFace.values().length];

	static {
		try {
			b[BlockFace.NORTH.ordinal()] = 1;
		} catch (NoSuchFieldError var8) {
			;
		}

		try {
			b[BlockFace.SOUTH.ordinal()] = 2;
		} catch (NoSuchFieldError var7) {
			;
		}

		try {
			b[BlockFace.WEST.ordinal()] = 3;
		} catch (NoSuchFieldError var6) {
			;
		}

		try {
			b[BlockFace.EAST.ordinal()] = 4;
		} catch (NoSuchFieldError var5) {
			;
		}

		a = new int[bml.values().length];

		try {
			a[bml.a.ordinal()] = 1;
		} catch (NoSuchFieldError var4) {
			;
		}

		try {
			a[bml.b.ordinal()] = 2;
		} catch (NoSuchFieldError var3) {
			;
		}

		try {
			a[bml.c.ordinal()] = 3;
		} catch (NoSuchFieldError var2) {
			;
		}

		try {
			a[bml.d.ordinal()] = 4;
		} catch (NoSuchFieldError var1) {
			;
		}

	}
}
