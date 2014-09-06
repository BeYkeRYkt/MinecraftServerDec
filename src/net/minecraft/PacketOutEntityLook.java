package net.minecraft;

public class PacketOutEntityLook extends PacketOutEntity {

	public PacketOutEntityLook() {
	}

	public PacketOutEntityLook(int entityId, byte yaw, byte pitch, boolean onGround) {
		super(entityId);
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	public void readData(PacketDataSerializer serializer) {
		super.readData(serializer);
		this.yaw = serializer.readByte();
		this.pitch = serializer.readByte();
		this.onGround = serializer.readBoolean();
	}

	public void writeData(PacketDataSerializer serializer) {
		super.writeData(serializer);
		serializer.writeByte(this.yaw);
		serializer.writeByte(this.pitch);
		serializer.writeBoolean(this.onGround);
	}

}
