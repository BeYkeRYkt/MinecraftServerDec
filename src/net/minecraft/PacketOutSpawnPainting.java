package net.minecraft;

public class PacketOutSpawnPainting implements Packet<PlayClientboundPacketListener> {

	private int entityId;
	private Position position;
	private BlockFace direction;
	private String title;

	public PacketOutSpawnPainting() {
	}

	public PacketOutSpawnPainting(EntityPainting painting) {
		this.entityId = painting.getId();
		this.position = painting.getPosition();
		this.direction = painting.direction;
		this.title = painting.type.name;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.title = serializer.readString(PaintingType.maxNameLength);
		this.position = serializer.readPosition();
		this.direction = BlockFace.fromByte(serializer.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeString(this.title);
		serializer.writePosition(this.position);
		serializer.writeByte(this.direction.toByte());
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}
