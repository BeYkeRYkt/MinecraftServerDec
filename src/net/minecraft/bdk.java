package net.minecraft;

class bdk implements CommandSenderInterface {

	// $FF: synthetic field
	final TileEntitySign a;

	bdk(TileEntitySign var1) {
		this.a = var1;
	}

	public String d_() {
		return "Sign";
	}

	public IJSONComponent e_() {
		return new hy(this.d_());
	}

	public void sendChatMessage(IJSONComponent var1) {
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public Position c() {
		return this.a.position;
	}

	public Vec3D d() {
		return new Vec3D((double) this.a.position.getX() + 0.5D, (double) this.a.position.getY() + 0.5D, (double) this.a.position.getZ() + 0.5D);
	}

	public World e() {
		return this.a.world;
	}

	public Entity f() {
		return null;
	}

	public boolean t_() {
		return false;
	}

	public void a(ag var1, int var2) {
	}
}
