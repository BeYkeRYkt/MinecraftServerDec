package net.minecraft;

public class PacketPlayOutSpawnObject implements Packet<PlayOutPacketListener> {

	private int entityId;
	private int x;
	private int y;
	private int z;
	private int speedX;
	private int speedY;
	private int speedZ;
	private int pitch;
	private int yaw;
	private int type;
	private int contentsLength;

	public PacketPlayOutSpawnObject() {
	}

	public PacketPlayOutSpawnObject(Entity entity, int type) {
		this(entity, type, 0);
	}

	public PacketPlayOutSpawnObject(Entity entity, int type, int contentsLength) {
		this.entityId = entity.getId();
		this.x = MathHelper.toFixedPointInt(entity.locationX * 32.0D);
		this.y = MathHelper.toFixedPointInt(entity.locationY * 32.0D);
		this.z = MathHelper.toFixedPointInt(entity.locationZ * 32.0D);
		this.pitch = MathHelper.d(entity.pitch * 256.0F / 360.0F);
		this.yaw = MathHelper.d(entity.yaw * 256.0F / 360.0F);
		this.type = type;
		this.contentsLength = contentsLength;
		if (contentsLength > 0) {
			double motX = entity.motionX;
			double motY = entity.motionY;
			double motZ = entity.motionZ;
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

			this.speedX = (int) (motX * 8000.0D);
			this.speedY = (int) (motY * 8000.0D);
			this.speedZ = (int) (motZ * 8000.0D);
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.type = serializer.readByte();
		this.x = serializer.readInt();
		this.y = serializer.readInt();
		this.z = serializer.readInt();
		this.pitch = serializer.readByte();
		this.yaw = serializer.readByte();
		this.contentsLength = serializer.readInt();
		if (this.contentsLength > 0) {
			this.speedX = serializer.readShort();
			this.speedY = serializer.readShort();
			this.speedZ = serializer.readShort();
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeByte(this.type);
		serializer.writeInt(this.x);
		serializer.writeInt(this.y);
		serializer.writeInt(this.z);
		serializer.writeByte(this.pitch);
		serializer.writeByte(this.yaw);
		serializer.writeInt(this.contentsLength);
		if (this.contentsLength > 0) {
			serializer.writeShort(this.speedX);
			serializer.writeShort(this.speedY);
			serializer.writeShort(this.speedZ);
		}

	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void setSpeedZ(int speedZ) {
		this.speedZ = speedZ;
	}

}
