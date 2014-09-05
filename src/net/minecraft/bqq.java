package net.minecraft;

import java.util.concurrent.Callable;

class bqq implements Callable {

	// $FF: synthetic field
	final WorldData a;

	bqq(WorldData var1) {
		this.a = var1;
	}

	public String a() {
		return String.format("ID %02d - %s, ver %d. Features enabled: %b", new Object[] { Integer.valueOf(WorldData.a(this.a).g()), WorldData.a(this.a).a(), Integer.valueOf(WorldData.a(this.a).d()), Boolean.valueOf(WorldData.b(this.a)) });
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
