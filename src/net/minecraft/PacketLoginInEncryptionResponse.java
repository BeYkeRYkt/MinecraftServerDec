package net.minecraft;

import java.security.PrivateKey;
import javax.crypto.SecretKey;

public class PacketLoginInEncryptionResponse implements Packet<LoginServerboundPacketListener> {

	private byte[] sharedSecret = new byte[0];
	private byte[] verifyToken = new byte[0];

	public void readData(PacketDataSerializer serializer) {
		this.sharedSecret = serializer.readByteArray();
		this.verifyToken = serializer.readByteArray();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByteArray(this.sharedSecret);
		serializer.writeByteArray(this.verifyToken);
	}

	public void handlePacket(LoginServerboundPacketListener listener) {
		listener.handle(this);
	}

	public SecretKey getSharedKey(PrivateKey privateKey) {
		return ServerCryptoUtils.a(privateKey, this.sharedSecret);
	}

	public byte[] getVerifyToken(PrivateKey privateKey) {
		return privateKey == null ? this.verifyToken : ServerCryptoUtils.b(privateKey, this.verifyToken);
	}

}
