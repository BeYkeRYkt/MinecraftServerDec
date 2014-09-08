package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ru implements StatusServerboundPacketListener {

	private final MinecraftServer a;
	private final gr b;

	public ru(MinecraftServer var1, gr var2) {
		this.a = var1;
		this.b = var2;
	}

	public void handle(IChatBaseComponent var1) {
	}

	public void handle(PacketStatusInRequest var1) {
		this.b.a((Packet) (new PacketStatusOutResponse(this.a.getServerPing())));
	}

	public void handle(PacketStatusInPing var1) {
		this.b.a((Packet) (new PacketStatusOutPing(var1.getTime())));
	}
}
