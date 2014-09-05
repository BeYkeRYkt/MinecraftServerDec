package net.minecraft;

import java.util.concurrent.Callable;

class bqp implements Callable {

	// $FF: synthetic field
	final WorldData a;

	bqp(WorldData var1) {
		this.a = var1;
	}

	public String a() {
		return String.valueOf(this.a.b());
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
