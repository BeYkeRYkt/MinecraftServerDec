package net.minecraft;

public class PacketStatusOutPing implements Packet<StatusClientboundPacketListener> {

	private long time;

	public PacketStatusOutPing() {
	}

	public PacketStatusOutPing(long time) {
		this.time = time;
	}

	public void readData(PacketDataSerializer serializer) {
		this.time = serializer.readLong();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeLong(this.time);
	}

	public void handlePacket(StatusClientboundPacketListener listener) {
		listener.handle(this);
	}

}
