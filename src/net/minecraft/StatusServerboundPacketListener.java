package net.minecraft;

public interface StatusServerboundPacketListener extends PacketListener {

	void handle(PacketStatusInPing packet);

	void handle(PacketStatusInRequest packet);

}
