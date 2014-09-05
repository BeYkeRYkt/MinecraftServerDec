package net.minecraft;

public class nn implements Packet<nm> {

	private long a;

	public nn() {
	}

	public nn(long var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readLong();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeLong(this.a);
	}

	public void handlePacket(nm var1) {
		var1.a(this);
	}
}
