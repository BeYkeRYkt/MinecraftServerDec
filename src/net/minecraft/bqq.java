package net.minecraft;

import java.util.concurrent.Callable;

class bqq implements Callable {

	// $FF: synthetic field
	final bqo a;

	bqq(bqo var1) {
		this.a = var1;
	}

	public String a() {
		return String.format("ID %02d - %s, ver %d. Features enabled: %b", new Object[] { Integer.valueOf(bqo.a(this.a).g()), bqo.a(this.a).a(), Integer.valueOf(bqo.a(this.a).d()), Boolean.valueOf(bqo.b(this.a)) });
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
