package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public abstract class Entity implements CommandSenderInterface {

	private static final brt a = new brt(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	private static int b;
	private int c;
	public double j;
	public boolean k;
	public Entity l;
	public Entity m;
	public boolean n;
	public World o;
	public double p;
	public double q;
	public double r;
	public double s;
	public double t;
	public double u;
	public double v;
	public double w;
	public double x;
	public float y;
	public float z;
	public float A;
	public float B;
	private brt f;
	public boolean C;
	public boolean D;
	public boolean E;
	public boolean F;
	public boolean G;
	protected boolean H;
	private boolean g;
	public boolean I;
	public float J;
	public float K;
	public float L;
	public float M;
	public float N;
	public float O;
	private int h;
	public double P;
	public double Q;
	public double R;
	public float S;
	public boolean T;
	public float U;
	protected Random V;
	public int W;
	public int X;
	private int i;
	protected boolean Y;
	public int Z;
	protected boolean aa;
	protected boolean ab;
	protected xv ac;
	private double ap;
	private double aq;
	public boolean ad;
	public int ae;
	public int af;
	public int ag;
	public boolean ah;
	public boolean ai;
	public int aj;
	protected boolean ak;
	protected int al;
	public int am;
	protected int an;
	private boolean ar;
	protected UUID ao;
	private final af as;

	public int F() {
		return this.c;
	}

	public void d(int var1) {
		this.c = var1;
	}

	public void G() {
		this.J();
	}

	public Entity(World var1) {
		this.c = b++;
		this.j = 1.0D;
		this.f = a;
		this.J = 0.6F;
		this.K = 1.8F;
		this.h = 1;
		this.V = new Random();
		this.X = 1;
		this.aa = true;
		this.ao = NumberConverter.a(this.V);
		this.as = new af();
		this.o = var1;
		this.b(0.0D, 0.0D, 0.0D);
		if (var1 != null) {
			this.am = var1.t.q();
		}

		this.ac = new xv(this);
		this.ac.a(0, Byte.valueOf((byte) 0));
		this.ac.a(1, Short.valueOf((short) 300));
		this.ac.a(3, Byte.valueOf((byte) 0));
		this.ac.a(2, "");
		this.ac.a(4, Byte.valueOf((byte) 0));
		this.h();
	}

	protected abstract void h();

	public xv H() {
		return this.ac;
	}

	public boolean equals(Object var1) {
		return var1 instanceof Entity ? ((Entity) var1).c == this.c : false;
	}

	public int hashCode() {
		return this.c;
	}

	public void J() {
		this.I = true;
	}

	protected void a(float var1, float var2) {
		if (var1 != this.J || var2 != this.K) {
			float var3 = this.J;
			this.J = var1;
			this.K = var2;
			this.a(new brt(this.aQ().a, this.aQ().b, this.aQ().c, this.aQ().a + (double) this.J, this.aQ().b + (double) this.K, this.aQ().c + (double) this.J));
			if (this.J > var3 && !this.aa && !this.o.D) {
				this.d((double) (var3 - this.J), 0.0D, (double) (var3 - this.J));
			}
		}

	}

	protected void b(float var1, float var2) {
		this.y = var1 % 360.0F;
		this.z = var2 % 360.0F;
	}

	public void b(double var1, double var3, double var5) {
		this.s = var1;
		this.t = var3;
		this.u = var5;
		float var7 = this.J / 2.0F;
		float var8 = this.K;
		this.a(new brt(var1 - (double) var7, var3, var5 - (double) var7, var1 + (double) var7, var3 + (double) var8, var5 + (double) var7));
	}

	public void s_() {
		this.K();
	}

	public void K() {
		this.o.B.a("entityBaseTick");
		if (this.m != null && this.m.I) {
			this.m = null;
		}

		this.L = this.M;
		this.p = this.s;
		this.q = this.t;
		this.r = this.u;
		this.B = this.z;
		this.A = this.y;
		if (!this.o.D && this.o instanceof WorldServer) {
			this.o.B.a("portal");
			MinecraftServer var1 = ((WorldServer) this.o).r();
			int var2 = this.L();
			if (this.ak) {
				if (var1.isNetherAllowed()) {
					if (this.m == null && this.al++ >= var2) {
						this.al = var2;
						this.aj = this.ar();
						byte var3;
						if (this.o.t.q() == -1) {
							var3 = 0;
						} else {
							var3 = -1;
						}

						this.c(var3);
					}

					this.ak = false;
				}
			} else {
				if (this.al > 0) {
					this.al -= 4;
				}

				if (this.al < 0) {
					this.al = 0;
				}
			}

			if (this.aj > 0) {
				--this.aj;
			}

			this.o.B.b();
		}

		this.Y();
		this.W();
		if (this.o.D) {
			this.i = 0;
		} else if (this.i > 0) {
			if (this.ab) {
				this.i -= 4;
				if (this.i < 0) {
					this.i = 0;
				}
			} else {
				if (this.i % 20 == 0) {
					this.a(wh.c, 1.0F);
				}

				--this.i;
			}
		}

		if (this.ab()) {
			this.M();
			this.O *= 0.5F;
		}

		if (this.t < -64.0D) {
			this.O();
		}

		if (!this.o.D) {
			this.b(0, this.i > 0);
		}

		this.aa = false;
		this.o.B.b();
	}

	public int L() {
		return 0;
	}

	protected void M() {
		if (!this.ab) {
			this.a(wh.d, 4.0F);
			this.e(15);
		}
	}

	public void e(int var1) {
		int var2 = var1 * 20;
		var2 = apu.a(this, var2);
		if (this.i < var2) {
			this.i = var2;
		}

	}

	public void N() {
		this.i = 0;
	}

	protected void O() {
		this.J();
	}

	public boolean c(double var1, double var3, double var5) {
		brt var7 = this.aQ().c(var1, var3, var5);
		return this.b(var7);
	}

	private boolean b(brt var1) {
		return this.o.a(this, var1).isEmpty() && !this.o.d(var1);
	}

	public void d(double var1, double var3, double var5) {
		if (this.T) {
			this.a(this.aQ().c(var1, var3, var5));
			this.m();
		} else {
			this.o.B.a("move");
			double var7 = this.s;
			double var9 = this.t;
			double var11 = this.u;
			if (this.H) {
				this.H = false;
				var1 *= 0.25D;
				var3 *= 0.05000000074505806D;
				var5 *= 0.25D;
				this.v = 0.0D;
				this.w = 0.0D;
				this.x = 0.0D;
			}

			double var13 = var1;
			double var15 = var3;
			double var17 = var5;
			boolean var19 = this.C && this.aw() && this instanceof ahd;
			if (var19) {
				double var20;
				for (var20 = 0.05D; var1 != 0.0D && this.o.a(this, this.aQ().c(var1, -1.0D, 0.0D)).isEmpty(); var13 = var1) {
					if (var1 < var20 && var1 >= -var20) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}
				}

				for (; var5 != 0.0D && this.o.a(this, this.aQ().c(0.0D, -1.0D, var5)).isEmpty(); var17 = var5) {
					if (var5 < var20 && var5 >= -var20) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}

				for (; var1 != 0.0D && var5 != 0.0D && this.o.a(this, this.aQ().c(var1, -1.0D, var5)).isEmpty(); var17 = var5) {
					if (var1 < var20 && var1 >= -var20) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}

					var13 = var1;
					if (var5 < var20 && var5 >= -var20) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}
			}

			List var53 = this.o.a(this, this.aQ().a(var1, var3, var5));
			brt var21 = this.aQ();

			brt var23;
			for (Iterator var22 = var53.iterator(); var22.hasNext(); var3 = var23.b(this.aQ(), var3)) {
				var23 = (brt) var22.next();
			}

			this.a(this.aQ().c(0.0D, var3, 0.0D));
			boolean var54 = this.C || var15 != var3 && var15 < 0.0D;

			brt var24;
			Iterator var55;
			for (var55 = var53.iterator(); var55.hasNext(); var1 = var24.a(this.aQ(), var1)) {
				var24 = (brt) var55.next();
			}

			this.a(this.aQ().c(var1, 0.0D, 0.0D));

			for (var55 = var53.iterator(); var55.hasNext(); var5 = var24.c(this.aQ(), var5)) {
				var24 = (brt) var55.next();
			}

			this.a(this.aQ().c(0.0D, 0.0D, var5));
			if (this.S > 0.0F && var54 && (var13 != var1 || var17 != var5)) {
				double var56 = var1;
				double var25 = var3;
				double var27 = var5;
				brt var29 = this.aQ();
				this.a(var21);
				var3 = (double) this.S;
				List var30 = this.o.a(this, this.aQ().a(var13, var3, var17));
				brt var31 = this.aQ();
				brt var32 = var31.a(var13, 0.0D, var17);
				double var33 = var3;

				brt var36;
				for (Iterator var35 = var30.iterator(); var35.hasNext(); var33 = var36.b(var32, var33)) {
					var36 = (brt) var35.next();
				}

				var31 = var31.c(0.0D, var33, 0.0D);
				double var67 = var13;

				brt var38;
				for (Iterator var37 = var30.iterator(); var37.hasNext(); var67 = var38.a(var31, var67)) {
					var38 = (brt) var37.next();
				}

				var31 = var31.c(var67, 0.0D, 0.0D);
				double var68 = var17;

				brt var40;
				for (Iterator var39 = var30.iterator(); var39.hasNext(); var68 = var40.c(var31, var68)) {
					var40 = (brt) var39.next();
				}

				var31 = var31.c(0.0D, 0.0D, var68);
				brt var69 = this.aQ();
				double var70 = var3;

				brt var43;
				for (Iterator var42 = var30.iterator(); var42.hasNext(); var70 = var43.b(var69, var70)) {
					var43 = (brt) var42.next();
				}

				var69 = var69.c(0.0D, var70, 0.0D);
				double var71 = var13;

				brt var45;
				for (Iterator var44 = var30.iterator(); var44.hasNext(); var71 = var45.a(var69, var71)) {
					var45 = (brt) var44.next();
				}

				var69 = var69.c(var71, 0.0D, 0.0D);
				double var72 = var17;

				brt var47;
				for (Iterator var46 = var30.iterator(); var46.hasNext(); var72 = var47.c(var69, var72)) {
					var47 = (brt) var46.next();
				}

				var69 = var69.c(0.0D, 0.0D, var72);
				double var73 = var67 * var67 + var68 * var68;
				double var48 = var71 * var71 + var72 * var72;
				if (var73 > var48) {
					var1 = var67;
					var5 = var68;
					this.a(var31);
				} else {
					var1 = var71;
					var5 = var72;
					this.a(var69);
				}

				var3 = (double) (-this.S);

				brt var51;
				for (Iterator var50 = var30.iterator(); var50.hasNext(); var3 = var51.b(this.aQ(), var3)) {
					var51 = (brt) var50.next();
				}

				this.a(this.aQ().c(0.0D, var3, 0.0D));
				if (var56 * var56 + var27 * var27 >= var1 * var1 + var5 * var5) {
					var1 = var56;
					var3 = var25;
					var5 = var27;
					this.a(var29);
				}
			}

			this.o.B.b();
			this.o.B.a("rest");
			this.m();
			this.D = var13 != var1 || var17 != var5;
			this.E = var15 != var3;
			this.C = this.E && var15 < 0.0D;
			this.F = this.D || this.E;
			int var57 = NumberConverter.c(this.s);
			int var58 = NumberConverter.c(this.t - 0.20000000298023224D);
			int var59 = NumberConverter.c(this.u);
			dt var26 = new dt(var57, var58, var59);
			atr var60 = this.o.p(var26).c();
			if (var60.r() == bof.a) {
				atr var28 = this.o.p(var26.b()).c();
				if (var28 instanceof avv || var28 instanceof bbx || var28 instanceof avw) {
					var60 = var28;
					var26 = var26.b();
				}
			}

			this.a(var3, this.C, var60, var26);
			if (var13 != var1) {
				this.v = 0.0D;
			}

			if (var17 != var5) {
				this.x = 0.0D;
			}

			if (var15 != var3) {
				var60.a(this.o, this);
			}

			if (this.r_() && !var19 && this.m == null) {
				double var61 = this.s - var7;
				double var64 = this.t - var9;
				double var66 = this.u - var11;
				if (var60 != aty.au) {
					var64 = 0.0D;
				}

				if (var60 != null && this.C) {
					var60.a(this.o, var26, this);
				}

				this.M = (float) ((double) this.M + (double) NumberConverter.a(var61 * var61 + var66 * var66) * 0.6D);
				this.N = (float) ((double) this.N + (double) NumberConverter.a(var61 * var61 + var64 * var64 + var66 * var66) * 0.6D);
				if (this.N > (float) this.h && var60.r() != bof.a) {
					this.h = (int) this.N + 1;
					if (this.V()) {
						float var34 = NumberConverter.a(this.v * this.v * 0.20000000298023224D + this.w * this.w + this.x * this.x * 0.20000000298023224D) * 0.35F;
						if (var34 > 1.0F) {
							var34 = 1.0F;
						}

						this.a(this.P(), var34, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
					}

					this.a(var26, var60);
				}
			}

			try {
				this.Q();
			} catch (Throwable var52) {
				CrashReport var63 = CrashReport.a(var52, "Checking entity block collision");
				j var65 = var63.a("Entity being checked for collision");
				this.a(var65);
				throw new u(var63);
			}

			boolean var62 = this.U();
			if (this.o.e(this.aQ().d(0.001D, 0.001D, 0.001D))) {
				this.f(1);
				if (!var62) {
					++this.i;
					if (this.i == 0) {
						this.e(8);
					}
				}
			} else if (this.i <= 0) {
				this.i = -this.X;
			}

			if (var62 && this.i > 0) {
				this.a("random.fizz", 0.7F, 1.6F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
				this.i = -this.X;
			}

			this.o.B.b();
		}
	}

	private void m() {
		this.s = (this.aQ().a + this.aQ().d) / 2.0D;
		this.t = this.aQ().b;
		this.u = (this.aQ().c + this.aQ().f) / 2.0D;
	}

	protected String P() {
		return "game.neutral.swim";
	}

	protected void Q() {
		dt var1 = new dt(this.aQ().a + 0.001D, this.aQ().b + 0.001D, this.aQ().c + 0.001D);
		dt var2 = new dt(this.aQ().d - 0.001D, this.aQ().e - 0.001D, this.aQ().f - 0.001D);
		if (this.o.a(var1, var2)) {
			for (int var3 = var1.n(); var3 <= var2.n(); ++var3) {
				for (int var4 = var1.o(); var4 <= var2.o(); ++var4) {
					for (int var5 = var1.p(); var5 <= var2.p(); ++var5) {
						dt var6 = new dt(var3, var4, var5);
						bec var7 = this.o.p(var6);

						try {
							var7.c().a(this.o, var6, var7, this);
						} catch (Throwable var11) {
							CrashReport var9 = CrashReport.a(var11, "Colliding entity with block");
							j var10 = var9.a("Block being collided with");
							net.minecraft.j.a(var10, var6, var7);
							throw new u(var9);
						}
					}
				}
			}
		}

	}

	protected void a(dt var1, atr var2) {
		atx var3 = var2.H;
		if (this.o.p(var1.a()).c() == aty.aH) {
			var3 = aty.aH.H;
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		} else if (!var2.r().d()) {
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		}

	}

	public void a(String var1, float var2, float var3) {
		if (!this.R()) {
			this.o.a(this, var1, var2, var3);
		}

	}

	public boolean R() {
		return this.ac.a(4) == 1;
	}

	public void b(boolean var1) {
		this.ac.b(4, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	protected boolean r_() {
		return true;
	}

	protected void a(double var1, boolean var3, atr var4, dt var5) {
		if (var3) {
			if (this.O > 0.0F) {
				if (var4 != null) {
					var4.a(this.o, var5, this, this.O);
				} else {
					this.e(this.O, 1.0F);
				}

				this.O = 0.0F;
			}
		} else if (var1 < 0.0D) {
			this.O = (float) ((double) this.O - var1);
		}

	}

	public brt S() {
		return null;
	}

	protected void f(int var1) {
		if (!this.ab) {
			this.a(wh.a, (float) var1);
		}

	}

	public final boolean T() {
		return this.ab;
	}

	public void e(float var1, float var2) {
		if (this.l != null) {
			this.l.e(var1, var2);
		}

	}

	public boolean U() {
		return this.Y || this.o.C(new dt(this.s, this.t, this.u)) || this.o.C(new dt(this.s, this.t + (double) this.K, this.u));
	}

	public boolean V() {
		return this.Y;
	}

	public boolean W() {
		if (this.o.a(this.aQ().b(0.0D, -0.4000000059604645D, 0.0D).d(0.001D, 0.001D, 0.001D), bof.h, this)) {
			if (!this.Y && !this.aa) {
				this.X();
			}

			this.O = 0.0F;
			this.Y = true;
			this.i = 0;
		} else {
			this.Y = false;
		}

		return this.Y;
	}

	protected void X() {
		float var1 = NumberConverter.a(this.v * this.v * 0.20000000298023224D + this.w * this.w + this.x * this.x * 0.20000000298023224D) * 0.2F;
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		this.a(this.aa(), var1, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
		float var2 = (float) NumberConverter.c(this.aQ().b);

		int var3;
		float var4;
		float var5;
		for (var3 = 0; (float) var3 < 1.0F + this.J * 20.0F; ++var3) {
			var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			this.o.a(ew.e, this.s + (double) var4, (double) (var2 + 1.0F), this.u + (double) var5, this.v, this.w - (double) (this.V.nextFloat() * 0.2F), this.x, new int[0]);
		}

		for (var3 = 0; (float) var3 < 1.0F + this.J * 20.0F; ++var3) {
			var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			this.o.a(ew.f, this.s + (double) var4, (double) (var2 + 1.0F), this.u + (double) var5, this.v, this.w, this.x, new int[0]);
		}

	}

	public void Y() {
		if (this.ax() && !this.V()) {
			this.Z();
		}

	}

	protected void Z() {
		int var1 = NumberConverter.c(this.s);
		int var2 = NumberConverter.c(this.t - 0.20000000298023224D);
		int var3 = NumberConverter.c(this.u);
		dt var4 = new dt(var1, var2, var3);
		bec var5 = this.o.p(var4);
		atr var6 = var5.c();
		if (var6.b() != -1) {
			this.o.a(ew.L, this.s + ((double) this.V.nextFloat() - 0.5D) * (double) this.J, this.aQ().b + 0.1D, this.u + ((double) this.V.nextFloat() - 0.5D) * (double) this.J, -this.v * 4.0D, 1.5D, -this.x * 4.0D, new int[] { atr.f(var5) });
		}

	}

	protected String aa() {
		return "game.neutral.swim.splash";
	}

	public boolean a(bof var1) {
		double var2 = this.t + (double) this.aR();
		dt var4 = new dt(this.s, var2, this.u);
		bec var5 = this.o.p(var4);
		atr var6 = var5.c();
		if (var6.r() == var1) {
			float var7 = axl.b(var5.c().c(var5)) - 0.11111111F;
			float var8 = (float) (var4.o() + 1) - var7;
			boolean var9 = var2 < (double) var8;
			return !var9 && this instanceof ahd ? false : var9;
		} else {
			return false;
		}
	}

	public boolean ab() {
		return this.o.a(this.aQ().b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), bof.i);
	}

	public void a(float var1, float var2, float var3) {
		float var4 = var1 * var1 + var2 * var2;
		if (var4 >= 1.0E-4F) {
			var4 = NumberConverter.c(var4);
			if (var4 < 1.0F) {
				var4 = 1.0F;
			}

			var4 = var3 / var4;
			var1 *= var4;
			var2 *= var4;
			float var5 = NumberConverter.a(this.y * 3.1415927F / 180.0F);
			float var6 = NumberConverter.b(this.y * 3.1415927F / 180.0F);
			this.v += (double) (var1 * var6 - var2 * var5);
			this.x += (double) (var2 * var6 + var1 * var5);
		}
	}

	public float c(float var1) {
		dt var2 = new dt(this.s, 0.0D, this.u);
		if (this.o.e(var2)) {
			double var3 = (this.aQ().e - this.aQ().b) * 0.66D;
			int var5 = NumberConverter.c(this.t + var3);
			return this.o.o(var2.b(var5));
		} else {
			return 0.0F;
		}
	}

	public void a(World var1) {
		this.o = var1;
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		this.p = this.s = var1;
		this.q = this.t = var3;
		this.r = this.u = var5;
		this.A = this.y = var7;
		this.B = this.z = var8;
		double var9 = (double) (this.A - var7);
		if (var9 < -180.0D) {
			this.A += 360.0F;
		}

		if (var9 >= 180.0D) {
			this.A -= 360.0F;
		}

		this.b(this.s, this.t, this.u);
		this.b(var7, var8);
	}

	public void a(dt var1, float var2, float var3) {
		this.b((double) var1.n() + 0.5D, (double) var1.o(), (double) var1.p() + 0.5D, var2, var3);
	}

	public void b(double var1, double var3, double var5, float var7, float var8) {
		this.P = this.p = this.s = var1;
		this.Q = this.q = this.t = var3;
		this.R = this.r = this.u = var5;
		this.y = var7;
		this.z = var8;
		this.b(this.s, this.t, this.u);
	}

	public float g(Entity var1) {
		float var2 = (float) (this.s - var1.s);
		float var3 = (float) (this.t - var1.t);
		float var4 = (float) (this.u - var1.u);
		return NumberConverter.c(var2 * var2 + var3 * var3 + var4 * var4);
	}

	public double e(double var1, double var3, double var5) {
		double var7 = this.s - var1;
		double var9 = this.t - var3;
		double var11 = this.u - var5;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public double b(dt var1) {
		return var1.c(this.s, this.t, this.u);
	}

	public double c(dt var1) {
		return var1.d(this.s, this.t, this.u);
	}

	public double f(double var1, double var3, double var5) {
		double var7 = this.s - var1;
		double var9 = this.t - var3;
		double var11 = this.u - var5;
		return (double) NumberConverter.a(var7 * var7 + var9 * var9 + var11 * var11);
	}

	public double h(Entity var1) {
		double var2 = this.s - var1.s;
		double var4 = this.t - var1.t;
		double var6 = this.u - var1.u;
		return var2 * var2 + var4 * var4 + var6 * var6;
	}

	public void d(ahd var1) {
	}

	public void i(Entity var1) {
		if (var1.l != this && var1.m != this) {
			if (!var1.T && !this.T) {
				double var2 = var1.s - this.s;
				double var4 = var1.u - this.u;
				double var6 = NumberConverter.a(var2, var4);
				if (var6 >= 0.009999999776482582D) {
					var6 = (double) NumberConverter.a(var6);
					var2 /= var6;
					var4 /= var6;
					double var8 = 1.0D / var6;
					if (var8 > 1.0D) {
						var8 = 1.0D;
					}

					var2 *= var8;
					var4 *= var8;
					var2 *= 0.05000000074505806D;
					var4 *= 0.05000000074505806D;
					var2 *= (double) (1.0F - this.U);
					var4 *= (double) (1.0F - this.U);
					if (this.l == null) {
						this.g(-var2, 0.0D, -var4);
					}

					if (var1.l == null) {
						var1.g(var2, 0.0D, var4);
					}
				}

			}
		}
	}

	public void g(double var1, double var3, double var5) {
		this.v += var1;
		this.w += var3;
		this.x += var5;
		this.ai = true;
	}

	protected void ac() {
		this.G = true;
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			this.ac();
			return false;
		}
	}

	public brw d(float var1) {
		if (var1 == 1.0F) {
			return this.f(this.z, this.y);
		} else {
			float var2 = this.B + (this.z - this.B) * var1;
			float var3 = this.A + (this.y - this.A) * var1;
			return this.f(var2, var3);
		}
	}

	protected final brw f(float var1, float var2) {
		float var3 = NumberConverter.b(-var2 * 0.017453292F - 3.1415927F);
		float var4 = NumberConverter.a(-var2 * 0.017453292F - 3.1415927F);
		float var5 = -NumberConverter.b(-var1 * 0.017453292F);
		float var6 = NumberConverter.a(-var1 * 0.017453292F);
		return new brw((double) (var4 * var5), (double) var6, (double) (var3 * var5));
	}

	public boolean ad() {
		return false;
	}

	public boolean ae() {
		return false;
	}

	public void b(Entity var1, int var2) {
	}

	public boolean c(NBTCompoundTag var1) {
		String var2 = this.ag();
		if (!this.I && var2 != null) {
			var1.a("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public boolean d(NBTCompoundTag var1) {
		String var2 = this.ag();
		if (!this.I && var2 != null && this.l == null) {
			var1.a("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public void e(NBTCompoundTag var1) {
		try {
			var1.a("Pos", (NBTTag) this.a(new double[] { this.s, this.t, this.u }));
			var1.a("Motion", (NBTTag) this.a(new double[] { this.v, this.w, this.x }));
			var1.a("Rotation", (NBTTag) this.a(new float[] { this.y, this.z }));
			var1.a("FallDistance", this.O);
			var1.a("Fire", (short) this.i);
			var1.a("Air", (short) this.aA());
			var1.a("OnGround", this.C);
			var1.a("Dimension", this.am);
			var1.a("Invulnerable", this.ar);
			var1.a("PortalCooldown", this.aj);
			var1.a("UUIDMost", this.aJ().getMostSignificantBits());
			var1.a("UUIDLeast", this.aJ().getLeastSignificantBits());
			if (this.aL() != null && this.aL().length() > 0) {
				var1.a("CustomName", this.aL());
				var1.a("CustomNameVisible", this.aM());
			}

			this.as.b(var1);
			if (this.R()) {
				var1.a("Silent", this.R());
			}

			this.b(var1);
			if (this.m != null) {
				NBTCompoundTag var2 = new NBTCompoundTag();
				if (this.m.c(var2)) {
					var1.a("Riding", (NBTTag) var2);
				}
			}

		} catch (Throwable var5) {
			CrashReport var3 = CrashReport.a(var5, "Saving entity NBT");
			j var4 = var3.a("Entity being saved");
			this.a(var4);
			throw new u(var3);
		}
	}

	public void f(NBTCompoundTag var1) {
		try {
			NBTListTag var2 = var1.c("Pos", 6);
			NBTListTag var6 = var1.c("Motion", 6);
			NBTListTag var7 = var1.c("Rotation", 5);
			this.v = var6.getDouble(0);
			this.w = var6.getDouble(1);
			this.x = var6.getDouble(2);
			if (Math.abs(this.v) > 10.0D) {
				this.v = 0.0D;
			}

			if (Math.abs(this.w) > 10.0D) {
				this.w = 0.0D;
			}

			if (Math.abs(this.x) > 10.0D) {
				this.x = 0.0D;
			}

			this.p = this.P = this.s = var2.getDouble(0);
			this.q = this.Q = this.t = var2.getDouble(1);
			this.r = this.R = this.u = var2.getDouble(2);
			this.A = this.y = var7.getFloat(0);
			this.B = this.z = var7.getFloat(1);
			this.O = var1.h("FallDistance");
			this.i = var1.e("Fire");
			this.h(var1.e("Air"));
			this.C = var1.n("OnGround");
			this.am = var1.f("Dimension");
			this.ar = var1.n("Invulnerable");
			this.aj = var1.f("PortalCooldown");
			if (var1.b("UUIDMost", 4) && var1.b("UUIDLeast", 4)) {
				this.ao = new UUID(var1.g("UUIDMost"), var1.g("UUIDLeast"));
			} else if (var1.b("UUID", 8)) {
				this.ao = UUID.fromString(var1.j("UUID"));
			}

			this.b(this.s, this.t, this.u);
			this.b(this.y, this.z);
			if (var1.b("CustomName", 8) && var1.j("CustomName").length() > 0) {
				this.a(var1.j("CustomName"));
			}

			this.g(var1.n("CustomNameVisible"));
			this.as.a(var1);
			this.b(var1.n("Silent"));
			this.a(var1);
			if (this.af()) {
				this.b(this.s, this.t, this.u);
			}

		} catch (Throwable var5) {
			CrashReport var3 = CrashReport.a(var5, "Loading entity NBT");
			j var4 = var3.a("Entity being loaded");
			this.a(var4);
			throw new u(var3);
		}
	}

	protected boolean af() {
		return true;
	}

	protected final String ag() {
		return xb.b(this);
	}

	protected abstract void a(NBTCompoundTag var1);

	protected abstract void b(NBTCompoundTag var1);

	public void ah() {
	}

	protected NBTListTag a(double... var1) {
		NBTListTag var2 = new NBTListTag();
		double[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.addTag((NBTTag) (new NBTDoubleTag(var6)));
		}

		return var2;
	}

	protected NBTListTag a(float... var1) {
		NBTListTag var2 = new NBTListTag();
		float[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			float var6 = var3[var5];
			var2.addTag((NBTTag) (new NBTFloatTag(var6)));
		}

		return var2;
	}

	public adw a(alq var1, int var2) {
		return this.a(var1, var2, 0.0F);
	}

	public adw a(alq var1, int var2, float var3) {
		return this.a(new amj(var1, var2, 0), var3);
	}

	public adw a(amj var1, float var2) {
		if (var1.b != 0 && var1.b() != null) {
			adw var3 = new adw(this.o, this.s, this.t + (double) var2, this.u, var1);
			var3.p();
			this.o.d((Entity) var3);
			return var3;
		} else {
			return null;
		}
	}

	public boolean ai() {
		return !this.I;
	}

	public boolean aj() {
		if (this.T) {
			return false;
		} else {
			for (int var1 = 0; var1 < 8; ++var1) {
				double var2 = this.s + (double) (((float) ((var1 >> 0) % 2) - 0.5F) * this.J * 0.8F);
				double var4 = this.t + (double) (((float) ((var1 >> 1) % 2) - 0.5F) * 0.1F);
				double var6 = this.u + (double) (((float) ((var1 >> 2) % 2) - 0.5F) * this.J * 0.8F);
				if (this.o.p(new dt(var2, var4 + (double) this.aR(), var6)).c().u()) {
					return true;
				}
			}

			return false;
		}
	}

	public boolean e(ahd var1) {
		return false;
	}

	public brt j(Entity var1) {
		return null;
	}

	public void ak() {
		if (this.m.I) {
			this.m = null;
		} else {
			this.v = 0.0D;
			this.w = 0.0D;
			this.x = 0.0D;
			this.s_();
			if (this.m != null) {
				this.m.al();
				this.aq += (double) (this.m.y - this.m.A);

				for (this.ap += (double) (this.m.z - this.m.B); this.aq >= 180.0D; this.aq -= 360.0D) {
					;
				}

				while (this.aq < -180.0D) {
					this.aq += 360.0D;
				}

				while (this.ap >= 180.0D) {
					this.ap -= 360.0D;
				}

				while (this.ap < -180.0D) {
					this.ap += 360.0D;
				}

				double var1 = this.aq * 0.5D;
				double var3 = this.ap * 0.5D;
				float var5 = 10.0F;
				if (var1 > (double) var5) {
					var1 = (double) var5;
				}

				if (var1 < (double) (-var5)) {
					var1 = (double) (-var5);
				}

				if (var3 > (double) var5) {
					var3 = (double) var5;
				}

				if (var3 < (double) (-var5)) {
					var3 = (double) (-var5);
				}

				this.aq -= var1;
				this.ap -= var3;
			}
		}
	}

	public void al() {
		if (this.l != null) {
			this.l.b(this.s, this.t + this.an() + this.l.am(), this.u);
		}
	}

	public double am() {
		return 0.0D;
	}

	public double an() {
		return (double) this.K * 0.75D;
	}

	public void a(Entity var1) {
		this.ap = 0.0D;
		this.aq = 0.0D;
		if (var1 == null) {
			if (this.m != null) {
				this.b(this.m.s, this.m.aQ().b + (double) this.m.K, this.m.u, this.y, this.z);
				this.m.l = null;
			}

			this.m = null;
		} else {
			if (this.m != null) {
				this.m.l = null;
			}

			if (var1 != null) {
				for (Entity var2 = var1.m; var2 != null; var2 = var2.m) {
					if (var2 == this) {
						return;
					}
				}
			}

			this.m = var1;
			var1.l = this;
		}
	}

	public float ao() {
		return 0.1F;
	}

	public brw ap() {
		return null;
	}

	public void aq() {
		if (this.aj > 0) {
			this.aj = this.ar();
		} else {
			double var1 = this.p - this.s;
			double var3 = this.r - this.u;
			if (!this.o.D && !this.ak) {
				int var5;
				if (NumberConverter.e((float) var1) > NumberConverter.e((float) var3)) {
					var5 = var1 > 0.0D ? ej.e.b() : ej.f.b();
				} else {
					var5 = var3 > 0.0D ? ej.c.b() : ej.d.b();
				}

				this.an = var5;
			}

			this.ak = true;
		}
	}

	public int ar() {
		return 300;
	}

	public amj[] at() {
		return null;
	}

	public void c(int var1, amj var2) {
	}

	public boolean au() {
		boolean var1 = this.o != null && this.o.D;
		return !this.ab && (this.i > 0 || var1 && this.g(0));
	}

	public boolean av() {
		return this.m != null;
	}

	public boolean aw() {
		return this.g(1);
	}

	public void c(boolean var1) {
		this.b(1, var1);
	}

	public boolean ax() {
		return this.g(3);
	}

	public void d(boolean var1) {
		this.b(3, var1);
	}

	public boolean ay() {
		return this.g(5);
	}

	public void e(boolean var1) {
		this.b(5, var1);
	}

	public void f(boolean var1) {
		this.b(4, var1);
	}

	protected boolean g(int var1) {
		return (this.ac.a(0) & 1 << var1) != 0;
	}

	protected void b(int var1, boolean var2) {
		byte var3 = this.ac.a(0);
		if (var2) {
			this.ac.b(0, Byte.valueOf((byte) (var3 | 1 << var1)));
		} else {
			this.ac.b(0, Byte.valueOf((byte) (var3 & ~(1 << var1))));
		}

	}

	public int aA() {
		return this.ac.b(1);
	}

	public void h(int var1) {
		this.ac.b(1, Short.valueOf((short) var1));
	}

	public void a(ads var1) {
		this.a(wh.b, 5.0F);
		++this.i;
		if (this.i == 0) {
			this.e(8);
		}

	}

	public void a(EntityLiving var1) {
	}

	protected boolean j(double var1, double var3, double var5) {
		dt var7 = new dt(var1, var3, var5);
		double var8 = var1 - (double) var7.n();
		double var10 = var3 - (double) var7.o();
		double var12 = var5 - (double) var7.p();
		List var14 = this.o.a(this.aQ());
		if (var14.isEmpty() && !this.o.u(var7)) {
			return false;
		} else {
			byte var15 = 3;
			double var16 = 9999.0D;
			if (!this.o.u(var7.e()) && var8 < var16) {
				var16 = var8;
				var15 = 0;
			}

			if (!this.o.u(var7.f()) && 1.0D - var8 < var16) {
				var16 = 1.0D - var8;
				var15 = 1;
			}

			if (!this.o.u(var7.a()) && 1.0D - var10 < var16) {
				var16 = 1.0D - var10;
				var15 = 3;
			}

			if (!this.o.u(var7.c()) && var12 < var16) {
				var16 = var12;
				var15 = 4;
			}

			if (!this.o.u(var7.d()) && 1.0D - var12 < var16) {
				var16 = 1.0D - var12;
				var15 = 5;
			}

			float var18 = this.V.nextFloat() * 0.2F + 0.1F;
			if (var15 == 0) {
				this.v = (double) (-var18);
			}

			if (var15 == 1) {
				this.v = (double) var18;
			}

			if (var15 == 3) {
				this.w = (double) var18;
			}

			if (var15 == 4) {
				this.x = (double) (-var18);
			}

			if (var15 == 5) {
				this.x = (double) var18;
			}

			return true;
		}
	}

	public void aB() {
		this.H = true;
		this.O = 0.0F;
	}

	public String d_() {
		if (this.k_()) {
			return this.aL();
		} else {
			String var1 = xb.b(this);
			if (var1 == null) {
				var1 = "generic";
			}

			return fi.a("entity." + var1 + ".name");
		}
	}

	public Entity[] aC() {
		return null;
	}

	public boolean k(Entity var1) {
		return this == var1;
	}

	public float aD() {
		return 0.0F;
	}

	public void f(float var1) {
	}

	public boolean aE() {
		return true;
	}

	public boolean l(Entity var1) {
		return false;
	}

	public String toString() {
		return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[] { this.getClass().getSimpleName(), this.d_(), Integer.valueOf(this.c), this.o == null ? "~NULL~" : this.o.P().k(), Double.valueOf(this.s), Double.valueOf(this.t), Double.valueOf(this.u) });
	}

	public boolean b(wh var1) {
		return this.ar && var1 != wh.j && !var1.u();
	}

	public void m(Entity var1) {
		this.b(var1.s, var1.t, var1.u, var1.y, var1.z);
	}

	public void n(Entity var1) {
		NBTCompoundTag var2 = new NBTCompoundTag();
		var1.e(var2);
		this.f(var2);
		this.aj = var1.aj;
		this.an = var1.an;
	}

	public void c(int var1) {
		if (!this.o.D && !this.I) {
			this.o.B.a("changeDimension");
			MinecraftServer var2 = MinecraftServer.getInstance();
			int var3 = this.am;
			WorldServer var4 = var2.a(var3);
			WorldServer var5 = var2.a(var1);
			this.am = var1;
			if (var3 == 1 && var1 == 1) {
				var5 = var2.a(0);
				this.am = 0;
			}

			this.o.e(this);
			this.I = false;
			this.o.B.a("reposition");
			var2.getPlayerList().a(this, var3, var4, var5);
			this.o.B.c("reloading");
			Entity var6 = xb.a(xb.b(this), (World) var5);
			if (var6 != null) {
				var6.n(this);
				if (var3 == 1 && var1 == 1) {
					dt var7 = this.o.r(var5.M());
					var6.a(var7, var6.y, var6.z);
				}

				var5.d(var6);
			}

			this.I = true;
			this.o.B.b();
			var4.j();
			var5.j();
			this.o.B.b();
		}
	}

	public float a(aqo var1, World var2, dt var3, bec var4) {
		return var4.c().a(this);
	}

	public boolean a(aqo var1, World var2, dt var3, bec var4, float var5) {
		return true;
	}

	public int aF() {
		return 3;
	}

	public int aG() {
		return this.an;
	}

	public boolean aH() {
		return false;
	}

	public void a(j var1) {
		var1.a("Entity Type", (Callable) (new ww(this)));
		var1.a("Entity ID", (Object) Integer.valueOf(this.c));
		var1.a("Entity Name", (Callable) (new wx(this)));
		var1.a("Entity\'s Exact location", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.s), Double.valueOf(this.t), Double.valueOf(this.u) }));
		var1.a("Entity\'s Block location", (Object) net.minecraft.j.a((double) NumberConverter.c(this.s), (double) NumberConverter.c(this.t), (double) NumberConverter.c(this.u)));
		var1.a("Entity\'s Momentum", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.v), Double.valueOf(this.w), Double.valueOf(this.x) }));
		var1.a("Entity\'s Rider", (Callable) (new wy(this)));
		var1.a("Entity\'s Vehicle", (Callable) (new wz(this)));
	}

	public UUID aJ() {
		return this.ao;
	}

	public boolean aK() {
		return true;
	}

	public ho e_() {
		hy var1 = new hy(this.d_());
		var1.b().a(this.aP());
		var1.b().a(this.aJ().toString());
		return var1;
	}

	public void a(String var1) {
		this.ac.b(2, var1);
	}

	public String aL() {
		return this.ac.e(2);
	}

	public boolean k_() {
		return this.ac.e(2).length() > 0;
	}

	public void g(boolean var1) {
		this.ac.b(3, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public boolean aM() {
		return this.ac.a(3) == 1;
	}

	public void a(double var1, double var3, double var5) {
		this.b(var1, var3, var5, this.y, this.z);
	}

	public void i(int var1) {
	}

	public ej aO() {
		return ej.b(NumberConverter.c((double) (this.y * 4.0F / 360.0F) + 0.5D) & 3);
	}

	protected hr aP() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		String var2 = xb.b(this);
		var1.a("id", this.aJ().toString());
		if (var2 != null) {
			var1.a("type", var2);
		}

		var1.a("name", this.d_());
		return new hr(hs.d, new hy(var1.toString()));
	}

	public boolean a(EntityPlayer var1) {
		return true;
	}

	public brt aQ() {
		return this.f;
	}

	public void a(brt var1) {
		this.f = var1;
	}

	public float aR() {
		return this.K * 0.85F;
	}

	public boolean aS() {
		return this.g;
	}

	public void h(boolean var1) {
		this.g = var1;
	}

	public boolean d(int var1, amj var2) {
		return false;
	}

	public void a(ho var1) {
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public dt c() {
		return new dt(this.s, this.t + 0.5D, this.u);
	}

	public brw d() {
		return new brw(this.s, this.t, this.u);
	}

	public World e() {
		return this.o;
	}

	public Entity f() {
		return this;
	}

	public boolean t_() {
		return false;
	}

	public void a(ag var1, int var2) {
		this.as.a(this, var1, var2);
	}

	public af aT() {
		return this.as;
	}

	public void o(Entity var1) {
		this.as.a(var1.aT());
	}

	public NBTCompoundTag aU() {
		return null;
	}

	public boolean a(ahd var1, brw var2) {
		return false;
	}

	public boolean aV() {
		return false;
	}

	protected void a(EntityLiving var1, Entity var2) {
		if (var2 instanceof EntityLiving) {
			aph.a((EntityLiving) var2, (Entity) var1);
		}

		aph.b(var1, var2);
	}

}
