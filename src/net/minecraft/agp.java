package net.minecraft;

import java.util.Iterator;

public class agp extends ws implements ago, aqb {

	private int bl;
	private boolean bm;
	private boolean bn;
	abi bk;
	private ahd bo;
	private aqd bp;
	private int bq;
	private boolean br;
	private boolean bs;
	private int bt;
	private String bu;
	private int bv;
	private int bw;
	private boolean bx;
	private boolean by;
	private wa bz;
	private static final agw[][][][] bA = new agw[][][][] {
			{
					{ { new agr(amk.O, new agx(18, 22)), new agr(amk.bS, new agx(15, 19)), new agr(amk.bR, new agx(15, 19)), new agv(amk.P, new agx(-4, -2)) }, { new agr(alq.a(aty.aU), new agx(8, 13)), new agv(amk.ca, new agx(-3, -2)) }, { new agr(alq.a(aty.bk), new agx(7, 12)), new agv(amk.e, new agx(-5, -7)) }, { new agv(amk.bc, new agx(-6, -10)), new agv(amk.aZ, new agx(1, 1)) } },
					{ { new agr(amk.F, new agx(15, 20)), new agr(amk.h, new agx(16, 24)), new agu(amk.aU, new agx(6, 6), amk.aV, new agx(6, 6)) }, { new agt(amk.aR, new agx(7, 8)) } },
					{
							{ new agr(alq.a(aty.L), new agx(16, 22)), new agv(amk.be, new agx(3, 4)) },
							{ new agv(new amj(alq.a(aty.L), 1, 0), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 1), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 2), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 3), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 4), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 5), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 6), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 7), new agx(1, 2)),
									new agv(new amj(alq.a(aty.L), 1, 8), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 9), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 10), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 11), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 12), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 13), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 14), new agx(1, 2)), new agv(new amj(alq.a(aty.L), 1, 15), new agx(1, 2)) } },
					{ { new agr(amk.F, new agx(15, 20)), new agv(amk.g, new agx(-12, -8)) }, { new agv(amk.f, new agx(2, 3)), new agu(alq.a(aty.n), new agx(10, 10), amk.ak, new agx(6, 10)) } } },
			{ { { new agr(amk.aK, new agx(24, 36)), new ags() }, { new agr(amk.aL, new agx(8, 10)), new agv(amk.aQ, new agx(10, 12)), new agv(alq.a(aty.X), new agx(3, 4)) }, { new agr(amk.bN, new agx(2, 2)), new agv(amk.aS, new agx(10, 12)), new agv(alq.a(aty.w), new agx(-5, -3)) }, { new ags() }, { new ags() }, { new agv(amk.co, new agx(20, 22)) } } },
			{ { { new agr(amk.bt, new agx(36, 40)), new agr(amk.k, new agx(8, 10)) }, { new agv(amk.aC, new agx(-4, -1)), new agv(new amj(amk.aW, 1, akv.l.b()), new agx(-2, -1)) }, { new agv(amk.bH, new agx(7, 11)), new agv(alq.a(aty.aX), new agx(-3, -1)) }, { new agv(amk.bK, new agx(3, 11)) } } },
			{ { { new agr(amk.h, new agx(16, 24)), new agv(amk.Y, new agx(4, 6)) }, { new agr(amk.j, new agx(7, 9)), new agv(amk.Z, new agx(10, 14)) }, { new agr(amk.i, new agx(3, 4)), new agt(amk.ad, new agx(16, 19)) }, { new agv(amk.X, new agx(5, 7)), new agv(amk.W, new agx(9, 11)), new agv(amk.U, new agx(5, 7)), new agv(amk.V, new agx(11, 15)) } },
					{ { new agr(amk.h, new agx(16, 24)), new agv(amk.c, new agx(6, 8)) }, { new agr(amk.j, new agx(7, 9)), new agt(amk.l, new agx(9, 10)) }, { new agr(amk.i, new agx(3, 4)), new agt(amk.u, new agx(12, 15)), new agt(amk.x, new agx(9, 12)) } }, { { new agr(amk.h, new agx(16, 24)), new agt(amk.a, new agx(5, 7)) }, { new agr(amk.j, new agx(7, 9)), new agt(amk.b, new agx(9, 11)) }, { new agr(amk.i, new agx(3, 4)), new agt(amk.w, new agx(12, 15)) } } },
			{ { { new agr(amk.al, new agx(14, 18)), new agr(amk.bk, new agx(14, 18)) }, { new agr(amk.h, new agx(16, 24)), new agv(amk.am, new agx(-7, -5)), new agv(amk.bl, new agx(-8, -6)) } }, { { new agr(amk.aF, new agx(9, 12)), new agv(amk.S, new agx(2, 4)) }, { new agt(amk.R, new agx(7, 12)) }, { new agv(amk.aA, new agx(8, 10)) } } } };

	public agp(World var1) {
		this(var1, 0);
	}

	public agp(World var1, int var2) {
		super(var1);
		this.bz = new wa("Items", false, 8);
		this.r(var2);
		this.a(0.6F, 1.8F);
		((aay) this.s()).b(true);
		((aay) this.s()).a(true);
		this.i.a(0, new yy(this));
		this.i.a(1, new yp(this, new agq(this), 8.0F, 0.6D, 0.6D));
		this.i.a(1, new aah(this));
		this.i.a(1, new zi(this));
		this.i.a(2, new zl(this));
		this.i.a(3, new aaa(this));
		this.i.a(4, new zt(this, true));
		this.i.a(5, new zo(this, 0.6D));
		this.i.a(6, new zj(this));
		this.i.a(7, new aaf(this));
		this.i.a(9, new zf(this, ahd.class, 3.0F, 1.0F));
		this.i.a(9, new aai(this));
		this.i.a(9, new zy(this, 0.6D));
		this.i.a(10, new zh(this, xn.class, 8.0F));
		this.j(true);
	}

	private void ct() {
		if (!this.by) {
			this.by = true;
			if (this.i_()) {
				this.i.a(8, new zv(this, 0.32D));
			} else if (this.cj() == 0) {
				this.i.a(6, new ze(this, 0.6D));
			}

		}
	}

	protected void n() {
		if (this.cj() == 0) {
			this.i.a(8, new ze(this, 0.6D));
		}

		super.n();
	}

	protected void aW() {
		super.aW();
		this.a(afs.d).a(0.5D);
	}

	protected void E() {
		if (--this.bl <= 0) {
			dt var1 = new dt(this);
			this.o.ae().a(var1);
			this.bl = 70 + this.V.nextInt(50);
			this.bk = this.o.ae().a(var1, 32);
			if (this.bk == null) {
				this.ch();
			} else {
				dt var2 = this.bk.a();
				this.a(var2, (int) ((float) this.bk.b() * 1.0F));
				if (this.bx) {
					this.bx = false;
					this.bk.b(5);
				}
			}
		}

		if (!this.cm() && this.bq > 0) {
			--this.bq;
			if (this.bq <= 0) {
				if (this.br) {
					Iterator var3 = this.bp.iterator();

					while (var3.hasNext()) {
						aqc var4 = (aqc) var3.next();
						if (var4.h()) {
							var4.a(this.V.nextInt(6) + this.V.nextInt(6) + 2);
						}
					}

					this.cu();
					this.br = false;
					if (this.bk != null && this.bu != null) {
						this.o.a((Entity) this, (byte) 14);
						this.bk.a(this.bu, 1);
					}
				}

				this.c(new wq(wp.l.H, 200, 0));
			}
		}

		super.E();
	}

	public boolean a(ahd var1) {
		amj var2 = var1.bg.h();
		boolean var3 = var2 != null && var2.b() == amk.bJ;
		if (!var3 && this.ai() && !this.cm() && !this.i_()) {
			if (!this.o.D && (this.bp == null || this.bp.size() > 0)) {
				this.a_(var1);
				var1.a((aqb) this);
			}

			var1.b(ty.F);
			return true;
		} else {
			return super.a(var1);
		}
	}

	protected void h() {
		super.h();
		this.ac.a(16, Integer.valueOf(0));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Profession", this.cj());
		var1.put("Riches", this.bt);
		var1.put("Career", this.bv);
		var1.put("CareerLevel", this.bw);
		var1.put("Willing", this.bs);
		if (this.bp != null) {
			var1.put("Offers", (NBTTag) this.bp.a());
		}

		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.bz.n_(); ++var3) {
			amj var4 = this.bz.a(var3);
			if (var4 != null) {
				var2.addTag((NBTTag) var4.b(new NBTCompoundTag()));
			}
		}

		var1.put("Inventory", (NBTTag) var2);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.r(var1.f("Profession"));
		this.bt = var1.f("Riches");
		this.bv = var1.f("Career");
		this.bw = var1.f("CareerLevel");
		this.bs = var1.n("Willing");
		if (var1.b("Offers", 10)) {
			NBTCompoundTag var2 = var1.m("Offers");
			this.bp = new aqd(var2);
		}

		NBTListTag var5 = var1.c("Inventory", 10);

		for (int var3 = 0; var3 < var5.getSize(); ++var3) {
			amj var4 = amj.a(var5.getCompound(var3));
			if (var4 != null) {
				this.bz.a(var4);
			}
		}

		this.j(true);
		this.ct();
	}

	protected boolean C() {
		return false;
	}

	protected String z() {
		return this.cm() ? "mob.villager.haggle" : "mob.villager.idle";
	}

	protected String bn() {
		return "mob.villager.hit";
	}

	protected String bo() {
		return "mob.villager.death";
	}

	public void r(int var1) {
		this.ac.b(16, Integer.valueOf(var1));
	}

	public int cj() {
		return Math.max(this.ac.c(16) % 5, 0);
	}

	public boolean ck() {
		return this.bm;
	}

	public void l(boolean var1) {
		this.bm = var1;
	}

	public void m(boolean var1) {
		this.bn = var1;
	}

	public boolean cl() {
		return this.bn;
	}

	public void b(EntityLiving var1) {
		super.b(var1);
		if (this.bk != null && var1 != null) {
			this.bk.a(var1);
			if (var1 instanceof ahd) {
				byte var2 = -1;
				if (this.i_()) {
					var2 = -3;
				}

				this.bk.a(var1.d_(), var2);
				if (this.ai()) {
					this.o.a((Entity) this, (byte) 13);
				}
			}
		}

	}

	public void a(wh var1) {
		if (this.bk != null) {
			Entity var2 = var1.j();
			if (var2 != null) {
				if (var2 instanceof ahd) {
					this.bk.a(var2.d_(), -2);
				} else if (var2 instanceof aex) {
					this.bk.h();
				}
			} else {
				ahd var3 = this.o.a(this, 16.0D);
				if (var3 != null) {
					this.bk.h();
				}
			}
		}

		super.a(var1);
	}

	public void a_(ahd var1) {
		this.bo = var1;
	}

	public ahd u_() {
		return this.bo;
	}

	public boolean cm() {
		return this.bo != null;
	}

	public boolean n(boolean var1) {
		if (!this.bs && var1 && this.cp()) {
			boolean var2 = false;

			for (int var3 = 0; var3 < this.bz.n_(); ++var3) {
				amj var4 = this.bz.a(var3);
				if (var4 != null) {
					if (var4.b() == amk.P && var4.b >= 3) {
						var2 = true;
						this.bz.a(var3, 3);
					} else if ((var4.b() == amk.bS || var4.b() == amk.bR) && var4.b >= 12) {
						var2 = true;
						this.bz.a(var3, 12);
					}
				}

				if (var2) {
					this.o.a((Entity) this, (byte) 18);
					this.bs = true;
					break;
				}
			}
		}

		return this.bs;
	}

	public void o(boolean var1) {
		this.bs = var1;
	}

	public void a(aqc var1) {
		var1.g();
		this.a_ = -this.w();
		this.a("mob.villager.yes", this.bA(), this.bB());
		int var2 = 3 + this.V.nextInt(4);
		if (var1.e() == 1 || this.V.nextInt(5) == 0) {
			this.bq = 40;
			this.br = true;
			this.bs = true;
			if (this.bo != null) {
				this.bu = this.bo.d_();
			} else {
				this.bu = null;
			}

			var2 += 5;
		}

		if (var1.a().b() == amk.bO) {
			this.bt += var1.a().b;
		}

		if (var1.j()) {
			this.o.d((Entity) (new xk(this.o, this.s, this.t + 0.5D, this.u, var2)));
		}

	}

	public void a_(amj var1) {
		if (!this.o.D && this.a_ > -this.w() + 20) {
			this.a_ = -this.w();
			if (var1 != null) {
				this.a("mob.villager.yes", this.bA(), this.bB());
			} else {
				this.a("mob.villager.no", this.bA(), this.bB());
			}
		}

	}

	public aqd b_(ahd var1) {
		if (this.bp == null) {
			this.cu();
		}

		return this.bp;
	}

	private void cu() {
		agw[][][] var1 = bA[this.cj()];
		if (this.bv != 0 && this.bw != 0) {
			++this.bw;
		} else {
			this.bv = this.V.nextInt(var1.length) + 1;
			this.bw = 1;
		}

		if (this.bp == null) {
			this.bp = new aqd();
		}

		int var2 = this.bv - 1;
		int var3 = this.bw - 1;
		agw[][] var4 = var1[var2];
		if (var3 < var4.length) {
			agw[] var5 = var4[var3];
			agw[] var6 = var5;
			int var7 = var5.length;

			for (int var8 = 0; var8 < var7; ++var8) {
				agw var9 = var6[var8];
				var9.a(this.bp, this.V);
			}
		}

	}

	public ho e_() {
		String var1 = this.aL();
		if (var1 != null && var1.length() > 0) {
			return new hy(var1);
		} else {
			if (this.bp == null) {
				this.cu();
			}

			String var2 = null;
			switch (this.cj()) {
				case 0:
					if (this.bv == 1) {
						var2 = "farmer";
					} else if (this.bv == 2) {
						var2 = "fisherman";
					} else if (this.bv == 3) {
						var2 = "shepherd";
					} else if (this.bv == 4) {
						var2 = "fletcher";
					}
					break;
				case 1:
					var2 = "librarian";
					break;
				case 2:
					var2 = "cleric";
					break;
				case 3:
					if (this.bv == 1) {
						var2 = "armor";
					} else if (this.bv == 2) {
						var2 = "weapon";
					} else if (this.bv == 3) {
						var2 = "tool";
					}
					break;
				case 4:
					if (this.bv == 1) {
						var2 = "butcher";
					} else if (this.bv == 2) {
						var2 = "leather";
					}
			}

			if (var2 != null) {
				hz var3 = new hz("entity.Villager." + var2, new Object[0]);
				var3.b().a(this.aP());
				var3.b().a(this.aJ().toString());
				return var3;
			} else {
				return super.e_();
			}
		}
	}

	public float aR() {
		float var1 = 1.62F;
		if (this.i_()) {
			var1 = (float) ((double) var1 - 0.81D);
		}

		return var1;
	}

	public xq a(vu var1, xq var2) {
		var2 = super.a(var1, var2);
		this.r(this.o.s.nextInt(5));
		this.ct();
		return var2;
	}

	public void cn() {
		this.bx = true;
	}

	public agp b(ws var1) {
		agp var2 = new agp(this.o);
		var2.a(this.o.E(new dt(var2)), (xq) null);
		return var2;
	}

	public boolean ca() {
		return false;
	}

	public void a(ads var1) {
		if (!this.o.D) {
			agi var2 = new agi(this.o);
			var2.b(this.s, this.t, this.u, this.y, this.z);
			var2.a(this.o.E(new dt(var2)), (xq) null);
			this.o.d((Entity) var2);
			this.J();
		}
	}

	public wa co() {
		return this.bz;
	}

	protected void a(adw var1) {
		amj var2 = var1.l();
		alq var3 = var2.b();
		if (this.a(var3)) {
			amj var4 = this.bz.a(var2);
			if (var4 == null) {
				var1.J();
			} else {
				var2.b = var4.b;
			}
		}

	}

	private boolean a(alq var1) {
		return var1 == amk.P || var1 == amk.bS || var1 == amk.bR || var1 == amk.O || var1 == amk.N;
	}

	public boolean cp() {
		return this.s(1);
	}

	public boolean cq() {
		return this.s(2);
	}

	public boolean cr() {
		boolean var1 = this.cj() == 0;
		return var1 ? !this.s(5) : !this.s(1);
	}

	private boolean s(int var1) {
		boolean var2 = this.cj() == 0;

		for (int var3 = 0; var3 < this.bz.n_(); ++var3) {
			amj var4 = this.bz.a(var3);
			if (var4 != null) {
				if (var4.b() == amk.P && var4.b >= 3 * var1 || var4.b() == amk.bS && var4.b >= 12 * var1 || var4.b() == amk.bR && var4.b >= 12 * var1) {
					return true;
				}

				if (var2 && var4.b() == amk.O && var4.b >= 9 * var1) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean cs() {
		for (int var1 = 0; var1 < this.bz.n_(); ++var1) {
			amj var2 = this.bz.a(var1);
			if (var2 != null && (var2.b() == amk.N || var2.b() == amk.bS || var2.b() == amk.bR)) {
				return true;
			}
		}

		return false;
	}

	public boolean d(int var1, amj var2) {
		if (super.d(var1, var2)) {
			return true;
		} else {
			int var3 = var1 - 300;
			if (var3 >= 0 && var3 < this.bz.n_()) {
				this.bz.a(var3, var2);
				return true;
			} else {
				return false;
			}
		}
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.b(var1);
	}

}
