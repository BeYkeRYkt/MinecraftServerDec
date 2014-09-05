package net.minecraft;

public class PacketEntityRelativeLookMove extends PacketEntity {

	public PacketEntityRelativeLookMove() {
	}

	public PacketEntityRelativeLookMove(int entityId, byte diffX, byte diffY, byte diffZ, byte yaw, byte pitch, boolean onGround) {
		super(entityId);
		this.diffX = diffX;
		this.diffY = diffY;
		this.diffZ = diffZ;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	public void readData(PacketDataSerializer serializer) {
		super.readData(serializer);
		this.diffX = serializer.readByte();
		this.diffY = serializer.readByte();
		this.diffZ = serializer.readByte();
		this.yaw = serializer.readByte();
		this.pitch = serializer.readByte();
		this.onGround = serializer.readBoolean();
	}

	public void writeData(PacketDataSerializer serializer) {
		super.writeData(serializer);
		serializer.writeByte(this.diffX);
		serializer.writeByte(this.diffY);
		serializer.writeByte(this.diffZ);
		serializer.writeByte(this.yaw);
		serializer.writeByte(this.pitch);
		serializer.writeBoolean(this.onGround);
	}

}
