package net.minecraft;

public class PacketSpawnPainting implements Packet<PlayPacketListener> {

	private int entityId;
	private Position position;
	private PaintingDirection direction;
	private String title;

	public PacketSpawnPainting() {
	}

	public PacketSpawnPainting(EntityPainting painting) {
		this.entityId = painting.getId();
		this.position = painting.getPosition();
		this.direction = painting.direction;
		this.title = painting.type.name;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.title = serializer.readString(PaintingType.maxNameLength);
		this.position = serializer.readPosition();
		this.direction = PaintingDirection.fromByte(serializer.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeString(this.title);
		serializer.writePosition(this.position);
		serializer.writeByte(this.direction.toByte());
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
