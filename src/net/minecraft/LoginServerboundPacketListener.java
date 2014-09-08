package net.minecraft;

public interface LoginServerboundPacketListener extends PacketListener {

	void handle(PacketLoginInLoginStart packet);

	void handle(PacketLoginInEncryptionResponse packet);

}
