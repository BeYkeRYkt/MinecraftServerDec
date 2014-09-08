package net.minecraft;

public class PacketPlayInPlayer implements Packet<PlayInPacketListener> {

	protected double x;
	protected double feetY;
	protected double z;
	protected float yaw;
	protected float pitch;
	protected boolean onGround;
	protected boolean hasPosition;
	protected boolean hasLook;

	public void readData(PacketDataSerializer serializer) {
		this.onGround = serializer.readUnsignedByte() != 0;
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.onGround ? 1 : 0);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public double getX() {
		return this.x;
	}

	public double getFeetY() {
		return this.feetY;
	}

	public double getZ() {
		return this.z;
	}

	public float getYaw() {
		return this.yaw;
	}

	public float getPitch() {
		return this.pitch;
	}

	public boolean isOnGround() {
		return this.onGround;
	}

	public boolean hasPosition() {
		return this.hasPosition;
	}

	public boolean hasLook() {
		return this.hasLook;
	}

	public void setHasPosition(boolean hasPosition) {
		this.hasPosition = hasPosition;
	}

}
