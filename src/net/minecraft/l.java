package net.minecraft;

import java.util.concurrent.Callable;

final class l implements Callable {

	// $FF: synthetic field
	final int a;

	l(int var1) {
		this.a = var1;
	}

	public String a() {
		if (this.a < 0) {
			return "Unknown? (Got " + this.a + ")";
		} else {
			String var1 = String.format("%4s", new Object[] { Integer.toBinaryString(this.a) }).replace(" ", "0");
			return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] { Integer.valueOf(this.a), var1 });
		}
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
