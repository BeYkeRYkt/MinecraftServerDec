package net.minecraft;

import java.util.Random;

class bkn implements bks {

	private bkn() {
	}

	public boolean a(blf var1) {
		if (var1.c[PaintingDirection.c.a()] && !var1.b[PaintingDirection.c.a()].d && var1.c[PaintingDirection.b.a()] && !var1.b[PaintingDirection.b.a()].d) {
			blf var2 = var1.b[PaintingDirection.c.a()];
			return var2.c[PaintingDirection.b.a()] && !var2.b[PaintingDirection.b.a()].d;
		} else {
			return false;
		}
	}

	public blb a(PaintingDirection var1, blf var2, Random var3) {
		var2.d = true;
		var2.b[PaintingDirection.c.a()].d = true;
		var2.b[PaintingDirection.b.a()].d = true;
		var2.b[PaintingDirection.c.a()].b[PaintingDirection.b.a()].d = true;
		return new bkx(var1, var2, var3);
	}

	// $FF: synthetic method
	bkn(bkj var1) {
		this();
	}
}
