package net.minecraft;

import java.util.Calendar;

public class afw extends afm implements afr {

	private zz b = new zz(this, 1.0D, 20, 60, 15.0F);
	private zk c = new zk(this, ahd.class, 1.2D, false);

	public afw(World var1) {
		super(var1);
		this.i.a(1, new yy(this));
		this.i.a(2, new aab(this));
		this.i.a(2, this.a);
		this.i.a(3, new yx(this, 1.0D));
		this.i.a(3, new yp(this, new afx(this), 6.0F, 1.0D, 1.2D));
		this.i.a(4, new zy(this, 1.0D));
		this.i.a(6, new zh(this, ahd.class, 8.0F));
		this.i.a(6, new zx(this));
		this.bg.a(1, new aal(this, false, new Class[0]));
		this.bg.a(2, new aaq(this, ahd.class, true));
		this.bg.a(3, new aaq(this, acq.class, true));
		if (var1 != null && !var1.D) {
			this.n();
		}

	}

	protected void aW() {
		super.aW();
		this.a(afs.d).a(0.25D);
	}

	protected void h() {
		super.h();
		this.ac.a(13, new Byte((byte) 0));
	}

	protected String z() {
		return "mob.skeleton.say";
	}

	protected String bn() {
		return "mob.skeleton.hurt";
	}

	protected String bo() {
		return "mob.skeleton.death";
	}

	protected void a(dt var1, atr var2) {
		this.a("mob.skeleton.step", 0.15F, 1.0F);
	}

	public boolean r(Entity var1) {
		if (super.r(var1)) {
			if (this.ck() == 1 && var1 instanceof EntityLiving) {
				((EntityLiving) var1).c(new wq(wp.v.H, 200));
			}

			return true;
		} else {
			return false;
		}
	}

	public xs by() {
		return xs.b;
	}

	public void m() {
		if (this.o.w() && !this.o.D) {
			float var1 = this.c(1.0F);
			dt var2 = new dt(this.s, (double) Math.round(this.t), this.u);
			if (var1 > 0.5F && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.o.i(var2)) {
				boolean var3 = true;
				amj var4 = this.p(4);
				if (var4 != null) {
					if (var4.e()) {
						var4.b(var4.h() + this.V.nextInt(2));
						if (var4.h() >= var4.j()) {
							this.b(var4);
							this.c(4, (amj) null);
						}
					}

					var3 = false;
				}

				if (var3) {
					this.e(8);
				}
			}
		}

		if (this.o.D && this.ck() == 1) {
			this.a(0.72F, 2.535F);
		}

		super.m();
	}

	public void ak() {
		super.ak();
		if (this.m instanceof EntityCreature) {
			EntityCreature var1 = (EntityCreature) this.m;
			this.aG = var1.aG;
		}

	}

	public void a(wh var1) {
		super.a(var1);
		if (var1.i() instanceof ahj && var1.j() instanceof ahd) {
			ahd var2 = (ahd) var1.j();
			double var3 = var2.s - this.s;
			double var5 = var2.u - this.u;
			if (var3 * var3 + var5 * var5 >= 2500.0D) {
				var2.b((PlayerStatistic) tl.v);
			}
		} else if (var1.j() instanceof aep && ((aep) var1.j()).n() && ((aep) var1.j()).cn()) {
			((aep) var1.j()).co();
			this.a(new amj(amk.bX, 1, this.ck() == 1 ? 1 : 0), 0.0F);
		}

	}

	protected alq A() {
		return amk.g;
	}

	protected void b(boolean var1, int var2) {
		int var3;
		int var4;
		if (this.ck() == 1) {
			var3 = this.V.nextInt(3 + var2) - 1;

			for (var4 = 0; var4 < var3; ++var4) {
				this.a(amk.h, 1);
			}
		} else {
			var3 = this.V.nextInt(3 + var2);

			for (var4 = 0; var4 < var3; ++var4) {
				this.a(amk.g, 1);
			}
		}

		var3 = this.V.nextInt(3 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			this.a(amk.aX, 1);
		}

	}

	protected void bp() {
		if (this.ck() == 1) {
			this.a(new amj(amk.bX, 1, 1), 0.0F);
		}

	}

	protected void a(vu var1) {
		super.a(var1);
		this.c(0, new amj(amk.f));
	}

	public xq a(vu var1, xq var2) {
		var2 = super.a(var1, var2);
		if (this.o.t instanceof bge && this.bb().nextInt(5) > 0) {
			this.i.a(4, this.c);
			this.a(1);
			this.c(0, new amj(amk.q));
			this.a(afs.e).a(4.0D);
		} else {
			this.i.a(4, this.b);
			this.a(var1);
			this.b(var1);
		}

		this.j(this.V.nextFloat() < 0.55F * var1.c());
		if (this.p(4) == null) {
			Calendar var3 = this.o.Y();
			if (var3.get(2) + 1 == 10 && var3.get(5) == 31 && this.V.nextFloat() < 0.25F) {
				this.c(4, new amj(this.V.nextFloat() < 0.1F ? aty.aZ : aty.aU));
				this.bh[4] = 0.0F;
			}
		}

		return var2;
	}

	public void n() {
		this.i.a((zb) this.c);
		this.i.a((zb) this.b);
		amj var1 = this.bz();
		if (var1 != null && var1.b() == amk.f) {
			this.i.a(4, this.b);
		} else {
			this.i.a(4, this.c);
		}

	}

	public void a(EntityLiving var1, float var2) {
		ahj var3 = new ahj(this.o, this, var1, 1.6F, (float) (14 - this.o.aa().getId() * 4));
		int var4 = aph.a(apf.v.B, this.bz());
		int var5 = aph.a(apf.w.B, this.bz());
		var3.b((double) (var2 * 2.0F) + this.V.nextGaussian() * 0.25D + (double) ((float) this.o.aa().getId() * 0.11F));
		if (var4 > 0) {
			var3.b(var3.j() + (double) var4 * 0.5D + 0.5D);
		}

		if (var5 > 0) {
			var3.a(var5);
		}

		if (aph.a(apf.x.B, this.bz()) > 0 || this.ck() == 1) {
			var3.e(100);
		}

		this.a("random.bow", 1.0F, 1.0F / (this.bb().nextFloat() * 0.4F + 0.8F));
		this.o.d((Entity) var3);
	}

	public int ck() {
		return this.ac.a(13);
	}

	public void a(int var1) {
		this.ac.b(13, Byte.valueOf((byte) var1));
		this.ab = var1 == 1;
		if (var1 == 1) {
			this.a(0.72F, 2.535F);
		} else {
			this.a(0.6F, 1.95F);
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.b("SkeletonType", 99)) {
			byte var2 = var1.d("SkeletonType");
			this.a(var2);
		}

		this.n();
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("SkeletonType", (byte) this.ck());
	}

	public void c(int var1, amj var2) {
		super.c(var1, var2);
		if (!this.o.D && var1 == 0) {
			this.n();
		}

	}

	public float aR() {
		return this.ck() == 1 ? super.aR() : 1.74F;
	}

	public double am() {
		return super.am() - 0.5D;
	}
}
