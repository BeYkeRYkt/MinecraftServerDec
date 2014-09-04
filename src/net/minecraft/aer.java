package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.UUID;

public class aer extends afm {

	private static final UUID b = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final ya c = (new ya(b, "Attacking speed boost", 0.15000000596046448D, 0)).a(false);
	private static final Set bk = Sets.newIdentityHashSet();
	private boolean bl;

	public aer(World var1) {
		super(var1);
		this.a(0.6F, 2.9F);
		this.S = 1.0F;
		this.i.a(0, new yy(this));
		this.i.a(2, new zk(this, 1.0D, false));
		this.i.a(7, new zy(this, 1.0D));
		this.i.a(8, new zh(this, ahd.class, 8.0F));
		this.i.a(8, new zx(this));
		this.i.a(10, new aet(this));
		this.i.a(11, new aev(this));
		this.bg.a(1, new aal(this, false, new Class[0]));
		this.bg.a(2, new aeu(this));
		this.bg.a(3, new aaq(this, aew.class, 10, true, false, new aes(this)));
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(40.0D);
		this.a(afs.d).a(0.30000001192092896D);
		this.a(afs.e).a(7.0D);
		this.a(afs.b).a(64.0D);
	}

	protected void h() {
		super.h();
		this.ac.a(16, new Short((short) 0));
		this.ac.a(17, new Byte((byte) 0));
		this.ac.a(18, new Byte((byte) 0));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		bec var2 = this.ck();
		var1.put("carried", (short) atr.a(var2.c()));
		var1.put("carriedData", (short) var2.c().c(var2));
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		bec var2;
		if (var1.b("carried", 8)) {
			var2 = atr.b(var1.j("carried")).a(var1.e("carriedData") & '\uffff');
		} else {
			var2 = atr.c(var1.e("carried")).a(var1.e("carriedData") & '\uffff');
		}

		this.a(var2);
	}

	private boolean c(ahd var1) {
		amj var2 = var1.bg.b[3];
		if (var2 != null && var2.b() == alq.a(aty.aU)) {
			return false;
		} else {
			brw var3 = var1.d(1.0F).a();
			brw var4 = new brw(this.s - var1.s, this.aQ().b + (double) (this.K / 2.0F) - (var1.t + (double) var1.aR()), this.u - var1.u);
			double var5 = var4.b();
			var4 = var4.a();
			double var7 = var3.b(var4);
			return var7 > 1.0D - 0.025D / var5 ? var1.t(this) : false;
		}
	}

	public float aR() {
		return 2.55F;
	}

	public void m() {
		if (this.o.D) {
			for (int var1 = 0; var1 < 2; ++var1) {
				this.o.a(ew.y, this.s + (this.V.nextDouble() - 0.5D) * (double) this.J, this.t + this.V.nextDouble() * (double) this.K - 0.25D, this.u + (this.V.nextDouble() - 0.5D) * (double) this.J, (this.V.nextDouble() - 0.5D) * 2.0D, -this.V.nextDouble(), (this.V.nextDouble() - 0.5D) * 2.0D, new int[0]);
			}
		}

		this.aW = false;
		super.m();
	}

	protected void E() {
		if (this.U()) {
			this.a(wh.f, 1.0F);
		}

		if (this.cm() && !this.bl && this.V.nextInt(100) == 0) {
			this.a(false);
		}

		if (this.o.w()) {
			float var1 = this.c(1.0F);
			if (var1 > 0.5F && this.o.i(new dt(this)) && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
				this.d((EntityLiving) null);
				this.a(false);
				this.bl = false;
				this.n();
			}
		}

		super.E();
	}

	protected boolean n() {
		double var1 = this.s + (this.V.nextDouble() - 0.5D) * 64.0D;
		double var3 = this.t + (double) (this.V.nextInt(64) - 32);
		double var5 = this.u + (this.V.nextDouble() - 0.5D) * 64.0D;
		return this.k(var1, var3, var5);
	}

	protected boolean b(Entity var1) {
		brw var2 = new brw(this.s - var1.s, this.aQ().b + (double) (this.K / 2.0F) - var1.t + (double) var1.aR(), this.u - var1.u);
		var2 = var2.a();
		double var3 = 16.0D;
		double var5 = this.s + (this.V.nextDouble() - 0.5D) * 8.0D - var2.a * var3;
		double var7 = this.t + (double) (this.V.nextInt(16) - 8) - var2.b * var3;
		double var9 = this.u + (this.V.nextDouble() - 0.5D) * 8.0D - var2.c * var3;
		return this.k(var5, var7, var9);
	}

	protected boolean k(double var1, double var3, double var5) {
		double var7 = this.s;
		double var9 = this.t;
		double var11 = this.u;
		this.s = var1;
		this.t = var3;
		this.u = var5;
		boolean var13 = false;
		dt var14 = new dt(this.s, this.t, this.u);
		if (this.o.e(var14)) {
			boolean var15 = false;

			while (!var15 && var14.o() > 0) {
				dt var16 = var14.b();
				atr var17 = this.o.p(var16).c();
				if (var17.r().c()) {
					var15 = true;
				} else {
					--this.t;
					var14 = var16;
				}
			}

			if (var15) {
				super.a(this.s, this.t, this.u);
				if (this.o.a((Entity) this, this.aQ()).isEmpty() && !this.o.d(this.aQ())) {
					var13 = true;
				}
			}
		}

		if (!var13) {
			this.b(var7, var9, var11);
			return false;
		} else {
			short var28 = 128;

			for (int var29 = 0; var29 < var28; ++var29) {
				double var30 = (double) var29 / ((double) var28 - 1.0D);
				float var19 = (this.V.nextFloat() - 0.5F) * 0.2F;
				float var20 = (this.V.nextFloat() - 0.5F) * 0.2F;
				float var21 = (this.V.nextFloat() - 0.5F) * 0.2F;
				double var22 = var7 + (this.s - var7) * var30 + (this.V.nextDouble() - 0.5D) * (double) this.J * 2.0D;
				double var24 = var9 + (this.t - var9) * var30 + this.V.nextDouble() * (double) this.K;
				double var26 = var11 + (this.u - var11) * var30 + (this.V.nextDouble() - 0.5D) * (double) this.J * 2.0D;
				this.o.a(ew.y, var22, var24, var26, (double) var19, (double) var20, (double) var21, new int[0]);
			}

			this.o.a(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
			this.a("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}

	protected String z() {
		return this.cm() ? "mob.endermen.scream" : "mob.endermen.idle";
	}

	protected String bn() {
		return "mob.endermen.hit";
	}

	protected String bo() {
		return "mob.endermen.death";
	}

	protected alq A() {
		return amk.bu;
	}

	protected void b(boolean var1, int var2) {
		alq var3 = this.A();
		if (var3 != null) {
			int var4 = this.V.nextInt(2 + var2);

			for (int var5 = 0; var5 < var4; ++var5) {
				this.a(var3, 1);
			}
		}

	}

	public void a(bec var1) {
		this.ac.b(16, Short.valueOf((short) (atr.f(var1) & '\uffff')));
	}

	public bec ck() {
		return atr.d(this.ac.b(16) & '\uffff');
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (var1.j() == null || !(var1.j() instanceof aew)) {
				if (!this.o.D) {
					this.a(true);
				}

				if (var1 instanceof wi && var1.j() instanceof ahd) {
					if (var1.j() instanceof EntityPlayer && ((EntityPlayer) var1.j()).c.d()) {
						this.a(false);
					} else {
						this.bl = true;
					}
				}

				if (var1 instanceof wj) {
					this.bl = false;

					for (int var4 = 0; var4 < 64; ++var4) {
						if (this.n()) {
							return true;
						}
					}

					return false;
				}
			}

			boolean var3 = super.a(var1, var2);
			if (var1.e() && this.V.nextInt(10) != 0) {
				this.n();
			}

			return var3;
		}
	}

	public boolean cm() {
		return this.ac.a(18) > 0;
	}

	public void a(boolean var1) {
		this.ac.b(18, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	// $FF: synthetic method
	static ya cn() {
		return c;
	}

	// $FF: synthetic method
	static boolean a(aer var0, ahd var1) {
		return var0.c(var1);
	}

	// $FF: synthetic method
	static boolean a(aer var0, boolean var1) {
		return var0.bl = var1;
	}

	// $FF: synthetic method
	static Set co() {
		return bk;
	}

	static {
		bk.add(aty.c);
		bk.add(aty.d);
		bk.add(aty.m);
		bk.add(aty.n);
		bk.add(aty.N);
		bk.add(aty.O);
		bk.add(aty.P);
		bk.add(aty.Q);
		bk.add(aty.W);
		bk.add(aty.aK);
		bk.add(aty.aL);
		bk.add(aty.aU);
		bk.add(aty.bk);
		bk.add(aty.bw);
	}
}
