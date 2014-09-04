package net.minecraft;

public class ajk {

	private final int a;
	public final vq d;
	public int e;
	public int f;
	public int g;

	public ajk(vq var1, int var2, int var3, int var4) {
		this.d = var1;
		this.a = var2;
		this.f = var3;
		this.g = var4;
	}

	public void a(amj var1, amj var2) {
		if (var1 != null && var2 != null) {
			if (var1.b() == var2.b()) {
				int var3 = var2.b - var1.b;
				if (var3 > 0) {
					this.a(var1, var3);
				}

			}
		}
	}

	protected void a(amj var1, int var2) {
	}

	protected void c(amj var1) {
	}

	public void a(ahd var1, amj var2) {
		this.f();
	}

	public boolean a(amj var1) {
		return true;
	}

	public amj d() {
		return this.d.a(this.a);
	}

	public boolean e() {
		return this.d() != null;
	}

	public void d(amj var1) {
		this.d.a(this.a, var1);
		this.f();
	}

	public void f() {
		this.d.o_();
	}

	public int a() {
		return this.d.p_();
	}

	public int b(amj var1) {
		return this.a();
	}

	public amj a(int var1) {
		return this.d.a(this.a, var1);
	}

	public boolean a(vq var1, int var2) {
		return var1 == this.d && var2 == this.a;
	}

	public boolean a(ahd var1) {
		return true;
	}
}
