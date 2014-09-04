package net.minecraft;

import java.util.concurrent.Callable;

class aqy implements Callable {

	// $FF: synthetic field
	final World a;

	aqy(World var1) {
		this.a = var1;
	}

	public String a() {
		return this.a.v.f();
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
