package net.minecraft;

import java.util.concurrent.Callable;

class bqr implements Callable {

	// $FF: synthetic field
	final WorldData a;

	bqr(WorldData var1) {
		this.a = var1;
	}

	public String a() {
		return WorldData.c(this.a);
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
