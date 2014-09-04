package net.minecraft;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;

public abstract class ahd extends EntityLiving {

	public ahb bg = new ahb(this);
	private ajh a = new ajh();
	public aib bh;
	public aib bi;
	protected ahz bj = new ahz();
	protected int bk;
	public float bl;
	public float bm;
	public int bn;
	public double bo;
	public double bp;
	public double bq;
	public double br;
	public double bs;
	public double bt;
	protected boolean bu;
	public dt bv;
	private int b;
	public float bw;
	public float bx;
	private dt c;
	private boolean d;
	private dt e;
	public PlayerProperties by = new PlayerProperties();
	public int bz;
	public int bA;
	public float bB;
	private int f;
	private amj g;
	private int h;
	protected float bC = 0.1F;
	protected float bD = 0.02F;
	private int i;
	private final GameProfile bF;
	private boolean bG = false;
	public ado bE;

	public ahd(World var1, GameProfile var2) {
		super(var1);
		this.ao = a(var2);
		this.bF = var2;
		this.bh = new ajb(this.bg, !var1.D, this);
		this.bi = this.bh;
		dt var3 = var1.M();
		this.b((double) var3.n() + 0.5D, (double) (var3.o() + 1), (double) var3.p() + 0.5D, 0.0F, 0.0F);
		this.aT = 180.0F;
		this.X = 20;
	}

	protected void aW() {
		super.aW();
		this.bx().b(afs.e).a(1.0D);
		this.a(afs.d).a(0.10000000149011612D);
	}

	protected void h() {
		super.h();
		this.ac.a(16, Byte.valueOf((byte) 0));
		this.ac.a(17, Float.valueOf(0.0F));
		this.ac.a(18, Integer.valueOf(0));
		this.ac.a(10, Byte.valueOf((byte) 0));
	}

	public boolean bR() {
		return this.g != null;
	}

	public void bT() {
		if (this.g != null) {
			this.g.b(this.o, this, this.h);
		}

		this.bU();
	}

	public void bU() {
		this.g = null;
		this.h = 0;
		if (!this.o.D) {
			this.f(false);
		}

	}

	public boolean bV() {
		return this.bR() && this.g.b().e(this.g) == ano.d;
	}

	public void s_() {
		this.T = this.v();
		if (this.v()) {
			this.C = false;
		}

		if (this.g != null) {
			amj var1 = this.bg.h();
			if (var1 == this.g) {
				if (this.h <= 25 && this.h % 4 == 0) {
					this.b(var1, 5);
				}

				if (--this.h == 0 && !this.o.D) {
					this.s();
				}
			} else {
				this.bU();
			}
		}

		if (this.bn > 0) {
			--this.bn;
		}

		if (this.bI()) {
			++this.b;
			if (this.b > 100) {
				this.b = 100;
			}

			if (!this.o.D) {
				if (!this.p()) {
					this.a(true, true, false);
				} else if (this.o.w()) {
					this.a(false, true, true);
				}
			}
		} else if (this.b > 0) {
			++this.b;
			if (this.b >= 110) {
				this.b = 0;
			}
		}

		super.s_();
		if (!this.o.D && this.bi != null && !this.bi.a(this)) {
			this.n();
			this.bi = this.bh;
		}

		if (this.au() && this.by.invulnerable) {
			this.N();
		}

		this.bo = this.br;
		this.bp = this.bs;
		this.bq = this.bt;
		double var14 = this.s - this.br;
		double var3 = this.t - this.bs;
		double var5 = this.u - this.bt;
		double var7 = 10.0D;
		if (var14 > var7) {
			this.bo = this.br = this.s;
		}

		if (var5 > var7) {
			this.bq = this.bt = this.u;
		}

		if (var3 > var7) {
			this.bp = this.bs = this.t;
		}

		if (var14 < -var7) {
			this.bo = this.br = this.s;
		}

		if (var5 < -var7) {
			this.bq = this.bt = this.u;
		}

		if (var3 < -var7) {
			this.bp = this.bs = this.t;
		}

		this.br += var14 * 0.25D;
		this.bt += var5 * 0.25D;
		this.bs += var3 * 0.25D;
		if (this.m == null) {
			this.e = null;
		}

		if (!this.o.D) {
			this.bj.a(this);
			this.b(ty.g);
			if (this.ai()) {
				this.b(ty.h);
			}
		}

		int var9 = 29999999;
		double var10 = NumberConverter.a(this.s, -2.9999999E7D, 2.9999999E7D);
		double var12 = NumberConverter.a(this.u, -2.9999999E7D, 2.9999999E7D);
		if (var10 != this.s || var12 != this.u) {
			this.b(var10, this.t, var12);
		}

	}

	public int L() {
		return this.by.invulnerable ? 0 : 80;
	}

	protected String P() {
		return "game.player.swim";
	}

	protected String aa() {
		return "game.player.swim.splash";
	}

	public int ar() {
		return 10;
	}

	public void a(String var1, float var2, float var3) {
		this.o.a(this, var1, var2, var3);
	}

	protected void b(amj var1, int var2) {
		if (var1.m() == ano.c) {
			this.a("random.drink", 0.5F, this.o.s.nextFloat() * 0.1F + 0.9F);
		}

		if (var1.m() == ano.b) {
			for (int var3 = 0; var3 < var2; ++var3) {
				brw var4 = new brw(((double) this.V.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
				var4 = var4.a(-this.z * 3.1415927F / 180.0F);
				var4 = var4.b(-this.y * 3.1415927F / 180.0F);
				double var5 = (double) (-this.V.nextFloat()) * 0.6D - 0.3D;
				brw var7 = new brw(((double) this.V.nextFloat() - 0.5D) * 0.3D, var5, 0.6D);
				var7 = var7.a(-this.z * 3.1415927F / 180.0F);
				var7 = var7.b(-this.y * 3.1415927F / 180.0F);
				var7 = var7.b(this.s, this.t + (double) this.aR(), this.u);
				if (var1.f()) {
					this.o.a(ew.K, var7.a, var7.b, var7.c, var4.a, var4.b + 0.05D, var4.c, new int[] { alq.b(var1.b()), var1.i() });
				} else {
					this.o.a(ew.K, var7.a, var7.b, var7.c, var4.a, var4.b + 0.05D, var4.c, new int[] { alq.b(var1.b()) });
				}
			}

			this.a("random.eat", 0.5F + 0.5F * (float) this.V.nextInt(2), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
		}

	}

	protected void s() {
		if (this.g != null) {
			this.b(this.g, 16);
			int var1 = this.g.b;
			amj var2 = this.g.b(this.o, this);
			if (var2 != this.g || var2 != null && var2.b != var1) {
				this.bg.a[this.bg.c] = var2;
				if (var2.b == 0) {
					this.bg.a[this.bg.c] = null;
				}
			}

			this.bU();
		}

	}

	protected boolean bC() {
		return this.bm() <= 0.0F || this.bI();
	}

	protected void n() {
		this.bi = this.bh;
	}

	public void ak() {
		if (!this.o.D && this.aw()) {
			this.a((Entity) null);
			this.c(false);
		} else {
			double var1 = this.s;
			double var3 = this.t;
			double var5 = this.u;
			float var7 = this.y;
			float var8 = this.z;
			super.ak();
			this.bl = this.bm;
			this.bm = 0.0F;
			this.l(this.s - var1, this.t - var3, this.u - var5);
			if (this.m instanceof aca) {
				this.z = var8;
				this.y = var7;
				this.aG = ((aca) this.m).aG;
			}

		}
	}

	protected void bJ() {
		super.bJ();
		this.bw();
		this.aI = this.y;
	}

	public void m() {
		if (this.bk > 0) {
			--this.bk;
		}

		if (this.o.aa() == Difficulty.PEACEFUL && this.o.Q().b("naturalRegeneration")) {
			if (this.bm() < this.bt() && this.W % 20 == 0) {
				this.g(1.0F);
			}

			if (this.bj.c() && this.W % 10 == 0) {
				this.bj.a(this.bj.a() + 1);
			}
		}

		this.bg.k();
		this.bl = this.bm;
		super.m();
		xz var1 = this.a(afs.d);
		if (!this.o.D) {
			var1.a((double) this.by.getWalkSpeed());
		}

		this.aK = this.bD;
		if (this.ax()) {
			this.aK = (float) ((double) this.aK + (double) this.bD * 0.3D);
		}

		this.j((float) var1.e());
		float var2 = NumberConverter.a(this.v * this.v + this.x * this.x);
		float var3 = (float) (Math.atan(-this.w * 0.20000000298023224D) * 15.0D);
		if (var2 > 0.1F) {
			var2 = 0.1F;
		}

		if (!this.C || this.bm() <= 0.0F) {
			var2 = 0.0F;
		}

		if (this.C || this.bm() <= 0.0F) {
			var3 = 0.0F;
		}

		this.bm += (var2 - this.bm) * 0.4F;
		this.aD += (var3 - this.aD) * 0.8F;
		if (this.bm() > 0.0F && !this.v()) {
			brt var4 = null;
			if (this.m != null && !this.m.I) {
				var4 = this.aQ().a(this.m.aQ()).b(1.0D, 0.0D, 1.0D);
			} else {
				var4 = this.aQ().b(1.0D, 0.5D, 1.0D);
			}

			List var5 = this.o.b((Entity) this, var4);

			for (int var6 = 0; var6 < var5.size(); ++var6) {
				Entity var7 = (Entity) var5.get(var6);
				if (!var7.I) {
					this.d(var7);
				}
			}
		}

	}

	private void d(Entity var1) {
		var1.d(this);
	}

	public int bW() {
		return this.ac.c(18);
	}

	public void r(int var1) {
		this.ac.b(18, Integer.valueOf(var1));
	}

	public void s(int var1) {
		int var2 = this.bW();
		this.ac.b(18, Integer.valueOf(var2 + var1));
	}

	public void a(wh var1) {
		super.a(var1);
		this.a(0.2F, 0.2F);
		this.b(this.s, this.t, this.u);
		this.w = 0.10000000149011612D;
		if (this.d_().equals("Notch")) {
			this.a(new amj(amk.e, 1), true, false);
		}

		if (!this.o.Q().b("keepInventory")) {
			this.bg.n();
		}

		if (var1 != null) {
			this.v = (double) (-NumberConverter.b((this.au + this.y) * 3.1415927F / 180.0F) * 0.1F);
			this.x = (double) (-NumberConverter.a((this.au + this.y) * 3.1415927F / 180.0F) * 0.1F);
		} else {
			this.v = this.x = 0.0D;
		}

		this.b(ty.y);
		this.a(ty.h);
	}

	protected String bn() {
		return "game.player.hurt";
	}

	protected String bo() {
		return "game.player.die";
	}

	public void b(Entity var1, int var2) {
		this.s(var2);
		Collection var3 = this.co().a(bsk.f);
		if (var1 instanceof ahd) {
			this.b(ty.B);
			var3.addAll(this.co().a(bsk.e));
			var3.addAll(this.e(var1));
		} else {
			this.b(ty.z);
		}

		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			bry var5 = (bry) var4.next();
			bsa var6 = this.co().c(this.d_(), var5);
			var6.a();
		}

	}

	private Collection e(Entity var1) {
		brz var2 = this.co().h(this.d_());
		if (var2 != null) {
			int var3 = var2.l().b();
			if (var3 >= 0 && var3 < bsk.i.length) {
				Iterator var4 = this.co().a(bsk.i[var3]).iterator();

				while (var4.hasNext()) {
					bry var5 = (bry) var4.next();
					bsa var6 = this.co().c(var1.d_(), var5);
					var6.a();
				}
			}
		}

		brz var7 = this.co().h(var1.d_());
		if (var7 != null) {
			int var8 = var7.l().b();
			if (var8 >= 0 && var8 < bsk.h.length) {
				return this.co().a(bsk.h[var8]);
			}
		}

		return Lists.newArrayList();
	}

	public adw a(boolean var1) {
		return this.a(this.bg.a(this.bg.c, var1 && this.bg.h() != null ? this.bg.h().b : 1), false, true);
	}

	public adw a(amj var1, boolean var2) {
		return this.a(var1, false, false);
	}

	public adw a(amj var1, boolean var2, boolean var3) {
		if (var1 == null) {
			return null;
		} else if (var1.b == 0) {
			return null;
		} else {
			double var4 = this.t - 0.30000001192092896D + (double) this.aR();
			adw var6 = new adw(this.o, this.s, var4, this.u, var1);
			var6.a(40);
			if (var3) {
				var6.c(this.d_());
			}

			float var7;
			float var8;
			if (var2) {
				var7 = this.V.nextFloat() * 0.5F;
				var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
				var6.v = (double) (-NumberConverter.a(var8) * var7);
				var6.x = (double) (NumberConverter.b(var8) * var7);
				var6.w = 0.20000000298023224D;
			} else {
				var7 = 0.3F;
				var6.v = (double) (-NumberConverter.a(this.y / 180.0F * 3.1415927F) * NumberConverter.b(this.z / 180.0F * 3.1415927F) * var7);
				var6.x = (double) (NumberConverter.b(this.y / 180.0F * 3.1415927F) * NumberConverter.b(this.z / 180.0F * 3.1415927F) * var7);
				var6.w = (double) (-NumberConverter.a(this.z / 180.0F * 3.1415927F) * var7 + 0.1F);
				var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
				var7 = 0.02F * this.V.nextFloat();
				var6.v += Math.cos((double) var8) * (double) var7;
				var6.w += (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.1F);
				var6.x += Math.sin((double) var8) * (double) var7;
			}

			this.a(var6);
			if (var3) {
				this.b(ty.v);
			}

			return var6;
		}
	}

	protected void a(adw var1) {
		this.o.d((Entity) var1);
	}

	public float a(atr var1) {
		float var2 = this.bg.a(var1);
		if (var2 > 1.0F) {
			int var3 = aph.c(this);
			amj var4 = this.bg.h();
			if (var3 > 0 && var4 != null) {
				var2 += (float) (var3 * var3 + 1);
			}
		}

		if (this.a(wp.e)) {
			var2 *= 1.0F + (float) (this.b(wp.e).c() + 1) * 0.2F;
		}

		if (this.a(wp.f)) {
			float var5 = 1.0F;
			switch (this.b(wp.f).c()) {
				case 0:
					var5 = 0.3F;
					break;
				case 1:
					var5 = 0.09F;
					break;
				case 2:
					var5 = 0.0027F;
					break;
				case 3:
				default:
					var5 = 8.1E-4F;
			}

			var2 *= var5;
		}

		if (this.a(bof.h) && !aph.j(this)) {
			var2 /= 5.0F;
		}

		if (!this.C) {
			var2 /= 5.0F;
		}

		return var2;
	}

	public boolean b(atr var1) {
		return this.bg.b(var1);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.ao = a(this.bF);
		NBTListTag var2 = var1.getList("Inventory", 10);
		this.bg.b(var2);
		this.bg.c = var1.getInt("SelectedItemSlot");
		this.bu = var1.getBoolean("Sleeping");
		this.b = var1.getShort("SleepTimer");
		this.bB = var1.getFloat("XpP");
		this.bz = var1.getInt("XpLevel");
		this.bA = var1.getInt("XpTotal");
		this.f = var1.getInt("XpSeed");
		if (this.f == 0) {
			this.f = this.V.nextInt();
		}

		this.r(var1.getInt("Score"));
		if (this.bu) {
			this.bv = new dt(this);
			this.a(true, true, false);
		}

		if (var1.isTagAssignableFrom("SpawnX", 99) && var1.isTagAssignableFrom("SpawnY", 99) && var1.isTagAssignableFrom("SpawnZ", 99)) {
			this.c = new dt(var1.getInt("SpawnX"), var1.getInt("SpawnY"), var1.getInt("SpawnZ"));
			this.d = var1.getBoolean("SpawnForced");
		}

		this.bj.a(var1);
		this.by.read(var1);
		if (var1.isTagAssignableFrom("EnderItems", 9)) {
			NBTListTag var3 = var1.getList("EnderItems", 10);
			this.a.a(var3);
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Inventory", (NBTTag) this.bg.a(new NBTListTag()));
		var1.put("SelectedItemSlot", this.bg.c);
		var1.put("Sleeping", this.bu);
		var1.put("SleepTimer", (short) this.b);
		var1.put("XpP", this.bB);
		var1.put("XpLevel", this.bz);
		var1.put("XpTotal", this.bA);
		var1.put("XpSeed", this.f);
		var1.put("Score", this.bW());
		if (this.c != null) {
			var1.put("SpawnX", this.c.n());
			var1.put("SpawnY", this.c.o());
			var1.put("SpawnZ", this.c.p());
			var1.put("SpawnForced", this.d);
		}

		this.bj.b(var1);
		this.by.write(var1);
		var1.put("EnderItems", (NBTTag) this.a.h());
		amj var2 = this.bg.h();
		if (var2 != null && var2.b() != null) {
			var1.put("SelectedItem", (NBTTag) var2.b(new NBTCompoundTag()));
		}

	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (this.by.invulnerable && !var1.g()) {
			return false;
		} else {
			this.aO = 0;
			if (this.bm() <= 0.0F) {
				return false;
			} else {
				if (this.bI() && !this.o.D) {
					this.a(true, true, false);
				}

				if (var1.r()) {
					if (this.o.aa() == Difficulty.PEACEFUL) {
						var2 = 0.0F;
					}

					if (this.o.aa() == Difficulty.EASY) {
						var2 = var2 / 2.0F + 1.0F;
					}

					if (this.o.aa() == Difficulty.HARD) {
						var2 = var2 * 3.0F / 2.0F;
					}
				}

				if (var2 == 0.0F) {
					return false;
				} else {
					Entity var3 = var1.j();
					if (var3 instanceof ahj && ((ahj) var3).c != null) {
						var3 = ((ahj) var3).c;
					}

					return super.a(var1, var2);
				}
			}
		}
	}

	public boolean a(ahd var1) {
		bsf var2 = this.bN();
		bsf var3 = var1.bN();
		return var2 == null ? true : (!var2.a(var3) ? true : var2.g());
	}

	protected void i(float var1) {
		this.bg.a(var1);
	}

	public int bq() {
		return this.bg.m();
	}

	public float bX() {
		int var1 = 0;
		amj[] var2 = this.bg.b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			amj var5 = var2[var4];
			if (var5 != null) {
				++var1;
			}
		}

		return (float) var1 / (float) this.bg.b.length;
	}

	protected void d(wh var1, float var2) {
		if (!this.b(var1)) {
			if (!var1.e() && this.bV() && var2 > 0.0F) {
				var2 = (1.0F + var2) * 0.5F;
			}

			var2 = this.b(var1, var2);
			var2 = this.c(var1, var2);
			float var3 = var2;
			var2 = Math.max(var2 - this.bM(), 0.0F);
			this.l(this.bM() - (var3 - var2));
			if (var2 != 0.0F) {
				this.a(var1.f());
				float var4 = this.bm();
				this.h(this.bm() - var2);
				this.br().a(var1, var4, var2);
				if (var2 < 3.4028235E37F) {
					this.a(ty.x, Math.round(var2 * 10.0F));
				}

			}
		}
	}

	public void a(bdj var1) {
	}

	public void a(aqf var1) {
	}

	public void a(aqb var1) {
	}

	public void a(vq var1) {
	}

	public void a(abt var1, vq var2) {
	}

	public void a(vv var1) {
	}

	public void a(amj var1) {
	}

	public boolean u(Entity var1) {
		if (this.v()) {
			if (var1 instanceof vq) {
				this.a((vq) var1);
			}

			return false;
		} else {
			amj var2 = this.bY();
			amj var3 = var2 != null ? var2.k() : null;
			if (!var1.e(this)) {
				if (var2 != null && var1 instanceof EntityLiving) {
					if (this.by.instabuild) {
						var2 = var3;
					}

					if (var2.a(this, (EntityLiving) var1)) {
						if (var2.b <= 0 && !this.by.instabuild) {
							this.bZ();
						}

						return true;
					}
				}

				return false;
			} else {
				if (var2 != null && var2 == this.bY()) {
					if (var2.b <= 0 && !this.by.instabuild) {
						this.bZ();
					} else if (var2.b < var3.b && this.by.instabuild) {
						var2.b = var3.b;
					}
				}

				return true;
			}
		}
	}

	public amj bY() {
		return this.bg.h();
	}

	public void bZ() {
		this.bg.a(this.bg.c, (amj) null);
	}

	public double am() {
		return -0.35D;
	}

	public void f(Entity var1) {
		if (var1.aE()) {
			if (!var1.l(this)) {
				float var2 = (float) this.a(afs.e).e();
				byte var3 = 0;
				float var4 = 0.0F;
				if (var1 instanceof EntityLiving) {
					var4 = aph.a(this.bz(), ((EntityLiving) var1).by());
				} else {
					var4 = aph.a(this.bz(), xs.a);
				}

				int var18 = var3 + aph.a((EntityLiving) this);
				if (this.ax()) {
					++var18;
				}

				if (var2 > 0.0F || var4 > 0.0F) {
					boolean var5 = this.O > 0.0F && !this.C && !this.j_() && !this.V() && !this.a(wp.q) && this.m == null && var1 instanceof EntityLiving;
					if (var5 && var2 > 0.0F) {
						var2 *= 1.5F;
					}

					var2 += var4;
					boolean var6 = false;
					int var7 = aph.b((EntityLiving) this);
					if (var1 instanceof EntityLiving && var7 > 0 && !var1.au()) {
						var6 = true;
						var1.e(1);
					}

					double var8 = var1.v;
					double var10 = var1.w;
					double var12 = var1.x;
					boolean var14 = var1.a(wh.a(this), var2);
					if (var14) {
						if (var18 > 0) {
							var1.g((double) (-NumberConverter.a(this.y * 3.1415927F / 180.0F) * (float) var18 * 0.5F), 0.1D, (double) (NumberConverter.b(this.y * 3.1415927F / 180.0F) * (float) var18 * 0.5F));
							this.v *= 0.6D;
							this.x *= 0.6D;
							this.d(false);
						}

						if (var1 instanceof EntityPlayer && var1.G) {
							((EntityPlayer) var1).a.a((id) (new kz(var1)));
							var1.G = false;
							var1.v = var8;
							var1.w = var10;
							var1.x = var12;
						}

						if (var5) {
							this.b(var1);
						}

						if (var4 > 0.0F) {
							this.c(var1);
						}

						if (var2 >= 18.0F) {
							this.b((PlayerStatistic) tl.F);
						}

						this.p(var1);
						if (var1 instanceof EntityLiving) {
							aph.a((EntityLiving) var1, (Entity) this);
						}

						aph.b(this, var1);
						amj var15 = this.bY();
						Object var16 = var1;
						if (var1 instanceof acz) {
							acy var17 = ((acz) var1).a;
							if (var17 instanceof EntityLiving) {
								var16 = (EntityLiving) var17;
							}
						}

						if (var15 != null && var16 instanceof EntityLiving) {
							var15.a((EntityLiving) var16, this);
							if (var15.b <= 0) {
								this.bZ();
							}
						}

						if (var1 instanceof EntityLiving) {
							this.a(ty.w, Math.round(var2 * 10.0F));
							if (var7 > 0) {
								var1.e(var7 * 4);
							}
						}

						this.a(0.3F);
					} else if (var6) {
						var1.N();
					}
				}

			}
		}
	}

	public void b(Entity var1) {
	}

	public void c(Entity var1) {
	}

	public void J() {
		super.J();
		this.bh.b(this);
		if (this.bi != null) {
			this.bi.b(this);
		}

	}

	public boolean aj() {
		return !this.bu && super.aj();
	}

	public GameProfile cc() {
		return this.bF;
	}

	public ahf a(dt var1) {
		if (!this.o.D) {
			if (this.bI() || !this.ai()) {
				return ahf.e;
			}

			if (!this.o.t.d()) {
				return ahf.b;
			}

			if (this.o.w()) {
				return ahf.c;
			}

			if (Math.abs(this.s - (double) var1.n()) > 3.0D || Math.abs(this.t - (double) var1.o()) > 2.0D || Math.abs(this.u - (double) var1.p()) > 3.0D) {
				return ahf.d;
			}

			double var2 = 8.0D;
			double var4 = 5.0D;
			List var6 = this.o.a(afm.class, new brt((double) var1.n() - var2, (double) var1.o() - var4, (double) var1.p() - var2, (double) var1.n() + var2, (double) var1.o() + var4, (double) var1.p() + var2));
			if (!var6.isEmpty()) {
				return ahf.f;
			}
		}

		if (this.av()) {
			this.a((Entity) null);
		}

		this.a(0.2F, 0.2F);
		if (this.o.e(var1)) {
			ej var7 = (ej) this.o.p(var1).b(avb.N);
			float var3 = 0.5F;
			float var8 = 0.5F;
			switch (ahe.a[var7.ordinal()]) {
				case 1:
					var8 = 0.9F;
					break;
				case 2:
					var8 = 0.1F;
					break;
				case 3:
					var3 = 0.1F;
					break;
				case 4:
					var3 = 0.9F;
			}

			this.a(var7);
			this.b((double) ((float) var1.n() + var3), (double) ((float) var1.o() + 0.6875F), (double) ((float) var1.p() + var8));
		} else {
			this.b((double) ((float) var1.n() + 0.5F), (double) ((float) var1.o() + 0.6875F), (double) ((float) var1.p() + 0.5F));
		}

		this.bu = true;
		this.b = 0;
		this.bv = var1;
		this.v = this.x = this.w = 0.0D;
		if (!this.o.D) {
			this.o.d();
		}

		return ahf.a;
	}

	private void a(ej var1) {
		this.bw = 0.0F;
		this.bx = 0.0F;
		switch (ahe.a[var1.ordinal()]) {
			case 1:
				this.bx = -1.8F;
				break;
			case 2:
				this.bx = 1.8F;
				break;
			case 3:
				this.bw = 1.8F;
				break;
			case 4:
				this.bw = -1.8F;
		}

	}

	public void a(boolean var1, boolean var2, boolean var3) {
		this.a(0.6F, 1.8F);
		bec var4 = this.o.p(this.bv);
		if (this.bv != null && var4.c() == aty.C) {
			this.o.a(this.bv, var4.a(atp.b, Boolean.valueOf(false)), 4);
			dt var5 = atp.a(this.o, this.bv, 0);
			if (var5 == null) {
				var5 = this.bv.a();
			}

			this.b((double) ((float) var5.n() + 0.5F), (double) ((float) var5.o() + 0.1F), (double) ((float) var5.p() + 0.5F));
		}

		this.bu = false;
		if (!this.o.D && var2) {
			this.o.d();
		}

		this.b = var1 ? 0 : 100;
		if (var3) {
			this.a(this.bv, false);
		}

	}

	private boolean p() {
		return this.o.p(this.bv).c() == aty.C;
	}

	public static dt a(World var0, dt var1, boolean var2) {
		if (var0.p(var1).c() != aty.C) {
			if (!var2) {
				return null;
			} else {
				bof var3 = var0.p(var1).c().r();
				bof var4 = var0.p(var1.a()).c().r();
				boolean var5 = !var3.a() && !var3.d();
				boolean var6 = !var4.a() && !var4.d();
				return var5 && var6 ? var1 : null;
			}
		} else {
			return atp.a(var0, var1, 0);
		}
	}

	public boolean bI() {
		return this.bu;
	}

	public boolean ce() {
		return this.bu && this.b >= 100;
	}

	public void b(ho var1) {
	}

	public dt cg() {
		return this.c;
	}

	public boolean ch() {
		return this.d;
	}

	public void a(dt var1, boolean var2) {
		if (var1 != null) {
			this.c = var1;
			this.d = var2;
		} else {
			this.c = null;
			this.d = false;
		}

	}

	public void b(PlayerStatistic var1) {
		this.a(var1, 1);
	}

	public void a(PlayerStatistic var1, int var2) {
	}

	public void a(PlayerStatistic var1) {
	}

	public void bE() {
		super.bE();
		this.b(ty.u);
		if (this.ax()) {
			this.a(0.8F);
		} else {
			this.a(0.2F);
		}

	}

	public void g(float var1, float var2) {
		double var3 = this.s;
		double var5 = this.t;
		double var7 = this.u;
		if (this.by.flying && this.m == null) {
			double var9 = this.w;
			float var11 = this.aK;
			this.aK = this.by.getFlySpeed() * (float) (this.ax() ? 2 : 1);
			super.g(var1, var2);
			this.w = var9 * 0.6D;
			this.aK = var11;
		} else {
			super.g(var1, var2);
		}

		this.k(this.s - var3, this.t - var5, this.u - var7);
	}

	public float bH() {
		return (float) this.a(afs.d).e();
	}

	public void k(double var1, double var3, double var5) {
		if (this.m == null) {
			int var7;
			if (this.a(bof.h)) {
				var7 = Math.round(NumberConverter.a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
				if (var7 > 0) {
					this.a(ty.p, var7);
					this.a(0.015F * (float) var7 * 0.01F);
				}
			} else if (this.V()) {
				var7 = Math.round(NumberConverter.a(var1 * var1 + var5 * var5) * 100.0F);
				if (var7 > 0) {
					this.a(ty.l, var7);
					this.a(0.015F * (float) var7 * 0.01F);
				}
			} else if (this.j_()) {
				if (var3 > 0.0D) {
					this.a(ty.n, (int) Math.round(var3 * 100.0D));
				}
			} else if (this.C) {
				var7 = Math.round(NumberConverter.a(var1 * var1 + var5 * var5) * 100.0F);
				if (var7 > 0) {
					this.a(ty.i, var7);
					if (this.ax()) {
						this.a(ty.k, var7);
						this.a(0.099999994F * (float) var7 * 0.01F);
					} else {
						if (this.aw()) {
							this.a(ty.j, var7);
						}

						this.a(0.01F * (float) var7 * 0.01F);
					}
				}
			} else {
				var7 = Math.round(NumberConverter.a(var1 * var1 + var5 * var5) * 100.0F);
				if (var7 > 25) {
					this.a(ty.o, var7);
				}
			}

		}
	}

	private void l(double var1, double var3, double var5) {
		if (this.m != null) {
			int var7 = Math.round(NumberConverter.a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
			if (var7 > 0) {
				if (this.m instanceof adx) {
					this.a(ty.q, var7);
					if (this.e == null) {
						this.e = new dt(this);
					} else if (this.e.c((double) NumberConverter.c(this.s), (double) NumberConverter.c(this.t), (double) NumberConverter.c(this.u)) >= 1000000.0D) {
						this.b((PlayerStatistic) tl.q);
					}
				} else if (this.m instanceof adu) {
					this.a(ty.r, var7);
				} else if (this.m instanceof aca) {
					this.a(ty.s, var7);
				} else if (this.m instanceof abt) {
					this.a(ty.t, var7);
				}
			}
		}

	}

	public void e(float var1, float var2) {
		if (!this.by.mayfly) {
			if (var1 >= 2.0F) {
				this.a(ty.m, (int) Math.round((double) var1 * 100.0D));
			}

			super.e(var1, var2);
		}
	}

	protected void X() {
		if (!this.v()) {
			super.X();
		}

	}

	protected String n(int var1) {
		return var1 > 4 ? "game.player.hurt.fall.big" : "game.player.hurt.fall.small";
	}

	public void a(EntityLiving var1) {
		if (var1 instanceof aex) {
			this.b((PlayerStatistic) tl.s);
		}

		xc var2 = (xc) xb.a.get(Integer.valueOf(xb.a(var1)));
		if (var2 != null) {
			this.b(var2.d);
		}

	}

	public void aB() {
		if (!this.by.flying) {
			super.aB();
		}

	}

	public amj q(int var1) {
		return this.bg.e(var1);
	}

	public void u(int var1) {
		this.s(var1);
		int var2 = Integer.MAX_VALUE - this.bA;
		if (var1 > var2) {
			var1 = var2;
		}

		this.bB += (float) var1 / (float) this.cj();

		for (this.bA += var1; this.bB >= 1.0F; this.bB /= (float) this.cj()) {
			this.bB = (this.bB - 1.0F) * (float) this.cj();
			this.a(1);
		}

	}

	public int ci() {
		return this.f;
	}

	public void b(int var1) {
		this.bz -= var1;
		if (this.bz < 0) {
			this.bz = 0;
			this.bB = 0.0F;
			this.bA = 0;
		}

		this.f = this.V.nextInt();
	}

	public void a(int var1) {
		this.bz += var1;
		if (this.bz < 0) {
			this.bz = 0;
			this.bB = 0.0F;
			this.bA = 0;
		}

		if (var1 > 0 && this.bz % 5 == 0 && (float) this.i < (float) this.W - 100.0F) {
			float var2 = this.bz > 30 ? 1.0F : (float) this.bz / 30.0F;
			this.o.a((Entity) this, "random.levelup", var2 * 0.75F, 1.0F);
			this.i = this.W;
		}

	}

	public int cj() {
		return this.bz >= 30 ? 112 + (this.bz - 30) * 9 : (this.bz >= 15 ? 37 + (this.bz - 15) * 5 : 7 + this.bz * 2);
	}

	public void a(float var1) {
		if (!this.by.invulnerable) {
			if (!this.o.D) {
				this.bj.a(var1);
			}

		}
	}

	public ahz ck() {
		return this.bj;
	}

	public boolean j(boolean var1) {
		return (var1 || this.bj.c()) && !this.by.invulnerable;
	}

	public boolean cl() {
		return this.bm() > 0.0F && this.bm() < this.bt();
	}

	public void a(amj var1, int var2) {
		if (var1 != this.g) {
			this.g = var1;
			this.h = var2;
			if (!this.o.D) {
				this.f(true);
			}

		}
	}

	public boolean cm() {
		return this.by.maybuild;
	}

	public boolean a(dt var1, ej var2, amj var3) {
		if (this.by.maybuild) {
			return true;
		} else if (var3 == null) {
			return false;
		} else {
			dt var4 = var1.a(var2.d());
			atr var5 = this.o.p(var4).c();
			return var3.d(var5) || var3.x();
		}
	}

	protected int b(ahd var1) {
		if (this.o.Q().b("keepInventory")) {
			return 0;
		} else {
			int var2 = this.bz * 7;
			return var2 > 100 ? 100 : var2;
		}
	}

	protected boolean ba() {
		return true;
	}

	public void a(ahd var1, boolean var2) {
		if (var2) {
			this.bg.b(var1.bg);
			this.h(var1.bm());
			this.bj = var1.bj;
			this.bz = var1.bz;
			this.bA = var1.bA;
			this.bB = var1.bB;
			this.r(var1.bW());
			this.an = var1.an;
		} else if (this.o.Q().b("keepInventory")) {
			this.bg.b(var1.bg);
			this.bz = var1.bz;
			this.bA = var1.bA;
			this.bB = var1.bB;
			this.r(var1.bW());
		}

		this.a = var1.a;
		this.H().b(10, Byte.valueOf(var1.H().a(10)));
	}

	protected boolean r_() {
		return !this.by.flying;
	}

	public void t() {
	}

	public void a(GameMode var1) {
	}

	public String d_() {
		return this.bF.getName();
	}

	public ajh cn() {
		return this.a;
	}

	public amj p(int var1) {
		return var1 == 0 ? this.bg.h() : this.bg.b[var1 - 1];
	}

	public amj bz() {
		return this.bg.h();
	}

	public void c(int var1, amj var2) {
		this.bg.b[var1] = var2;
	}

	public abstract boolean v();

	public amj[] at() {
		return this.bg.b;
	}

	public boolean aK() {
		return !this.by.flying;
	}

	public bsd co() {
		return this.o.Z();
	}

	public bsf bN() {
		return this.co().h(this.d_());
	}

	public ho e_() {
		hy var1 = new hy(brz.a(this.bN(), this.d_()));
		var1.b().a(new hm(hn.e, "/msg " + this.d_() + " "));
		var1.b().a(this.aP());
		var1.b().a(this.d_());
		return var1;
	}

	public float aR() {
		float var1 = 1.62F;
		if (this.bI()) {
			var1 = 0.2F;
		}

		if (this.aw()) {
			var1 -= 0.08F;
		}

		return var1;
	}

	public void l(float var1) {
		if (var1 < 0.0F) {
			var1 = 0.0F;
		}

		this.H().b(17, Float.valueOf(var1));
	}

	public float bM() {
		return this.H().d(17);
	}

	public static UUID a(GameProfile var0) {
		UUID var1 = var0.getId();
		if (var1 == null) {
			var1 = b(var0.getName());
		}

		return var1;
	}

	public static UUID b(String var0) {
		return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes(Charsets.UTF_8));
	}

	public boolean a(vx var1) {
		if (var1.a()) {
			return true;
		} else {
			amj var2 = this.bY();
			return var2 != null && var2.s() ? var2.q().equals(var1.b()) : false;
		}
	}

	public boolean t_() {
		return MinecraftServer.getInstance().worlds[0].Q().b("sendCommandFeedback");
	}

	public boolean d(int var1, amj var2) {
		if (var1 >= 0 && var1 < this.bg.a.length) {
			this.bg.a(var1, var2);
			return true;
		} else {
			int var3 = var1 - 100;
			int var4;
			if (var3 >= 0 && var3 < this.bg.b.length) {
				var4 = var3 + 1;
				if (var2 != null && var2.b() != null) {
					if (var2.b() instanceof ajn) {
						if (xn.c(var2) != var4) {
							return false;
						}
					} else if (var4 != 4 || var2.b() != amk.bX && !(var2.b() instanceof aju)) {
						return false;
					}
				}

				this.bg.a(var3 + this.bg.a.length, var2);
				return true;
			} else {
				var4 = var1 - 200;
				if (var4 >= 0 && var4 < this.a.n_()) {
					this.a.a(var4, var2);
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
