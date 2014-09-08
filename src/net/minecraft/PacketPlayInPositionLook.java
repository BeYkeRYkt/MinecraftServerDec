package net.minecraft;

public class PacketPlayInPositionLook extends PacketPlayInPlayer {

	public PacketPlayInPositionLook() {
		this.hasPosition = true;
		this.hasLook = true;
	}

	public void readData(PacketDataSerializer serializer) {
		this.x = serializer.readDouble();
		this.feetY = serializer.readDouble();
		this.z = serializer.readDouble();
		this.yaw = serializer.readFloat();
		this.pitch = serializer.readFloat();
		super.readData(serializer);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeDouble(this.x);
		serializer.writeDouble(this.feetY);
		serializer.writeDouble(this.z);
		serializer.writeFloat(this.yaw);
		serializer.writeFloat(this.pitch);
		super.writeData(serializer);
	}

}
