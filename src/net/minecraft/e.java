package net.minecraft;

import java.util.concurrent.Callable;

class e implements Callable {

	// $FF: synthetic field
	final CrashReport a;

	e(CrashReport var1) {
		this.a = var1;
	}

	public String a() {
		return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
