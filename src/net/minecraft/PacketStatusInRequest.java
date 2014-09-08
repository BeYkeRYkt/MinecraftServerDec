package net.minecraft;

public class PacketStatusInRequest implements Packet<StatusInPacketListener> {

	public void readData(PacketDataSerializer serializer) {
	}

	public void writeData(PacketDataSerializer serializer) {
	}

	public void handlePacket(StatusInPacketListener listener) {
		listener.handle(this);
	}

}
