package net.minecraft;

enum ace {

	a("NONE", 0, 0.0F, 0.0F, 30, 1), b("HOP", 1, 0.8F, 0.2F, 20, 10), c("STEP", 2, 1.0F, 0.45F, 14, 14), d("SPRINT", 3, 1.75F, 0.4F, 1, 8), e("ATTACK", 4, 2.0F, 0.7F, 7, 8);
	private final float f;
	private final float g;
	private final int h;
	private final int i;
	// $FF: synthetic field
	private static final ace[] j = new ace[] { a, b, c, d, e };

	private ace(String var1, int var2, float var3, float var4, int var5, int var6) {
		this.f = var3;
		this.g = var4;
		this.h = var5;
		this.i = var6;
	}

	public float a() {
		return this.f;
	}

	public float b() {
		return this.g;
	}

	public int c() {
		return this.h;
	}

	public int d() {
		return this.i;
	}

}
