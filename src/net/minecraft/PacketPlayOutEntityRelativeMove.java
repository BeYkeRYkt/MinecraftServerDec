package net.minecraft;

public class PacketPlayOutEntityRelativeMove extends PacketPlayOutEntity {

	public PacketPlayOutEntityRelativeMove() {
	}

	public PacketPlayOutEntityRelativeMove(int entityId, byte diffX, byte diffY, byte diffZ, boolean onGround) {
		super(entityId);
		this.diffX = diffX;
		this.diffY = diffY;
		this.diffZ = diffZ;
		this.onGround = onGround;
	}

	public void readData(PacketDataSerializer serializer) {
		super.readData(serializer);
		this.diffX = serializer.readByte();
		this.diffY = serializer.readByte();
		this.diffZ = serializer.readByte();
		this.onGround = serializer.readBoolean();
	}

	public void writeData(PacketDataSerializer serializer) {
		super.writeData(serializer);
		serializer.writeByte(this.diffX);
		serializer.writeByte(this.diffY);
		serializer.writeByte(this.diffZ);
		serializer.writeBoolean(this.onGround);
	}

}
