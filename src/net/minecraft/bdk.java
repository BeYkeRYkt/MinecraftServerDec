package net.minecraft;

class bdk implements CommandSenderInterface {

	// $FF: synthetic field
	final TileEntitySign a;

	bdk(TileEntitySign var1) {
		this.a = var1;
	}

	public String getName() {
		return "Sign";
	}

	public IChatBaseComponent getComponentName() {
		return new ChatComponentText(this.getName());
	}

	public void sendChatMessage(IChatBaseComponent var1) {
	}

	public boolean canExecuteCommand(int var1, String var2) {
		return true;
	}

	public Position getEntityPosition() {
		return this.a.position;
	}

	public Vec3D getCenter() {
		return new Vec3D((double) this.a.position.getX() + 0.5D, (double) this.a.position.getY() + 0.5D, (double) this.a.position.getZ() + 0.5D);
	}

	public World getPrimaryWorld() {
		return this.a.world;
	}

	public Entity getEntity() {
		return null;
	}

	public boolean t_() {
		return false;
	}

	public void a(ag var1, int var2) {
	}
}
