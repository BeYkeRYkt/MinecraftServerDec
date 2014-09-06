package net.minecraft;

// $FF: synthetic class
class blj {

	// $FF: synthetic field
	static final int[] a = new int[BlockFace.values().length];

	static {
		try {
			a[BlockFace.c.ordinal()] = 1;
		} catch (NoSuchFieldError var2) {
			;
		}

		try {
			a[BlockFace.d.ordinal()] = 2;
		} catch (NoSuchFieldError var1) {
			;
		}

	}
}
