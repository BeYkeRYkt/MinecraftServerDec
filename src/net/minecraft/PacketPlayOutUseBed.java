package net.minecraft;

public class PacketPlayOutUseBed implements Packet<PlayOutPacketListener> {

	private int entityId;
	private Position position;

	public PacketPlayOutUseBed() {
	}

	public PacketPlayOutUseBed(EntityHuman human, Position position) {
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

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
