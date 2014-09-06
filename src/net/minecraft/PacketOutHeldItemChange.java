package net.minecraft;

public class PacketOutHeldItemChange implements Packet<PlayClientboundPacketListener> {

	private int newslot;

	public PacketOutHeldItemChange() {
	}

	public PacketOutHeldItemChange(int newslot) {
		this.newslot = newslot;
	}

	public void readData(PacketDataSerializer serializer) {
		this.newslot = serializer.readByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.newslot);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
