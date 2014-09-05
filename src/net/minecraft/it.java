package net.minecraft;

public class it implements Packet<PlayPacketListener> {

	private int a;
	private Position b;
	private int c;

	public it() {
	}

	public it(int var1, Position var2, int var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
		this.b = var1.readPosition();
		this.c = var1.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		var1.writePosition(this.b);
		var1.writeByte(this.c);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
