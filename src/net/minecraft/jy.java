package net.minecraft;

public class jy implements Packet<PlayPacketListener> {

	protected int a;
	protected byte b;
	protected byte c;
	protected byte d;
	protected byte e;
	protected byte f;
	protected boolean g;
	protected boolean h;

	public jy() {
	}

	public jy(int var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}

	public String toString() {
		return "Entity_" + super.toString();
	}
}
