package net.minecraft;

import java.util.Random;

class bko implements bks {

	private bko() {
	}

	public boolean a(blf var1) {
		return var1.c[PaintingDirection.c.a()] && !var1.b[PaintingDirection.c.a()].d;
	}

	public blb a(PaintingDirection var1, blf var2, Random var3) {
		blf var4 = var2;
		if (!var2.c[PaintingDirection.c.a()] || var2.b[PaintingDirection.c.a()].d) {
			var4 = var2.b[PaintingDirection.d.a()];
		}

		var4.d = true;
		var4.b[PaintingDirection.c.a()].d = true;
		return new bky(var1, var4, var3);
	}

	// $FF: synthetic method
	bko(bkj var1) {
		this();
	}
}
