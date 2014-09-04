package net.minecraft;

import java.util.concurrent.Callable;

class aqw implements Callable {

	// $FF: synthetic field
	final atr a;
	// $FF: synthetic field
	final World b;

	aqw(World var1, atr var2) {
		this.b = var1;
		this.a = var2;
	}

	public String a() {
		try {
			return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(atr.a(this.a)), this.a.a(), this.a.getClass().getCanonicalName() });
		} catch (Throwable var2) {
			return "ID #" + atr.a(this.a);
		}
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
