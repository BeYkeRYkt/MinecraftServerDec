package net.minecraft;

public class PacketCollectItem implements Packet<PlayPacketListener> {

	private int collectedEntityId;
	private int collectorEntityId;

	public PacketCollectItem() {
	}

	public PacketCollectItem(int collectedEntityId, int collectorEntityId) {
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

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
