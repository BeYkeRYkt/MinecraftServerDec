package net.minecraft;

import java.util.concurrent.Callable;

class bqs implements Callable {

	// $FF: synthetic field
	final WorldData a;

	bqs(WorldData var1) {
		this.a = var1;
	}

	public String a() {
		return CrashReportSystemDetails.a((double) WorldData.d(this.a), (double) WorldData.e(this.a), (double) WorldData.f(this.a));
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
