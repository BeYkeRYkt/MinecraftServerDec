package net.minecraft;

import java.util.concurrent.Callable;

class bcn implements Callable {

	// $FF: synthetic field
	final bcm a;

	bcn(bcm var1) {
		this.a = var1;
	}

	public String a() {
		return (String) bcm.F().get(this.a.getClass()) + " // " + this.a.getClass().getCanonicalName();
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
