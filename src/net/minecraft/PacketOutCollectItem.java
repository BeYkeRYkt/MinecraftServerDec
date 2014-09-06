package net.minecraft;

public class PacketOutCollectItem implements Packet<PlayClientboundPacketListener> {

	private int collectedEntityId;
	private int collectorEntityId;

	public PacketOutCollectItem() {
	}

	public PacketOutCollectItem(int collectedEntityId, int collectorEntityId) {
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

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
