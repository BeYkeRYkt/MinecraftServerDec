package net.minecraft;

public class jd implements Packet<PlayPacketListener> {

	private int a;

	public jd() {
	}

	public jd(int var1) {
		this.a = var1;
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a);
	}
}
