package net.minecraft;

public class PacketPlayOutSetCompression implements Packet<PlayOutPacketListener> {

	private int threshold;

	public void readData(PacketDataSerializer serializer) {
		this.threshold = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.threshold);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
