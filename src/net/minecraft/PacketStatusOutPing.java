package net.minecraft;

public class PacketStatusOutPing implements Packet<StatusOutPacketListener> {

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

	public void handlePacket(StatusOutPacketListener listener) {
		listener.handle(this);
	}

}
