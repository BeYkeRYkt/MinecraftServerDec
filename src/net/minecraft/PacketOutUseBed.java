package net.minecraft;

public class PacketOutUseBed implements Packet<PlayClientboundPacketListener> {

	private int entityId;
	private Position position;

	public PacketOutUseBed() {
	}

	public PacketOutUseBed(EntityHuman human, Position position) {
		this.entityId = human.getId();
		this.position = position;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.position = serializer.readPosition();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writePosition(this.position);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
