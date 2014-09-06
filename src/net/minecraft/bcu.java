package net.minecraft;

class bcu extends aqf {

	// $FF: synthetic field
	final TileEntityCommand a;

	bcu(TileEntityCommand var1) {
		this.a = var1;
	}

	public Position c() {
		return this.a.position;
	}

	public Vec3D d() {
		return new Vec3D((double) this.a.position.getX() + 0.5D, (double) this.a.position.getY() + 0.5D, (double) this.a.position.getZ() + 0.5D);
	}

	public World e() {
		return this.a.z();
	}

	public void a(String var1) {
		super.a(var1);
		this.a.o_();
	}

	public void h() {
		this.a.z().h(this.a.position);
	}

	public Entity f() {
		return null;
	}
}
