package net.minecraft;

public interface StatusInPacketListener extends PacketListener {

	void handle(PacketStatusInPing packet);

	void handle(PacketStatusInRequest packet);

}
