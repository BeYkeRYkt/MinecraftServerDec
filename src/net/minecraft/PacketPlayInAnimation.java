package net.minecraft;

public class PacketPlayInAnimation implements Packet<PlayInPacketListener> {

	public void readData(PacketDataSerializer serializer) {
	}

	public void writeData(PacketDataSerializer serializer) {
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

}
