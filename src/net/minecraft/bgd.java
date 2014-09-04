package net.minecraft;

public abstract class bgd {

	public static final float[] a = new float[] { 1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F };
	protected World b;
	private are h;
	private String i;
	protected arz c;
	protected boolean d;
	protected boolean e;
	protected final float[] f = new float[16];
	protected int g;
	private final float[] j = new float[4];

	public final void a(World var1) {
		this.b = var1;
		this.h = var1.P().u();
		this.i = var1.P().B();
		this.b();
		this.a();
	}

	protected void a() {
		float var1 = 0.0F;

		for (int var2 = 0; var2 <= 15; ++var2) {
			float var3 = 1.0F - (float) var2 / 15.0F;
			this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
		}

	}

	protected void b() {
		are var1 = this.b.P().u();
		if (var1 == are.c) {
			biv var2 = biv.a(this.b.P().B());
			this.c = new asc(arm.a(var2.a(), arm.ad), 0.5F);
		} else if (var1 == are.g) {
			this.c = new asc(arm.q, 0.0F);
		} else {
			this.c = new arz(this.b);
		}

	}

	public bfe c() {
		return (bfe) (this.h == are.c ? new bgq(this.b, this.b.J(), this.b.P().s(), this.i) : (this.h == are.g ? new bgp(this.b) : (this.h == are.f ? new bgv(this.b, this.b.J(), this.b.P().s(), this.i) : new bgv(this.b, this.b.J(), this.b.P().s(), this.i))));
	}

	public boolean a(int var1, int var2) {
		return this.b.c(new dt(var1, 0, var2)) == aty.c;
	}

	public float a(long var1, float var3) {
		int var4 = (int) (var1 % 24000L);
		float var5 = ((float) var4 + var3) / 24000.0F - 0.25F;
		if (var5 < 0.0F) {
			++var5;
		}

		if (var5 > 1.0F) {
			--var5;
		}

		float var6 = var5;
		var5 = 1.0F - (float) ((Math.cos((double) var5 * 3.141592653589793D) + 1.0D) / 2.0D);
		var5 = var6 + (var5 - var6) / 3.0F;
		return var5;
	}

	public int a(long var1) {
		return (int) (var1 / 24000L % 8L + 8L) % 8;
	}

	public boolean d() {
		return true;
	}

	public boolean e() {
		return true;
	}

	public static bgd a(int var0) {
		return (bgd) (var0 == -1 ? new bge() : (var0 == 0 ? new bgg() : (var0 == 1 ? new bgh() : null)));
	}

	public dt h() {
		return null;
	}

	public int i() {
		return this.h == are.c ? 4 : 64;
	}

	public abstract String k();

	public abstract String l();

	public arz m() {
		return this.c;
	}

	public boolean n() {
		return this.d;
	}

	public boolean o() {
		return this.e;
	}

	public float[] p() {
		return this.f;
	}

	public int q() {
		return this.g;
	}

	public bfb r() {
		return new bfb();
	}

}
