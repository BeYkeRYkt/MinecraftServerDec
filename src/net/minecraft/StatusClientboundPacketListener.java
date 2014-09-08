package net.minecraft;

public interface StatusClientboundPacketListener extends PacketListener {

	void handle(PacketStatusOutResponse packet);

	void handle(PacketStatusOutPing packet);

}
