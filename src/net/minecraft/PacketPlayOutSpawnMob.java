package net.minecraft;

import java.io.IOException;

public class PacketPlayOutSpawnMob implements Packet<PlayOutPacketListener> {

	private int entityId;
	private int fixedId;
	private int x;
	private int y;
	private int z;
	private int speedX;
	private int speedY;
	private int speedZ;
	private byte yaw;
	private byte pitch;
	private byte headPitch;
	private DataWatcher dataWatcher;
	public PacketPlayOutSpawnMob() {
	}

	public PacketPlayOutSpawnMob(EntityLiving entityLiving) {
		this.entityId = entityLiving.getId();
		this.fixedId = (byte) EntityTypes.getFixedId(entityLiving);
		this.x = MathHelper.toFixedPointInt(entityLiving.locationX * 32.0D);
		this.y = MathHelper.toFixedPointInt(entityLiving.locationY * 32.0D);
		this.z = MathHelper.toFixedPointInt(entityLiving.locationZ * 32.0D);
		this.yaw = (byte) ((int) (entityLiving.yaw * 256.0F / 360.0F));
		this.pitch = (byte) ((int) (entityLiving.pitch * 256.0F / 360.0F));
		this.headPitch = (byte) ((int) (entityLiving.headPitch * 256.0F / 360.0F));
		double var = 3.9D;
		double motX = entityLiving.motionX;
		double motY = entityLiving.motionY;
		double motZ = entityLiving.motionZ;
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
		this.dataWatcher = entityLiving.getDataWatcher();
	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.entityId = serializer.readVarInt();
		this.fixedId = serializer.readByte() & 255;
		this.x = serializer.readInt();
		this.y = serializer.readInt();
		this.z = serializer.readInt();
		this.yaw = serializer.readByte();
		this.pitch = serializer.readByte();
		this.headPitch = serializer.readByte();
		this.speedX = serializer.readShort();
		this.speedY = serializer.readShort();
		this.speedZ = serializer.readShort();
		DataWatcher.readData(serializer);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeByte(this.fixedId & 255);
		serializer.writeInt(this.x);
		serializer.writeInt(this.y);
		serializer.writeInt(this.z);
		serializer.writeByte(this.yaw);
		serializer.writeByte(this.pitch);
		serializer.writeByte(this.headPitch);
		serializer.writeShort(this.speedX);
		serializer.writeShort(this.speedY);
		serializer.writeShort(this.speedZ);
		this.dataWatcher.writeData(serializer);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}
