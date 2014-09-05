package net.minecraft;

import java.util.concurrent.Callable;

final class m implements Callable {

	// $FF: synthetic field
	final Position a;

	m(Position var1) {
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
