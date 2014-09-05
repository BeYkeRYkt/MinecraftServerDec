package net.minecraft;

public class mf implements Packet<ls> {

	private int a;

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
	}

	public int a() {
		return this.a;
	}
}
