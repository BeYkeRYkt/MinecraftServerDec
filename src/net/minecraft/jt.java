package net.minecraft;

public class jt implements Packet<PlayPacketListener> {

	private int a;
	private Position b;
	private int c;
	private boolean d;

	public jt() {
	}

	public jt(int var1, Position var2, int var3, boolean var4) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readInt();
		this.b = var1.readPosition();
		this.c = var1.readInt();
		this.d = var1.readBoolean();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeInt(this.a);
		var1.writePosition(this.b);
		var1.writeInt(this.c);
		var1.writeBoolean(this.d);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
