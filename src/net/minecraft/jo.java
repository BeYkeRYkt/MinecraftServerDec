package net.minecraft;

public class jo implements Packet<PlayPacketListener> {

	public static final String[] a = new String[] { "tile.bed.notValid" };
	private int b;
	private float c;

	public jo() {
	}

	public jo(int var1, float var2) {
		this.b = var1;
		this.c = var2;
	}

	public void readData(PacketDataSerializer var1) {
		this.b = var1.readUnsignedByte();
		this.c = var1.readFloat();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.b);
		var1.writeFloat(this.c);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}

}
