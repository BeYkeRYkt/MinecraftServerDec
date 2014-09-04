package net.minecraft;

import java.util.concurrent.Callable;

class aqv implements Callable {

	// $FF: synthetic field
	final dt a;
	// $FF: synthetic field
	final World b;

	aqv(World var1, dt var2) {
		this.b = var1;
		this.a = var2;
	}

	public String a() {
		return CrashReportSystemDetails.a(this.a);
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
