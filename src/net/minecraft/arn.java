package net.minecraft;

// $FF: synthetic class
class arn {

	// $FF: synthetic field
	static final int[] a = new int[EnumCreatureType.values().length];

	static {
		try {
			a[EnumCreatureType.MONSTER.ordinal()] = 1;
		} catch (NoSuchFieldError var4) {
			;
		}

		try {
			a[EnumCreatureType.CREATURE.ordinal()] = 2;
		} catch (NoSuchFieldError var3) {
			;
		}

		try {
			a[EnumCreatureType.WATER_CREATURE.ordinal()] = 3;
		} catch (NoSuchFieldError var2) {
			;
		}

		try {
			a[EnumCreatureType.AMBIENT.ordinal()] = 4;
		} catch (NoSuchFieldError var1) {
			;
		}

	}
}
