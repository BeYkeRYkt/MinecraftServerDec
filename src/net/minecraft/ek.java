package net.minecraft;

// $FF: synthetic class
class ek {

	// $FF: synthetic field
	static final int[] a;
	// $FF: synthetic field
	static final int[] b;
	// $FF: synthetic field
	static final int[] c = new int[en.values().length];

	static {
		try {
			c[en.a.ordinal()] = 1;
		} catch (NoSuchFieldError var11) {
			;
		}

		try {
			c[en.b.ordinal()] = 2;
		} catch (NoSuchFieldError var10) {
			;
		}

		b = new int[PaintingDirection.values().length];

		try {
			b[PaintingDirection.c.ordinal()] = 1;
		} catch (NoSuchFieldError var9) {
			;
		}

		try {
			b[PaintingDirection.f.ordinal()] = 2;
		} catch (NoSuchFieldError var8) {
			;
		}

		try {
			b[PaintingDirection.d.ordinal()] = 3;
		} catch (NoSuchFieldError var7) {
			;
		}

		try {
			b[PaintingDirection.e.ordinal()] = 4;
		} catch (NoSuchFieldError var6) {
			;
		}

		try {
			b[PaintingDirection.b.ordinal()] = 5;
		} catch (NoSuchFieldError var5) {
			;
		}

		try {
			b[PaintingDirection.a.ordinal()] = 6;
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
