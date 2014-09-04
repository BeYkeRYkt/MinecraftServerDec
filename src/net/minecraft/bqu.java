package net.minecraft;

import java.util.concurrent.Callable;

class bqu implements Callable {

	// $FF: synthetic field
	final bqo a;

	bqu(bqo var1) {
		this.a = var1;
	}

	public String a() {
		return String.valueOf(bqo.i(this.a));
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
