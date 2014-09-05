package net.minecraft;

class ack extends zn {

	private final acb c;
	private boolean d;
	private boolean e = false;

	public ack(acb var1) {
		super(var1, 0.699999988079071D, 16);
		this.c = var1;
	}

	public boolean a() {
		if (this.a <= 0) {
			if (!this.c.o.Q().b("mobGriefing")) {
				return false;
			}

			this.e = false;
			this.d = acb.a(this.c);
		}

		return super.a();
	}

	public boolean b() {
		return this.e && super.b();
	}

	public void c() {
		super.c();
	}

	public void d() {
		super.d();
	}

	public void e() {
		super.e();
		this.c.p().a((double) this.b.n() + 0.5D, (double) (this.b.o() + 1), (double) this.b.p() + 0.5D, 10.0F, (float) this.c.bP());
		if (this.f()) {
			World var1 = this.c.o;
			Position var2 = this.b.a();
			bec var3 = var1.p(var2);
			Block var4 = var3.c();
			if (this.e && var4 instanceof BlockCarrots && ((Integer) var3.b(BlockCarrots.a)).intValue() == 7) {
				var1.a(var2, aty.a.P(), 2);
				var1.b(var2, true);
				this.c.cn();
			}

			this.e = false;
			this.a = 10;
		}

	}

	protected boolean a(World var1, Position var2) {
		Block var3 = var1.p(var2).c();
		if (var3 == aty.ak) {
			var2 = var2.a();
			bec var4 = var1.p(var2);
			var3 = var4.c();
			if (var3 instanceof BlockCarrots && ((Integer) var4.b(BlockCarrots.a)).intValue() == 7 && this.d && !this.e) {
				this.e = true;
				return true;
			}
		}

		return false;
	}
}
