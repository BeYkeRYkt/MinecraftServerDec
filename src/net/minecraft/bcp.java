package net.minecraft;

import java.util.concurrent.Callable;

class bcp implements Callable {

	// $FF: synthetic field
	final bcm a;

	bcp(bcm var1) {
		this.a = var1;
	}

	public String a() {
		bec var1 = this.a.b.p(this.a.c);
		int var2 = var1.c().c(var1);
		if (var2 < 0) {
			return "Unknown? (Got " + var2 + ")";
		} else {
			String var3 = String.format("%4s", new Object[] { Integer.toBinaryString(var2) }).replace(" ", "0");
			return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] { Integer.valueOf(var2), var3 });
		}
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
