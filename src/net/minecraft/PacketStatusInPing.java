package net.minecraft;

public class PacketStatusInPing implements Packet<StatusInPacketListener> {

	private long time;

	public void readData(PacketDataSerializer serializer) {
		this.time = serializer.readLong();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeLong(this.time);
	}

	public void handlePacket(StatusInPacketListener listener) {
		listener.handle(this);
	}

	public long getTime() {
		return this.time;
	}

}
