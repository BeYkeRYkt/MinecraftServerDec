package net.minecraft;

public class lb implements Packet<PlayPacketListener> {

	private float a;
	private int b;
	private int c;

	public lb() {
	}

	public lb(float var1, int var2, int var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readFloat();
		this.c = var1.readVarInt();
		this.b = var1.readVarInt();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeFloat(this.a);
		var1.writeVarInt(this.c);
		var1.writeVarInt(this.b);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
