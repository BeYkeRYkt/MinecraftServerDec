package net.minecraft;

import java.util.concurrent.Callable;

class bqw implements Callable {

	// $FF: synthetic field
	final WorldData a;

	bqw(WorldData var1) {
		this.a = var1;
	}

	public String a() {
		return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", new Object[] { Integer.valueOf(WorldData.k(this.a)), Boolean.valueOf(WorldData.l(this.a)), Integer.valueOf(WorldData.m(this.a)), Boolean.valueOf(WorldData.n(this.a)) });
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
