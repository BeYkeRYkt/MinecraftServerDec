package net.minecraft;

public class kc implements Packet<PlayClientboundPacketListener> {

	private Position a;

	public kc() {
	}

	public kc(Position var1) {
		this.a = var1;
	}

	public void handlePacket(PlayClientboundPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readPosition();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writePosition(this.a);
	}
}
