package net.minecraft;

public class PacketPlayOutEntityVelocity implements Packet<PlayOutPacketListener> {

	private int entityId;
	private int x;
	private int y;
	private int z;

	public PacketPlayOutEntityVelocity() {
	}

	public PacketPlayOutEntityVelocity(Entity entity) {
		this(entity.getId(), entity.motionX, entity.motionY, entity.motionZ);
	}

	public PacketPlayOutEntityVelocity(int entityId, double motX, double motY, double motZ) {
		this.entityId = entityId;
		double var = 3.9D;
		if (motX < -var) {
			motX = -var;
		}

		if (motY < -var) {
			motY = -var;
		}

		if (motZ < -var) {
			motZ = -var;
		}

		if (motX > var) {
			motX = var;
		}

		if (motY > var) {
			motY = var;
		}

		if (motZ > var) {
			motZ = var;
		}

		this.x = (int) (motX * 8000.0D);
		this.y = (int) (motY * 8000.0D);
		this.z = (int) (motZ * 8000.0D);
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.x = serializer.readShort();
		this.y = serializer.readShort();
		this.z = serializer.readShort();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeShort(this.x);
		serializer.writeShort(this.y);
		serializer.writeShort(this.z);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
