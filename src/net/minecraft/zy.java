package net.minecraft;

public class zy extends zb {

	private xu a;
	private double b;
	private double c;
	private double d;
	private double e;
	private int f;
	private boolean g;

	public zy(xu var1, double var2) {
		this(var1, var2, 120);
	}

	public zy(xu var1, double var2, int var4) {
		this.a = var1;
		this.e = var2;
		this.f = var4;
		this.a(1);
	}

	public boolean a() {
		if (!this.g) {
			if (this.a.bg() >= 100) {
				return false;
			}

			if (this.a.bb().nextInt(this.f) != 0) {
				return false;
			}
		}

		brw var1 = abf.a(this.a, 10, 7);
		if (var1 == null) {
			return false;
		} else {
			this.b = var1.a;
			this.c = var1.b;
			this.d = var1.c;
			this.g = false;
			return true;
		}
	}

	public boolean b() {
		return !this.a.s().m();
	}

	public void c() {
		this.a.s().a(this.b, this.c, this.d, this.e);
	}

	public void f() {
		this.g = true;
	}

	public void b(int var1) {
		this.f = var1;
	}
}
