package net.minecraft;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class pf implements Callable {

	// $FF: synthetic field
	final MinecraftServer a;

	public pf(MinecraftServer var1) {
		this.a = var1;
	}

	public String a() {
		return this.a.profiler.a ? this.a.profiler.c() : "N/A (disabled)";
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
