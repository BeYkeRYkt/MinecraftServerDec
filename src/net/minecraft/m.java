package net.minecraft;

import java.util.concurrent.Callable;

final class m implements Callable {

	// $FF: synthetic field
	final dt a;

	m(dt var1) {
		this.a = var1;
	}

	public String a() {
		return j.a(this.a);
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
