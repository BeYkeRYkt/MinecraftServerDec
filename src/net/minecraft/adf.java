package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.List;

public class adf extends afm implements afr {

	private float[] b = new float[2];
	private float[] c = new float[2];
	private float[] bk = new float[2];
	private float[] bl = new float[2];
	private int[] bm = new int[2];
	private int[] bn = new int[2];
	private int bo;
	private static final Predicate bp = new adg();

	public adf(World var1) {
		super(var1);
		this.h(this.bt());
		this.a(0.9F, 3.5F);
		this.ab = true;
		((aay) this.s()).d(true);
		this.i.a(0, new yy(this));
		this.i.a(2, new zz(this, 1.0D, 40, 20.0F));
		this.i.a(5, new zy(this, 1.0D));
		this.i.a(6, new zh(this, ahd.class, 8.0F));
		this.i.a(7, new zx(this));
		this.bg.a(1, new aal(this, false, new Class[0]));
		this.bg.a(2, new aaq(this, xn.class, 0, false, false, bp));
		this.b_ = 50;
	}

	protected void h() {
		super.h();
		this.ac.a(17, new Integer(0));
		this.ac.a(18, new Integer(0));
		this.ac.a(19, new Integer(0));
		this.ac.a(20, new Integer(0));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("Invul", this.cj());
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.r(var1.f("Invul"));
	}

	protected String z() {
		return "mob.wither.idle";
	}

	protected String bn() {
		return "mob.wither.hurt";
	}

	protected String bo() {
		return "mob.wither.death";
	}

	public void m() {
		this.w *= 0.6000000238418579D;
		double var4;
		double var6;
		double var8;
		if (!this.o.D && this.s(0) > 0) {
			Entity var1 = this.o.a(this.s(0));
			if (var1 != null) {
				if (this.t < var1.t || !this.ck() && this.t < var1.t + 5.0D) {
					if (this.w < 0.0D) {
						this.w = 0.0D;
					}

					this.w += (0.5D - this.w) * 0.6000000238418579D;
				}

				double var2 = var1.s - this.s;
				var4 = var1.u - this.u;
				var6 = var2 * var2 + var4 * var4;
				if (var6 > 9.0D) {
					var8 = (double) uv.a(var6);
					this.v += (var2 / var8 * 0.5D - this.v) * 0.6000000238418579D;
					this.x += (var4 / var8 * 0.5D - this.x) * 0.6000000238418579D;
				}
			}
		}

		if (this.v * this.v + this.x * this.x > 0.05000000074505806D) {
			this.y = (float) Math.atan2(this.x, this.v) * 57.295776F - 90.0F;
		}

		super.m();

		int var20;
		for (var20 = 0; var20 < 2; ++var20) {
			this.bl[var20] = this.c[var20];
			this.bk[var20] = this.b[var20];
		}

		int var22;
		for (var20 = 0; var20 < 2; ++var20) {
			var22 = this.s(var20 + 1);
			Entity var3 = null;
			if (var22 > 0) {
				var3 = this.o.a(var22);
			}

			if (var3 != null) {
				var4 = this.t(var20 + 1);
				var6 = this.u(var20 + 1);
				var8 = this.v(var20 + 1);
				double var10 = var3.s - var4;
				double var12 = var3.t + (double) var3.aR() - var6;
				double var14 = var3.u - var8;
				double var16 = (double) uv.a(var10 * var10 + var14 * var14);
				float var18 = (float) (Math.atan2(var14, var10) * 180.0D / 3.1415927410125732D) - 90.0F;
				float var19 = (float) (-(Math.atan2(var12, var16) * 180.0D / 3.1415927410125732D));
				this.b[var20] = this.b(this.b[var20], var19, 40.0F);
				this.c[var20] = this.b(this.c[var20], var18, 10.0F);
			} else {
				this.c[var20] = this.b(this.c[var20], this.aG, 10.0F);
			}
		}

		boolean var21 = this.ck();

		for (var22 = 0; var22 < 3; ++var22) {
			double var23 = this.t(var22);
			double var5 = this.u(var22);
			double var7 = this.v(var22);
			this.o.a(ew.l, var23 + this.V.nextGaussian() * 0.30000001192092896D, var5 + this.V.nextGaussian() * 0.30000001192092896D, var7 + this.V.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D, new int[0]);
			if (var21 && this.o.s.nextInt(4) == 0) {
				this.o.a(ew.p, var23 + this.V.nextGaussian() * 0.30000001192092896D, var5 + this.V.nextGaussian() * 0.30000001192092896D, var7 + this.V.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D, new int[0]);
			}
		}

		if (this.cj() > 0) {
			for (var22 = 0; var22 < 3; ++var22) {
				this.o.a(ew.p, this.s + this.V.nextGaussian() * 1.0D, this.t + (double) (this.V.nextFloat() * 3.3F), this.u + this.V.nextGaussian() * 1.0D, 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D, new int[0]);
			}
		}

	}

	protected void E() {
		int var1;
		if (this.cj() > 0) {
			var1 = this.cj() - 1;
			if (var1 <= 0) {
				this.o.a(this, this.s, this.t + (double) this.aR(), this.u, 7.0F, false, this.o.Q().b("mobGriefing"));
				this.o.a(1013, new dt(this), 0);
			}

			this.r(var1);
			if (this.W % 10 == 0) {
				this.g(10.0F);
			}

		} else {
			super.E();

			int var12;
			for (var1 = 1; var1 < 3; ++var1) {
				if (this.W >= this.bm[var1 - 1]) {
					this.bm[var1 - 1] = this.W + 10 + this.V.nextInt(10);
					if (this.o.aa() == vt.c || this.o.aa() == vt.d) {
						int var10001 = var1 - 1;
						int var10003 = this.bn[var1 - 1];
						this.bn[var10001] = this.bn[var1 - 1] + 1;
						if (var10003 > 15) {
							float var2 = 10.0F;
							float var3 = 5.0F;
							double var4 = uv.a(this.V, this.s - (double) var2, this.s + (double) var2);
							double var6 = uv.a(this.V, this.t - (double) var3, this.t + (double) var3);
							double var8 = uv.a(this.V, this.u - (double) var2, this.u + (double) var2);
							this.a(var1 + 1, var4, var6, var8, true);
							this.bn[var1 - 1] = 0;
						}
					}

					var12 = this.s(var1);
					if (var12 > 0) {
						Entity var14 = this.o.a(var12);
						if (var14 != null && var14.ai() && this.h(var14) <= 900.0D && this.t(var14)) {
							this.a(var1 + 1, (EntityLiving) var14);
							this.bm[var1 - 1] = this.W + 40 + this.V.nextInt(20);
							this.bn[var1 - 1] = 0;
						} else {
							this.b(var1, 0);
						}
					} else {
						List var13 = this.o.a(EntityLiving.class, this.aQ().b(20.0D, 8.0D, 20.0D), Predicates.and(bp, xe.d));

						for (int var16 = 0; var16 < 10 && !var13.isEmpty(); ++var16) {
							EntityLiving var5 = (EntityLiving) var13.get(this.V.nextInt(var13.size()));
							if (var5 != this && var5.ai() && this.t(var5)) {
								if (var5 instanceof ahd) {
									if (!((ahd) var5).by.a) {
										this.b(var1, var5.F());
									}
								} else {
									this.b(var1, var5.F());
								}
								break;
							}

							var13.remove(var5);
						}
					}
				}
			}

			if (this.u() != null) {
				this.b(0, this.u().F());
			} else {
				this.b(0, 0);
			}

			if (this.bo > 0) {
				--this.bo;
				if (this.bo == 0 && this.o.Q().b("mobGriefing")) {
					var1 = uv.c(this.t);
					var12 = uv.c(this.s);
					int var15 = uv.c(this.u);
					boolean var17 = false;

					for (int var18 = -1; var18 <= 1; ++var18) {
						for (int var19 = -1; var19 <= 1; ++var19) {
							for (int var7 = 0; var7 <= 3; ++var7) {
								int var20 = var12 + var18;
								int var9 = var1 + var7;
								int var10 = var15 + var19;
								atr var11 = this.o.p(new dt(var20, var9, var10)).c();
								if (var11.r() != bof.a && var11 != aty.h && var11 != aty.bF && var11 != aty.bG && var11 != aty.bX && var11 != aty.cv) {
									var17 = this.o.b(new dt(var20, var9, var10), true) || var17;
								}
							}
						}
					}

					if (var17) {
						this.o.a((ahd) null, 1012, new dt(this), 0);
					}
				}
			}

			if (this.W % 20 == 0) {
				this.g(1.0F);
			}

		}
	}

	public void n() {
		this.r(220);
		this.h(this.bt() / 3.0F);
	}

	public void aB() {
	}

	public int bq() {
		return 4;
	}

	private double t(int var1) {
		if (var1 <= 0) {
			return this.s;
		} else {
			float var2 = (this.aG + (float) (180 * (var1 - 1))) / 180.0F * 3.1415927F;
			float var3 = uv.b(var2);
			return this.s + (double) var3 * 1.3D;
		}
	}

	private double u(int var1) {
		return var1 <= 0 ? this.t + 3.0D : this.t + 2.2D;
	}

	private double v(int var1) {
		if (var1 <= 0) {
			return this.u;
		} else {
			float var2 = (this.aG + (float) (180 * (var1 - 1))) / 180.0F * 3.1415927F;
			float var3 = uv.a(var2);
			return this.u + (double) var3 * 1.3D;
		}
	}

	private float b(float var1, float var2, float var3) {
		float var4 = uv.g(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	private void a(int var1, EntityLiving var2) {
		this.a(var1, var2.s, var2.t + (double) var2.aR() * 0.5D, var2.u, var1 == 0 && this.V.nextFloat() < 0.001F);
	}

	private void a(int var1, double var2, double var4, double var6, boolean var8) {
		this.o.a((ahd) null, 1014, new dt(this), 0);
		double var9 = this.t(var1);
		double var11 = this.u(var1);
		double var13 = this.v(var1);
		double var15 = var2 - var9;
		double var17 = var4 - var11;
		double var19 = var6 - var13;
		ahw var21 = new ahw(this.o, this, var15, var17, var19);
		if (var8) {
			var21.a(true);
		}

		var21.t = var11;
		var21.s = var9;
		var21.u = var13;
		this.o.d((Entity) var21);
	}

	public void a(EntityLiving var1, float var2) {
		this.a(0, var1);
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (var1 != wh.f && !(var1.j() instanceof adf)) {
			if (this.cj() > 0 && var1 != wh.j) {
				return false;
			} else {
				Entity var3;
				if (this.ck()) {
					var3 = var1.i();
					if (var3 instanceof ahj) {
						return false;
					}
				}

				var3 = var1.j();
				if (var3 != null && !(var3 instanceof ahd) && var3 instanceof EntityLiving && ((EntityLiving) var3).by() == this.by()) {
					return false;
				} else {
					if (this.bo <= 0) {
						this.bo = 20;
					}

					for (int var4 = 0; var4 < this.bn.length; ++var4) {
						this.bn[var4] += 3;
					}

					return super.a(var1, var2);
				}
			}
		} else {
			return false;
		}
	}

	protected void b(boolean var1, int var2) {
		adw var3 = this.a(amk.bZ, 1);
		if (var3 != null) {
			var3.u();
		}

		if (!this.o.D) {
			Iterator var4 = this.o.a(ahd.class, this.aQ().b(50.0D, 100.0D, 50.0D)).iterator();

			while (var4.hasNext()) {
				ahd var5 = (ahd) var4.next();
				var5.b((tq) tl.J);
			}
		}

	}

	protected void D() {
		this.aO = 0;
	}

	public void e(float var1, float var2) {
	}

	public void c(wq var1) {
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(300.0D);
		this.a(afs.d).a(0.6000000238418579D);
		this.a(afs.b).a(40.0D);
	}

	public int cj() {
		return this.ac.c(20);
	}

	public void r(int var1) {
		this.ac.b(20, Integer.valueOf(var1));
	}

	public int s(int var1) {
		return this.ac.c(17 + var1);
	}

	public void b(int var1, int var2) {
		this.ac.b(17 + var1, Integer.valueOf(var2));
	}

	public boolean ck() {
		return this.bm() <= this.bt() / 2.0F;
	}

	public xs by() {
		return xs.b;
	}

	public void a(Entity var1) {
		this.m = null;
	}

}
