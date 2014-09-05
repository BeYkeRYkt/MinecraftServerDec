package net.minecraft;

public class PacketHeldItemChange implements Packet<PlayPacketListener> {

	private int newslot;

	public PacketHeldItemChange() {
	}

	public PacketHeldItemChange(int newslot) {
		this.newslot = newslot;
	}

	public void readData(PacketDataSerializer serializer) {
		this.newslot = serializer.readByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.newslot);
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
