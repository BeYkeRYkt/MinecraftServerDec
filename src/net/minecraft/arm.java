package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class arm {

	private static final Logger aD = LogManager.getLogger();
	protected static final aro a = new aro(0.1F, 0.2F);
	protected static final aro b = new aro(-0.5F, 0.0F);
	protected static final aro c = new aro(-1.0F, 0.1F);
	protected static final aro d = new aro(-1.8F, 0.1F);
	protected static final aro e = new aro(0.125F, 0.05F);
	protected static final aro f = new aro(0.2F, 0.2F);
	protected static final aro g = new aro(0.45F, 0.3F);
	protected static final aro h = new aro(1.5F, 0.025F);
	protected static final aro i = new aro(1.0F, 0.5F);
	protected static final aro j = new aro(0.0F, 0.025F);
	protected static final aro k = new aro(0.1F, 0.8F);
	protected static final aro l = new aro(0.2F, 0.3F);
	protected static final aro m = new aro(-0.2F, 0.1F);
	private static final arm[] aE = new arm[256];
	public static final Set n = Sets.newHashSet();
	public static final Map o = Maps.newHashMap();
	public static final arm p = (new asm(0)).b(112).a("Ocean").a(c);
	public static final arm q = (new asn(1)).b(9286496).a("Plains");
	public static final arm r = (new asa(2)).b(16421912).a("Desert").b().a(2.0F, 0.0F).a(e);
	public static final arm s = (new asb(3, false)).b(6316128).a("Extreme Hills").a(i).a(0.2F, 0.3F);
	public static final arm t = (new asd(4, 0)).b(353825).a("Forest");
	public static final arm u = (new asu(5, 0)).b(747097).a("Taiga").a(5159473).a(0.25F, 0.8F).a(f);
	public static final arm v = (new ast(6)).b(522674).a("Swampland").a(9154376).a(m).a(0.8F, 0.9F);
	public static final arm w = (new asp(7)).b(255).a("River").a(b);
	public static final arm x = (new asg(8)).b(16711680).a("Hell").b().a(2.0F, 0.0F);
	public static final arm y = (new asv(9)).b(8421631).a("The End").b();
	public static final arm z = (new asm(10)).b(9474208).a("FrozenOcean").c().a(c).a(0.0F, 0.5F);
	public static final arm A = (new asp(11)).b(10526975).a("FrozenRiver").c().a(b).a(0.0F, 0.5F);
	public static final arm B = (new ash(12, false)).b(16777215).a("Ice Plains").c().a(0.0F, 0.5F).a(e);
	public static final arm C = (new ash(13, false)).b(10526880).a("Ice Mountains").c().a(g).a(0.0F, 0.5F);
	public static final arm D = (new ask(14)).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).a(l);
	public static final arm E = (new ask(15)).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).a(j);
	public static final arm F = (new arl(16)).b(16440917).a("Beach").a(0.8F, 0.4F).a(j);
	public static final arm G = (new asa(17)).b(13786898).a("DesertHills").b().a(2.0F, 0.0F).a(g);
	public static final arm H = (new asd(18, 0)).b(2250012).a("ForestHills").a(g);
	public static final arm I = (new asu(19, 0)).b(1456435).a("TaigaHills").a(5159473).a(0.25F, 0.8F).a(g);
	public static final arm J = (new asb(20, true)).b(7501978).a("Extreme Hills Edge").a(i.a()).a(0.2F, 0.3F);
	public static final arm K = (new asi(21, false)).b(5470985).a("Jungle").a(5470985).a(0.95F, 0.9F);
	public static final arm L = (new asi(22, false)).b(2900485).a("JungleHills").a(5470985).a(0.95F, 0.9F).a(g);
	public static final arm M = (new asi(23, true)).b(6458135).a("JungleEdge").a(5470985).a(0.95F, 0.8F);
	public static final arm N = (new asm(24)).b(48).a("Deep Ocean").a(d);
	public static final arm O = (new ass(25)).b(10658436).a("Stone Beach").a(0.2F, 0.3F).a(k);
	public static final arm P = (new arl(26)).b(16445632).a("Cold Beach").a(0.05F, 0.3F).a(j).c();
	public static final arm Q = (new asd(27, 2)).a("Birch Forest").b(3175492);
	public static final arm R = (new asd(28, 2)).a("Birch Forest Hills").b(2055986).a(g);
	public static final arm S = (new asd(29, 3)).b(4215066).a("Roofed Forest");
	public static final arm T = (new asu(30, 0)).b(3233098).a("Cold Taiga").a(5159473).c().a(-0.5F, 0.4F).a(f).c(16777215);
	public static final arm U = (new asu(31, 0)).b(2375478).a("Cold Taiga Hills").a(5159473).c().a(-0.5F, 0.4F).a(g).c(16777215);
	public static final arm V = (new asu(32, 1)).b(5858897).a("Mega Taiga").a(5159473).a(0.3F, 0.8F).a(f);
	public static final arm W = (new asu(33, 1)).b(4542270).a("Mega Taiga Hills").a(5159473).a(0.3F, 0.8F).a(g);
	public static final arm X = (new asb(34, true)).b(5271632).a("Extreme Hills+").a(i).a(0.2F, 0.3F);
	public static final arm Y = (new asq(35)).b(12431967).a("Savanna").a(1.2F, 0.0F).b().a(e);
	public static final arm Z = (new asq(36)).b(10984804).a("Savanna Plateau").a(1.0F, 0.0F).b().a(h);
	public static final arm aa = (new asj(37, false, false)).b(14238997).a("Mesa");
	public static final arm ab = (new asj(38, false, true)).b(11573093).a("Mesa Plateau F").a(h);
	public static final arm ac = (new asj(39, false, false)).b(13274213).a("Mesa Plateau").a(h);
	public static final arm ad = p;
	protected static final bnw ae;
	protected static final bnw af;
	protected static final bho ag;
	public String ah;
	public int ai;
	public int aj;
	public bec ak;
	public bec al;
	public int am;
	public float an;
	public float ao;
	public float ap;
	public float aq;
	public int ar;
	public ary as;
	protected List at;
	protected List au;
	protected List av;
	protected List aw;
	protected boolean ax;
	protected boolean ay;
	public final int az;
	protected bir aA;
	protected bhd aB;
	protected bip aC;

	protected arm(int var1) {
		this.ak = aty.c.P();
		this.al = aty.d.P();
		this.am = 5169201;
		this.an = a.a;
		this.ao = a.b;
		this.ap = 0.5F;
		this.aq = 0.5F;
		this.ar = 16777215;
		this.at = Lists.newArrayList();
		this.au = Lists.newArrayList();
		this.av = Lists.newArrayList();
		this.aw = Lists.newArrayList();
		this.ay = true;
		this.aA = new bir(false);
		this.aB = new bhd(false);
		this.aC = new bip();
		this.az = var1;
		aE[var1] = this;
		this.as = this.a();
		this.au.add(new arq(acl.class, 12, 4, 4));
		this.au.add(new arq(acb.class, 10, 3, 3));
		this.au.add(new arq(aca.class, 10, 4, 4));
		this.au.add(new arq(abr.class, 10, 4, 4));
		this.au.add(new arq(abs.class, 8, 4, 4));
		this.at.add(new arq(age.class, 100, 4, 4));
		this.at.add(new arq(agj.class, 100, 4, 4));
		this.at.add(new arq(afw.class, 100, 4, 4));
		this.at.add(new arq(aep.class, 100, 4, 4));
		this.at.add(new arq(afy.class, 100, 4, 4));
		this.at.add(new arq(aer.class, 10, 1, 4));
		this.at.add(new arq(agi.class, 5, 1, 1));
		this.av.add(new arq(aco.class, 10, 4, 4));
		this.aw.add(new arq(abo.class, 10, 8, 8));
	}

	protected ary a() {
		return new ary();
	}

	protected arm a(float var1, float var2) {
		if (var1 > 0.1F && var1 < 0.2F) {
			throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
		} else {
			this.ap = var1;
			this.aq = var2;
			return this;
		}
	}

	protected final arm a(aro var1) {
		this.an = var1.a;
		this.ao = var1.b;
		return this;
	}

	protected arm b() {
		this.ay = false;
		return this;
	}

	public bhc a(Random var1) {
		return (bhc) (var1.nextInt(10) == 0 ? this.aB : this.aA);
	}

	public bhp b(Random var1) {
		return new biq(bbi.b);
	}

	public awa a(Random var1, dt var2) {
		return var1.nextInt(3) > 0 ? awa.a : awa.b;
	}

	protected arm c() {
		this.ax = true;
		return this;
	}

	protected arm a(String var1) {
		this.ah = var1;
		return this;
	}

	protected arm a(int var1) {
		this.am = var1;
		return this;
	}

	protected arm b(int var1) {
		this.a(var1, false);
		return this;
	}

	protected arm c(int var1) {
		this.aj = var1;
		return this;
	}

	protected arm a(int var1, boolean var2) {
		this.ai = var1;
		if (var2) {
			this.aj = (var1 & 16711422) >> 1;
		} else {
			this.aj = var1;
		}

		return this;
	}

	public List a(xp var1) {
		switch (arn.a[var1.ordinal()]) {
			case 1:
				return this.at;
			case 2:
				return this.au;
			case 3:
				return this.av;
			case 4:
				return this.aw;
			default:
				return Collections.emptyList();
		}
	}

	public boolean d() {
		return this.j();
	}

	public boolean e() {
		return this.j() ? false : this.ay;
	}

	public boolean f() {
		return this.aq > 0.85F;
	}

	public float g() {
		return 0.1F;
	}

	public final int h() {
		return (int) (this.aq * 65536.0F);
	}

	public final float a(dt var1) {
		if (var1.o() > 64) {
			float var2 = (float) (ae.a((double) var1.n() * 1.0D / 8.0D, (double) var1.p() * 1.0D / 8.0D) * 4.0D);
			return this.ap - (var2 + (float) var1.o() - 64.0F) * 0.05F / 30.0F;
		} else {
			return this.ap;
		}
	}

	public void a(World var1, Random var2, dt var3) {
		this.as.a(var1, var2, this, var3);
	}

	public boolean j() {
		return this.ax;
	}

	public void a(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
		this.b(var1, var2, var3, var4, var5, var6);
	}

	public final void b(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
		boolean var8 = true;
		bec var9 = this.ak;
		bec var10 = this.al;
		int var11 = -1;
		int var12 = (int) (var6 / 3.0D + 3.0D + var2.nextDouble() * 0.25D);
		int var13 = var4 & 15;
		int var14 = var5 & 15;

		for (int var15 = 255; var15 >= 0; --var15) {
			if (var15 <= var2.nextInt(5)) {
				var3.a(var14, var15, var13, aty.h.P());
			} else {
				bec var16 = var3.a(var14, var15, var13);
				if (var16.c().r() == bof.a) {
					var11 = -1;
				} else if (var16.c() == aty.b) {
					if (var11 == -1) {
						if (var12 <= 0) {
							var9 = null;
							var10 = aty.b.P();
						} else if (var15 >= 59 && var15 <= 64) {
							var9 = this.ak;
							var10 = this.al;
						}

						if (var15 < 63 && (var9 == null || var9.c().r() == bof.a)) {
							if (this.a(new dt(var4, var15, var5)) < 0.15F) {
								var9 = aty.aI.P();
							} else {
								var9 = aty.j.P();
							}
						}

						var11 = var12;
						if (var15 >= 62) {
							var3.a(var14, var15, var13, var9);
						} else if (var15 < 56 - var12) {
							var9 = null;
							var10 = aty.b.P();
							var3.a(var14, var15, var13, aty.n.P());
						} else {
							var3.a(var14, var15, var13, var10);
						}
					} else if (var11 > 0) {
						--var11;
						var3.a(var14, var15, var13, var10);
						if (var11 == 0 && var10.c() == aty.m) {
							var11 = var2.nextInt(4) + Math.max(0, var15 - 63);
							var10 = var10.b(bab.a) == bac.b ? aty.cM.P() : aty.A.P();
						}
					}
				}
			}
		}

	}

	protected arm k() {
		return this.d(this.az + 128);
	}

	protected arm d(int var1) {
		return new asl(var1, this);
	}

	public Class l() {
		return this.getClass();
	}

	public boolean a(arm var1) {
		return var1 == this ? true : (var1 == null ? false : this.l() == var1.l());
	}

	public arp m() {
		return (double) this.ap < 0.2D ? arp.b : ((double) this.ap < 1.0D ? arp.c : arp.d);
	}

	public static arm[] n() {
		return aE;
	}

	public static arm e(int var0) {
		return a(var0, (arm) null);
	}

	public static arm a(int var0, arm var1) {
		if (var0 >= 0 && var0 <= aE.length) {
			arm var2 = aE[var0];
			return var2 == null ? var1 : var2;
		} else {
			aD.warn("Biome ID is out of bounds: " + var0 + ", defaulting to 0 (Ocean)");
			return p;
		}
	}

	static {
		q.k();
		r.k();
		t.k();
		u.k();
		v.k();
		B.k();
		K.k();
		M.k();
		T.k();
		Y.k();
		Z.k();
		aa.k();
		ab.k();
		ac.k();
		Q.k();
		R.k();
		S.k();
		V.k();
		s.k();
		X.k();
		V.d(W.az + 128).a("Redwood Taiga Hills M");
		arm[] var0 = aE;
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			arm var3 = var0[var2];
			if (var3 != null) {
				if (o.containsKey(var3.ah)) {
					throw new Error("Biome \"" + var3.ah + "\" is defined as both ID " + ((arm) o.get(var3.ah)).az + " and " + var3.az);
				}

				o.put(var3.ah, var3);
				if (var3.az < 128) {
					n.add(var3);
				}
			}
		}

		n.remove(x);
		n.remove(y);
		n.remove(z);
		n.remove(J);
		ae = new bnw(new Random(1234L), 1);
		af = new bnw(new Random(2345L), 1);
		ag = new bho();
	}
}
