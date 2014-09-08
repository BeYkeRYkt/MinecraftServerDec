package net.minecraft;

import java.util.concurrent.Callable;

class aqh implements Callable {

	// $FF: synthetic field
	final CommandBlockListenerAbstract a;

	aqh(CommandBlockListenerAbstract var1) {
		this.a = var1;
	}

	public String a() {
		return this.a.getName();
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
