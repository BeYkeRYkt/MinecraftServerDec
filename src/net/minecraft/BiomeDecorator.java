package net.minecraft;

import java.util.Random;

public class BiomeDecorator {

	protected World a;
	protected Random b;
	protected Position c;
	protected ChunkProviderGenerateProperties d;
	protected WorldGenerator e = new bhl(4);
	protected WorldGenerator f;
	protected WorldGenerator g;
	protected WorldGenerator h;
	protected WorldGenerator i;
	protected WorldGenerator j;
	protected WorldGenerator k;
	protected WorldGenerator l;
	protected WorldGenerator m;
	protected WorldGenerator n;
	protected WorldGenerator o;
	protected WorldGenerator p;
	protected WorldGenerator q;
	protected WorldGenerator r;
	protected bhq s;
	protected WorldGenerator t;
	protected WorldGenerator u;
	protected WorldGenerator v;
	protected WorldGenerator w;
	protected WorldGenerator x;
	protected WorldGenerator y;
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

	public BiomeDecorator() {
		this.f = new bik(Blocks.SAND, 7);
		this.g = new bik(Blocks.GRAVEL, 6);
		this.s = new bhq(Blocks.YELLOW_FLOWER, EnumFlowerType.a);
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

	public void a(World var1, Random var2, BiomeBase var3, Position var4) {
		if (this.a != null) {
			throw new RuntimeException("Already decorating");
		} else {
			this.a = var1;
			String var5 = var1.getWorldData().getGeneratorOptions();
			if (var5 != null) {
				this.d = ChunkProviderGeneratePropertiesHolder.fromJSON(var5).getPropertiesHolder();
			} else {
				this.d = ChunkProviderGeneratePropertiesHolder.fromJSON("").getPropertiesHolder();
			}

			this.b = var2;
			this.c = var4;
			this.h = new bif(Blocks.DIRT.getBlockState(), this.d.dirtSize);
			this.i = new bif(Blocks.GRAVEL.getBlockState(), this.d.gravelSize);
			this.j = new bif(Blocks.STONE.getBlockState().a(BlockStone.a, bbb.b), this.d.graniteSize);
			this.k = new bif(Blocks.STONE.getBlockState().a(BlockStone.a, bbb.d), this.d.dioriteSize);
			this.l = new bif(Blocks.STONE.getBlockState().a(BlockStone.a, bbb.f), this.d.andesiteSize);
			this.m = new bif(Blocks.COAL_ORE.getBlockState(), this.d.coalSize);
			this.n = new bif(Blocks.IRON_ORE.getBlockState(), this.d.ironSize);
			this.o = new bif(Blocks.GOLD_ORE.getBlockState(), this.d.goldSize);
			this.p = new bif(Blocks.REDSTONE_ORE.getBlockState(), this.d.redstoneSize);
			this.q = new bif(Blocks.DIAMOND_ORE.getBlockState(), this.d.diamondSize);
			this.r = new bif(Blocks.LAPIS_ORE.getBlockState(), this.d.lapisSize);
			this.a(var3);
			this.a = null;
			this.b = null;
		}
	}

	protected void a(BiomeBase var1) {
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
			WorldGenTreeAbstract var6 = var1.a(this.b);
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
			EnumFlowerType var8 = var1.a(this.b, var7);
			BlockFlowers var9 = var8.a().a();
			if (var9.getMaterial() != Material.AIR) {
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

	protected void a(int var1, WorldGenerator var2, int var3, int var4) {
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

	protected void b(int var1, WorldGenerator var2, int var3, int var4) {
		for (int var5 = 0; var5 < var1; ++var5) {
			Position var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4) + this.b.nextInt(var4) + var3 - var4, this.b.nextInt(16));
			var2.b(this.a, this.b, var6);
		}

	}

	protected void a() {
		this.a(this.d.dirtCount, this.h, this.d.dirtMinHeight, this.d.dirtMaxHeight);
		this.a(this.d.gravelCount, this.i, this.d.gravelMinHeight, this.d.gravelMaxHeight);
		this.a(this.d.dioriteCount, this.k, this.d.dioriteMinHeight, this.d.dioriteMaxHeight);
		this.a(this.d.graniteCount, this.j, this.d.graniteMinHeight, this.d.graniteMaxHeight);
		this.a(this.d.andesiteCount, this.l, this.d.andesiteMinHeight, this.d.andesiteMaxHeight);
		this.a(this.d.coalCount, this.m, this.d.coalMinHeight, this.d.coalMaxHeight);
		this.a(this.d.ironCount, this.n, this.d.ironMinHeight, this.d.ironMaxHeight);
		this.a(this.d.goldCount, this.o, this.d.goldMinHeight, this.d.goldMaxHeight);
		this.a(this.d.redstoneCount, this.p, this.d.redstoneMinHeight, this.d.redstoneMaxHeight);
		this.a(this.d.diamondCount, this.q, this.d.diamondMinHeight, this.d.diamondMaxHeight);
		this.b(this.d.lapisCount, this.r, this.d.lapisCenterHeight, this.d.lapisSpread);
	}
}
