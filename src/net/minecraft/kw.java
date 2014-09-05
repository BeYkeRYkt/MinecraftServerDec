package net.minecraft;

public class kw implements Packet<PlayPacketListener> {

	private int a;
	private String b;

	public kw() {
	}

	public kw(int var1, bry var2) {
		this.a = var1;
		if (var2 == null) {
			this.b = "";
		} else {
			this.b = var2.b();
		}

	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readByte();
		this.b = var1.readString(16);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a);
		var1.writeString(this.b);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
