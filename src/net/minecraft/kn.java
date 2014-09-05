package net.minecraft;

public class kn implements Packet<PlayPacketListener> {

	private int a;
	private int b;

	public kn() {
	}

	public kn(int var1, wq var2) {
		this.a = var1;
		this.b = var2.a();
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
		this.b = var1.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		var1.writeByte(this.b);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
