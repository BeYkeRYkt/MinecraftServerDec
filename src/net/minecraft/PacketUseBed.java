package net.minecraft;

public class PacketUseBed implements Packet<PlayPacketListener> {

	private int entityId;
	private Position position;

	public PacketUseBed() {
	}

	public PacketUseBed(EntityHuman human, Position position) {
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

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
