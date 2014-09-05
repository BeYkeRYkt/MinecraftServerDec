package net.minecraft;

class aec extends aqf {

	// $FF: synthetic field
	final aeb a;

	aec(aeb var1) {
		this.a = var1;
	}

	public void h() {
		this.a.getDataWatcher().b(23, this.l());
		this.a.getDataWatcher().b(24, JSONComponentFormat.a(this.k()));
	}

	public Position c() {
		return new Position(this.a.locationX, this.a.locationY + 0.5D, this.a.locationZ);
	}

	public brw d() {
		return new brw(this.a.locationX, this.a.locationY, this.a.locationZ);
	}

	public World e() {
		return this.a.o;
	}

	public Entity f() {
		return this.a;
	}
}
