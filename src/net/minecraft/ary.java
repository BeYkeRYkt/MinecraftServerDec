package net.minecraft;

import java.util.Random;

public class ary {

	protected World a;
	protected Random b;
	protected Position c;
	protected bgl d;
	protected bhp e = new bhl(4);
	protected bhp f;
	protected bhp g;
	protected bhp h;
	protected bhp i;
	protected bhp j;
	protected bhp k;
	protected bhp l;
	protected bhp m;
	protected bhp n;
	protected bhp o;
	protected bhp p;
	protected bhp q;
	protected bhp r;
	protected bhq s;
	protected bhp t;
	protected bhp u;
	protected bhp v;
	protected bhp w;
	protected bhp x;
	protected bhp y;
	protected int z;
	protected int A;
	protected int B;
	protected int C;
	protected int D;
	protected int E;
	protected int F;
	protected int G;
	protected int H;
	protected int I;
	protected int J;
	protected int K;
	public boolean L;

	public ary() {
		this.f = new bik(Blocks.SAND, 7);
		this.g = new bik(Blocks.GRAVEL, 6);
		this.s = new bhq(Blocks.YELLOW_FLOWER, awa.a);
		this.t = new bhi(Blocks.BRWON_MUSHROOM);
		this.u = new bhi(Blocks.RED_MUSHROOM);
		this.v = new bhv();
		this.w = new bii();
		this.x = new bhj();
		this.y = new bit();
		this.B = 2;
		this.C = 1;
		this.H = 1;
		this.I = 3;
		this.J = 1;
		this.L = true;
	}

	public void a(World var1, Random var2, arm var3, Position var4) {
		if (this.a != null) {
			throw new RuntimeException("Already decorating");
		} else {
			this.a = var1;
			String var5 = var1.P().B();
			if (var5 != null) {
				this.d = bgn.a(var5).b();
			} else {
				this.d = bgn.a("").b();
			}

			this.b = var2;
			this.c = var4;
			this.h = new bif(Blocks.DIRT.P(), this.d.I);
			this.i = new bif(Blocks.GRAVEL.P(), this.d.M);
			this.j = new bif(Blocks.STONE.P().a(BlockStone.a, bbb.b), this.d.Q);
			this.k = new bif(Blocks.STONE.P().a(BlockStone.a, bbb.d), this.d.U);
			this.l = new bif(Blocks.STONE.P().a(BlockStone.a, bbb.f), this.d.Y);
			this.m = new bif(Blocks.COAL_ORE.P(), this.d.ac);
			this.n = new bif(Blocks.IRON_ORE.P(), this.d.ag);
			this.o = new bif(Blocks.GOLD_ORE.P(), this.d.ak);
			this.p = new bif(Blocks.REDSTONE_ORE.P(), this.d.ao);
			this.q = new bif(Blocks.DIAMOND_ORE.P(), this.d.as);
			this.r = new bif(Blocks.LAPIS_ORE.P(), this.d.aw);
			this.a(var3);
			this.a = null;
			this.b = null;
		}
	}

	protected void a(arm var1) {
		this.a();

		int var2;
		int var3;
		int var4;
		for (var2 = 0; var2 < this.I; ++var2) {
			var3 = this.b.nextInt(16) + 8;
			var4 = this.b.nextInt(16) + 8;
			this.f.b(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
		}

		for (var2 = 0; var2 < this.J; ++var2) {
			var3 = this.b.nextInt(16) + 8;
			var4 = this.b.nextInt(16) + 8;
			this.e.b(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
		}

		for (var2 = 0; var2 < this.H; ++var2) {
			var3 = this.b.nextInt(16) + 8;
			var4 = this.b.nextInt(16) + 8;
			this.g.b(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
		}

		var2 = this.A;
		if (this.b.nextInt(10) == 0) {
			++var2;
		}

		int var5;
		Position var7;
		for (var3 = 0; var3 < var2; ++var3) {
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(16) + 8;
			bhc var6 = var1.a(this.b);
			var6.e();
			var7 = this.a.m(this.c.a(var4, 0, var5));
			if (var6.b(this.a, this.b, var7)) {
				var6.a(this.a, this.b, var7);
			}
		}

		for (var3 = 0; var3 < this.K; ++var3) {
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(16) + 8;
			this.v.b(this.a, this.b, this.a.m(this.c.a(var4, 0, var5)));
		}

		int var11;
		for (var3 = 0; var3 < this.B; ++var3) {
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(16) + 8;
			var11 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).getY() + 32);
			var7 = this.c.a(var4, var11, var5);
			awa var8 = var1.a(this.b, var7);
			BlockFlowers var9 = var8.a().a();
			if (var9.r() != Material.AIR) {
				this.s.a(var9, var8);
				this.s.b(this.a, this.b, var7);
			}
		}

		for (var3 = 0; var3 < this.C; ++var3) {
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(16) + 8;
			var11 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).getY() * 2);
			var1.b(this.b).b(this.a, this.b, this.c.a(var4, var11, var5));
		}

		for (var3 = 0; var3 < this.D; ++var3) {
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(16) + 8;
			var11 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).getY() * 2);
			(new bhm()).b(this.a, this.b, this.c.a(var4, var11, var5));
		}

		var3 = 0;

		while (var3 < this.z) {
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(16) + 8;
			var11 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).getY() * 2);
			var7 = this.c.a(var4, var11, var5);

			while (true) {
				if (var7.getY() > 0) {
					Position var13 = var7.b();
					if (this.a.d(var13)) {
						var7 = var13;
						continue;
					}
				}

				this.y.b(this.a, this.b, var7);
				++var3;
				break;
			}
		}

		for (var3 = 0; var3 < this.E; ++var3) {
			if (this.b.nextInt(4) == 0) {
				var4 = this.b.nextInt(16) + 8;
				var5 = this.b.nextInt(16) + 8;
				Position var12 = this.a.m(this.c.a(var4, 0, var5));
				this.t.b(this.a, this.b, var12);
			}

			if (this.b.nextInt(8) == 0) {
				var4 = this.b.nextInt(16) + 8;
				var5 = this.b.nextInt(16) + 8;
				var11 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).getY() * 2);
				var7 = this.c.a(var4, var11, var5);
				this.u.b(this.a, this.b, var7);
			}
		}

		if (this.b.nextInt(4) == 0) {
			var3 = this.b.nextInt(16) + 8;
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(this.a.m(this.c.a(var3, 0, var4)).getY() * 2);
			this.t.b(this.a, this.b, this.c.a(var3, var5, var4));
		}

		if (this.b.nextInt(8) == 0) {
			var3 = this.b.nextInt(16) + 8;
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(this.a.m(this.c.a(var3, 0, var4)).getY() * 2);
			this.u.b(this.a, this.b, this.c.a(var3, var5, var4));
		}

		for (var3 = 0; var3 < this.F; ++var3) {
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(16) + 8;
			var11 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).getY() * 2);
			this.w.b(this.a, this.b, this.c.a(var4, var11, var5));
		}

		for (var3 = 0; var3 < 10; ++var3) {
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(16) + 8;
			var11 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).getY() * 2);
			this.w.b(this.a, this.b, this.c.a(var4, var11, var5));
		}

		if (this.b.nextInt(32) == 0) {
			var3 = this.b.nextInt(16) + 8;
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(this.a.m(this.c.a(var3, 0, var4)).getY() * 2);
			(new bih()).b(this.a, this.b, this.c.a(var3, var5, var4));
		}

		for (var3 = 0; var3 < this.G; ++var3) {
			var4 = this.b.nextInt(16) + 8;
			var5 = this.b.nextInt(16) + 8;
			var11 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).getY() * 2);
			this.x.b(this.a, this.b, this.c.a(var4, var11, var5));
		}

		if (this.L) {
			Position var10;
			for (var3 = 0; var3 < 50; ++var3) {
				var10 = this.c.a(this.b.nextInt(16) + 8, this.b.nextInt(this.b.nextInt(248) + 8), this.b.nextInt(16) + 8);
				(new bin(Blocks.FLOWING_WATER)).b(this.a, this.b, var10);
			}

			for (var3 = 0; var3 < 20; ++var3) {
				var10 = this.c.a(this.b.nextInt(16) + 8, this.b.nextInt(this.b.nextInt(this.b.nextInt(240) + 8) + 8), this.b.nextInt(16) + 8);
				(new bin(Blocks.FLOWING_LAVA)).b(this.a, this.b, var10);
			}
		}

	}

	protected void a(int var1, bhp var2, int var3, int var4) {
		int var5;
		if (var4 < var3) {
			var5 = var3;
			var3 = var4;
			var4 = var5;
		} else if (var4 == var3) {
			if (var3 < 255) {
				++var4;
			} else {
				--var3;
			}
		}

		for (var5 = 0; var5 < var1; ++var5) {
			Position var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4 - var3) + var3, this.b.nextInt(16));
			var2.b(this.a, this.b, var6);
		}

	}

	protected void b(int var1, bhp var2, int var3, int var4) {
		for (int var5 = 0; var5 < var1; ++var5) {
			Position var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4) + this.b.nextInt(var4) + var3 - var4, this.b.nextInt(16));
			var2.b(this.a, this.b, var6);
		}

	}

	protected void a() {
		this.a(this.d.J, this.h, this.d.K, this.d.L);
		this.a(this.d.N, this.i, this.d.O, this.d.P);
		this.a(this.d.V, this.k, this.d.W, this.d.X);
		this.a(this.d.R, this.j, this.d.S, this.d.T);
		this.a(this.d.Z, this.l, this.d.aa, this.d.ab);
		this.a(this.d.ad, this.m, this.d.ae, this.d.af);
		this.a(this.d.ah, this.n, this.d.ai, this.d.aj);
		this.a(this.d.al, this.o, this.d.am, this.d.an);
		this.a(this.d.ap, this.p, this.d.aq, this.d.ar);
		this.a(this.d.at, this.q, this.d.au, this.d.av);
		this.b(this.d.ax, this.r, this.d.ay, this.d.az);
	}
}
