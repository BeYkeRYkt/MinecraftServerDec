package net.minecraft;

import java.util.concurrent.Callable;

class f implements Callable {

	// $FF: synthetic field
	final CrashReport a;

	f(CrashReport var1) {
		this.a = var1;
	}

	public String a() {
		return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
