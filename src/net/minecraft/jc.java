package net.minecraft;

public class jc implements Packet<PlayPacketListener> {

	private int a;
	private short b;
	private boolean c;

	public jc() {
	}

	public jc(int var1, short var2, boolean var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readUnsignedByte();
		this.b = var1.readShort();
		this.c = var1.readBoolean();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a);
		var1.writeShort(this.b);
		var1.writeBoolean(this.c);
	}
}
