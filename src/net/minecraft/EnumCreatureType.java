package net.minecraft;

public enum EnumCreatureType {

	a("MONSTER", 0, aex.class, 70, Material.AIR, false, false), b("CREATURE", 1, abq.class, 10, Material.AIR, true, true), c("AMBIENT", 2, abn.class, 15, Material.AIR, true, false), d("WATER_CREATURE", 3, act.class, 5, Material.WATER, true, false);
	private final Class e;
	private final int f;
	private final Material g;
	private final boolean h;
	private final boolean i;
	// $FF: synthetic field
	private static final EnumCreatureType[] j = new EnumCreatureType[] { a, b, c, d };

	private EnumCreatureType(String var1, int var2, Class var3, int var4, Material var5, boolean var6, boolean var7) {
		this.e = var3;
		this.f = var4;
		this.g = var5;
		this.h = var6;
		this.i = var7;
	}

	public Class a() {
		return this.e;
	}

	public int b() {
		return this.f;
	}

	public boolean d() {
		return this.h;
	}

	public boolean e() {
		return this.i;
	}

}
