package net.minecraft;

import java.util.concurrent.Callable;

class aqx implements Callable {

	// $FF: synthetic field
	final World a;

	aqx(World var1) {
		this.a = var1;
	}

	public String a() {
		return this.a.j.size() + " total; " + this.a.j.toString();
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
