package net.minecraft;

import java.util.Set;

public class PacketPlayerPositionAndLook implements Packet<PlayPacketListener> {

	private double x;
	private double y;
	private double z;
	private float yaw;
	private float pitch;
	private Set<PositionFlag> flags;

	public PacketPlayerPositionAndLook() {
	}

	public PacketPlayerPositionAndLook(double x, double y, double z, float yaw, float pitch, Set<PositionFlag> flags) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
		this.flags = flags;
	}

	public void readData(PacketDataSerializer serializer) {
		this.x = serializer.readDouble();
		this.y = serializer.readDouble();
		this.z = serializer.readDouble();
		this.yaw = serializer.readFloat();
		this.pitch = serializer.readFloat();
		this.flags = PositionFlag.fromBitfield(serializer.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeDouble(this.x);
		serializer.writeDouble(this.y);
		serializer.writeDouble(this.z);
		serializer.writeFloat(this.yaw);
		serializer.writeFloat(this.pitch);
		serializer.writeByte(PositionFlag.toBitfield(this.flags));
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}
