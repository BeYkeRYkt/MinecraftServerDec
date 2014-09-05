package net.minecraft;

public class iw implements Packet<PlayPacketListener> {

	private Position a;
	private bec b;

	public iw() {
	}

	public iw(World var1, Position var2) {
		this.a = var2;
		this.b = var1.p(var2);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readPosition();
		this.b = (bec) Block.d.a(var1.readVarInt());
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writePosition(this.a);
		var1.writeVarInt(Block.d.b(this.b));
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
