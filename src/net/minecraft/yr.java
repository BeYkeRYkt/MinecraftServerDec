package net.minecraft;

public class yr extends zb {

	private acu a;
	private ahd b;
	private World c;
	private float d;
	private int e;

	public yr(acu var1, float var2) {
		this.a = var1;
		this.c = var1.o;
		this.d = var2;
		this.a(2);
	}

	public boolean a() {
		this.b = this.c.a(this.a, (double) this.d);
		return this.b == null ? false : this.a(this.b);
	}

	public boolean b() {
		return !this.b.ai() ? false : (this.a.h(this.b) > (double) (this.d * this.d) ? false : this.e > 0 && this.a(this.b));
	}

	public void c() {
		this.a.p(true);
		this.e = 40 + this.a.bb().nextInt(40);
	}

	public void d() {
		this.a.p(false);
		this.b = null;
	}

	public void e() {
		this.a.p().a(this.b.s, this.b.t + (double) this.b.aR(), this.b.u, 10.0F, (float) this.a.bP());
		--this.e;
	}

	private boolean a(ahd var1) {
		amj var2 = var1.bg.h();
		return var2 == null ? false : (!this.a.cj() && var2.b() == amk.aX ? true : this.a.d(var2));
	}
}
