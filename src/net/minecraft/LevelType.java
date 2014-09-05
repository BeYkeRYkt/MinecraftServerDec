package net.minecraft;

public class LevelType {

	public static final LevelType[] LEVELS = new LevelType[16];
	public static final LevelType DEFAULT = (new LevelType(0, "default", 1)).i();
	public static final LevelType FLAT = new LevelType(1, "flat");
	public static final LevelType LARGE_BIOMES = new LevelType(2, "largeBiomes");
	public static final LevelType AMPLIFIED = (new LevelType(3, "amplified")).j();
	public static final LevelType CUSTOM = new LevelType(4, "customized");
	public static final LevelType DEBUG = new LevelType(5, "debug_all_block_states");
	public static final LevelType DEFAULT_1_1 = (new LevelType(8, "default_1_1", 0)).a(false);
	private final int i;
	private final String j;
	private final int k;
	private boolean m;

	private LevelType(int var1, String var2) {
		this(var1, var2, 0);
	}

	private LevelType(int var1, String var2, int var3) {
		this.j = var2;
		this.k = var3;
		this.i = var1;
		LEVELS[var1] = this;
	}

	public String a() {
		return this.j;
	}

	public int d() {
		return this.k;
	}

	public LevelType a(int var1) {
		return this == DEFAULT && var1 == 0 ? DEFAULT_1_1 : this;
	}

	private LevelType a(boolean var1) {
		return this;
	}

	private LevelType i() {
		this.m = true;
		return this;
	}

	public boolean f() {
		return this.m;
	}

	public static LevelType byName(String var0) {
		for (int var1 = 0; var1 < LEVELS.length; ++var1) {
			if (LEVELS[var1] != null && LEVELS[var1].j.equalsIgnoreCase(var0)) {
				return LEVELS[var1];
			}
		}

		return null;
	}

	public int g() {
		return this.i;
	}

	private LevelType j() {
		return this;
	}

}
