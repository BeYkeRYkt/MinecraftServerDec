package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class atr {

	private static final oa a = new oa("air");
	public static final eh c = new eh(a);
	public static final er d = new er();
	private akf b;
	public static final atx e = new atx("stone", 1.0F, 1.0F);
	public static final atx f = new atx("wood", 1.0F, 1.0F);
	public static final atx g = new atx("gravel", 1.0F, 1.0F);
	public static final atx h = new atx("grass", 1.0F, 1.0F);
	public static final atx i = new atx("stone", 1.0F, 1.0F);
	public static final atx j = new atx("stone", 1.0F, 1.5F);
	public static final atx k = new ats("stone", 1.0F, 1.0F);
	public static final atx l = new atx("cloth", 1.0F, 1.0F);
	public static final atx m = new atx("sand", 1.0F, 1.0F);
	public static final atx n = new atx("snow", 1.0F, 1.0F);
	public static final atx o = new att("ladder", 1.0F, 1.0F);
	public static final atx p = new atu("anvil", 0.3F, 1.0F);
	public static final atx q = new atv("slime", 1.0F, 1.0F);
	protected boolean r;
	protected int s;
	protected boolean t;
	protected int u;
	protected boolean v;
	protected float w;
	protected float x;
	protected boolean y = true;
	protected boolean z;
	protected boolean A;
	protected double B;
	protected double C;
	protected double D;
	protected double E;
	protected double F;
	protected double G;
	public atx H;
	public float I;
	protected final bof J;
	public float K;
	protected final bed L;
	private bec M;
	private String N;

	public static int a(atr var0) {
		return c.b(var0);
	}

	public static int f(bec var0) {
		return a(var0.c()) + (var0.c().c(var0) << 12);
	}

	public static atr c(int var0) {
		return (atr) c.a(var0);
	}

	public static bec d(int var0) {
		int var1 = var0 & 4095;
		int var2 = var0 >> 12 & 15;
		return c(var1).a(var2);
	}

	public static atr a(alq var0) {
		return var0 instanceof aju ? ((aju) var0).d() : null;
	}

	public static atr b(String var0) {
		oa var1 = new oa(var0);
		if (c.d(var1)) {
			return (atr) c.a(var1);
		} else {
			try {
				return (atr) c.a(Integer.parseInt(var0));
			} catch (NumberFormatException var3) {
				return null;
			}
		}
	}

	public boolean m() {
		return this.r;
	}

	public int n() {
		return this.s;
	}

	public int p() {
		return this.u;
	}

	public boolean q() {
		return this.v;
	}

	public bof r() {
		return this.J;
	}

	public boh g(bec var1) {
		return this.r().r();
	}

	public bec a(int var1) {
		return this.P();
	}

	public int c(bec var1) {
		if (var1 != null && !var1.a().isEmpty()) {
			throw new IllegalArgumentException("Don\'t know how to convert " + var1 + " back into data...");
		} else {
			return 0;
		}
	}

	public bec a(bec var1, ard var2, dt var3) {
		return var1;
	}

	protected atr(bof var1) {
		this.H = e;
		this.I = 1.0F;
		this.K = 0.6F;
		this.J = var1;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.r = this.c();
		this.s = this.c() ? 255 : 0;
		this.t = !var1.b();
		this.L = this.e();
		this.j(this.L.b());
	}

	protected atr a(atx var1) {
		this.H = var1;
		return this;
	}

	protected atr e(int var1) {
		this.s = var1;
		return this;
	}

	protected atr a(float var1) {
		this.u = (int) (15.0F * var1);
		return this;
	}

	protected atr b(float var1) {
		this.x = var1 * 3.0F;
		return this;
	}

	public boolean s() {
		return this.J.c() && this.d();
	}

	public boolean t() {
		return this.J.k() && this.d() && !this.g();
	}

	public boolean u() {
		return this.J.c() && this.d();
	}

	public boolean d() {
		return true;
	}

	public boolean b(ard var1, dt var2) {
		return !this.J.c();
	}

	public int b() {
		return 3;
	}

	public boolean f(World var1, dt var2) {
		return false;
	}

	protected atr c(float var1) {
		this.w = var1;
		if (this.x < var1 * 5.0F) {
			this.x = var1 * 5.0F;
		}

		return this;
	}

	protected atr v() {
		this.c(-1.0F);
		return this;
	}

	public float g(World var1, dt var2) {
		return this.w;
	}

	protected atr a(boolean var1) {
		this.z = var1;
		return this;
	}

	public boolean w() {
		return this.z;
	}

	public boolean x() {
		return this.A;
	}

	protected final void a(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.B = (double) var1;
		this.C = (double) var2;
		this.D = (double) var3;
		this.E = (double) var4;
		this.F = (double) var5;
		this.G = (double) var6;
	}

	public boolean b(ard var1, dt var2, ej var3) {
		return var1.p(var2).c().r().a();
	}

	public void a(World var1, dt var2, bec var3, brt var4, List var5, Entity var6) {
		brt var7 = this.a(var1, var2, var3);
		if (var7 != null && var4.b(var7)) {
			var5.add(var7);
		}

	}

	public brt a(World var1, dt var2, bec var3) {
		return new brt((double) var2.n() + this.B, (double) var2.o() + this.C, (double) var2.p() + this.D, (double) var2.n() + this.E, (double) var2.o() + this.F, (double) var2.p() + this.G);
	}

	public boolean c() {
		return true;
	}

	public boolean a(bec var1, boolean var2) {
		return this.y();
	}

	public boolean y() {
		return true;
	}

	public void a(World var1, dt var2, bec var3, Random var4) {
		this.b(var1, var2, var3, var4);
	}

	public void b(World var1, dt var2, bec var3, Random var4) {
	}

	public void d(World var1, dt var2, bec var3) {
	}

	public void a(World var1, dt var2, bec var3, atr var4) {
	}

	public int a(World var1) {
		return 10;
	}

	public void c(World var1, dt var2, bec var3) {
	}

	public void b(World var1, dt var2, bec var3) {
	}

	public int a(Random var1) {
		return 1;
	}

	public alq a(bec var1, Random var2, int var3) {
		return alq.a(this);
	}

	public float a(ahd var1, World var2, dt var3) {
		float var4 = this.g(var2, var3);
		return var4 < 0.0F ? 0.0F : (!var1.b(this) ? var1.a(this) / var4 / 100.0F : var1.a(this) / var4 / 30.0F);
	}

	public final void b(World var1, dt var2, bec var3, int var4) {
		this.a(var1, var2, var3, 1.0F, var4);
	}

	public void a(World var1, dt var2, bec var3, float var4, int var5) {
		if (!var1.D) {
			int var6 = this.a(var5, var1.s);

			for (int var7 = 0; var7 < var6; ++var7) {
				if (var1.s.nextFloat() <= var4) {
					alq var8 = this.a(var3, var1.s, var5);
					if (var8 != null) {
						a(var1, var2, new amj(var8, 1, this.a(var3)));
					}
				}
			}

		}
	}

	public static void a(World var0, dt var1, amj var2) {
		if (!var0.D && var0.Q().b("doTileDrops")) {
			float var3 = 0.5F;
			double var4 = (double) (var0.s.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
			double var6 = (double) (var0.s.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
			double var8 = (double) (var0.s.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
			adw var10 = new adw(var0, (double) var1.n() + var4, (double) var1.o() + var6, (double) var1.p() + var8, var2);
			var10.p();
			var0.d((Entity) var10);
		}
	}

	protected void b(World var1, dt var2, int var3) {
		if (!var1.D) {
			while (var3 > 0) {
				int var4 = xk.a(var3);
				var3 -= var4;
				var1.d((Entity) (new xk(var1, (double) var2.n() + 0.5D, (double) var2.o() + 0.5D, (double) var2.p() + 0.5D, var4)));
			}
		}

	}

	public int a(bec var1) {
		return 0;
	}

	public float a(Entity var1) {
		return this.x / 5.0F;
	}

	public bru a(World var1, dt var2, brw var3, brw var4) {
		this.a((ard) var1, var2);
		var3 = var3.b((double) (-var2.n()), (double) (-var2.o()), (double) (-var2.p()));
		var4 = var4.b((double) (-var2.n()), (double) (-var2.o()), (double) (-var2.p()));
		brw var5 = var3.a(var4, this.B);
		brw var6 = var3.a(var4, this.E);
		brw var7 = var3.b(var4, this.C);
		brw var8 = var3.b(var4, this.F);
		brw var9 = var3.c(var4, this.D);
		brw var10 = var3.c(var4, this.G);
		if (!this.a(var5)) {
			var5 = null;
		}

		if (!this.a(var6)) {
			var6 = null;
		}

		if (!this.b(var7)) {
			var7 = null;
		}

		if (!this.b(var8)) {
			var8 = null;
		}

		if (!this.c(var9)) {
			var9 = null;
		}

		if (!this.c(var10)) {
			var10 = null;
		}

		brw var11 = null;
		if (var5 != null && (var11 == null || var3.g(var5) < var3.g(var11))) {
			var11 = var5;
		}

		if (var6 != null && (var11 == null || var3.g(var6) < var3.g(var11))) {
			var11 = var6;
		}

		if (var7 != null && (var11 == null || var3.g(var7) < var3.g(var11))) {
			var11 = var7;
		}

		if (var8 != null && (var11 == null || var3.g(var8) < var3.g(var11))) {
			var11 = var8;
		}

		if (var9 != null && (var11 == null || var3.g(var9) < var3.g(var11))) {
			var11 = var9;
		}

		if (var10 != null && (var11 == null || var3.g(var10) < var3.g(var11))) {
			var11 = var10;
		}

		if (var11 == null) {
			return null;
		} else {
			ej var12 = null;
			if (var11 == var5) {
				var12 = ej.e;
			}

			if (var11 == var6) {
				var12 = ej.f;
			}

			if (var11 == var7) {
				var12 = ej.a;
			}

			if (var11 == var8) {
				var12 = ej.b;
			}

			if (var11 == var9) {
				var12 = ej.c;
			}

			if (var11 == var10) {
				var12 = ej.d;
			}

			return new bru(var11.b((double) var2.n(), (double) var2.o(), (double) var2.p()), var12, var2);
		}
	}

	private boolean a(brw var1) {
		return var1 == null ? false : var1.b >= this.C && var1.b <= this.F && var1.c >= this.D && var1.c <= this.G;
	}

	private boolean b(brw var1) {
		return var1 == null ? false : var1.a >= this.B && var1.a <= this.E && var1.c >= this.D && var1.c <= this.G;
	}

	private boolean c(brw var1) {
		return var1 == null ? false : var1.a >= this.B && var1.a <= this.E && var1.b >= this.C && var1.b <= this.F;
	}

	public void a(World var1, dt var2, aqo var3) {
	}

	public boolean a(World var1, dt var2, ej var3, amj var4) {
		return this.a(var1, var2, var3);
	}

	public boolean a(World var1, dt var2, ej var3) {
		return this.c(var1, var2);
	}

	public boolean c(World var1, dt var2) {
		return var1.p(var2).c().J.j();
	}

	public boolean a(World var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
		return false;
	}

	public void a(World var1, dt var2, Entity var3) {
	}

	public bec a(World var1, dt var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.a(var7);
	}

	public void a(World var1, dt var2, ahd var3) {
	}

	public brw a(World var1, dt var2, Entity var3, brw var4) {
		return var4;
	}

	public void a(ard var1, dt var2) {
	}

	public final double z() {
		return this.B;
	}

	public final double A() {
		return this.E;
	}

	public final double B() {
		return this.C;
	}

	public final double C() {
		return this.F;
	}

	public final double D() {
		return this.D;
	}

	public final double E() {
		return this.G;
	}

	public int a(ard var1, dt var2, bec var3, ej var4) {
		return 0;
	}

	public boolean g() {
		return false;
	}

	public void a(World var1, dt var2, bec var3, Entity var4) {
	}

	public int b(ard var1, dt var2, bec var3, ej var4) {
		return 0;
	}

	public void h() {
	}

	public void a(World var1, ahd var2, dt var3, bec var4, bcm var5) {
		var2.b(ty.H[a(this)]);
		var2.a(0.025F);
		if (this.G() && aph.e(var2)) {
			amj var7 = this.i(var4);
			if (var7 != null) {
				a(var1, var3, var7);
			}
		} else {
			int var6 = aph.f(var2);
			this.b(var1, var3, var4, var6);
		}

	}

	protected boolean G() {
		return this.d() && !this.A;
	}

	protected amj i(bec var1) {
		int var2 = 0;
		alq var3 = alq.a(this);
		if (var3 != null && var3.k()) {
			var2 = this.c(var1);
		}

		return new amj(var3, 1, var2);
	}

	public int a(int var1, Random var2) {
		return this.a(var2);
	}

	public void a(World var1, dt var2, bec var3, EntityLiving var4, amj var5) {
	}

	public atr c(String var1) {
		this.N = var1;
		return this;
	}

	public String H() {
		return fi.a(this.a() + ".name");
	}

	public String a() {
		return "tile." + this.N;
	}

	public boolean a(World var1, dt var2, bec var3, int var4, int var5) {
		return false;
	}

	public boolean I() {
		return this.y;
	}

	protected atr J() {
		this.y = false;
		return this;
	}

	public int i() {
		return this.J.m();
	}

	public void a(World var1, dt var2, Entity var3, float var4) {
		var3.e(var4, 1.0F);
	}

	public void a(World var1, Entity var2) {
		var2.w = 0.0D;
	}

	public int j(World var1, dt var2) {
		return this.a(var1.p(var2));
	}

	public atr a(akf var1) {
		this.b = var1;
		return this;
	}

	public void a(World var1, dt var2, bec var3, ahd var4) {
	}

	public void k(World var1, dt var2) {
	}

	public boolean M() {
		return true;
	}

	public boolean a(aqo var1) {
		return true;
	}

	public boolean b(atr var1) {
		return this == var1;
	}

	public static boolean a(atr var0, atr var1) {
		return var0 != null && var1 != null ? (var0 == var1 ? true : var0.b(var1)) : false;
	}

	public boolean N() {
		return false;
	}

	public int l(World var1, dt var2) {
		return 0;
	}

	protected bed e() {
		return new bed(this, new bex[0]);
	}

	public bed O() {
		return this.L;
	}

	protected final void j(bec var1) {
		this.M = var1;
	}

	public final bec P() {
		return this.M;
	}

	public static void R() {
		a(0, a, (new asy()).c("air"));
		a(1, "stone", (new bba()).c(1.5F).b(10.0F).a(i).c("stone"));
		a(2, "grass", (new awn()).c(0.6F).a(h).c("grass"));
		a(3, "dirt", (new avc()).c(0.5F).a(g).c("dirt"));
		atr var0 = (new atr(bof.e)).c(2.0F).b(10.0F).a(i).c("stonebrick").a(akf.b);
		a(4, "cobblestone", var0);
		atr var1 = (new ayw()).c(2.0F).b(5.0F).a(f).c("wood");
		a(5, "planks", var1);
		a(6, "sapling", (new baf()).c(0.0F).a(h).c("sapling"));
		a(7, "bedrock", (new atr(bof.e)).v().b(6000000.0F).a(i).c("bedrock").J().a(akf.b));
		a(8, "flowing_water", (new avn(bof.h)).c(100.0F).e(3).c("water").J());
		a(9, "water", (new bax(bof.h)).c(100.0F).e(3).c("water").J());
		a(10, "flowing_lava", (new avn(bof.i)).c(100.0F).a(1.0F).c("lava").J());
		a(11, "lava", (new bax(bof.i)).c(100.0F).a(1.0F).c("lava").J());
		a(12, "sand", (new bab()).c(0.5F).a(m).c("sand"));
		a(13, "gravel", (new awo()).c(0.6F).a(g).c("gravel"));
		a(14, "gold_ore", (new ayu()).c(3.0F).b(5.0F).a(i).c("oreGold"));
		a(15, "iron_ore", (new ayu()).c(3.0F).b(5.0F).a(i).c("oreIron"));
		a(16, "coal_ore", (new ayu()).c(3.0F).b(5.0F).a(i).c("oreCoal"));
		a(17, "log", (new ayr()).c("log"));
		a(18, "leaves", (new ayp()).c("leaves"));
		a(19, "sponge", (new baq()).c(0.6F).a(h).c("sponge"));
		a(20, "glass", (new awl(bof.s, false)).c(0.3F).a(k).c("glass"));
		a(21, "lapis_ore", (new ayu()).c(3.0F).b(5.0F).a(i).c("oreLapis"));
		a(22, "lapis_block", (new axq(boh.H)).c(3.0F).b(5.0F).a(i).c("blockLapis").a(akf.b));
		a(23, "dispenser", (new ave()).c(3.5F).a(i).c("dispenser"));
		atr var2 = (new bad()).a(i).c(0.8F).c("sandStone");
		a(24, "sandstone", var2);
		a(25, "noteblock", (new ayn()).c(0.8F).c("musicBlock"));
		a(26, "bed", (new atp()).a(f).c(0.2F).c("bed").J());
		a(27, "golden_rail", (new azc()).c(0.7F).a(j).c("goldenRail"));
		a(28, "detector_rail", (new auy()).c(0.7F).a(j).c("detectorRail"));
		a(29, "sticky_piston", (new bdq(true)).c("pistonStickyBase"));
		a(30, "web", (new bcc()).e(1).c(4.0F).c("web"));
		a(31, "tallgrass", (new bbh()).c(0.0F).a(h).c("tallgrass"));
		a(32, "deadbush", (new auw()).c(0.0F).a(h).c("deadbush"));
		a(33, "piston", (new bdq(false)).c("pistonBase"));
		a(34, "piston_head", new bds());
		a(35, "wool", (new aun(bof.n)).c(0.8F).a(l).c("cloth"));
		a(36, "piston_extension", new bdx());
		a(37, "yellow_flower", (new bch()).c(0.0F).a(h).c("flower1"));
		a(38, "red_flower", (new azp()).c(0.0F).a(h).c("flower2"));
		atr var3 = (new ayb()).c(0.0F).a(h).a(0.125F).c("mushroom");
		a(39, "brown_mushroom", var3);
		atr var4 = (new ayb()).c(0.0F).a(h).c("mushroom");
		a(40, "red_mushroom", var4);
		a(41, "gold_block", (new axq(boh.F)).c(3.0F).b(10.0F).a(j).c("blockGold"));
		a(42, "iron_block", (new axq(boh.h)).c(5.0F).b(10.0F).a(j).c("blockIron"));
		a(43, "double_stone_slab", (new awh()).c(2.0F).b(10.0F).a(i).c("stoneSlab"));
		a(44, "stone_slab", (new aws()).c(2.0F).b(10.0F).a(i).c("stoneSlab"));
		atr var5 = (new atr(bof.e)).c(2.0F).b(10.0F).a(i).c("brick").a(akf.b);
		a(45, "brick_block", var5);
		a(46, "tnt", (new bbk()).c(0.0F).a(h).c("tnt"));
		a(47, "bookshelf", (new aua()).c(1.5F).a(f).c("bookshelf"));
		a(48, "mossy_cobblestone", (new atr(bof.e)).c(2.0F).b(10.0F).a(i).c("stoneMoss").a(akf.b));
		a(49, "obsidian", (new ayo()).c(50.0F).b(2000.0F).a(i).c("obsidian"));
		a(50, "torch", (new bbl()).c(0.0F).a(0.9375F).a(f).c("torch"));
		a(51, "fire", (new avx()).c(0.0F).a(1.0F).a(l).c("fire").J());
		a(52, "mob_spawner", (new axr()).c(5.0F).a(j).c("mobSpawner").J());
		a(53, "oak_stairs", (new bat(var1.P().a(ayw.a, ayx.a))).c("stairsWood"));
		a(54, "chest", (new auj(0)).c(2.5F).a(f).c("chest"));
		a(55, "redstone_wire", (new azt()).c(0.0F).a(e).c("redstoneDust").J());
		a(56, "diamond_ore", (new ayu()).c(3.0F).b(5.0F).a(i).c("oreDiamond"));
		a(57, "diamond_block", (new axq(boh.G)).c(5.0F).b(10.0F).a(j).c("blockDiamond"));
		a(58, "crafting_table", (new aus()).c(2.5F).a(f).c("workbench"));
		a(59, "wheat", (new auu()).c("crops"));
		atr var6 = (new avu()).c(0.6F).a(g).c("farmland");
		a(60, "farmland", var6);
		a(61, "furnace", (new awj(false)).c(3.5F).a(i).c("furnace").a(akf.c));
		a(62, "lit_furnace", (new awj(true)).c(3.5F).a(i).a(0.875F).c("furnace"));
		a(63, "standing_sign", (new baw()).c(1.0F).a(f).c("sign").J());
		a(64, "wooden_door", (new avf(bof.d)).c(3.0F).a(f).c("doorOak").J());
		a(65, "ladder", (new axe()).c(0.4F).a(o).c("ladder"));
		a(66, "rail", (new azo()).c(0.7F).a(j).c("rail"));
		a(67, "stone_stairs", (new bat(var0.P())).c("stairsStone"));
		a(68, "wall_sign", (new bbz()).c(1.0F).a(f).c("sign").J());
		a(69, "lever", (new axi()).c(0.5F).a(f).c("lever"));
		a(70, "stone_pressure_plate", (new azf(bof.e, azh.b)).c(0.5F).a(i).c("pressurePlateStone"));
		a(71, "iron_door", (new avf(bof.f)).c(5.0F).a(j).c("doorIron").J());
		a(72, "wooden_pressure_plate", (new azf(bof.d, azh.a)).c(0.5F).a(f).c("pressurePlateWood"));
		a(73, "redstone_ore", (new azs(false)).c(3.0F).b(5.0F).a(i).c("oreRedstone").a(akf.b));
		a(74, "lit_redstone_ore", (new azs(true)).a(0.625F).c(3.0F).b(5.0F).a(i).c("oreRedstone"));
		a(75, "unlit_redstone_torch", (new azw(false)).c(0.0F).a(f).c("notGate"));
		a(76, "redstone_torch", (new azw(true)).c(0.0F).a(0.5F).a(f).c("notGate").a(akf.d));
		a(77, "stone_button", (new bbe()).c(0.5F).a(i).c("button"));
		a(78, "snow_layer", (new bao()).c(0.1F).a(n).c("snow").e(0));
		a(79, "ice", (new axb()).c(0.5F).e(3).a(k).c("ice"));
		a(80, "snow", (new ban()).c(0.2F).a(n).c("snow"));
		a(81, "cactus", (new auf()).c(0.4F).a(l).c("cactus"));
		a(82, "clay", (new auk()).c(0.6F).a(g).c("clay"));
		a(83, "reeds", (new azy()).c(0.0F).a(h).c("reeds").J());
		a(84, "jukebox", (new axc()).c(2.0F).b(10.0F).a(i).c("jukebox"));
		a(85, "fence", (new avv(bof.d)).c(2.0F).b(5.0F).a(f).c("fence"));
		atr var7 = (new azk()).c(1.0F).a(f).c("pumpkin");
		a(86, "pumpkin", var7);
		a(87, "netherrack", (new ayf()).c(0.4F).a(i).c("hellrock"));
		a(88, "soul_sand", (new bap()).c(0.5F).a(m).c("hellsand"));
		a(89, "glowstone", (new awm(bof.s)).c(0.3F).a(k).a(1.0F).c("lightgem"));
		a(90, "portal", (new ayy()).c(-1.0F).a(k).a(0.75F).c("portal"));
		a(91, "lit_pumpkin", (new azk()).c(1.0F).a(f).a(1.0F).c("litpumpkin"));
		a(92, "cake", (new aug()).c(0.5F).a(l).c("cake").J());
		a(93, "unpowered_repeater", (new azz(false)).c(0.0F).a(f).c("diode").J());
		a(94, "powered_repeater", (new azz(true)).c(0.0F).a(f).c("diode").J());
		a(95, "stained_glass", (new bar(bof.s)).c(0.3F).a(k).c("stainedGlass"));
		a(96, "trapdoor", (new bbp(bof.d)).c(3.0F).a(f).c("trapdoor").J());
		a(97, "monster_egg", (new axs()).c(0.75F).c("monsterStoneEgg"));
		atr var8 = (new bbc()).c(1.5F).b(10.0F).a(i).c("stonebricksmooth");
		a(98, "stonebrick", var8);
		a(99, "brown_mushroom_block", (new awz(bof.d, var3)).c(0.2F).a(f).c("mushroom"));
		a(100, "red_mushroom_block", (new awz(bof.d, var4)).c(0.2F).a(f).c("mushroom"));
		a(101, "iron_bars", (new bbj(bof.f, true)).c(5.0F).b(10.0F).a(j).c("fenceIron"));
		a(102, "glass_pane", (new bbj(bof.s, false)).c(0.3F).a(k).c("thinGlass"));
		atr var9 = (new axp()).c(1.0F).a(f).c("melon");
		a(103, "melon_block", var9);
		a(104, "pumpkin_stem", (new bay(var7)).c(0.0F).a(f).c("pumpkinStem"));
		a(105, "melon_stem", (new bay(var9)).c(0.0F).a(f).c("pumpkinStem"));
		a(106, "vine", (new bbv()).c(0.2F).a(h).c("vine"));
		a(107, "fence_gate", (new avw()).c(2.0F).b(5.0F).a(f).c("fenceGate"));
		a(108, "brick_stairs", (new bat(var5.P())).c("stairsBrick"));
		a(109, "stone_brick_stairs", (new bat(var8.P().a(bbc.a, bbd.a))).c("stairsStoneBrickSmooth"));
		a(110, "mycelium", (new ayc()).c(0.6F).a(h).c("mycel"));
		a(111, "waterlily", (new bcb()).c(0.0F).a(h).c("waterlily"));
		atr var10 = (new ayd()).c(2.0F).b(10.0F).a(i).c("netherBrick").a(akf.b);
		a(112, "nether_brick", var10);
		a(113, "nether_brick_fence", (new avv(bof.e)).c(2.0F).b(10.0F).a(i).c("netherFence"));
		a(114, "nether_brick_stairs", (new bat(var10.P())).c("stairsNetherBrick"));
		a(115, "nether_wart", (new aye()).c("netherStalk"));
		a(116, "enchanting_table", (new avo()).c(5.0F).b(2000.0F).c("enchantmentTable"));
		a(117, "brewing_stand", (new aub()).c(0.5F).a(0.125F).c("brewingStand"));
		a(118, "cauldron", (new aui()).c(2.0F).c("cauldron"));
		a(119, "end_portal", (new avp(bof.E)).c(-1.0F).b(6000000.0F));
		a(120, "end_portal_frame", (new avq()).a(k).a(0.125F).c(-1.0F).c("endPortalFrame").b(6000000.0F).a(akf.c));
		a(121, "end_stone", (new atr(bof.e)).c(3.0F).b(15.0F).a(i).c("whiteStone").a(akf.b));
		a(122, "dragon_egg", (new avl()).c(3.0F).b(15.0F).a(i).a(0.125F).c("dragonEgg"));
		a(123, "redstone_lamp", (new azv(false)).c(0.3F).a(k).c("redstoneLight").a(akf.d));
		a(124, "lit_redstone_lamp", (new azv(true)).c(0.3F).a(k).c("redstoneLight"));
		a(125, "double_wooden_slab", (new awi()).c(2.0F).b(5.0F).a(f).c("woodSlab"));
		a(126, "wooden_slab", (new awu()).c(2.0F).b(5.0F).a(f).c("woodSlab"));
		a(127, "cocoa", (new aul()).c(0.2F).b(5.0F).a(f).c("cocoa"));
		a(128, "sandstone_stairs", (new bat(var2.P().a(bad.a, bae.c))).c("stairsSandStone"));
		a(129, "emerald_ore", (new ayu()).c(3.0F).b(5.0F).a(i).c("oreEmerald"));
		a(130, "ender_chest", (new avr()).c(22.5F).b(1000.0F).a(i).c("enderChest").a(0.5F));
		a(131, "tripwire_hook", (new bbt()).c("tripWireSource"));
		a(132, "tripwire", (new bbs()).c("tripWire"));
		a(133, "emerald_block", (new axq(boh.I)).c(5.0F).b(10.0F).a(j).c("blockEmerald"));
		a(134, "spruce_stairs", (new bat(var1.P().a(ayw.a, ayx.b))).c("stairsWoodSpruce"));
		a(135, "birch_stairs", (new bat(var1.P().a(ayw.a, ayx.c))).c("stairsWoodBirch"));
		a(136, "jungle_stairs", (new bat(var1.P().a(ayw.a, ayx.d))).c("stairsWoodJungle"));
		a(137, "command_block", (new auo()).v().b(6000000.0F).c("commandBlock"));
		a(138, "beacon", (new atm()).c("beacon").a(1.0F));
		a(139, "cobblestone_wall", (new bbx(var0)).c("cobbleWall"));
		a(140, "flower_pot", (new awd()).c(0.0F).a(e).c("flowerPot"));
		a(141, "carrots", (new auh()).c("carrots"));
		a(142, "potatoes", (new aza()).c("potatoes"));
		a(143, "wooden_button", (new bce()).c(0.5F).a(f).c("button"));
		a(144, "skull", (new baj()).c(1.0F).a(i).c("skull"));
		a(145, "anvil", (new asz()).c(5.0F).a(p).b(2000.0F).c("anvil"));
		a(146, "trapped_chest", (new auj(1)).c(2.5F).a(f).c("chestTrap"));
		a(147, "light_weighted_pressure_plate", (new bcd("gold_block", bof.f, 15)).c(0.5F).a(f).c("weightedPlate_light"));
		a(148, "heavy_weighted_pressure_plate", (new bcd("iron_block", bof.f, 150)).c(0.5F).a(f).c("weightedPlate_heavy"));
		a(149, "unpowered_comparator", (new aup(false)).c(0.0F).a(f).c("comparator").J());
		a(150, "powered_comparator", (new aup(true)).c(0.0F).a(0.625F).a(f).c("comparator").J());
		a(151, "daylight_detector", new auv(false));
		a(152, "redstone_block", (new azb(boh.f)).c(5.0F).b(10.0F).a(j).c("blockRedstone"));
		a(153, "quartz_ore", (new ayu()).c(3.0F).b(5.0F).a(i).c("netherquartz"));
		a(154, "hopper", (new awx()).c(3.0F).b(8.0F).a(j).c("hopper"));
		atr var11 = (new azl()).a(i).c(0.8F).c("quartzBlock");
		a(155, "quartz_block", var11);
		a(156, "quartz_stairs", (new bat(var11.P().a(azl.a, azn.a))).c("stairsQuartz"));
		a(157, "activator_rail", (new azc()).c(0.7F).a(j).c("activatorRail"));
		a(158, "dropper", (new avm()).c(3.5F).a(i).c("dropper"));
		a(159, "stained_hardened_clay", (new aun(bof.e)).c(1.25F).b(7.0F).a(i).c("clayHardenedStained"));
		a(160, "stained_glass_pane", (new bas()).c(0.3F).a(k).c("thinStainedGlass"));
		a(161, "leaves2", (new ayg()).c("leaves"));
		a(162, "log2", (new ayi()).c("log"));
		a(163, "acacia_stairs", (new bat(var1.P().a(ayw.a, ayx.e))).c("stairsWoodAcacia"));
		a(164, "dark_oak_stairs", (new bat(var1.P().a(ayw.a, ayx.f))).c("stairsWoodDarkOak"));
		a(165, "slime", (new bam()).c("slime").a(q));
		a(166, "barrier", (new atf()).c("barrier"));
		a(167, "iron_trapdoor", (new bbp(bof.f)).c(5.0F).a(j).c("ironTrapdoor").J());
		a(168, "prismarine", (new azi()).c(1.5F).b(10.0F).a(i).c("prismarine"));
		a(169, "sea_lantern", (new bah(bof.s)).c(0.3F).a(k).a(1.0F).c("seaLantern"));
		a(170, "hay_block", (new aww()).c(0.5F).a(h).c("hayBlock").a(akf.b));
		a(171, "carpet", (new bcg()).c(0.1F).a(l).c("woolCarpet").e(0));
		a(172, "hardened_clay", (new awv()).c(1.25F).b(7.0F).a(i).c("clayHardened"));
		a(173, "coal_block", (new atr(bof.e)).c(5.0F).b(10.0F).a(i).c("blockCoal").a(akf.b));
		a(174, "packed_ice", (new ayv()).c(0.5F).a(k).c("icePacked"));
		a(175, "double_plant", new avi());
		a(176, "standing_banner", (new atd()).c(1.0F).a(f).c("banner").J());
		a(177, "wall_banner", (new ate()).c(1.0F).a(f).c("banner").J());
		a(178, "daylight_detector_inverted", new auv(true));
		atr var12 = (new azq()).a(i).c(0.8F).c("redSandStone");
		a(179, "red_sandstone", var12);
		a(180, "red_sandstone_stairs", (new bat(var12.P().a(azq.a, azr.c))).c("stairsRedSandStone"));
		a(181, "double_stone_slab2", (new awg()).c(2.0F).b(10.0F).a(i).c("stoneSlab2"));
		a(182, "stone_slab2", (new awp()).c(2.0F).b(10.0F).a(i).c("stoneSlab2"));
		a(183, "spruce_fence_gate", (new avw()).c(2.0F).b(5.0F).a(f).c("spruceFenceGate"));
		a(184, "birch_fence_gate", (new avw()).c(2.0F).b(5.0F).a(f).c("birchFenceGate"));
		a(185, "jungle_fence_gate", (new avw()).c(2.0F).b(5.0F).a(f).c("jungleFenceGate"));
		a(186, "dark_oak_fence_gate", (new avw()).c(2.0F).b(5.0F).a(f).c("darkOakFenceGate"));
		a(187, "acacia_fence_gate", (new avw()).c(2.0F).b(5.0F).a(f).c("acaciaFenceGate"));
		a(188, "spruce_fence", (new avv(bof.d)).c(2.0F).b(5.0F).a(f).c("spruceFence"));
		a(189, "birch_fence", (new avv(bof.d)).c(2.0F).b(5.0F).a(f).c("birchFence"));
		a(190, "jungle_fence", (new avv(bof.d)).c(2.0F).b(5.0F).a(f).c("jungleFence"));
		a(191, "dark_oak_fence", (new avv(bof.d)).c(2.0F).b(5.0F).a(f).c("darkOakFence"));
		a(192, "acacia_fence", (new avv(bof.d)).c(2.0F).b(5.0F).a(f).c("acaciaFence"));
		a(193, "spruce_door", (new avf(bof.d)).c(3.0F).a(f).c("doorSpruce").J());
		a(194, "birch_door", (new avf(bof.d)).c(3.0F).a(f).c("doorBirch").J());
		a(195, "jungle_door", (new avf(bof.d)).c(3.0F).a(f).c("doorJungle").J());
		a(196, "acacia_door", (new avf(bof.d)).c(3.0F).a(f).c("doorAcacia").J());
		a(197, "dark_oak_door", (new avf(bof.d)).c(3.0F).a(f).c("doorDarkOak").J());
		c.a();
		Iterator var13 = c.iterator();

		atr var14;
		while (var13.hasNext()) {
			var14 = (atr) var13.next();
			if (var14.J == bof.a) {
				var14.v = false;
			} else {
				boolean var15 = false;
				boolean var16 = var14 instanceof bat;
				boolean var17 = var14 instanceof awq;
				boolean var18 = var14 == var6;
				boolean var19 = var14.t;
				boolean var20 = var14.s == 0;
				if (var16 || var17 || var18 || var19 || var20) {
					var15 = true;
				}

				var14.v = var15;
			}
		}

		var13 = c.iterator();

		while (var13.hasNext()) {
			var14 = (atr) var13.next();
			Iterator var21 = var14.O().a().iterator();

			while (var21.hasNext()) {
				bec var22 = (bec) var21.next();
				int var23 = c.b(var14) << 4 | var14.c(var22);
				d.a(var22, var23);
			}
		}

	}

	private static void a(int var0, oa var1, atr var2) {
		c.a(var0, var1, var2);
	}

	private static void a(int var0, String var1, atr var2) {
		a(var0, new oa(var1), var2);
	}

}
