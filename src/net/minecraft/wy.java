package net.minecraft;

import java.util.concurrent.Callable;

class wy implements Callable {

	// $FF: synthetic field
	final Entity a;

	wy(Entity var1) {
		this.a = var1;
	}

	public String a() {
		return this.a.l.toString();
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
