package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class HandshakeListener implements HandshakingServerboundPacketListener {

	private final MinecraftServer minecraftserver;
	private final NetworkManager networkManager;

	public HandshakeListener(MinecraftServer minecraftserver, NetworkManager networkManager) {
		this.minecraftserver = minecraftserver;
		this.networkManager = networkManager;
	}

	public void handle(PacketHandshakingInSetProtocol packet) {
		switch (packet.getNextState()) {
			case LOGIN: {
				this.networkManager.setProtocolState(EnumProtocol.LOGIN);
				ChatComponentText response;
				if (packet.getProtocolVersion() > 47) {
					response = new ChatComponentText("Outdated server! I\'m still on 1.8");
					this.networkManager.handleSendPacket(new PacketLoginOutDisconnect(response));
					this.networkManager.disconnect(response);
				} else if (packet.getProtocolVersion() < 47) {
					response = new ChatComponentText("Outdated client! Please use 1.8");
					this.networkManager.handleSendPacket(new PacketLoginOutDisconnect(response));
					this.networkManager.disconnect(response);
				} else {
					this.networkManager.setPacketListener(new LoginListener(this.minecraftserver, this.networkManager));
				}
				break;
			}
			case STATUS: {
				this.networkManager.setProtocolState(EnumProtocol.STATUS);
				this.networkManager.setPacketListener(new StatusListener(this.minecraftserver, this.networkManager));
				break;
			}
			default: {
				throw new UnsupportedOperationException("Invalid intention " + packet.getNextState());
			}
		}

	}

	public void handleDisconnect(IChatBaseComponent var1) {
	}

}
