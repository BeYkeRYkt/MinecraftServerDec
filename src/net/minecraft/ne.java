package net.minecraft;

import java.security.PublicKey;

public class ne implements Packet<nc> {

	private String a;
	private PublicKey b;
	private byte[] c;

	public ne() {
	}

	public ne(String var1, PublicKey var2, byte[] var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readString(20);
		this.b = ServerCryptoUtils.a(var1.readByteArray());
		this.c = var1.readByteArray();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(this.a);
		var1.writeByteArray(this.b.getEncoded());
		var1.writeByteArray(this.c);
	}

	public void handlePacket(nc var1) {
		var1.a(this);
	}
}
