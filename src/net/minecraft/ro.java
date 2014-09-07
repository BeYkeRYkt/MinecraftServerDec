package net.minecraft;

import net.minecraft.server.MinecraftServer;

public class ro implements HandshakingServerboundPacketListener {

	private final MinecraftServer a;
	private final gr b;

	public ro(MinecraftServer var1, gr var2) {
		this.a = var1;
		this.b = var2;
	}

	public void handle(PacketHandshakingInSetProtocol var1) {
		switch (rp.a[var1.getNextState().ordinal()]) {
			case 1:
				this.b.a(EnumProtocol.LOGIN);
				ChatComponentText var2;
				if (var1.getProtocolVersion() > 47) {
					var2 = new ChatComponentText("Outdated server! I\'m still on 1.8");
					this.b.a((Packet) (new ng(var2)));
					this.b.a((IChatBaseComponent) var2);
				} else if (var1.getProtocolVersion() < 47) {
					var2 = new ChatComponentText("Outdated client! Please use 1.8");
					this.b.a((Packet) (new ng(var2)));
					this.b.a((IChatBaseComponent) var2);
				} else {
					this.b.a((PacketListener) (new rq(this.a, this.b)));
				}
				break;
			case 2:
				this.b.a(EnumProtocol.STATUS);
				this.b.a((PacketListener) (new ru(this.a, this.b)));
				break;
			default:
				throw new UnsupportedOperationException("Invalid intention " + var1.getNextState());
		}

	}

	public void handle(IChatBaseComponent var1) {
	}
}
