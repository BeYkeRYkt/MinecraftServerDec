package net.minecraft;

class bdk implements CommandSenderInterface {

	// $FF: synthetic field
	final bdj a;

	bdk(bdj var1) {
		this.a = var1;
	}

	public String d_() {
		return "Sign";
	}

	public IJSONComponent e_() {
		return new hy(this.d_());
	}

	public void a(IJSONComponent var1) {
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public Position c() {
		return this.a.c;
	}

	public brw d() {
		return new brw((double) this.a.c.n() + 0.5D, (double) this.a.c.o() + 0.5D, (double) this.a.c.p() + 0.5D);
	}

	public World e() {
		return this.a.b;
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
