package net.minecraft;

public class PacketLoginOutSetCompression implements Packet<LoginClientboundPacketListener> {

	private int threshold;

	public PacketLoginOutSetCompression() {
	}

	public PacketLoginOutSetCompression(int threshold) {
		this.threshold = threshold;
	}

	public void readData(PacketDataSerializer serializer) {
		this.threshold = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.threshold);
	}

	public void handlePacket(LoginClientboundPacketListener listener) {
		listener.handle(this);
	}

}
