package net.minecraft;

public class lv implements Packet<ls> {

	private lw a;

	public lv() {
	}

	public lv(lw var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = (lw) var1.readEnum(lw.class);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeEnum((Enum) this.a);
	}

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public lw a() {
		return this.a;
	}
}
