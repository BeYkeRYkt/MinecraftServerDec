package net.minecraft;

public class ajj extends ajk {

	private final ain a;
	private final ahd b;
	private int c;

	public ajj(ahd var1, ain var2, vq var3, int var4, int var5, int var6) {
		super(var3, var4, var5, var6);
		this.b = var1;
		this.a = var2;
	}

	public boolean a(amj var1) {
		return false;
	}

	public amj a(int var1) {
		if (this.e()) {
			this.c += Math.min(var1, this.d().b);
		}

		return super.a(var1);
	}

	protected void a(amj var1, int var2) {
		this.c += var2;
		this.c(var1);
	}

	protected void c(amj var1) {
		if (this.c > 0) {
			var1.a(this.b.o, this.b, this.c);
		}

		this.c = 0;
		if (var1.b() == alq.a(aty.ai)) {
			this.b.b((tq) tl.h);
		}

		if (var1.b() instanceof amu) {
			this.b.b((tq) tl.i);
		}

		if (var1.b() == alq.a(aty.al)) {
			this.b.b((tq) tl.j);
		}

		if (var1.b() instanceof alo) {
			this.b.b((tq) tl.l);
		}

		if (var1.b() == amk.P) {
			this.b.b((tq) tl.m);
		}

		if (var1.b() == amk.aZ) {
			this.b.b((tq) tl.n);
		}

		if (var1.b() instanceof amu && ((amu) var1.b()).g() != ami.a) {
			this.b.b((tq) tl.o);
		}

		if (var1.b() instanceof anm) {
			this.b.b((tq) tl.r);
		}

		if (var1.b() == alq.a(aty.bC)) {
			this.b.b((tq) tl.E);
		}

		if (var1.b() == alq.a(aty.X)) {
			this.b.b((tq) tl.G);
		}

		if (var1.b() == amk.ao && var1.i() == 1) {
			this.b.b((tq) tl.M);
		}

	}

	public void a(ahd var1, amj var2) {
		this.c(var2);
		amj[] var3 = aop.a().b(this.a, var1.o);

		for (int var4 = 0; var4 < var3.length; ++var4) {
			amj var5 = this.a.a(var4);
			amj var6 = var3[var4];
			if (var5 != null) {
				this.a.a(var4, 1);
			}

			if (var6 != null) {
				if (this.a.a(var4) == null) {
					this.a.a(var4, var6);
				} else if (!this.b.bg.a(var6)) {
					this.b.a(var6, false);
				}
			}
		}

	}
}
