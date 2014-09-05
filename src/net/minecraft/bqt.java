package net.minecraft;

import java.util.concurrent.Callable;

class bqt implements Callable {

	// $FF: synthetic field
	final WorldData a;

	bqt(WorldData var1) {
		this.a = var1;
	}

	public String a() {
		return String.format("%d game time, %d day time", new Object[] { Long.valueOf(WorldData.g(this.a)), Long.valueOf(WorldData.h(this.a)) });
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
