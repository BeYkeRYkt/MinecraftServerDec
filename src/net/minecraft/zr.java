package net.minecraft;

public class zr extends zn {

	private final aby c;

	public zr(aby var1, double var2) {
		super(var1, var2, 8);
		this.c = var1;
	}

	public boolean a() {
		return this.c.cj() && !this.c.cl() && super.a();
	}

	public boolean b() {
		return super.b();
	}

	public void c() {
		super.c();
		this.c.cn().a(false);
	}

	public void d() {
		super.d();
		this.c.n(false);
	}

	public void e() {
		super.e();
		this.c.cn().a(false);
		if (!this.f()) {
			this.c.n(false);
		} else if (!this.c.cl()) {
			this.c.n(true);
		}

	}

	protected boolean a(World var1, Position var2) {
		if (!var1.d(var2.a())) {
			return false;
		} else {
			bec var3 = var1.p(var2);
			Block var4 = var3.c();
			if (var4 == aty.ae) {
				bcm var5 = var1.s(var2);
				if (var5 instanceof bcr && ((bcr) var5).l < 1) {
					return true;
				}
			} else {
				if (var4 == aty.am) {
					return true;
				}

				if (var4 == aty.C && var3.b(atp.a) != atq.a) {
					return true;
				}
			}

			return false;
		}
	}
}
