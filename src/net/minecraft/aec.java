package net.minecraft;

class aec extends aqf {

	// $FF: synthetic field
	final aeb a;

	aec(aeb var1) {
		this.a = var1;
	}

	public void h() {
		this.a.H().b(23, this.l());
		this.a.H().b(24, hp.a(this.k()));
	}

	public dt c() {
		return new dt(this.a.s, this.a.t + 0.5D, this.a.u);
	}

	public brw d() {
		return new brw(this.a.s, this.a.t, this.a.u);
	}

	public World e() {
		return this.a.o;
	}

	public Entity f() {
		return this.a;
	}
}
