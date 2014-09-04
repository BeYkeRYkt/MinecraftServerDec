package net.minecraft;

import java.util.concurrent.Callable;

class c implements Callable {

	// $FF: synthetic field
	final CrashReport a;

	c(CrashReport var1) {
		this.a = var1;
	}

	public String a() {
		return "1.8";
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
