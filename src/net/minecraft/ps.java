package net.minecraft;

import java.util.concurrent.Callable;

class ps implements Callable {

	// $FF: synthetic field
	final DedicatedMinecraftServer a;

	ps(DedicatedMinecraftServer var1) {
		this.a = var1;
	}

	public String a() {
		return "Dedicated Server (map_server.txt)";
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
