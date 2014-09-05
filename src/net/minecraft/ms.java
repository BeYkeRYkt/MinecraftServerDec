package net.minecraft;

public class ms implements Packet<ls> {

	private int a;

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readShort();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeShort(this.a);
	}

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public int a() {
		return this.a;
	}
}
