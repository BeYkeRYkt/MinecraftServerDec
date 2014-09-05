package net.minecraft;

public class iv implements Packet<PlayPacketListener> {

	private Position a;
	private int b;
	private int c;
	private Block d;

	public iv() {
	}

	public iv(Position var1, Block var2, int var3, int var4) {
		this.a = var1;
		this.b = var3;
		this.c = var4;
		this.d = var2;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readPosition();
		this.b = var1.readUnsignedByte();
		this.c = var1.readUnsignedByte();
		this.d = Block.c(var1.readVarInt() & 4095);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writePosition(this.a);
		var1.writeByte(this.b);
		var1.writeByte(this.c);
		var1.writeVarInt(Block.a(this.d) & 4095);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
