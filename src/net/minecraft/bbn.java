package net.minecraft;

// $FF: synthetic class
class bbn {

	// $FF: synthetic field
	static final int[] a = new int[BlockFace.values().length];

	static {
		try {
			a[BlockFace.EAST.ordinal()] = 1;
		} catch (NoSuchFieldError var6) {
			;
		}

		try {
			a[BlockFace.WEST.ordinal()] = 2;
		} catch (NoSuchFieldError var5) {
			;
		}

		try {
			a[BlockFace.SOUTH.ordinal()] = 3;
		} catch (NoSuchFieldError var4) {
			;
		}

		try {
			a[BlockFace.NORTH.ordinal()] = 4;
		} catch (NoSuchFieldError var3) {
			;
		}

		try {
			a[BlockFace.DOWN.ordinal()] = 5;
		} catch (NoSuchFieldError var2) {
			;
		}

		try {
			a[BlockFace.UP.ordinal()] = 6;
		} catch (NoSuchFieldError var1) {
			;
		}

	}
}
