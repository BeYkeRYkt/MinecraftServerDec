package net.minecraft;

class bdl implements CommandSenderInterface {

	// $FF: synthetic field
	final EntityHuman a;
	// $FF: synthetic field
	final bdj b;

	bdl(bdj var1, EntityHuman var2) {
		this.b = var1;
		this.a = var2;
	}

	public String d_() {
		return this.a.d_();
	}

	public IJSONComponent e_() {
		return this.a.e_();
	}

	public void a(IJSONComponent var1) {
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public Position c() {
		return this.b.c;
	}

	public brw d() {
		return new brw((double) this.b.c.n() + 0.5D, (double) this.b.c.o() + 0.5D, (double) this.b.c.p() + 0.5D);
	}

	public World e() {
		return this.a.e();
	}

	public Entity f() {
		return this.a;
	}

	public boolean t_() {
		return false;
	}

	public void a(ag var1, int var2) {
		bdj.a(this.b).a(this, var1, var2);
	}
}
