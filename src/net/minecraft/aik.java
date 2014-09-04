package net.minecraft;

class aik extends ajk {

	private ahd a;

	public aik(ahd var1, vq var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		this.a = var1;
	}

	public boolean a(amj var1) {
		return b_(var1);
	}

	public int a() {
		return 1;
	}

	public void a(ahd var1, amj var2) {
		if (var2.b() == amk.bz && var2.i() > 0) {
			this.a.b((PlayerStatistic) tl.B);
		}

		super.a(var1, var2);
	}

	public static boolean b_(amj var0) {
		return var0 != null && (var0.b() == amk.bz || var0.b() == amk.bA);
	}
}
