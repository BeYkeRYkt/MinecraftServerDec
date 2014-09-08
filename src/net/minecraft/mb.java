package net.minecraft;

public class mb implements Packet<PlayInPacketListener> {

	private int a;

	public void handlePacket(PlayInPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readByte();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a);
	}
}
