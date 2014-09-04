package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ru implements nv {

	private final MinecraftServer a;
	private final gr b;

	public ru(MinecraftServer var1, gr var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(ho var1) {
	}

	public void a(nx var1) {
		this.b.a((id) (new no(this.a.getServerPing())));
	}

	public void a(nw var1) {
		this.b.a((id) (new nn(var1.a())));
	}
}
