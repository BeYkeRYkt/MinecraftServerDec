package net.minecraft;

public class lz implements Packet<PlayInPacketListener> {

	private int a;
	private int b;

	public void handlePacket(PlayInPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readByte();
		this.b = var1.readByte();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a);
		var1.writeByte(this.b);
	}

	public int a() {
		return this.a;
	}

	public int b() {
		return this.b;
	}
}
