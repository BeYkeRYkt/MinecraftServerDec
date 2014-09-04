package net.minecraft;

import java.util.concurrent.Callable;

class bqx implements Callable {

	// $FF: synthetic field
	final bqo a;

	bqx(bqo var1) {
		this.a = var1;
	}

	public String a() {
		return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", new Object[] { bqo.o(this.a).getName(), Integer.valueOf(bqo.o(this.a).getId()), Boolean.valueOf(bqo.p(this.a)), Boolean.valueOf(bqo.q(this.a)) });
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
