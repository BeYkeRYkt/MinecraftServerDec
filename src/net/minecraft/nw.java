package net.minecraft;

public class nw implements Packet<nv> {

	private long a;

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readLong();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeLong(this.a);
	}

	public void handlePacket(nv var1) {
		var1.a(this);
	}

	public long a() {
		return this.a;
	}
}
