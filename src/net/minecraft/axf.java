package net.minecraft;

// $FF: synthetic class
class axf {

	// $FF: synthetic field
	static final int[] a = new int[BlockFace.values().length];

	static {
		try {
			a[BlockFace.NORTH.ordinal()] = 1;
		} catch (NoSuchFieldError var4) {
			;
		}

		try {
			a[BlockFace.SOUTH.ordinal()] = 2;
		} catch (NoSuchFieldError var3) {
			;
		}

		try {
			a[BlockFace.WEST.ordinal()] = 3;
		} catch (NoSuchFieldError var2) {
			;
		}

		try {
			a[BlockFace.EAST.ordinal()] = 4;
		} catch (NoSuchFieldError var1) {
			;
		}

	}
}
