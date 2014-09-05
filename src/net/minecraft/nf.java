package net.minecraft;

public class nf implements Packet<nc> {

	private int a;

	public nf() {
	}

	public nf(int var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
	}

	public void handlePacket(nc var1) {
		var1.a(this);
	}
}
