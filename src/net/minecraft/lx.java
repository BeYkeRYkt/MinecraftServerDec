package net.minecraft;

public class lx implements Packet<ls> {

	private String a;
	private int b;
	private ahg c;
	private boolean d;
	private int e;

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readString(7);
		this.b = var1.readByte();
		this.c = ahg.a(var1.readByte());
		this.d = var1.readBoolean();
		this.e = var1.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(this.a);
		var1.writeByte(this.b);
		var1.writeByte(this.c.a());
		var1.writeBoolean(this.d);
		var1.writeByte(this.e);
	}

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public String a() {
		return this.a;
	}

	public ahg c() {
		return this.c;
	}

	public boolean d() {
		return this.d;
	}

	public int e() {
		return this.e;
	}
}
