package net.minecraft;

import java.util.concurrent.Callable;

class bfk implements Callable {

	// $FF: synthetic field
	final Position a;
	// $FF: synthetic field
	final Chunk b;

	bfk(Chunk var1, Position var2) {
		this.b = var1;
		this.a = var2;
	}

	public String a() {
		return CrashReportSystemDetails.a(this.a);
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
