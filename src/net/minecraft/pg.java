package net.minecraft;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class pg implements Callable {

	// $FF: synthetic field
	final MinecraftServer a;

	public pg(MinecraftServer var1) {
		this.a = var1;
	}

	public String a() {
		return MinecraftServer.a(this.a).p() + " / " + MinecraftServer.a(this.a).q() + "; " + MinecraftServer.a(this.a).players;
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
