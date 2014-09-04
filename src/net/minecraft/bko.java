package net.minecraft;

import java.util.Random;

class bko implements bks {

	private bko() {
	}

	public boolean a(blf var1) {
		return var1.c[ej.c.a()] && !var1.b[ej.c.a()].d;
	}

	public blb a(ej var1, blf var2, Random var3) {
		blf var4 = var2;
		if (!var2.c[ej.c.a()] || var2.b[ej.c.a()].d) {
			var4 = var2.b[ej.d.a()];
		}

		var4.d = true;
		var4.b[ej.c.a()].d = true;
		return new bky(var1, var4, var3);
	}

	// $FF: synthetic method
	bko(bkj var1) {
		this();
	}
}
