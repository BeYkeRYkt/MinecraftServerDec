package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class StatusListener implements StatusServerboundPacketListener {

	private final MinecraftServer minecraftserver;
	private final NetworkManager networkManager;

	public StatusListener(MinecraftServer minecraftserver, NetworkManager networkManager) {
		this.minecraftserver = minecraftserver;
		this.networkManager = networkManager;
	}

	public void handle(IChatBaseComponent message) {
	}

	public void handle(PacketStatusInRequest packet) {
		this.networkManager.handleSendPacket(new PacketStatusOutResponse(this.minecraftserver.getServerPing()));
	}

	public void handle(PacketStatusInPing packet) {
		this.networkManager.handleSendPacket(new PacketStatusOutPing(packet.getTime()));
	}

}
