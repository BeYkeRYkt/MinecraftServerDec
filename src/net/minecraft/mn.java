package net.minecraft;

public class mn implements Packet<ls> {

	private int a;
	private mo b;
	private int c;

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
		this.b = (mo) var1.a(mo.class);
		this.c = var1.readVarInt();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		var1.writeEnum((Enum) this.b);
		var1.writeVarInt(this.c);
	}

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public mo b() {
		return this.b;
	}

	public int c() {
		return this.c;
	}
}
