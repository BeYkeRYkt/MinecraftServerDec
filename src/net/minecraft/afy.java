package net.minecraft;

public class afy extends xn implements aex {

	public float a;
	public float b;
	public float c;
	private boolean bi;

	public afy(World var1) {
		super(var1);
		this.f = new agc(this);
		this.i.a(1, new aga(this));
		this.i.a(2, new afz(this));
		this.i.a(3, new agd(this));
		this.i.a(5, new agb(this));
		this.bg.a(1, new aao(this));
		this.bg.a(3, new aam(this, acq.class));
	}

	protected void h() {
		super.h();
		this.ac.a(16, Byte.valueOf((byte) 1));
	}

	protected void a(int var1) {
		this.ac.b(16, Byte.valueOf((byte) var1));
		this.a(0.51000005F * (float) var1, 0.51000005F * (float) var1);
		this.b(this.s, this.t, this.u);
		this.a(afs.a).a((double) (var1 * var1));
		this.a(afs.d).a((double) (0.2F + 0.1F * (float) var1));
		this.h(this.bt());
		this.b_ = var1;
	}

	public int ck() {
		return this.ac.a(16);
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("Size", this.ck() - 1);
		var1.a("wasOnGround", this.bi);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		int var2 = var1.f("Size");
		if (var2 < 0) {
			var2 = 0;
		}

		this.a(var2 + 1);
		this.bi = var1.n("wasOnGround");
	}

	protected ew n() {
		return ew.H;
	}

	protected String ci() {
		return "mob.slime." + (this.ck() > 1 ? "big" : "small");
	}

	public void s_() {
		if (!this.o.D && this.o.aa() == Difficulty.PEACEFUL && this.ck() > 0) {
			this.I = true;
		}

		this.b += (this.a - this.b) * 0.5F;
		this.c = this.b;
		super.s_();
		if (this.C && !this.bi) {
			int var1 = this.ck();

			for (int var2 = 0; var2 < var1 * 8; ++var2) {
				float var3 = this.V.nextFloat() * 3.1415927F * 2.0F;
				float var4 = this.V.nextFloat() * 0.5F + 0.5F;
				float var5 = uv.a(var3) * (float) var1 * 0.5F * var4;
				float var6 = uv.b(var3) * (float) var1 * 0.5F * var4;
				World var10000 = this.o;
				ew var10001 = this.n();
				double var10002 = this.s + (double) var5;
				double var10004 = this.u + (double) var6;
				var10000.a(var10001, var10002, this.aQ().b, var10004, 0.0D, 0.0D, 0.0D, new int[0]);
			}

			if (this.cj()) {
				this.a(this.ci(), this.bA(), ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			}

			this.a = -0.5F;
		} else if (!this.C && this.bi) {
			this.a = 1.0F;
		}

		this.bi = this.C;
		this.cf();
	}

	protected void cf() {
		this.a *= 0.6F;
	}

	protected int ce() {
		return this.V.nextInt(20) + 10;
	}

	protected afy cd() {
		return new afy(this.o);
	}

	public void i(int var1) {
		if (var1 == 16) {
			int var2 = this.ck();
			this.a(0.51000005F * (float) var2, 0.51000005F * (float) var2);
			this.y = this.aI;
			this.aG = this.aI;
			if (this.V() && this.V.nextInt(20) == 0) {
				this.X();
			}
		}

		super.i(var1);
	}

	public void J() {
		int var1 = this.ck();
		if (!this.o.D && var1 > 1 && this.bm() <= 0.0F) {
			int var2 = 2 + this.V.nextInt(3);

			for (int var3 = 0; var3 < var2; ++var3) {
				float var4 = ((float) (var3 % 2) - 0.5F) * (float) var1 / 4.0F;
				float var5 = ((float) (var3 / 2) - 0.5F) * (float) var1 / 4.0F;
				afy var6 = this.cd();
				if (this.k_()) {
					var6.a(this.aL());
				}

				if (this.bY()) {
					var6.bW();
				}

				var6.a(var1 / 2);
				var6.b(this.s + (double) var4, this.t + 0.5D, this.u + (double) var5, this.V.nextFloat() * 360.0F, 0.0F);
				this.o.d((Entity) var6);
			}
		}

		super.J();
	}

	public void i(Entity var1) {
		super.i(var1);
		if (var1 instanceof acq && this.cg()) {
			this.e((EntityLiving) var1);
		}

	}

	public void d(ahd var1) {
		if (this.cg()) {
			this.e(var1);
		}

	}

	protected void e(EntityLiving var1) {
		int var2 = this.ck();
		if (this.t(var1) && this.h(var1) < 0.6D * (double) var2 * 0.6D * (double) var2 && var1.a(wh.a((EntityLiving) this), (float) this.ch())) {
			this.a("mob.attack", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
			this.a(this, var1);
		}

	}

	public float aR() {
		return 0.625F * this.K;
	}

	protected boolean cg() {
		return this.ck() > 1;
	}

	protected int ch() {
		return this.ck();
	}

	protected String bn() {
		return "mob.slime." + (this.ck() > 1 ? "big" : "small");
	}

	protected String bo() {
		return "mob.slime." + (this.ck() > 1 ? "big" : "small");
	}

	protected alq A() {
		return this.ck() == 1 ? amk.aM : null;
	}

	public boolean bQ() {
		bfh var1 = this.o.f(new dt(uv.c(this.s), 0, uv.c(this.u)));
		if (this.o.P().u() == are.c && this.V.nextInt(4) != 1) {
			return false;
		} else {
			if (this.o.aa() != Difficulty.PEACEFUL) {
				arm var2 = this.o.b(new dt(uv.c(this.s), 0, uv.c(this.u)));
				if (var2 == arm.v && this.t > 50.0D && this.t < 70.0D && this.V.nextFloat() < 0.5F && this.V.nextFloat() < this.o.y() && this.o.l(new dt(this)) <= this.V.nextInt(8)) {
					return super.bQ();
				}

				if (this.V.nextInt(10) == 0 && var1.a(987234911L).nextInt(10) == 0 && this.t < 40.0D) {
					return super.bQ();
				}
			}

			return false;
		}
	}

	protected float bA() {
		return 0.4F * (float) this.ck();
	}

	public int bP() {
		return 0;
	}

	protected boolean cl() {
		return this.ck() > 0;
	}

	protected boolean cj() {
		return this.ck() > 2;
	}

	protected void bE() {
		this.w = 0.41999998688697815D;
		this.ai = true;
	}

	public xq a(vu var1, xq var2) {
		int var3 = this.V.nextInt(3);
		if (var3 < 2 && this.V.nextFloat() < 0.5F * var1.c()) {
			++var3;
		}

		int var4 = 1 << var3;
		this.a(var4);
		return super.a(var1, var2);
	}
}
