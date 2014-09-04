package net.minecraft;

public class zh extends zb {

	protected xn a;
	protected Entity b;
	protected float c;
	private int e;
	private float f;
	protected Class d;

	public zh(xn var1, Class var2, float var3) {
		this.a = var1;
		this.d = var2;
		this.c = var3;
		this.f = 0.02F;
		this.a(2);
	}

	public zh(xn var1, Class var2, float var3, float var4) {
		this.a = var1;
		this.d = var2;
		this.c = var3;
		this.f = var4;
		this.a(2);
	}

	public boolean a() {
		if (this.a.bb().nextFloat() >= this.f) {
			return false;
		} else {
			if (this.a.u() != null) {
				this.b = this.a.u();
			}

			if (this.d == ahd.class) {
				this.b = this.a.o.a(this.a, (double) this.c);
			} else {
				this.b = this.a.o.a(this.d, this.a.aQ().b((double) this.c, 3.0D, (double) this.c), (Entity) this.a);
			}

			return this.b != null;
		}
	}

	public boolean b() {
		return !this.b.ai() ? false : (this.a.h(this.b) > (double) (this.c * this.c) ? false : this.e > 0);
	}

	public void c() {
		this.e = 40 + this.a.bb().nextInt(40);
	}

	public void d() {
		this.b = null;
	}

	public void e() {
		this.a.p().a(this.b.s, this.b.t + (double) this.b.aR(), this.b.u, 10.0F, (float) this.a.bP());
		--this.e;
	}
}
