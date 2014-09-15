package net.minecraft;

public class PacketPlayInPlayerPosition extends PacketPlayInPlayer {

	public PacketPlayInPlayerPosition() {
		this.hasPosition = true;
	}

	public void readData(PacketDataSerializer serializer) {
		this.x = serializer.readDouble();
		this.feetY = serializer.readDouble();
		this.z = serializer.readDouble();
		super.readData(serializer);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeDouble(this.x);
		serializer.writeDouble(this.feetY);
		serializer.writeDouble(this.z);
		super.writeData(serializer);
	}

}
