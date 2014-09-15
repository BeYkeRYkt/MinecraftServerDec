package net.minecraft;

public class PacketPlayInSteerVehicle implements Packet<PlayInPacketListener> {

	private float sideways;
	private float forward;
	private boolean jump;
	private boolean unmount;

	public void readData(PacketDataSerializer serializer) {
		this.sideways = serializer.readFloat();
		this.forward = serializer.readFloat();
		byte flag = serializer.readByte();
		this.jump = (flag & 1) > 0;
		this.unmount = (flag & 2) > 0;
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeFloat(this.sideways);
		serializer.writeFloat(this.forward);
		byte flag = 0;
		if (this.jump) {
			flag = (byte) (flag | 1);
		}

		if (this.unmount) {
			flag = (byte) (flag | 2);
		}
		serializer.writeByte(flag);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public float getSidewaysSpeed() {
		return this.sideways;
	}

	public float getForwardSpeed() {
		return this.forward;
	}

	public boolean isJump() {
		return this.jump;
	}

	public boolean isUnmount() {
		return this.unmount;
	}

}
