package net.minecraft;

public class PacketPlayOutPlayerAbilities implements Packet<PlayOutPacketListener> {

	private boolean invulnerable;
	private boolean flying;
	private boolean mayfly;
	private boolean instabuild;
	private float flySpeed;
	private float walkSpeed;

	public PacketPlayOutPlayerAbilities() {
	}

	public PacketPlayOutPlayerAbilities(PlayerProperties properties) {
		this.setInvulnerable(properties.invulnerable);
		this.setFlying(properties.flying);
		this.setMayFly(properties.mayfly);
		this.setInstabuild(properties.instabuild);
		this.setFlySpeed(properties.getFlySpeed());
		this.setWalkSpeed(properties.getWalkSpeed());
	}

	public void readData(PacketDataSerializer serializer) {
		byte b = serializer.readByte();
		this.setInvulnerable((b & 1) > 0);
		this.setFlying((b & 2) > 0);
		this.setMayFly((b & 4) > 0);
		this.setInstabuild((b & 8) > 0);
		this.setFlySpeed(serializer.readFloat());
		this.setWalkSpeed(serializer.readFloat());
	}

	public void writeData(PacketDataSerializer serializer) {
		byte b = 0;

		if (this.isInvulnerable()) {
			b = (byte) (b | 1);
		}

		if (this.isFlying()) {
			b = (byte) (b | 2);
		}

		if (this.isMayFly()) {
			b = (byte) (b | 4);
		}

		if (this.isInstabuild()) {
			b = (byte) (b | 8);
		}

		serializer.writeByte(b);
		serializer.writeFloat(this.flySpeed);
		serializer.writeFloat(this.walkSpeed);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	public boolean isInvulnerable() {
		return this.invulnerable;
	}

	public void setInvulnerable(boolean invulnerable) {
		this.invulnerable = invulnerable;
	}

	public boolean isFlying() {
		return this.flying;
	}

	public void setFlying(boolean flying) {
		this.flying = flying;
	}

	public boolean isMayFly() {
		return this.mayfly;
	}

	public void setMayFly(boolean mayfly) {
		this.mayfly = mayfly;
	}

	public boolean isInstabuild() {
		return this.instabuild;
	}

	public void setInstabuild(boolean instabuild) {
		this.instabuild = instabuild;
	}

	public void setFlySpeed(float flySpeed) {
		this.flySpeed = flySpeed;
	}

	public void setWalkSpeed(float walkSpeed) {
		this.walkSpeed = walkSpeed;
	}

}
