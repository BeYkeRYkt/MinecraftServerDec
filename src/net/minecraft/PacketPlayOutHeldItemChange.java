package net.minecraft;

public class PacketPlayOutHeldItemChange implements Packet<PlayOutPacketListener> {

	private int newslot;

	public PacketPlayOutHeldItemChange() {
	}

	public PacketPlayOutHeldItemChange(int newslot) {
		this.newslot = newslot;
	}

	public void readData(PacketDataSerializer serializer) {
		this.newslot = serializer.readByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.newslot);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
