package net.minecraft;

public class PacketPlayInHeldItemChange implements Packet<PlayInPacketListener> {

	private int slot;

	public void readData(PacketDataSerializer serializer) {
		this.slot = serializer.readShort();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeShort(this.slot);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public int getSlot() {
		return this.slot;
	}

}
