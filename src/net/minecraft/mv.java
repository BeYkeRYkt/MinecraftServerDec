package net.minecraft;

public class mv implements Packet<PlayInPacketListener> {

	public void readData(PacketDataSerializer var1) {
	}

	public void writeData(PacketDataSerializer var1) {
	}

	public void handlePacket(PlayInPacketListener var1) {
		var1.a(this);
	}
}
