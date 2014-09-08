package net.minecraft;

class aec extends aqf {

	// $FF: synthetic field
	final EntityMinecartCommandBlock a;

	aec(EntityMinecartCommandBlock var1) {
		this.a = var1;
	}

	public void h() {
		this.a.getDataWatcher().b(23, this.l());
		this.a.getDataWatcher().b(24, ChatSerializer.a(this.k()));
	}

	public Position c() {
		return new Position(this.a.locationX, this.a.locationY + 0.5D, this.a.locationZ);
	}

	public Vec3D d() {
		return new Vec3D(this.a.locationX, this.a.locationY, this.a.locationZ);
	}

	public World e() {
		return this.a.o;
	}

	public Entity f() {
		return this.a;
	}
}
