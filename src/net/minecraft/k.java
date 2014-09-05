package net.minecraft;

import java.util.concurrent.Callable;

final class k implements Callable {

	// $FF: synthetic field
	final int a;
	// $FF: synthetic field
	final Block b;

	k(int var1, Block var2) {
		this.a = var1;
		this.b = var2;
	}

	public String a() {
		try {
			return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(this.a), this.b.a(), this.b.getClass().getCanonicalName() });
		} catch (Throwable var2) {
			return "ID #" + this.a;
		}
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
