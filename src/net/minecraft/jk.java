package net.minecraft;

public class jk implements Packet<PlayPacketListener> {

	private int a;
	private byte b;

	public jk() {
	}

	public jk(Entity var1, byte var2) {
		this.a = var1.getId();
		this.b = var2;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readInt();
		this.b = var1.readByte();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeInt(this.a);
		var1.writeByte(this.b);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
