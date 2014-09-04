package net.minecraft;

import java.util.concurrent.Callable;

class bco implements Callable {

	// $FF: synthetic field
	final bcm a;

	bco(bcm var1) {
		this.a = var1;
	}

	public String a() {
		int var1 = atr.a(this.a.b.p(this.a.c).c());

		try {
			return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(var1), atr.c(var1).a(), atr.c(var1).getClass().getCanonicalName() });
		} catch (Throwable var3) {
			return "ID #" + var1;
		}
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
