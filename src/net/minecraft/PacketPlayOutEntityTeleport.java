package net.minecraft;

public class PacketPlayOutEntityTeleport implements Packet<PlayOutPacketListener> {

	private int entityId;
	private int x;
	private int y;
	private int z;
	private byte yaw;
	private byte pitch;
	private boolean onGround;

	public PacketPlayOutEntityTeleport() {
	}

	public PacketPlayOutEntityTeleport(Entity entity) {
		this.entityId = entity.getId();
		this.x = MathHelper.toFixedPointInt(entity.locationX * 32.0D);
		this.y = MathHelper.toFixedPointInt(entity.locationY * 32.0D);
		this.z = MathHelper.toFixedPointInt(entity.locationZ * 32.0D);
		this.yaw = (byte) ((int) (entity.yaw * 256.0F / 360.0F));
		this.pitch = (byte) ((int) (entity.pitch * 256.0F / 360.0F));
		this.onGround = entity.onGround;
	}

	public PacketPlayOutEntityTeleport(int entityId, int x, int y, int z, byte yaw, byte pitch, boolean onGround) {
		this.entityId = entityId;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.x = serializer.readInt();
		this.y = serializer.readInt();
		this.z = serializer.readInt();
		this.yaw = serializer.readByte();
		this.pitch = serializer.readByte();
		this.onGround = serializer.readBoolean();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeInt(this.x);
		serializer.writeInt(this.y);
		serializer.writeInt(this.z);
		serializer.writeByte(this.yaw);
		serializer.writeByte(this.pitch);
		serializer.writeBoolean(this.onGround);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
