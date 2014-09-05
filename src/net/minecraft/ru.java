package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ru implements nv {

	private final MinecraftServer a;
	private final gr b;

	public ru(MinecraftServer var1, gr var2) {
		this.a = var1;
		this.b = var2;
	}

	public void handle(IJSONComponent var1) {
	}

	public void a(nx var1) {
		this.b.a((Packet) (new no(this.a.getServerPing())));
	}

	public void a(nw var1) {
		this.b.a((Packet) (new nn(var1.a())));
	}
}
