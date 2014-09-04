package net.minecraft;

import java.util.concurrent.Callable;

class pr implements Callable {

	// $FF: synthetic field
	final DedicatedMinecraftServer a;

	pr(DedicatedMinecraftServer var1) {
		this.a = var1;
	}

	public String a() {
		String var1 = this.a.getServerModName();
		return !var1.equals("vanilla") ? "Definitely; Server brand changed to \'" + var1 + "\'" : "Unknown (can\'t tell)";
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
