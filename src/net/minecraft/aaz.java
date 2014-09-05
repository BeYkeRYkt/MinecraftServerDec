package net.minecraft;

public abstract class aaz {

	protected xn b;
	protected World c;
	protected bpv d;
	protected double e;
	private final AttributeInstance a;
	private int f;
	private int g;
	private brw h = new brw(0.0D, 0.0D, 0.0D);
	private float i = 1.0F;
	private final bpw j;

	public aaz(xn var1, World var2) {
		this.b = var1;
		this.c = var2;
		this.a = var1.a(afs.b);
		this.j = this.a();
	}

	protected abstract bpw a();

	public void a(double var1) {
		this.e = var1;
	}

	public float i() {
		return (float) this.a.e();
	}

	public final bpv a(double var1, double var3, double var5) {
		return this.a(new Position(DataTypesConverter.toFixedPointInt(var1), (int) var3, DataTypesConverter.toFixedPointInt(var5)));
	}

	public bpv a(Position var1) {
		if (!this.b()) {
			return null;
		} else {
			float var2 = this.i();
			this.c.B.a("pathfind");
			Position var3 = new Position(this.b);
			int var4 = (int) (var2 + 8.0F);
			arj var5 = new arj(this.c, var3.a(-var4, -var4, -var4), var3.a(var4, var4, var4), 0);
			bpv var6 = this.j.a((ard) var5, (Entity) this.b, var1, var2);
			this.c.B.b();
			return var6;
		}
	}

	public boolean a(double var1, double var3, double var5, double var7) {
		bpv var9 = this.a((double) DataTypesConverter.toFixedPointInt(var1), (double) ((int) var3), (double) DataTypesConverter.toFixedPointInt(var5));
		return this.a(var9, var7);
	}

	public void a(float var1) {
		this.i = var1;
	}

	public bpv a(Entity var1) {
		if (!this.b()) {
			return null;
		} else {
			float var2 = this.i();
			this.c.B.a("pathfind");
			Position var3 = (new Position(this.b)).a();
			int var4 = (int) (var2 + 16.0F);
			arj var5 = new arj(this.c, var3.a(-var4, -var4, -var4), var3.a(var4, var4, var4), 0);
			bpv var6 = this.j.a((ard) var5, (Entity) this.b, var1, var2);
			this.c.B.b();
			return var6;
		}
	}

	public boolean a(Entity var1, double var2) {
		bpv var4 = this.a(var1);
		return var4 != null ? this.a(var4, var2) : false;
	}

	public boolean a(bpv var1, double var2) {
		if (var1 == null) {
			this.d = null;
			return false;
		} else {
			if (!var1.a(this.d)) {
				this.d = var1;
			}

			this.d();
			if (this.d.d() == 0) {
				return false;
			} else {
				this.e = var2;
				brw var4 = this.c();
				this.g = this.f;
				this.h = var4;
				return true;
			}
		}
	}

	public bpv j() {
		return this.d;
	}

	public void k() {
		++this.f;
		if (!this.m()) {
			brw var1;
			if (this.b()) {
				this.l();
			} else if (this.d != null && this.d.e() < this.d.d()) {
				var1 = this.c();
				brw var2 = this.d.a(this.b, this.d.e());
				if (var1.b > var2.b && !this.b.onGround && DataTypesConverter.toFixedPointInt(var1.a) == DataTypesConverter.toFixedPointInt(var2.a) && DataTypesConverter.toFixedPointInt(var1.c) == DataTypesConverter.toFixedPointInt(var2.c)) {
					this.d.c(this.d.e() + 1);
				}
			}

			if (!this.m()) {
				var1 = this.d.a((Entity) this.b);
				if (var1 != null) {
					this.b.q().a(var1.a, var1.b, var1.c, this.e);
				}
			}
		}
	}

	protected void l() {
		brw var1 = this.c();
		int var2 = this.d.d();

		for (int var3 = this.d.e(); var3 < this.d.d(); ++var3) {
			if (this.d.a(var3).b != (int) var1.b) {
				var2 = var3;
				break;
			}
		}

		float var8 = this.b.J * this.b.J * this.i;

		int var4;
		for (var4 = this.d.e(); var4 < var2; ++var4) {
			brw var5 = this.d.a(this.b, var4);
			if (var1.g(var5) < (double) var8) {
				this.d.c(var4 + 1);
			}
		}

		var4 = DataTypesConverter.f(this.b.J);
		int var9 = (int) this.b.K + 1;
		int var6 = var4;

		for (int var7 = var2 - 1; var7 >= this.d.e(); --var7) {
			if (this.a(var1, this.d.a(this.b, var7), var4, var9, var6)) {
				this.d.c(var7);
				break;
			}
		}

		this.a(var1);
	}

	protected void a(brw var1) {
		if (this.f - this.g > 100) {
			if (var1.g(this.h) < 2.25D) {
				this.n();
			}

			this.g = this.f;
			this.h = var1;
		}

	}

	public boolean m() {
		return this.d == null || this.d.b();
	}

	public void n() {
		this.d = null;
	}

	protected abstract brw c();

	protected abstract boolean b();

	protected boolean o() {
		return this.b.V() || this.b.ab();
	}

	protected void d() {
	}

	protected abstract boolean a(brw var1, brw var2, int var3, int var4, int var5);
}
