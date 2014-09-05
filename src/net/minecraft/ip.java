package net.minecraft;

public class ip implements Packet<PlayPacketListener> {

	private int a;
	private Position b;
	private ej c;
	private String d;

	public ip() {
	}

	public ip(adm var1) {
		this.a = var1.getId();
		this.b = var1.n();
		this.c = var1.b;
		this.d = var1.c.B;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
		this.d = var1.readString(adn.A);
		this.b = var1.readPosition();
		this.c = ej.b(var1.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		var1.writeString(this.d);
		var1.writePosition(this.b);
		var1.writeByte(this.c.b());
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
