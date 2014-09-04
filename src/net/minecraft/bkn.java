package net.minecraft;

import java.util.Random;

class bkn implements bks {

	private bkn() {
	}

	public boolean a(blf var1) {
		if (var1.c[ej.c.a()] && !var1.b[ej.c.a()].d && var1.c[ej.b.a()] && !var1.b[ej.b.a()].d) {
			blf var2 = var1.b[ej.c.a()];
			return var2.c[ej.b.a()] && !var2.b[ej.b.a()].d;
		} else {
			return false;
		}
	}

	public blb a(ej var1, blf var2, Random var3) {
		var2.d = true;
		var2.b[ej.c.a()].d = true;
		var2.b[ej.b.a()].d = true;
		var2.b[ej.c.a()].b[ej.b.a()].d = true;
		return new bkx(var1, var2, var3);
	}

	// $FF: synthetic method
	bkn(bkj var1) {
		this();
	}
}
