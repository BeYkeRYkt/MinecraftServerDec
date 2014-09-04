package net.minecraft;

public class acn extends abw implements afr {

	public acn(World var1) {
		super(var1);
		this.a(0.7F, 1.9F);
		((aay) this.s()).a(true);
		this.i.a(1, new zz(this, 1.25D, 20, 10.0F));
		this.i.a(2, new zy(this, 1.0D));
		this.i.a(3, new zh(this, ahd.class, 6.0F));
		this.i.a(4, new zx(this));
		this.bg.a(1, new aaq(this, xn.class, 10, true, false, aex.d));
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(4.0D);
		this.a(afs.d).a(0.20000000298023224D);
	}

	public void m() {
		super.m();
		if (!this.o.D) {
			int var1 = uv.c(this.s);
			int var2 = uv.c(this.t);
			int var3 = uv.c(this.u);
			if (this.U()) {
				this.a(wh.f, 1.0F);
			}

			if (this.o.b(new dt(var1, 0, var3)).a(new dt(var1, var2, var3)) > 1.0F) {
				this.a(wh.c, 1.0F);
			}

			for (int var4 = 0; var4 < 4; ++var4) {
				var1 = uv.c(this.s + (double) ((float) (var4 % 2 * 2 - 1) * 0.25F));
				var2 = uv.c(this.t);
				var3 = uv.c(this.u + (double) ((float) (var4 / 2 % 2 * 2 - 1) * 0.25F));
				if (this.o.p(new dt(var1, var2, var3)).c().r() == bof.a && this.o.b(new dt(var1, 0, var3)).a(new dt(var1, var2, var3)) < 0.8F && aty.aH.c(this.o, new dt(var1, var2, var3))) {
					this.o.a(new dt(var1, var2, var3), aty.aH.P());
				}
			}
		}

	}

	protected alq A() {
		return amk.aD;
	}

	protected void b(boolean var1, int var2) {
		int var3 = this.V.nextInt(16);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.a(amk.aD, 1);
		}

	}

	public void a(EntityLiving var1, float var2) {
		ahq var3 = new ahq(this.o, this);
		double var4 = var1.t + (double) var1.aR() - 1.100000023841858D;
		double var6 = var1.s - this.s;
		double var8 = var4 - var3.t;
		double var10 = var1.u - this.u;
		float var12 = uv.a(var6 * var6 + var10 * var10) * 0.2F;
		var3.c(var6, var8 + (double) var12, var10, 1.6F, 12.0F);
		this.a("random.bow", 1.0F, 1.0F / (this.bb().nextFloat() * 0.4F + 0.8F));
		this.o.d((Entity) var3);
	}

	public float aR() {
		return 1.7F;
	}
}
