package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public enum ali {

	a("COD", 0, 0, "cod", 2, 0.1F, 5, 0.6F), b("SALMON", 1, 1, "salmon", 2, 0.1F, 6, 0.8F), c("CLOWNFISH", 2, 2, "clownfish", 1, 0.1F), d("PUFFERFISH", 3, 3, "pufferfish", 1, 0.1F);
	private static final Map e = Maps.newHashMap();
	private final int f;
	private final String g;
	private final int h;
	private final float i;
	private final int j;
	private final float k;
	private boolean l = false;
	// $FF: synthetic field
	private static final ali[] m = new ali[] { a, b, c, d };

	private ali(String var1, int var2, int var3, String var4, int var5, float var6, int var7, float var8) {
		this.f = var3;
		this.g = var4;
		this.h = var5;
		this.i = var6;
		this.j = var7;
		this.k = var8;
		this.l = true;
	}

	private ali(String var1, int var2, int var3, String var4, int var5, float var6) {
		this.f = var3;
		this.g = var4;
		this.h = var5;
		this.i = var6;
		this.j = 0;
		this.k = 0.0F;
		this.l = false;
	}

	public int a() {
		return this.f;
	}

	public String b() {
		return this.g;
	}

	public int c() {
		return this.h;
	}

	public float d() {
		return this.i;
	}

	public int e() {
		return this.j;
	}

	public float f() {
		return this.k;
	}

	public boolean g() {
		return this.l;
	}

	public static ali a(int var0) {
		ali var1 = (ali) e.get(Integer.valueOf(var0));
		return var1 == null ? a : var1;
	}

	public static ali a(ItemStack var0) {
		return var0.getItem() instanceof ItemFish ? a(var0.i()) : a;
	}

	static {
		ali[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			ali var3 = var0[var2];
			e.put(Integer.valueOf(var3.a()), var3);
		}

	}
}
