package net.minecraft;

public class PacketTimeUpdate implements Packet<PlayPacketListener> {

	private long worldAge;
	private long time;

	public PacketTimeUpdate() {
	}

	public PacketTimeUpdate(long worldAge, long time, boolean doDayLightCycle) {
		this.worldAge = worldAge;
		this.time = time;
		if (!doDayLightCycle) {
			this.time = -this.time;
			if (this.time == 0L) {
				this.time = -1L;
			}
		}
	}

	public void readData(PacketDataSerializer serializer) {
		this.worldAge = serializer.readLong();
		this.time = serializer.readLong();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeLong(this.worldAge);
		serializer.writeLong(this.time);
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handlePacket(this);
	}

}
