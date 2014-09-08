package net.minecraft;

public class PacketPlayInPlayAbilities implements Packet<PlayInPacketListener> {

	private boolean invulnerable;
	private boolean flying;
	private boolean mayfly;
	private boolean instabuild;
	private float flySpeed;
	private float walkSpeed;

	public PacketPlayInPlayAbilities() {
	}

	public PacketPlayInPlayAbilities(PlayerProperties properties) {
		this.setInvulnerable(properties.invulnerable);
		this.setFlying(properties.flying);
		this.setMayFly(properties.mayfly);
		this.setInstabuild(properties.instabuild);
		this.setFlySpeed(properties.getFlySpeed());
		this.setWalkSpeed(properties.getWalkSpeed());
	}

	public void readData(PacketDataSerializer serializer) {
		byte bifield = serializer.readByte();
		this.setInvulnerable((bifield & 1) > 0);
		this.setFlying((bifield & 2) > 0);
		this.setMayFly((bifield & 4) > 0);
		this.setInstabuild((bifield & 8) > 0);
		this.setFlySpeed(serializer.readFloat());
		this.setWalkSpeed(serializer.readFloat());
	}

	public void writeData(PacketDataSerializer serializer) {
		byte bitfield = 0;
		if (this.isInvulnerable()) {
			bitfield = (byte) (bitfield | 1);
		}

		if (this.isFlying()) {
			bitfield = (byte) (bitfield | 2);
		}

		if (this.mayFly()) {
			bitfield = (byte) (bitfield | 4);
		}

		if (this.isInstabuild()) {
			bitfield = (byte) (bitfield | 8);
		}

		serializer.writeByte(bitfield);
		serializer.writeFloat(this.flySpeed);
		serializer.writeFloat(this.walkSpeed);
	}

	public void handlePacket(PlayInPacketListener listener) {
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

	public boolean mayFly() {
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
