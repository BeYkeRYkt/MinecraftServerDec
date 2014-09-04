package net.minecraft;

public enum arc {

	a("NOT_SET", 0, -1, ""), b("SURVIVAL", 1, 0, "survival"), c("CREATIVE", 2, 1, "creative"), d("ADVENTURE", 3, 2, "adventure"), e("SPECTATOR", 4, 3, "spectator");
	int f;
	String g;
	// $FF: synthetic field
	private static final arc[] h = new arc[] { a, b, c, d, e };

	private arc(String var1, int var2, int var3, String var4) {
		this.f = var3;
		this.g = var4;
	}

	public int a() {
		return this.f;
	}

	public String b() {
		return this.g;
	}

	public void a(aha var1) {
		if (this == c) {
			var1.c = true;
			var1.d = true;
			var1.a = true;
		} else if (this == e) {
			var1.c = true;
			var1.d = false;
			var1.a = true;
			var1.b = true;
		} else {
			var1.c = false;
			var1.d = false;
			var1.a = false;
			var1.b = false;
		}

		var1.e = !this.c();
	}

	public boolean c() {
		return this == d || this == e;
	}

	public boolean d() {
		return this == c;
	}

	public boolean e() {
		return this == b || this == d;
	}

	public static arc a(int var0) {
		arc[] var1 = values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			arc var4 = var1[var3];
			if (var4.f == var0) {
				return var4;
			}
		}

		return b;
	}

}
