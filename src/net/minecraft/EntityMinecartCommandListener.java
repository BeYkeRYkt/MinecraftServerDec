package net.minecraft;

class EntityMinecartCommandListener extends CommandBlockListenerAbstract {

	final EntityMinecartCommandBlock minecart;

	EntityMinecartCommandListener(EntityMinecartCommandBlock minecart) {
		this.minecart = minecart;
	}

	public void updateEntity() {
		this.minecart.getDataWatcher().b(23, this.getCommand());
		this.minecart.getDataWatcher().b(24, ChatSerializer.toJsonString(this.getLastOutput()));
	}

	public Position getEntityPosition() {
		return new Position(this.minecart.locationX, this.minecart.locationY + 0.5D, this.minecart.locationZ);
	}

	public Vec3D getCenter() {
		return new Vec3D(this.minecart.locationX, this.minecart.locationY, this.minecart.locationZ);
	}

	public World getWorld() {
		return this.minecart.world;
	}

	public Entity getEntity() {
		return this.minecart;
	}

}
