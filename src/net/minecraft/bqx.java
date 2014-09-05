package net.minecraft;

import java.util.concurrent.Callable;

class bqx implements Callable {

	// $FF: synthetic field
	final WorldData a;

	bqx(WorldData var1) {
		this.a = var1;
	}

	public String a() {
		return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", new Object[] { WorldData.o(this.a).getName(), Integer.valueOf(WorldData.o(this.a).getId()), Boolean.valueOf(WorldData.p(this.a)), Boolean.valueOf(WorldData.q(this.a)) });
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
