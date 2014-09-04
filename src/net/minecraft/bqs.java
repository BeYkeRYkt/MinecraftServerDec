package net.minecraft;

import java.util.concurrent.Callable;

class bqs implements Callable {

	// $FF: synthetic field
	final bqo a;

	bqs(bqo var1) {
		this.a = var1;
	}

	public String a() {
		return CrashReportSystemDetails.a((double) bqo.d(this.a), (double) bqo.e(this.a), (double) bqo.f(this.a));
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
