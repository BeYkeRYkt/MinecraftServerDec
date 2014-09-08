package net.minecraft;

public class PacketPlayOutSpawnPainting implements Packet<PlayOutPacketListener> {

	private int entityId;
	private Position position;
	private BlockFace direction;
	private String title;

	public PacketPlayOutSpawnPainting() {
	}

	public PacketPlayOutSpawnPainting(EntityPainting painting) {
		this.entityId = painting.getId();
		this.position = painting.getPosition();
		this.direction = painting.direction;
		this.title = painting.type.name;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.title = serializer.readString(PaintingType.maxNameLength);
		this.position = serializer.readPosition();
		this.direction = BlockFace.fromDirection(serializer.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeString(this.title);
		serializer.writePosition(this.position);
		serializer.writeByte(this.direction.toDirection());
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
