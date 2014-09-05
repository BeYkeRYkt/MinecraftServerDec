package net.minecraft;

class agd extends zb {

	private afy a;
	private float b;
	private int c;

	public agd(afy var1) {
		this.a = var1;
		this.a(2);
	}

	public boolean a() {
		return this.a.u() == null && (this.a.onGround || this.a.V() || this.a.ab());
	}

	public void e() {
		if (--this.c <= 0) {
			this.c = 40 + this.a.bb().nextInt(60);
			this.b = (float) this.a.bb().nextInt(360);
		}

		((agc) this.a.q()).a(this.b, false);
	}
}
