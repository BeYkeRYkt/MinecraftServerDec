package net.minecraft;

import java.util.concurrent.Callable;

class rm implements Callable {

	// $FF: synthetic field
	final Packet a;
	// $FF: synthetic field
	final rj b;

	rm(rj var1, Packet var2) {
		this.b = var1;
		this.a = var2;
	}

	public String a() {
		return this.a.getClass().getCanonicalName();
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
