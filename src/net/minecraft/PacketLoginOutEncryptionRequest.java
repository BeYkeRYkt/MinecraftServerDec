package net.minecraft;

import java.security.PublicKey;

public class PacketLoginOutEncryptionRequest implements Packet<LoginClientboundPacketListener> {

	private String serverId;
	private PublicKey publicKey;
	private byte[] verifyToken;

	public PacketLoginOutEncryptionRequest() {
	}

	public PacketLoginOutEncryptionRequest(String serverId, PublicKey publicKey, byte[] verifyToken) {
		this.serverId = serverId;
		this.publicKey = publicKey;
		this.verifyToken = verifyToken;
	}

	public void readData(PacketDataSerializer serializer) {
		this.serverId = serializer.readString(20);
		this.publicKey = ServerCryptoUtils.fromArray(serializer.readByteArray());
		this.verifyToken = serializer.readByteArray();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.serverId);
		serializer.writeByteArray(this.publicKey.getEncoded());
		serializer.writeByteArray(this.verifyToken);
	}

	public void handlePacket(LoginClientboundPacketListener listener) {
		listener.handle(this);
	}

}
