package net.minecraft;

public class PacketStatusInRequest implements Packet<StatusServerboundPacketListener> {

	public void readData(PacketDataSerializer serializer) {
	}

	public void writeData(PacketDataSerializer serializer) {
	}

	public void handlePacket(StatusServerboundPacketListener listener) {
		listener.handle(this);
	}

}
