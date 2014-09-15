package net.minecraft;

import java.util.concurrent.Callable;

class bmp implements Callable {

	// $FF: synthetic field
	final StructureGenerator a;

	bmp(StructureGenerator var1) {
		this.a = var1;
	}

	public String a() {
		return this.a.getClass().getCanonicalName();
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
