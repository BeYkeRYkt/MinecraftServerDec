package net.minecraft;

public class ky implements Packet<PlayPacketListener> {

	private int a;
	private int b;
	private int c;

	public ky() {
	}

	public ky(int var1, Entity var2, Entity var3) {
		this.a = var1;
		this.b = var2.getId();
		this.c = var3 != null ? var3.getId() : -1;
	}

	public void readData(PacketDataSerializer var1) {
		this.b = var1.readInt();
		this.c = var1.readInt();
		this.a = var1.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeInt(this.b);
		var1.writeInt(this.c);
		var1.writeByte(this.a);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
