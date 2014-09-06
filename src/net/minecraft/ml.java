package net.minecraft;

public class ml implements Packet<ls> {

	private Position a;
	private BlockFace b;
	private mm c;

	public void readData(PacketDataSerializer var1) {
		this.c = (mm) var1.a(mm.class);
		this.a = var1.readPosition();
		this.b = BlockFace.a(var1.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeEnum((Enum) this.c);
		var1.writePosition(this.a);
		var1.writeByte(this.b.a());
	}

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public Position a() {
		return this.a;
	}

	public BlockFace b() {
		return this.b;
	}

	public mm c() {
		return this.c;
	}
}
