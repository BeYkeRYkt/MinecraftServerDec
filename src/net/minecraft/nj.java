package net.minecraft;

import java.security.PrivateKey;
import javax.crypto.SecretKey;

public class nj implements Packet<nh> {

	private byte[] a = new byte[0];
	private byte[] b = new byte[0];

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readByteArray();
		this.b = var1.readByteArray();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByteArray(this.a);
		var1.writeByteArray(this.b);
	}

	public void handlePacket(nh var1) {
		var1.a(this);
	}

	public SecretKey a(PrivateKey var1) {
		return ServerCryptoUtils.a(var1, this.a);
	}

	public byte[] b(PrivateKey var1) {
		return var1 == null ? this.b : ServerCryptoUtils.b(var1, this.b);
	}
}
