package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class pd implements uy {

	private long b;
	// $FF: synthetic field
	final MinecraftServer a;

	public pd(MinecraftServer var1) {
		this.a = var1;
		this.b = MinecraftServer.getCurrentMillis();
	}

	public void a(String var1) {
	}

	public void a(int var1) {
		if (MinecraftServer.getCurrentMillis() - this.b >= 1000L) {
			this.b = MinecraftServer.getCurrentMillis();
			MinecraftServer.getLogger().info("Converting... " + var1 + "%");
		}

	}

	public void c(String var1) {
	}
}
