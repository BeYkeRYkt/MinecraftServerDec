package net.minecraft;

public class PacketPlayOutSpawnGlobalEntity implements Packet<PlayOutPacketListener> {

	private int entityId;
	private int x;
	private int y;
	private int z;
	private int type;

	public PacketPlayOutSpawnGlobalEntity() {
	}

	public PacketPlayOutSpawnGlobalEntity(Entity entity1) {
		this.entityId = entity1.getId();
		this.x = MathHelper.toFixedPointInt(entity1.locationX * 32.0D);
		this.y = MathHelper.toFixedPointInt(entity1.locationY * 32.0D);
		this.z = MathHelper.toFixedPointInt(entity1.locationZ * 32.0D);
		if (entity1 instanceof EntityLightning) {
			this.type = 1;
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.type = serializer.readByte();
		this.x = serializer.readInt();
		this.y = serializer.readInt();
		this.z = serializer.readInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeByte(this.type);
		serializer.writeInt(this.x);
		serializer.writeInt(this.y);
		serializer.writeInt(this.z);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
