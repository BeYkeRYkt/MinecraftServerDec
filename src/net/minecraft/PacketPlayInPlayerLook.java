package net.minecraft;

public class PacketPlayInPlayerLook extends PacketPlayInPlayer {

	public PacketPlayInPlayerLook() {
		this.hasLook = true;
	}

	public void readData(PacketDataSerializer serializer) {
		this.yaw = serializer.readFloat();
		this.pitch = serializer.readFloat();
		super.readData(serializer);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeFloat(this.yaw);
		serializer.writeFloat(this.pitch);
		super.writeData(serializer);
	}

}
