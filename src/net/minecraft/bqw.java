package net.minecraft;

import java.util.concurrent.Callable;

class bqw implements Callable {

	// $FF: synthetic field
	final bqo a;

	bqw(bqo var1) {
		this.a = var1;
	}

	public String a() {
		return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", new Object[] { Integer.valueOf(bqo.k(this.a)), Boolean.valueOf(bqo.l(this.a)), Integer.valueOf(bqo.m(this.a)), Boolean.valueOf(bqo.n(this.a)) });
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
