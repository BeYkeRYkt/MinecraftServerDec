package net.minecraft;

public class PacketPlayOutCollectItem implements Packet<PlayOutPacketListener> {

	private int collectedEntityId;
	private int collectorEntityId;

	public PacketPlayOutCollectItem() {
	}

	public PacketPlayOutCollectItem(int collectedEntityId, int collectorEntityId) {
		this.collectedEntityId = collectedEntityId;
		this.collectorEntityId = collectorEntityId;
	}

	public void readData(PacketDataSerializer serializer) {
		this.collectedEntityId = serializer.readVarInt();
		this.collectorEntityId = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer collectorEntityId) {
		collectorEntityId.writeVarInt(this.collectedEntityId);
		collectorEntityId.writeVarInt(this.collectorEntityId);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
