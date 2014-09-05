package net.minecraft;

public class jn implements Packet<PlayPacketListener> {

	private int a;

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}
