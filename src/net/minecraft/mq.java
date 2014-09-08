package net.minecraft;

public class mq implements Packet<PlayInPacketListener> {

	private String a;
	private mr b;

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readString(40);
		this.b = (mr) var1.readEnum(mr.class);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(this.a);
		var1.writeEnum((Enum) this.b);
	}

	public void handlePacket(PlayInPacketListener var1) {
		var1.a(this);
	}
}
