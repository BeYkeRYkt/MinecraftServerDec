package net.minecraft;

public class acu extends xx {

	private float bm;
	private float bn;
	private boolean bo;
	private boolean bp;
	private float bq;
	private float br;

	public acu(World var1) {
		super(var1);
		this.a(0.6F, 0.8F);
		((aay) this.s()).a(true);
		this.i.a(1, new yy(this));
		this.i.a(2, this.bk);
		this.i.a(3, new zg(this, 0.4F));
		this.i.a(4, new zk(this, 1.0D, true));
		this.i.a(5, new yz(this, 1.0D, 10.0F, 2.0F));
		this.i.a(6, new yt(this, 1.0D));
		this.i.a(7, new zy(this, 1.0D));
		this.i.a(8, new yr(this, 8.0F));
		this.i.a(9, new zh(this, ahd.class, 8.0F));
		this.i.a(9, new zx(this));
		this.bg.a(1, new aau(this));
		this.bg.a(2, new aav(this));
		this.bg.a(3, new aal(this, true, new Class[0]));
		this.bg.a(4, new aat(this, abq.class, false, new acv(this)));
		this.bg.a(5, new aaq(this, afw.class, false));
		this.m(false);
	}

	protected void aW() {
		super.aW();
		this.a(afs.d).a(0.30000001192092896D);
		if (this.cj()) {
			this.a(afs.a).a(20.0D);
		} else {
			this.a(afs.a).a(8.0D);
		}

		this.bx().b(afs.e);
		this.a(afs.e).a(2.0D);
	}

	public void d(EntityLiving var1) {
		super.d(var1);
		if (var1 == null) {
			this.o(false);
		} else if (!this.cj()) {
			this.o(true);
		}

	}

	protected void E() {
		this.ac.b(18, Float.valueOf(this.bm()));
	}

	protected void h() {
		super.h();
		this.ac.a(18, new Float(this.bm()));
		this.ac.a(19, new Byte((byte) 0));
		this.ac.a(20, new Byte((byte) akv.o.a()));
	}

	protected void a(dt var1, atr var2) {
		this.a("mob.wolf.step", 0.15F, 1.0F);
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Angry", this.ct());
		var1.put("CollarColor", (byte) this.cu().b());
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.o(var1.n("Angry"));
		if (var1.b("CollarColor", 99)) {
			this.a(akv.a(var1.d("CollarColor")));
		}

	}

	protected String z() {
		return this.ct() ? "mob.wolf.growl" : (this.V.nextInt(3) == 0 ? (this.cj() && this.ac.d(18) < 10.0F ? "mob.wolf.whine" : "mob.wolf.panting") : "mob.wolf.bark");
	}

	protected String bn() {
		return "mob.wolf.hurt";
	}

	protected String bo() {
		return "mob.wolf.death";
	}

	protected float bA() {
		return 0.4F;
	}

	protected alq A() {
		return alq.b(-1);
	}

	public void m() {
		super.m();
		if (!this.o.D && this.bo && !this.bp && !this.cd() && this.C) {
			this.bp = true;
			this.bq = 0.0F;
			this.br = 0.0F;
			this.o.a((Entity) this, (byte) 8);
		}

		if (!this.o.D && this.u() == null && this.ct()) {
			this.o(false);
		}

	}

	public void s_() {
		super.s_();
		this.bn = this.bm;
		if (this.cv()) {
			this.bm += (1.0F - this.bm) * 0.4F;
		} else {
			this.bm += (0.0F - this.bm) * 0.4F;
		}

		if (this.U()) {
			this.bo = true;
			this.bp = false;
			this.bq = 0.0F;
			this.br = 0.0F;
		} else if ((this.bo || this.bp) && this.bp) {
			if (this.bq == 0.0F) {
				this.a("mob.wolf.shake", this.bA(), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
			}

			this.br = this.bq;
			this.bq += 0.05F;
			if (this.br >= 2.0F) {
				this.bo = false;
				this.bp = false;
				this.br = 0.0F;
				this.bq = 0.0F;
			}

			if (this.bq > 0.4F) {
				float var1 = (float) this.aQ().b;
				int var2 = (int) (NumberConverter.a((this.bq - 0.4F) * 3.1415927F) * 7.0F);

				for (int var3 = 0; var3 < var2; ++var3) {
					float var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J * 0.5F;
					float var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J * 0.5F;
					this.o.a(ew.f, this.s + (double) var4, (double) (var1 + 0.8F), this.u + (double) var5, this.v, this.w, this.x, new int[0]);
				}
			}
		}

	}

	public float aR() {
		return this.K * 0.8F;
	}

	public int bP() {
		return this.cl() ? 20 : super.bP();
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			Entity var3 = var1.j();
			this.bk.a(false);
			if (var3 != null && !(var3 instanceof ahd) && !(var3 instanceof ahj)) {
				var2 = (var2 + 1.0F) / 2.0F;
			}

			return super.a(var1, var2);
		}
	}

	public boolean r(Entity var1) {
		boolean var2 = var1.a(wh.a((EntityLiving) this), (float) ((int) this.a(afs.e).e()));
		if (var2) {
			this.a((EntityLiving) this, var1);
		}

		return var2;
	}

	public void m(boolean var1) {
		super.m(var1);
		if (var1) {
			this.a(afs.a).a(20.0D);
		} else {
			this.a(afs.a).a(8.0D);
		}

		this.a(afs.e).a(4.0D);
	}

	public boolean a(ahd var1) {
		amj var2 = var1.bg.h();
		if (this.cj()) {
			if (var2 != null) {
				if (var2.b() instanceof all) {
					all var3 = (all) var2.b();
					if (var3.g() && this.ac.d(18) < 20.0F) {
						if (!var1.by.instabuild) {
							--var2.b;
						}

						this.g((float) var3.h(var2));
						if (var2.b <= 0) {
							var1.bg.a(var1.bg.c, (amj) null);
						}

						return true;
					}
				} else if (var2.b() == amk.aW) {
					akv var4 = akv.a(var2.i());
					if (var4 != this.cu()) {
						this.a(var4);
						if (!var1.by.instabuild && --var2.b <= 0) {
							var1.bg.a(var1.bg.c, (amj) null);
						}

						return true;
					}
				}
			}

			if (this.e(var1) && !this.o.D && !this.d(var2)) {
				this.bk.a(!this.cl());
				this.aW = false;
				this.h.n();
				this.d((EntityLiving) null);
			}
		} else if (var2 != null && var2.b() == amk.aX && !this.ct()) {
			if (!var1.by.instabuild) {
				--var2.b;
			}

			if (var2.b <= 0) {
				var1.bg.a(var1.bg.c, (amj) null);
			}

			if (!this.o.D) {
				if (this.V.nextInt(3) == 0) {
					this.m(true);
					this.h.n();
					this.d((EntityLiving) null);
					this.bk.a(true);
					this.h(20.0F);
					this.b(var1.aJ().toString());
					this.l(true);
					this.o.a((Entity) this, (byte) 7);
				} else {
					this.l(false);
					this.o.a((Entity) this, (byte) 6);
				}
			}

			return true;
		}

		return super.a(var1);
	}

	public boolean d(amj var1) {
		return var1 == null ? false : (!(var1.b() instanceof all) ? false : ((all) var1.b()).g());
	}

	public int bU() {
		return 8;
	}

	public boolean ct() {
		return (this.ac.a(16) & 2) != 0;
	}

	public void o(boolean var1) {
		byte var2 = this.ac.a(16);
		if (var1) {
			this.ac.b(16, Byte.valueOf((byte) (var2 | 2)));
		} else {
			this.ac.b(16, Byte.valueOf((byte) (var2 & -3)));
		}

	}

	public akv cu() {
		return akv.a(this.ac.a(20) & 15);
	}

	public void a(akv var1) {
		this.ac.b(20, Byte.valueOf((byte) (var1.b() & 15)));
	}

	public acu b(ws var1) {
		acu var2 = new acu(this.o);
		String var3 = this.b();
		if (var3 != null && var3.trim().length() > 0) {
			var2.b(var3);
			var2.m(true);
		}

		return var2;
	}

	public void p(boolean var1) {
		if (var1) {
			this.ac.b(19, Byte.valueOf((byte) 1));
		} else {
			this.ac.b(19, Byte.valueOf((byte) 0));
		}

	}

	public boolean a(abq var1) {
		if (var1 == this) {
			return false;
		} else if (!this.cj()) {
			return false;
		} else if (!(var1 instanceof acu)) {
			return false;
		} else {
			acu var2 = (acu) var1;
			return !var2.cj() ? false : (var2.cl() ? false : this.cp() && var2.cp());
		}
	}

	public boolean cv() {
		return this.ac.a(19) == 1;
	}

	protected boolean C() {
		return !this.cj() && this.W > 2400;
	}

	public boolean a(EntityLiving var1, EntityLiving var2) {
		if (!(var1 instanceof aep) && !(var1 instanceof afa)) {
			if (var1 instanceof acu) {
				acu var3 = (acu) var1;
				if (var3.cj() && var3.cm() == var2) {
					return false;
				}
			}

			return var1 instanceof ahd && var2 instanceof ahd && !((ahd) var2).a((ahd) var1) ? false : !(var1 instanceof abt) || !((abt) var1).cm();
		} else {
			return false;
		}
	}

	public boolean ca() {
		return !this.ct() && super.ca();
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.b(var1);
	}
}
