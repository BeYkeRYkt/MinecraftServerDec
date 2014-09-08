package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ro implements HandshakingServerboundPacketListener {

	private final MinecraftServer minecraftserver;
	private final NetworkManager networkManager;

	public ro(MinecraftServer minecraftserver, NetworkManager networkManager) {
		this.minecraftserver = minecraftserver;
		this.networkManager = networkManager;
	}

	public void handle(PacketHandshakingInSetProtocol var1) {
		switch (rp.a[var1.getNextState().ordinal()]) {
			case 1:
				this.networkManager.setProtocolState(EnumProtocol.LOGIN);
				ChatComponentText var2;
				if (var1.getProtocolVersion() > 47) {
					var2 = new ChatComponentText("Outdated server! I\'m still on 1.8");
					this.networkManager.handleSendPacket((new PacketLoginOutDisconnect(var2)));
					this.networkManager.disconnect((IChatBaseComponent) var2);
				} else if (var1.getProtocolVersion() < 47) {
					var2 = new ChatComponentText("Outdated client! Please use 1.8");
					this.networkManager.handleSendPacket((new PacketLoginOutDisconnect(var2)));
					this.networkManager.disconnect((IChatBaseComponent) var2);
				} else {
					this.networkManager.setPacketListener((PacketListener) (new rq(this.minecraftserver, this.networkManager)));
				}
				break;
			case 2:
				this.networkManager.setProtocolState(EnumProtocol.STATUS);
				this.networkManager.setPacketListener((PacketListener) (new ru(this.minecraftserver, this.networkManager)));
				break;
			default:
				throw new UnsupportedOperationException("Invalid intention " + var1.getNextState());
		}

	}

	public void handle(IChatBaseComponent var1) {
	}

}
