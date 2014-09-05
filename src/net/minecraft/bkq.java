package net.minecraft;

import java.util.Random;

class bkq implements bks {

	private bkq() {
	}

	public boolean a(blf var1) {
		return !var1.c[PaintingDirection.e.a()] && !var1.c[PaintingDirection.f.a()] && !var1.c[PaintingDirection.c.a()] && !var1.c[PaintingDirection.d.a()] && !var1.c[PaintingDirection.b.a()];
	}

	public blb a(PaintingDirection var1, blf var2, Random var3) {
		var2.d = true;
		return new bld(var1, var2, var3);
	}

	// $FF: synthetic method
	bkq(bkj var1) {
		this();
	}
}
