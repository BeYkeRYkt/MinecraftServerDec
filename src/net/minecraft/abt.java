package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class abt extends abq implements vr {

	private static final Predicate bq = new abu();
	private static final xy br = (new yg((xy) null, "horse.jumpStrength", 0.7D, 0.0D, 2.0D)).a("Jump Strength").a(true);
	private static final String[] bs = new String[] { null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png" };
	private static final String[] bt = new String[] { "", "meo", "goo", "dio" };
	private static final int[] bu = new int[] { 0, 5, 7, 11 };
	private static final String[] bv = new String[] { "textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png" };
	private static final String[] bw = new String[] { "hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb" };
	private static final String[] bx = new String[] { null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png" };
	private static final String[] by = new String[] { "", "wo_", "wmo", "wdo", "bdo" };
	private int bz;
	private int bA;
	private int bB;
	public int bk;
	public int bm;
	protected boolean bn;
	private aic bC;
	private boolean bD;
	protected int bo;
	protected float bp;
	private boolean bE;
	private float bF;
	private float bG;
	private float bH;
	private float bI;
	private float bJ;
	private float bK;
	private int bL;
	private String bM;
	private String[] bN = new String[3];
	private boolean bO = false;

	public abt(World var1) {
		super(var1);
		this.a(1.4F, 1.6F);
		this.ab = false;
		this.o(false);
		((aay) this.s()).a(true);
		this.i.a(0, new yy(this));
		this.i.a(1, new zu(this, 1.2D));
		this.i.a(1, new aac(this, 1.2D));
		this.i.a(2, new yt(this, 1.0D));
		this.i.a(4, new za(this, 1.0D));
		this.i.a(6, new zy(this, 0.7D));
		this.i.a(7, new zh(this, ahd.class, 6.0F));
		this.i.a(8, new zx(this));
		this.cY();
	}

	protected void h() {
		super.h();
		this.ac.a(16, Integer.valueOf(0));
		this.ac.a(19, Byte.valueOf((byte) 0));
		this.ac.a(20, Integer.valueOf(0));
		this.ac.a(21, String.valueOf(""));
		this.ac.a(22, Integer.valueOf(0));
	}

	public void r(int var1) {
		this.ac.b(19, Byte.valueOf((byte) var1));
		this.da();
	}

	public int cj() {
		return this.ac.a(19);
	}

	public void s(int var1) {
		this.ac.b(20, Integer.valueOf(var1));
		this.da();
	}

	public int ck() {
		return this.ac.c(20);
	}

	public String d_() {
		if (this.k_()) {
			return this.aL();
		} else {
			int var1 = this.cj();
			switch (var1) {
				case 0:
				default:
					return fi.a("entity.horse.name");
				case 1:
					return fi.a("entity.donkey.name");
				case 2:
					return fi.a("entity.mule.name");
				case 3:
					return fi.a("entity.zombiehorse.name");
				case 4:
					return fi.a("entity.skeletonhorse.name");
			}
		}
	}

	private boolean w(int var1) {
		return (this.ac.c(16) & var1) != 0;
	}

	private void c(int var1, boolean var2) {
		int var3 = this.ac.c(16);
		if (var2) {
			this.ac.b(16, Integer.valueOf(var3 | var1));
		} else {
			this.ac.b(16, Integer.valueOf(var3 & ~var1));
		}

	}

	public boolean cl() {
		return !this.i_();
	}

	public boolean cm() {
		return this.w(2);
	}

	public boolean cn() {
		return this.cl();
	}

	public String cr() {
		return this.ac.e(21);
	}

	public void b(String var1) {
		this.ac.b(21, var1);
	}

	public float cs() {
		int var1 = this.l();
		return var1 >= 0 ? 1.0F : 0.5F + (float) (-24000 - var1) / -24000.0F * 0.5F;
	}

	public void a(boolean var1) {
		if (var1) {
			this.a(this.cs());
		} else {
			this.a(1.0F);
		}

	}

	public boolean ct() {
		return this.bn;
	}

	public void l(boolean var1) {
		this.c(2, var1);
	}

	public void m(boolean var1) {
		this.bn = var1;
	}

	public boolean ca() {
		return !this.cP() && super.ca();
	}

	protected void n(float var1) {
		if (var1 > 6.0F && this.cw()) {
			this.r(false);
		}

	}

	public boolean cu() {
		return this.w(8);
	}

	public int cv() {
		return this.ac.c(22);
	}

	private int f(amj var1) {
		if (var1 == null) {
			return 0;
		} else {
			alq var2 = var1.b();
			return var2 == amk.ck ? 1 : (var2 == amk.cl ? 2 : (var2 == amk.cm ? 3 : 0));
		}
	}

	public boolean cw() {
		return this.w(32);
	}

	public boolean cx() {
		return this.w(64);
	}

	public boolean cy() {
		return this.w(16);
	}

	public boolean cz() {
		return this.bD;
	}

	public void e(amj var1) {
		this.ac.b(22, Integer.valueOf(this.f(var1)));
		this.da();
	}

	public void n(boolean var1) {
		this.c(16, var1);
	}

	public void o(boolean var1) {
		this.c(8, var1);
	}

	public void p(boolean var1) {
		this.bD = var1;
	}

	public void q(boolean var1) {
		this.c(4, var1);
	}

	public int cA() {
		return this.bo;
	}

	public void t(int var1) {
		this.bo = var1;
	}

	public int u(int var1) {
		int var2 = NumberConverter.a(this.cA() + var1, 0, this.cG());
		this.t(var2);
		return var2;
	}

	public boolean a(wh var1, float var2) {
		Entity var3 = var1.j();
		return this.l != null && this.l.equals(var3) ? false : super.a(var1, var2);
	}

	public int bq() {
		return bu[this.cv()];
	}

	public boolean ae() {
		return this.l == null;
	}

	public boolean cB() {
		int var1 = NumberConverter.c(this.s);
		int var2 = NumberConverter.c(this.u);
		this.o.b(new dt(var1, 0, var2));
		return true;
	}

	public void cC() {
		if (!this.o.D && this.cu()) {
			this.a(alq.a((atr) aty.ae), 1);
			this.o(false);
		}
	}

	private void cW() {
		this.dd();
		if (!this.R()) {
			this.o.a((Entity) this, "eating", 1.0F, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
		}

	}

	public void e(float var1, float var2) {
		if (var1 > 1.0F) {
			this.a("mob.horse.land", 0.4F, 1.0F);
		}

		int var3 = NumberConverter.f((var1 * 0.5F - 3.0F) * var2);
		if (var3 > 0) {
			this.a(wh.i, (float) var3);
			if (this.l != null) {
				this.l.a(wh.i, (float) var3);
			}

			atr var4 = this.o.p(new dt(this.s, this.t - 0.2D - (double) this.A, this.u)).c();
			if (var4.r() != bof.a && !this.R()) {
				atx var5 = var4.H;
				this.o.a((Entity) this, var5.c(), var5.d() * 0.5F, var5.e() * 0.75F);
			}

		}
	}

	private int cX() {
		int var1 = this.cj();
		return this.cu() && (var1 == 1 || var1 == 2) ? 17 : 2;
	}

	private void cY() {
		aic var1 = this.bC;
		this.bC = new aic("HorseChest", this.cX());
		this.bC.a(this.d_());
		if (var1 != null) {
			var1.b(this);
			int var2 = Math.min(var1.n_(), this.bC.n_());

			for (int var3 = 0; var3 < var2; ++var3) {
				amj var4 = var1.a(var3);
				if (var4 != null) {
					this.bC.a(var3, var4.k());
				}
			}
		}

		this.bC.a(this);
		this.cZ();
	}

	private void cZ() {
		if (!this.o.D) {
			this.q(this.bC.a(0) != null);
			if (this.cM()) {
				this.e(this.bC.a(1));
			}
		}

	}

	public void a(wa var1) {
		int var2 = this.cv();
		boolean var3 = this.cE();
		this.cZ();
		if (this.W > 20) {
			if (var2 == 0 && var2 != this.cv()) {
				this.a("mob.horse.armor", 0.5F, 1.0F);
			} else if (var2 != this.cv()) {
				this.a("mob.horse.armor", 0.5F, 1.0F);
			}

			if (!var3 && this.cE()) {
				this.a("mob.horse.leather", 0.5F, 1.0F);
			}
		}

	}

	public boolean bQ() {
		this.cB();
		return super.bQ();
	}

	protected abt a(Entity var1, double var2) {
		double var4 = Double.MAX_VALUE;
		Entity var6 = null;
		List var7 = this.o.a(var1, var1.aQ().a(var2, var2, var2), bq);
		Iterator var8 = var7.iterator();

		while (var8.hasNext()) {
			Entity var9 = (Entity) var8.next();
			double var10 = var9.e(var1.s, var1.t, var1.u);
			if (var10 < var4) {
				var6 = var9;
				var4 = var10;
			}
		}

		return (abt) var6;
	}

	public double cD() {
		return this.a(br).e();
	}

	protected String bo() {
		this.dd();
		int var1 = this.cj();
		return var1 == 3 ? "mob.horse.zombie.death" : (var1 == 4 ? "mob.horse.skeleton.death" : (var1 != 1 && var1 != 2 ? "mob.horse.death" : "mob.horse.donkey.death"));
	}

	protected alq A() {
		boolean var1 = this.V.nextInt(4) == 0;
		int var2 = this.cj();
		return var2 == 4 ? amk.aX : (var2 == 3 ? (var1 ? null : amk.bt) : amk.aF);
	}

	protected String bn() {
		this.dd();
		if (this.V.nextInt(3) == 0) {
			this.df();
		}

		int var1 = this.cj();
		return var1 == 3 ? "mob.horse.zombie.hit" : (var1 == 4 ? "mob.horse.skeleton.hit" : (var1 != 1 && var1 != 2 ? "mob.horse.hit" : "mob.horse.donkey.hit"));
	}

	public boolean cE() {
		return this.w(4);
	}

	protected String z() {
		this.dd();
		if (this.V.nextInt(10) == 0 && !this.bC()) {
			this.df();
		}

		int var1 = this.cj();
		return var1 == 3 ? "mob.horse.zombie.idle" : (var1 == 4 ? "mob.horse.skeleton.idle" : (var1 != 1 && var1 != 2 ? "mob.horse.idle" : "mob.horse.donkey.idle"));
	}

	protected String cF() {
		this.dd();
		this.df();
		int var1 = this.cj();
		return var1 != 3 && var1 != 4 ? (var1 != 1 && var1 != 2 ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
	}

	protected void a(dt var1, atr var2) {
		atx var3 = var2.H;
		if (this.o.p(var1.a()).c() == aty.aH) {
			var3 = aty.aH.H;
		}

		if (!var2.r().d()) {
			int var4 = this.cj();
			if (this.l != null && var4 != 1 && var4 != 2) {
				++this.bL;
				if (this.bL > 5 && this.bL % 3 == 0) {
					this.a("mob.horse.gallop", var3.d() * 0.15F, var3.e());
					if (var4 == 0 && this.V.nextInt(10) == 0) {
						this.a("mob.horse.breathe", var3.d() * 0.6F, var3.e());
					}
				} else if (this.bL <= 5) {
					this.a("mob.horse.wood", var3.d() * 0.15F, var3.e());
				}
			} else if (var3 == atr.f) {
				this.a("mob.horse.wood", var3.d() * 0.15F, var3.e());
			} else {
				this.a("mob.horse.soft", var3.d() * 0.15F, var3.e());
			}
		}

	}

	protected void aW() {
		super.aW();
		this.bx().b(br);
		this.a(afs.a).a(53.0D);
		this.a(afs.d).a(0.22499999403953552D);
	}

	public int bU() {
		return 6;
	}

	public int cG() {
		return 100;
	}

	protected float bA() {
		return 0.8F;
	}

	public int w() {
		return 400;
	}

	private void da() {
		this.bM = null;
	}

	public void g(ahd var1) {
		if (!this.o.D && (this.l == null || this.l == var1) && this.cm()) {
			this.bC.a(this.d_());
			var1.a(this, this.bC);
		}

	}

	public boolean a(ahd var1) {
		amj var2 = var1.bg.h();
		if (var2 != null && var2.b() == amk.bJ) {
			return super.a(var1);
		} else if (!this.cm() && this.cP()) {
			return false;
		} else if (this.cm() && this.cl() && var1.aw()) {
			this.g(var1);
			return true;
		} else if (this.cn() && this.l != null) {
			return super.a(var1);
		} else {
			if (var2 != null) {
				boolean var3 = false;
				if (this.cM()) {
					byte var4 = -1;
					if (var2.b() == amk.ck) {
						var4 = 1;
					} else if (var2.b() == amk.cl) {
						var4 = 2;
					} else if (var2.b() == amk.cm) {
						var4 = 3;
					}

					if (var4 >= 0) {
						if (!this.cm()) {
							this.cU();
							return true;
						}

						this.g(var1);
						return true;
					}
				}

				if (!var3 && !this.cP()) {
					float var7 = 0.0F;
					short var5 = 0;
					byte var6 = 0;
					if (var2.b() == amk.O) {
						var7 = 2.0F;
						var5 = 20;
						var6 = 3;
					} else if (var2.b() == amk.aY) {
						var7 = 1.0F;
						var5 = 30;
						var6 = 3;
					} else if (atr.a(var2.b()) == aty.cx) {
						var7 = 20.0F;
						var5 = 180;
					} else if (var2.b() == amk.e) {
						var7 = 3.0F;
						var5 = 60;
						var6 = 3;
					} else if (var2.b() == amk.bW) {
						var7 = 4.0F;
						var5 = 60;
						var6 = 5;
						if (this.cm() && this.l() == 0) {
							var3 = true;
							this.c(var1);
						}
					} else if (var2.b() == amk.ao) {
						var7 = 10.0F;
						var5 = 240;
						var6 = 10;
						if (this.cm() && this.l() == 0) {
							var3 = true;
							this.c(var1);
						}
					}

					if (this.bm() < this.bt() && var7 > 0.0F) {
						this.g(var7);
						var3 = true;
					}

					if (!this.cl() && var5 > 0) {
						this.a(var5);
						var3 = true;
					}

					if (var6 > 0 && (var3 || !this.cm()) && var6 < this.cG()) {
						var3 = true;
						this.u(var6);
					}

					if (var3) {
						this.cW();
					}
				}

				if (!this.cm() && !var3) {
					if (var2 != null && var2.a(var1, (EntityLiving) this)) {
						return true;
					}

					this.cU();
					return true;
				}

				if (!var3 && this.cN() && !this.cu() && var2.b() == alq.a((atr) aty.ae)) {
					this.o(true);
					this.a("mob.chickenplop", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
					var3 = true;
					this.cY();
				}

				if (!var3 && this.cn() && !this.cE() && var2.b() == amk.aA) {
					this.g(var1);
					return true;
				}

				if (var3) {
					if (!var1.by.instabuild && --var2.b == 0) {
						var1.bg.a(var1.bg.c, (amj) null);
					}

					return true;
				}
			}

			if (this.cn() && this.l == null) {
				if (var2 != null && var2.a(var1, (EntityLiving) this)) {
					return true;
				} else {
					this.i(var1);
					return true;
				}
			} else {
				return super.a(var1);
			}
		}
	}

	private void i(ahd var1) {
		var1.y = this.y;
		var1.z = this.z;
		this.r(false);
		this.s(false);
		if (!this.o.D) {
			var1.a((Entity) this);
		}

	}

	public boolean cM() {
		return this.cj() == 0;
	}

	public boolean cN() {
		int var1 = this.cj();
		return var1 == 2 || var1 == 1;
	}

	protected boolean bC() {
		return this.l != null && this.cE() ? true : this.cw() || this.cx();
	}

	public boolean cP() {
		int var1 = this.cj();
		return var1 == 3 || var1 == 4;
	}

	public boolean cQ() {
		return this.cP() || this.cj() == 2;
	}

	public boolean d(amj var1) {
		return false;
	}

	private void dc() {
		this.bk = 1;
	}

	public void a(wh var1) {
		super.a(var1);
		if (!this.o.D) {
			this.cV();
		}

	}

	public void m() {
		if (this.V.nextInt(200) == 0) {
			this.dc();
		}

		super.m();
		if (!this.o.D) {
			if (this.V.nextInt(900) == 0 && this.av == 0) {
				this.g(1.0F);
			}

			if (!this.cw() && this.l == null && this.V.nextInt(300) == 0 && this.o.p(new dt(NumberConverter.c(this.s), NumberConverter.c(this.t) - 1, NumberConverter.c(this.u))).c() == aty.c) {
				this.r(true);
			}

			if (this.cw() && ++this.bz > 50) {
				this.bz = 0;
				this.r(false);
			}

			if (this.cy() && !this.cl() && !this.cw()) {
				abt var1 = this.a(this, 16.0D);
				if (var1 != null && this.h(var1) > 4.0D) {
					this.h.a((Entity) var1);
				}
			}
		}

	}

	public void s_() {
		super.s_();
		if (this.o.D && this.ac.a()) {
			this.ac.e();
			this.da();
		}

		if (this.bA > 0 && ++this.bA > 30) {
			this.bA = 0;
			this.c(128, false);
		}

		if (!this.o.D && this.bB > 0 && ++this.bB > 20) {
			this.bB = 0;
			this.s(false);
		}

		if (this.bk > 0 && ++this.bk > 8) {
			this.bk = 0;
		}

		if (this.bm > 0) {
			++this.bm;
			if (this.bm > 300) {
				this.bm = 0;
			}
		}

		this.bG = this.bF;
		if (this.cw()) {
			this.bF += (1.0F - this.bF) * 0.4F + 0.05F;
			if (this.bF > 1.0F) {
				this.bF = 1.0F;
			}
		} else {
			this.bF += (0.0F - this.bF) * 0.4F - 0.05F;
			if (this.bF < 0.0F) {
				this.bF = 0.0F;
			}
		}

		this.bI = this.bH;
		if (this.cx()) {
			this.bG = this.bF = 0.0F;
			this.bH += (1.0F - this.bH) * 0.4F + 0.05F;
			if (this.bH > 1.0F) {
				this.bH = 1.0F;
			}
		} else {
			this.bE = false;
			this.bH += (0.8F * this.bH * this.bH * this.bH - this.bH) * 0.6F - 0.05F;
			if (this.bH < 0.0F) {
				this.bH = 0.0F;
			}
		}

		this.bK = this.bJ;
		if (this.w(128)) {
			this.bJ += (1.0F - this.bJ) * 0.7F + 0.05F;
			if (this.bJ > 1.0F) {
				this.bJ = 1.0F;
			}
		} else {
			this.bJ += (0.0F - this.bJ) * 0.7F - 0.05F;
			if (this.bJ < 0.0F) {
				this.bJ = 0.0F;
			}
		}

	}

	private void dd() {
		if (!this.o.D) {
			this.bA = 1;
			this.c(128, true);
		}

	}

	private boolean de() {
		return this.l == null && this.m == null && this.cm() && this.cl() && !this.cQ() && this.bm() >= this.bt() && this.cp();
	}

	public void f(boolean var1) {
		this.c(32, var1);
	}

	public void r(boolean var1) {
		this.f(var1);
	}

	public void s(boolean var1) {
		if (var1) {
			this.r(false);
		}

		this.c(64, var1);
	}

	private void df() {
		if (!this.o.D) {
			this.bB = 1;
			this.s(true);
		}

	}

	public void cU() {
		this.df();
		String var1 = this.cF();
		if (var1 != null) {
			this.a(var1, this.bA(), this.bB());
		}

	}

	public void cV() {
		this.a((Entity) this, this.bC);
		this.cC();
	}

	private void a(Entity var1, aic var2) {
		if (var2 != null && !this.o.D) {
			for (int var3 = 0; var3 < var2.n_(); ++var3) {
				amj var4 = var2.a(var3);
				if (var4 != null) {
					this.a(var4, 0.0F);
				}
			}

		}
	}

	public boolean h(ahd var1) {
		this.b(var1.aJ().toString());
		this.l(true);
		return true;
	}

	public void g(float var1, float var2) {
		if (this.l != null && this.l instanceof EntityLiving && this.cE()) {
			this.A = this.y = this.l.y;
			this.z = this.l.z * 0.5F;
			this.b(this.y, this.z);
			this.aI = this.aG = this.y;
			var1 = ((EntityLiving) this.l).aX * 0.5F;
			var2 = ((EntityLiving) this.l).aY;
			if (var2 <= 0.0F) {
				var2 *= 0.25F;
				this.bL = 0;
			}

			if (this.C && this.bp == 0.0F && this.cx() && !this.bE) {
				var1 = 0.0F;
				var2 = 0.0F;
			}

			if (this.bp > 0.0F && !this.ct() && this.C) {
				this.w = this.cD() * (double) this.bp;
				if (this.a(wp.j)) {
					this.w += (double) ((float) (this.b(wp.j).c() + 1) * 0.1F);
				}

				this.m(true);
				this.ai = true;
				if (var2 > 0.0F) {
					float var3 = NumberConverter.a(this.y * 3.1415927F / 180.0F);
					float var4 = NumberConverter.b(this.y * 3.1415927F / 180.0F);
					this.v += (double) (-0.4F * var3 * this.bp);
					this.x += (double) (0.4F * var4 * this.bp);
					this.a("mob.horse.jump", 0.4F, 1.0F);
				}

				this.bp = 0.0F;
			}

			this.S = 1.0F;
			this.aK = this.bH() * 0.1F;
			if (!this.o.D) {
				this.j((float) this.a(afs.d).e());
				super.g(var1, var2);
			}

			if (this.C) {
				this.bp = 0.0F;
				this.m(false);
			}

			this.ay = this.az;
			double var8 = this.s - this.p;
			double var5 = this.u - this.r;
			float var7 = NumberConverter.a(var8 * var8 + var5 * var5) * 4.0F;
			if (var7 > 1.0F) {
				var7 = 1.0F;
			}

			this.az += (var7 - this.az) * 0.4F;
			this.aA += this.az;
		} else {
			this.S = 0.5F;
			this.aK = 0.02F;
			super.g(var1, var2);
		}
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("EatingHaystack", this.cw());
		var1.a("ChestedHorse", this.cu());
		var1.a("HasReproduced", this.cz());
		var1.a("Bred", this.cy());
		var1.a("Type", this.cj());
		var1.a("Variant", this.ck());
		var1.a("Temper", this.cA());
		var1.a("Tame", this.cm());
		var1.a("OwnerUUID", this.cr());
		if (this.cu()) {
			NBTListTag var2 = new NBTListTag();

			for (int var3 = 2; var3 < this.bC.n_(); ++var3) {
				amj var4 = this.bC.a(var3);
				if (var4 != null) {
					NBTCompoundTag var5 = new NBTCompoundTag();
					var5.a("Slot", (byte) var3);
					var4.b(var5);
					var2.addTag((NBTTag) var5);
				}
			}

			var1.a("Items", (NBTTag) var2);
		}

		if (this.bC.a(1) != null) {
			var1.a("ArmorItem", (NBTTag) this.bC.a(1).b(new NBTCompoundTag()));
		}

		if (this.bC.a(0) != null) {
			var1.a("SaddleItem", (NBTTag) this.bC.a(0).b(new NBTCompoundTag()));
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.r(var1.n("EatingHaystack"));
		this.n(var1.n("Bred"));
		this.o(var1.n("ChestedHorse"));
		this.p(var1.n("HasReproduced"));
		this.r(var1.f("Type"));
		this.s(var1.f("Variant"));
		this.t(var1.f("Temper"));
		this.l(var1.n("Tame"));
		String var2 = "";
		if (var1.b("OwnerUUID", 8)) {
			var2 = var1.j("OwnerUUID");
		} else {
			String var3 = var1.j("Owner");
			var2 = sf.a(var3);
		}

		if (var2.length() > 0) {
			this.b(var2);
		}

		xz var8 = this.bx().a("Speed");
		if (var8 != null) {
			this.a(afs.d).a(var8.b() * 0.25D);
		}

		if (this.cu()) {
			NBTListTag var4 = var1.c("Items", 10);
			this.cY();

			for (int var5 = 0; var5 < var4.getSize(); ++var5) {
				NBTCompoundTag var6 = var4.getCompound(var5);
				int var7 = var6.d("Slot") & 255;
				if (var7 >= 2 && var7 < this.bC.n_()) {
					this.bC.a(var7, amj.a(var6));
				}
			}
		}

		amj var9;
		if (var1.b("ArmorItem", 10)) {
			var9 = amj.a(var1.m("ArmorItem"));
			if (var9 != null && a(var9.b())) {
				this.bC.a(1, var9);
			}
		}

		if (var1.b("SaddleItem", 10)) {
			var9 = amj.a(var1.m("SaddleItem"));
			if (var9 != null && var9.b() == amk.aA) {
				this.bC.a(0, var9);
			}
		} else if (var1.n("Saddle")) {
			this.bC.a(0, new amj(amk.aA));
		}

		this.cZ();
	}

	public boolean a(abq var1) {
		if (var1 == this) {
			return false;
		} else if (var1.getClass() != this.getClass()) {
			return false;
		} else {
			abt var2 = (abt) var1;
			if (this.de() && var2.de()) {
				int var3 = this.cj();
				int var4 = var2.cj();
				return var3 == var4 || var3 == 0 && var4 == 1 || var3 == 1 && var4 == 0;
			} else {
				return false;
			}
		}
	}

	public ws a(ws var1) {
		abt var2 = (abt) var1;
		abt var3 = new abt(this.o);
		int var4 = this.cj();
		int var5 = var2.cj();
		int var6 = 0;
		if (var4 == var5) {
			var6 = var4;
		} else if (var4 == 0 && var5 == 1 || var4 == 1 && var5 == 0) {
			var6 = 2;
		}

		if (var6 == 0) {
			int var8 = this.V.nextInt(9);
			int var7;
			if (var8 < 4) {
				var7 = this.ck() & 255;
			} else if (var8 < 8) {
				var7 = var2.ck() & 255;
			} else {
				var7 = this.V.nextInt(7);
			}

			int var9 = this.V.nextInt(5);
			if (var9 < 2) {
				var7 |= this.ck() & '\uff00';
			} else if (var9 < 4) {
				var7 |= var2.ck() & '\uff00';
			} else {
				var7 |= this.V.nextInt(5) << 8 & '\uff00';
			}

			var3.s(var7);
		}

		var3.r(var6);
		double var13 = this.a(afs.a).b() + var1.a(afs.a).b() + (double) this.dg();
		var3.a(afs.a).a(var13 / 3.0D);
		double var14 = this.a(br).b() + var1.a(br).b() + this.dh();
		var3.a(br).a(var14 / 3.0D);
		double var11 = this.a(afs.d).b() + var1.a(afs.d).b() + this.di();
		var3.a(afs.d).a(var11 / 3.0D);
		return var3;
	}

	public xq a(vu var1, xq var2) {
		Object var7 = super.a(var1, var2);
		boolean var3 = false;
		int var4 = 0;
		int var8;
		if (var7 instanceof abv) {
			var8 = ((abv) var7).a;
			var4 = ((abv) var7).b & 255 | this.V.nextInt(5) << 8;
		} else {
			if (this.V.nextInt(10) == 0) {
				var8 = 1;
			} else {
				int var5 = this.V.nextInt(7);
				int var6 = this.V.nextInt(5);
				var8 = 0;
				var4 = var5 | var6 << 8;
			}

			var7 = new abv(var8, var4);
		}

		this.r(var8);
		this.s(var4);
		if (this.V.nextInt(5) == 0) {
			this.b(-24000);
		}

		if (var8 != 4 && var8 != 3) {
			this.a(afs.a).a((double) this.dg());
			if (var8 == 0) {
				this.a(afs.d).a(this.di());
			} else {
				this.a(afs.d).a(0.17499999701976776D);
			}
		} else {
			this.a(afs.a).a(15.0D);
			this.a(afs.d).a(0.20000000298023224D);
		}

		if (var8 != 2 && var8 != 1) {
			this.a(br).a(this.dh());
		} else {
			this.a(br).a(0.5D);
		}

		this.h(this.bt());
		return (xq) var7;
	}

	public void v(int var1) {
		if (this.cE()) {
			if (var1 < 0) {
				var1 = 0;
			} else {
				this.bE = true;
				this.df();
			}

			if (var1 >= 90) {
				this.bp = 1.0F;
			} else {
				this.bp = 0.4F + 0.4F * (float) var1 / 90.0F;
			}
		}

	}

	public void al() {
		super.al();
		if (this.bI > 0.0F) {
			float var1 = NumberConverter.a(this.aG * 3.1415927F / 180.0F);
			float var2 = NumberConverter.b(this.aG * 3.1415927F / 180.0F);
			float var3 = 0.7F * this.bI;
			float var4 = 0.15F * this.bI;
			this.l.b(this.s + (double) (var3 * var1), this.t + this.an() + this.l.am() + (double) var4, this.u - (double) (var3 * var2));
			if (this.l instanceof EntityLiving) {
				((EntityLiving) this.l).aG = this.aG;
			}
		}

	}

	private float dg() {
		return 15.0F + (float) this.V.nextInt(8) + (float) this.V.nextInt(9);
	}

	private double dh() {
		return 0.4000000059604645D + this.V.nextDouble() * 0.2D + this.V.nextDouble() * 0.2D + this.V.nextDouble() * 0.2D;
	}

	private double di() {
		return (0.44999998807907104D + this.V.nextDouble() * 0.3D + this.V.nextDouble() * 0.3D + this.V.nextDouble() * 0.3D) * 0.25D;
	}

	public static boolean a(alq var0) {
		return var0 == amk.ck || var0 == amk.cl || var0 == amk.cm;
	}

	public boolean j_() {
		return false;
	}

	public float aR() {
		return this.K;
	}

	public boolean d(int var1, amj var2) {
		if (var1 == 499 && this.cN()) {
			if (var2 == null && this.cu()) {
				this.o(false);
				this.cY();
				return true;
			}

			if (var2 != null && var2.b() == alq.a((atr) aty.ae) && !this.cu()) {
				this.o(true);
				this.cY();
				return true;
			}
		}

		int var3 = var1 - 400;
		if (var3 >= 0 && var3 < 2 && var3 < this.bC.n_()) {
			if (var3 == 0 && var2 != null && var2.b() != amk.aA) {
				return false;
			} else if (var3 == 1 && (var2 != null && !a(var2.b()) || !this.cM())) {
				return false;
			} else {
				this.bC.a(var3, var2);
				this.cZ();
				return true;
			}
		} else {
			int var4 = var1 - 500 + 2;
			if (var4 >= 2 && var4 < this.bC.n_()) {
				this.bC.a(var4, var2);
				return true;
			} else {
				return false;
			}
		}
	}

}
