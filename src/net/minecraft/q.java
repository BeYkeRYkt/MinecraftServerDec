package net.minecraft;

import java.util.concurrent.Callable;

final class q implements Callable {

	// $FF: synthetic field
	final Position a;

	q(Position var1) {
		this.a = var1;
	}

	public String a() {
		return CrashReportSystemDetails.a(this.a);
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
