package net.minecraft;

public interface StatusOutPacketListener extends PacketListener {

	void handle(PacketStatusOutResponse packet);

	void handle(PacketStatusOutPing packet);

}
