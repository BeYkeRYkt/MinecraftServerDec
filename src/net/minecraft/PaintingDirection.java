package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;

public enum PaintingDirection implements va {

	a("DOWN", 0, 0, 1, -1, "down", em.b, el.b, new fd(0, -1, 0)), 
	b("UP", 1, 1, 0, -1, "up", em.a, el.b, new fd(0, 1, 0)), 
	c("NORTH", 2, 2, 3, 2, "north", em.b, el.c, new fd(0, 0, -1)), 
	d("SOUTH", 3, 3, 2, 0, "south", em.a, el.c, new fd(0, 0, 1)), 
	e("WEST", 4, 4, 5, 1, "west", em.b, el.a, new fd(-1, 0, 0)), 
	f("EAST", 5, 5, 4, 3, "east", em.a, el.a, new fd(1, 0, 0));

	private final int g;
	private final int h;
	private final int i;
	private final String j;
	private final el k;
	private final em l;
	private final fd m;
	private static final PaintingDirection[] n = new PaintingDirection[6];
	private static final PaintingDirection[] o = new PaintingDirection[4];
	private static final Map p = Maps.newHashMap();

	private PaintingDirection(String var1, int var2, int var3, int var4, int var5, String var6, em var7, el var8, fd var9) {
		this.g = var3;
		this.i = var5;
		this.h = var4;
		this.j = var6;
		this.k = var8;
		this.l = var7;
		this.m = var9;
	}

	public int a() {
		return this.g;
	}

	public int toByte() {
		return this.i;
	}

	public em c() {
		return this.l;
	}

	public PaintingDirection d() {
		return a(this.h);
	}

	public PaintingDirection e() {
		switch (ek.b[this.ordinal()]) {
			case 1:
				return f;
			case 2:
				return d;
			case 3:
				return e;
			case 4:
				return c;
			default:
				throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
		}
	}

	public PaintingDirection f() {
		switch (ek.b[this.ordinal()]) {
			case 1:
				return e;
			case 2:
				return c;
			case 3:
				return f;
			case 4:
				return d;
			default:
				throw new IllegalStateException("Unable to get CCW facing of " + this);
		}
	}

	public int g() {
		return this.k == el.a ? this.l.a() : 0;
	}

	public int h() {
		return this.k == el.b ? this.l.a() : 0;
	}

	public int i() {
		return this.k == el.c ? this.l.a() : 0;
	}

	public String j() {
		return this.j;
	}

	public el k() {
		return this.k;
	}

	public static PaintingDirection a(int var0) {
		return n[DataTypesConverter.a(var0 % n.length)];
	}

	public static PaintingDirection fromByte(int var0) {
		return o[DataTypesConverter.a(var0 % o.length)];
	}

	public static PaintingDirection a(double var0) {
		return fromByte(DataTypesConverter.toFixedPointInt(var0 / 90.0D + 0.5D) & 3);
	}

	public static PaintingDirection a(Random var0) {
		return values()[var0.nextInt(values().length)];
	}

	public String toString() {
		return this.j;
	}

	public String l() {
		return this.j;
	}

	static {
		PaintingDirection[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			PaintingDirection var3 = var0[var2];
			n[var3.g] = var3;
			if (var3.k().c()) {
				o[var3.i] = var3;
			}

			p.put(var3.j().toLowerCase(), var3);
		}

	}
}
