package net.minecraft;

public enum axu implements va {

	a("STONE", 0, 0, "stone") {
		@Override
		public bec d() {
			return aty.b.P().a(BlockStone.a, bbb.a);
		}
	},
	b("COBBLESTONE", 1, 1, "cobblestone", "cobble") {
		@Override
		public bec d() {
			return aty.e.P();
		}
	},
	c("STONEBRICK", 2, 2, "stone_brick", "brick") {
		@Override
		public bec d() {
			return aty.bf.P().a(BlockSmoothBrick.a, bbd.a);
		}
	},
	d("MOSSY_STONEBRICK", 3, 3, "mossy_brick", "mossybrick") {
		@Override
		public bec d() {
			return aty.bf.P().a(BlockSmoothBrick.a, bbd.b);
		}
	},
	e("CRACKED_STONEBRICK", 4, 4, "cracked_brick", "crackedbrick") {
		@Override
		public bec d() {
			return aty.bf.P().a(BlockSmoothBrick.a, bbd.c);
		}
	},
	f("CHISELED_STONEBRICK", 5, 5, "chiseled_brick", "chiseledbrick") {
		@Override
		public bec d() {
			return aty.bf.P().a(BlockSmoothBrick.a, bbd.d);
		}
	};

	private static final axu[] g = new axu[values().length];
	private final int h;
	private final String i;
	private final String j;
	// $FF: synthetic field
	private static final axu[] k = new axu[] { a, b, c, d, e, f };

	private axu(String var1, int var2, int var3, String var4) {
		this(var1, var2, var3, var4, var4);
	}

	private axu(String var1, int var2, int var3, String var4, String var5) {
		this.h = var3;
		this.i = var4;
		this.j = var5;
	}

	public int a() {
		return this.h;
	}

	public String toString() {
		return this.i;
	}

	public static axu a(int var0) {
		if (var0 < 0 || var0 >= g.length) {
			var0 = 0;
		}

		return g[var0];
	}

	public String l() {
		return this.i;
	}

	public String c() {
		return this.j;
	}

	public abstract bec d();

	public static axu a(bec var0) {
		axu[] var1 = values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			axu var4 = var1[var3];
			if (var0 == var4.d()) {
				return var4;
			}
		}

		return a;
	}

	// $FF: synthetic method
	axu(String var1, int var2, int var3, String var4, axt var5) {
		this(var1, var2, var3, var4);
	}

	// $FF: synthetic method
	axu(String var1, int var2, int var3, String var4, String var5, axt var6) {
		this(var1, var2, var3, var4, var5);
	}

	static {
		axu[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			axu var3 = var0[var2];
			g[var3.a()] = var3;
		}

	}
}
