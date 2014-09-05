package net.minecraft;

// $FF: synthetic class
class rp {

	// $FF: synthetic field
	static final int[] a = new int[EnumProtocol.values().length];

	static {
		try {
			a[EnumProtocol.LOGIN.ordinal()] = 1;
		} catch (NoSuchFieldError var2) {
			;
		}

		try {
			a[EnumProtocol.STATUS.ordinal()] = 2;
		} catch (NoSuchFieldError var1) {
			;
		}

	}
}
