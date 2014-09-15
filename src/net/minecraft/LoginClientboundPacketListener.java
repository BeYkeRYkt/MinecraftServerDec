package net.minecraft;

public interface LoginClientboundPacketListener extends PacketListener {

	void handle(PacketLoginOutEncryptionRequest packet);

	void handle(PacketLoginOutLoginSuccess packet);

	void handle(PacketLoginOutDisconnect packet);

	void handle(PacketLoginOutSetCompression packet);

}
