package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldServer extends World implements vn {

	private static final Logger a = LogManager.getLogger();
	private final MinecraftServer I;
	private final qn J;
	private final qq K;
	private final Set L = Sets.newHashSet();
	private final TreeSet M = new TreeSet();
	private final Map N = Maps.newHashMap();
	public qs b;
	public boolean c;
	private boolean O;
	private int P;
	private final arh Q;
	private final arg R = new arg();
	protected final abk d = new abk(this);
	private qv[] S = new qv[] { new qv((qu) null), new qv((qu) null) };
	private int T;
	private static final List U = Lists.newArrayList((Object[]) (new vl[] { new vl(amk.y, 0, 1, 3, 10), new vl(alq.a(aty.f), 0, 1, 3, 10), new vl(alq.a(aty.r), 0, 1, 3, 10), new vl(amk.t, 0, 1, 1, 3), new vl(amk.p, 0, 1, 1, 5), new vl(amk.s, 0, 1, 1, 3), new vl(amk.o, 0, 1, 1, 5), new vl(amk.e, 0, 2, 3, 5), new vl(amk.P, 0, 2, 3, 3), new vl(alq.a(aty.s), 0, 1, 3, 10) }));
	private List V = Lists.newArrayList();

	public WorldServer(MinecraftServer var1, bqy var2, bqo var3, int var4, MethodProfiler var5) {
		super(var2, var3, bgd.a(var4), var5, false);
		this.I = var1;
		this.J = new qn(this);
		this.K = new qq(this);
		this.t.a(this);
		this.v = this.k();
		this.Q = new arh(this);
		this.B();
		this.C();
		this.af().a(var1.aG());
	}

	public World b() {
		this.z = new brn(this.w);
		String var1 = abl.a(this.t);
		abl var2 = (abl) this.z.a(abl.class, var1);
		if (var2 == null) {
			this.A = new abl(this);
			this.z.a(var1, (bqc) this.A);
		} else {
			this.A = var2;
			this.A.a((World) this);
		}

		this.C = new pk(this.I);
		bse var3 = (bse) this.z.a(bse.class, "scoreboard");
		if (var3 == null) {
			var3 = new bse();
			this.z.a("scoreboard", (bqc) var3);
		}

		var3.a(this.C);
		((pk) this.C).a(var3);
		this.af().c(this.x.C(), this.x.D());
		this.af().c(this.x.I());
		this.af().b(this.x.H());
		this.af().c(this.x.J());
		this.af().b(this.x.K());
		if (this.x.F() > 0L) {
			this.af().a(this.x.E(), this.x.G(), this.x.F());
		} else {
			this.af().a(this.x.E());
		}

		return this;
	}

	public void c() {
		super.c();
		if (this.P().t() && this.aa() != Difficulty.HARD) {
			this.P().a(Difficulty.HARD);
		}

		this.t.m().b();
		if (this.f()) {
			if (this.Q().b("doDaylightCycle")) {
				long var1 = this.x.g() + 24000L;
				this.x.c(var1 - var1 % 24000L);
			}

			this.e();
		}

		this.B.a("mobSpawner");
		if (this.Q().b("doMobSpawning") && this.x.u() != are.g) {
			this.R.a(this, this.F, this.G, this.x.f() % 400L == 0L);
		}

		this.B.c("chunkSource");
		this.v.d();
		int var3 = this.a(1.0F);
		if (var3 != this.ab()) {
			this.b(var3);
		}

		this.x.b(this.x.f() + 1L);
		if (this.Q().b("doDaylightCycle")) {
			this.x.c(this.x.g() + 1L);
		}

		this.B.c("tickPending");
		this.a(false);
		this.B.c("tickBlocks");
		this.h();
		this.B.c("chunkMap");
		this.K.b();
		this.B.c("village");
		this.A.a();
		this.d.a();
		this.B.c("portalForcer");
		this.Q.a(this.K());
		this.B.b();
		this.ak();
	}

	public arq a(xp var1, dt var2) {
		List var3 = this.N().a(var1, var2);
		return var3 != null && !var3.isEmpty() ? (arq) vj.a(this.s, var3) : null;
	}

	public boolean a(xp var1, arq var2, dt var3) {
		List var4 = this.N().a(var1, var3);
		return var4 != null && !var4.isEmpty() ? var4.contains(var2) : false;
	}

	public void d() {
		this.O = false;
		if (!this.j.isEmpty()) {
			int var1 = 0;
			int var2 = 0;
			Iterator var3 = this.j.iterator();

			while (var3.hasNext()) {
				ahd var4 = (ahd) var3.next();
				if (var4.v()) {
					++var1;
				} else if (var4.bI()) {
					++var2;
				}
			}

			this.O = var2 > 0 && var2 >= this.j.size() - var1;
		}

	}

	protected void e() {
		this.O = false;
		Iterator var1 = this.j.iterator();

		while (var1.hasNext()) {
			ahd var2 = (ahd) var1.next();
			if (var2.bI()) {
				var2.a(false, false, true);
			}
		}

		this.ag();
	}

	private void ag() {
		this.x.g(0);
		this.x.b(false);
		this.x.f(0);
		this.x.a(false);
	}

	public boolean f() {
		if (this.O && !this.D) {
			Iterator var1 = this.j.iterator();

			ahd var2;
			do {
				if (!var1.hasNext()) {
					return true;
				}

				var2 = (ahd) var1.next();
			} while (!var2.v() && var2.ce());

			return false;
		} else {
			return false;
		}
	}

	protected void h() {
		super.h();
		if (this.x.u() == are.g) {
			Iterator var21 = this.E.iterator();

			while (var21.hasNext()) {
				aqm var22 = (aqm) var21.next();
				this.a(var22.a, var22.b).b(false);
			}

		} else {
			int var1 = 0;
			int var2 = 0;

			for (Iterator var3 = this.E.iterator(); var3.hasNext(); this.B.b()) {
				aqm var4 = (aqm) var3.next();
				int var5 = var4.a * 16;
				int var6 = var4.b * 16;
				this.B.a("getChunk");
				bfh var7 = this.a(var4.a, var4.b);
				this.a(var5, var6, var7);
				this.B.c("tickChunk");
				var7.b(false);
				this.B.c("thunder");
				int var8;
				dt var9;
				if (this.s.nextInt(100000) == 0 && this.S() && this.R()) {
					this.m = this.m * 3 + 1013904223;
					var8 = this.m >> 2;
					var9 = this.a(new dt(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
					if (this.C(var9)) {
						this.c(new ads(this, (double) var9.n(), (double) var9.o(), (double) var9.p()));
					}
				}

				this.B.c("iceandsnow");
				if (this.s.nextInt(16) == 0) {
					this.m = this.m * 3 + 1013904223;
					var8 = this.m >> 2;
					var9 = this.q(new dt(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
					dt var10 = var9.b();
					if (this.w(var10)) {
						this.a(var10, aty.aI.P());
					}

					if (this.S() && this.f(var9, true)) {
						this.a(var9, aty.aH.P());
					}

					if (this.S() && this.b(var10).e()) {
						this.p(var10).c().k(this, var10);
					}
				}

				this.B.c("tickBlocks");
				var8 = this.Q().c("randomTickSpeed");
				if (var8 > 0) {
					bfm[] var23 = var7.h();
					int var24 = var23.length;

					for (int var11 = 0; var11 < var24; ++var11) {
						bfm var12 = var23[var11];
						if (var12 != null && var12.b()) {
							for (int var13 = 0; var13 < var8; ++var13) {
								this.m = this.m * 3 + 1013904223;
								int var14 = this.m >> 2;
								int var15 = var14 & 15;
								int var16 = var14 >> 8 & 15;
								int var17 = var14 >> 16 & 15;
								++var2;
								dt var18 = new dt(var15 + var5, var17 + var12.d(), var16 + var6);
								bec var19 = var12.a(var15, var17, var16);
								atr var20 = var19.c();
								if (var20.w()) {
									++var1;
									var20.a((World) this, var18, var19, this.s);
								}
							}
						}
					}
				}
			}

		}
	}

	protected dt a(dt var1) {
		dt var2 = this.q(var1);
		brt var3 = (new brt(var2, new dt(var2.n(), this.U(), var2.p()))).b(3.0D, 3.0D, 3.0D);
		List var4 = this.a(EntityLiving.class, var3, new qu(this));
		return !var4.isEmpty() ? ((EntityLiving) var4.get(this.s.nextInt(var4.size()))).c() : var2;
	}

	public boolean a(dt var1, atr var2) {
		ark var3 = new ark(var1, var2);
		return this.V.contains(var3);
	}

	public void a(dt var1, atr var2, int var3) {
		this.a(var1, var2, var3, 0);
	}

	public void a(dt var1, atr var2, int var3, int var4) {
		ark var5 = new ark(var1, var2);
		byte var6 = 0;
		if (this.e && var2.r() != bof.a) {
			if (var2.M()) {
				var6 = 8;
				if (this.a(var5.a.a(-var6, -var6, -var6), var5.a.a(var6, var6, var6))) {
					bec var7 = this.p(var5.a);
					if (var7.c().r() != bof.a && var7.c() == var5.a()) {
						var7.c().b((World) this, var5.a, var7, this.s);
					}
				}

				return;
			}

			var3 = 1;
		}

		if (this.a(var1.a(-var6, -var6, -var6), var1.a(var6, var6, var6))) {
			if (var2.r() != bof.a) {
				var5.a((long) var3 + this.x.f());
				var5.a(var4);
			}

			if (!this.L.contains(var5)) {
				this.L.add(var5);
				this.M.add(var5);
			}
		}

	}

	public void b(dt var1, atr var2, int var3, int var4) {
		ark var5 = new ark(var1, var2);
		var5.a(var4);
		if (var2.r() != bof.a) {
			var5.a((long) var3 + this.x.f());
		}

		if (!this.L.contains(var5)) {
			this.L.add(var5);
			this.M.add(var5);
		}

	}

	public void i() {
		if (this.j.isEmpty()) {
			if (this.P++ >= 1200) {
				return;
			}
		} else {
			this.j();
		}

		super.i();
	}

	public void j() {
		this.P = 0;
	}

	public boolean a(boolean var1) {
		if (this.x.u() == are.g) {
			return false;
		} else {
			int var2 = this.M.size();
			if (var2 != this.L.size()) {
				throw new IllegalStateException("TickNextTick list out of synch");
			} else {
				if (var2 > 1000) {
					var2 = 1000;
				}

				this.B.a("cleaning");

				ark var4;
				for (int var3 = 0; var3 < var2; ++var3) {
					var4 = (ark) this.M.first();
					if (!var1 && var4.b > this.x.f()) {
						break;
					}

					this.M.remove(var4);
					this.L.remove(var4);
					this.V.add(var4);
				}

				this.B.b();
				this.B.a("ticking");
				Iterator var11 = this.V.iterator();

				while (var11.hasNext()) {
					var4 = (ark) var11.next();
					var11.remove();
					byte var5 = 0;
					if (this.a(var4.a.a(-var5, -var5, -var5), var4.a.a(var5, var5, var5))) {
						bec var6 = this.p(var4.a);
						if (var6.c().r() != bof.a && atr.a(var6.c(), var4.a())) {
							try {
								var6.c().b((World) this, var4.a, var6, this.s);
							} catch (Throwable var10) {
								CrashReport var8 = CrashReport.a(var10, "Exception while ticking a block");
								j var9 = var8.a("Block being ticked");
								net.minecraft.j.a(var9, var4.a, var6);
								throw new u(var8);
							}
						}
					} else {
						this.a(var4.a, var4.a(), 0);
					}
				}

				this.B.b();
				this.V.clear();
				return !this.M.isEmpty();
			}
		}
	}

	public List a(bfh var1, boolean var2) {
		aqm var3 = var1.j();
		int var4 = (var3.a << 4) - 2;
		int var5 = var4 + 16 + 2;
		int var6 = (var3.b << 4) - 2;
		int var7 = var6 + 16 + 2;
		return this.a(new bjb(var4, 0, var6, var5, 256, var7), var2);
	}

	public List a(bjb var1, boolean var2) {
		ArrayList var3 = null;

		for (int var4 = 0; var4 < 2; ++var4) {
			Iterator var5;
			if (var4 == 0) {
				var5 = this.M.iterator();
			} else {
				var5 = this.V.iterator();
				if (!this.V.isEmpty()) {
					a.debug("toBeTicked = " + this.V.size());
				}
			}

			while (var5.hasNext()) {
				ark var6 = (ark) var5.next();
				dt var7 = var6.a;
				if (var7.n() >= var1.a && var7.n() < var1.d && var7.p() >= var1.c && var7.p() < var1.f) {
					if (var2) {
						this.L.remove(var6);
						var5.remove();
					}

					if (var3 == null) {
						var3 = Lists.newArrayList();
					}

					var3.add(var6);
				}
			}
		}

		return var3;
	}

	public void a(Entity var1, boolean var2) {
		if (!this.ai() && (var1 instanceof abq || var1 instanceof act)) {
			var1.J();
		}

		if (!this.ah() && var1 instanceof ago) {
			var1.J();
		}

		super.a(var1, var2);
	}

	private boolean ah() {
		return this.I.isNPCSpawnEnabled();
	}

	private boolean ai() {
		return this.I.isAnimalSpawnEnabled();
	}

	protected bfe k() {
		bfq var1 = this.w.a(this.t);
		this.b = new qs(this, var1, this.t.c());
		return this.b;
	}

	public List a(int var1, int var2, int var3, int var4, int var5, int var6) {
		ArrayList var7 = Lists.newArrayList();

		for (int var8 = 0; var8 < this.h.size(); ++var8) {
			bcm var9 = (bcm) this.h.get(var8);
			dt var10 = var9.v();
			if (var10.n() >= var1 && var10.o() >= var2 && var10.p() >= var3 && var10.n() < var4 && var10.o() < var5 && var10.p() < var6) {
				var7.add(var9);
			}
		}

		return var7;
	}

	public boolean a(ahd var1, dt var2) {
		return !this.I.a((World) this, var2, var1) && this.af().a(var2);
	}

	public void a(arb var1) {
		if (!this.x.w()) {
			try {
				this.b(var1);
				if (this.x.u() == are.g) {
					this.aj();
				}

				super.a(var1);
			} catch (Throwable var6) {
				CrashReport var3 = CrashReport.a(var6, "Exception initializing level");

				try {
					this.a(var3);
				} catch (Throwable var5) {
					;
				}

				throw new u(var3);
			}

			this.x.d(true);
		}

	}

	private void aj() {
		this.x.f(false);
		this.x.c(true);
		this.x.b(false);
		this.x.a(false);
		this.x.i(1000000000);
		this.x.c(6000L);
		this.x.a(GameMode.SPECTATOR);
		this.x.g(false);
		this.x.a(Difficulty.PEACEFUL);
		this.x.e(true);
		this.Q().a("doDaylightCycle", "false");
	}

	private void b(arb var1) {
		if (!this.t.e()) {
			this.x.a(dt.a.b(this.t.i()));
		} else if (this.x.u() == are.g) {
			this.x.a(dt.a.a());
		} else {
			this.y = true;
			arz var2 = this.t.m();
			List var3 = var2.a();
			Random var4 = new Random(this.J());
			dt var5 = var2.a(0, 0, 256, var3, var4);
			int var6 = 0;
			int var7 = this.t.i();
			int var8 = 0;
			if (var5 != null) {
				var6 = var5.n();
				var8 = var5.p();
			} else {
				a.warn("Unable to find spawn biome");
			}

			int var9 = 0;

			while (!this.t.a(var6, var8)) {
				var6 += var4.nextInt(64) - var4.nextInt(64);
				var8 += var4.nextInt(64) - var4.nextInt(64);
				++var9;
				if (var9 == 1000) {
					break;
				}
			}

			this.x.a(new dt(var6, var7, var8));
			this.y = false;
			if (var1.c()) {
				this.l();
			}

		}
	}

	protected void l() {
		bhh var1 = new bhh(U, 10);

		for (int var2 = 0; var2 < 10; ++var2) {
			int var3 = this.x.c() + this.s.nextInt(6) - this.s.nextInt(6);
			int var4 = this.x.e() + this.s.nextInt(6) - this.s.nextInt(6);
			dt var5 = this.r(new dt(var3, 0, var4)).a();
			if (var1.b(this, this.s, var5)) {
				break;
			}
		}

	}

	public dt m() {
		return this.t.h();
	}

	public void save(boolean var1, uy var2) throws aqz {
		if (this.v.e()) {
			if (var2 != null) {
				var2.a("Saving level");
			}

			this.a();
			if (var2 != null) {
				var2.c("Saving chunks");
			}

			this.v.a(var1, var2);
			List var3 = this.b.a();
			Iterator var4 = var3.iterator();

			while (var4.hasNext()) {
				bfh var5 = (bfh) var4.next();
				if (!this.K.a(var5.a, var5.b)) {
					this.b.b(var5.a, var5.b);
				}
			}

		}
	}

	public void n() {
		if (this.v.e()) {
			this.v.c();
		}
	}

	protected void a() throws aqz {
		this.I();
		this.x.a(this.af().h());
		this.x.d(this.af().f());
		this.x.c(this.af().g());
		this.x.e(this.af().m());
		this.x.f(this.af().n());
		this.x.j(this.af().q());
		this.x.k(this.af().p());
		this.x.b(this.af().j());
		this.x.e(this.af().i());
		this.w.a(this.x, this.I.getPlayerList().u());
		this.z.a();
	}

	protected void a(Entity var1) {
		super.a(var1);
		this.l.a(var1.F(), var1);
		this.N.put(var1.aJ(), var1);
		Entity[] var2 = var1.aC();
		if (var2 != null) {
			for (int var3 = 0; var3 < var2.length; ++var3) {
				this.l.a(var2[var3].F(), var2[var3]);
			}
		}

	}

	protected void b(Entity var1) {
		super.b(var1);
		this.l.d(var1.F());
		this.N.remove(var1.aJ());
		Entity[] var2 = var1.aC();
		if (var2 != null) {
			for (int var3 = 0; var3 < var2.length; ++var3) {
				this.l.d(var2[var3].F());
			}
		}

	}

	public boolean c(Entity var1) {
		if (super.c(var1)) {
			this.I.getPlayerList().a(var1.s, var1.t, var1.u, 512.0D, this.t.q(), new in(var1));
			return true;
		} else {
			return false;
		}
	}

	public void a(Entity var1, byte var2) {
		this.s().b(var1, new jk(var1, var2));
	}

	public aqo a(Entity var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
		aqo var11 = new aqo(this, var1, var2, var4, var6, var8, var9, var10);
		var11.a();
		var11.a(false);
		if (!var10) {
			var11.d();
		}

		Iterator var12 = this.j.iterator();

		while (var12.hasNext()) {
			ahd var13 = (ahd) var12.next();
			if (var13.e(var2, var4, var6) < 4096.0D) {
				((EntityPlayer) var13).a.a((id) (new jm(var2, var4, var6, var8, var11.e(), (brw) var11.b().get(var13))));
			}
		}

		return var11;
	}

	public void c(dt var1, atr var2, int var3, int var4) {
		aqk var5 = new aqk(var1, var2, var3, var4);
		Iterator var6 = this.S[this.T].iterator();

		aqk var7;
		do {
			if (!var6.hasNext()) {
				this.S[this.T].add(var5);
				return;
			}

			var7 = (aqk) var6.next();
		} while (!var7.equals(var5));

	}

	private void ak() {
		while (!this.S[this.T].isEmpty()) {
			int var1 = this.T;
			this.T ^= 1;
			Iterator var2 = this.S[var1].iterator();

			while (var2.hasNext()) {
				aqk var3 = (aqk) var2.next();
				if (this.a(var3)) {
					this.I.getPlayerList().a((double) var3.a().n(), (double) var3.a().o(), (double) var3.a().p(), 64.0D, this.t.q(), new iv(var3.a(), var3.d(), var3.b(), var3.c()));
				}
			}

			this.S[var1].clear();
		}

	}

	private boolean a(aqk var1) {
		bec var2 = this.p(var1.a());
		return var2.c() == var1.d() ? var2.c().a(this, var1.a(), var2, var1.b(), var1.c()) : false;
	}

	public void saveData() {
		this.w.a();
	}

	protected void p() {
		boolean var1 = this.S();
		super.p();
		if (this.o != this.p) {
			this.I.getPlayerList().a((id) (new jo(7, this.p)), this.t.q());
		}

		if (this.q != this.r) {
			this.I.getPlayerList().a((id) (new jo(8, this.r)), this.t.q());
		}

		if (var1 != this.S()) {
			if (var1) {
				this.I.getPlayerList().a((id) (new jo(2, 0.0F)));
			} else {
				this.I.getPlayerList().a((id) (new jo(1, 0.0F)));
			}

			this.I.getPlayerList().a((id) (new jo(7, this.p)));
			this.I.getPlayerList().a((id) (new jo(8, this.r)));
		}

	}

	protected int q() {
		return this.I.getPlayerList().t();
	}

	public MinecraftServer r() {
		return this.I;
	}

	public qn s() {
		return this.J;
	}

	public qq t() {
		return this.K;
	}

	public arh u() {
		return this.Q;
	}

	public void a(ew var1, double var2, double var4, double var6, int var8, double var9, double var11, double var13, double var15, int... var17) {
		this.a(var1, false, var2, var4, var6, var8, var9, var11, var13, var15, var17);
	}

	public void a(ew var1, boolean var2, double var3, double var5, double var7, int var9, double var10, double var12, double var14, double var16, int... var18) {
		ju var19 = new ju(var1, var2, (float) var3, (float) var5, (float) var7, (float) var10, (float) var12, (float) var14, (float) var16, var9, var18);

		for (int var20 = 0; var20 < this.j.size(); ++var20) {
			EntityPlayer var21 = (EntityPlayer) this.j.get(var20);
			dt var22 = var21.c();
			double var23 = var22.c(var3, var5, var7);
			if (var23 <= 256.0D || var2 && var23 <= 65536.0D) {
				var21.a.a((id) var19);
			}
		}

	}

	public Entity a(UUID var1) {
		return (Entity) this.N.get(var1);
	}

	public ListenableFuture a(Runnable var1) {
		return this.I.a(var1);
	}

	public boolean aH() {
		return this.I.aH();
	}

}
