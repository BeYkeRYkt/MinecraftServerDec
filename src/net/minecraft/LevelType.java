package net.minecraft;

public class LevelType {

	public static final LevelType[] LEVELS = new LevelType[16];
	public static final LevelType DEFAULT = (new LevelType(0, "default", 1)).setDefault();
	public static final LevelType FLAT = new LevelType(1, "flat");
	public static final LevelType LARGE_BIOMES = new LevelType(2, "largeBiomes");
	public static final LevelType AMPLIFIED = (new LevelType(3, "amplified"));
	public static final LevelType CUSTOM = new LevelType(4, "customized");
	public static final LevelType DEBUG = new LevelType(5, "debug_all_block_states");
	public static final LevelType DEFAULT_1_1 = (new LevelType(8, "default_1_1", 0));

	public static LevelType getByName(String name) {
		for (int i = 0; i < LEVELS.length; ++i) {
			if (LEVELS[i] != null && LEVELS[i].name.equalsIgnoreCase(name)) {
				return LEVELS[i];
			}
		}

		return null;
	}

	private final int id;
	private final String name;
	private final int version;
	private boolean defualt;

	private LevelType(int id, String name) {
		this(id, name, 0);
	}

	private LevelType(int id, String name, int version) {
		this.name = name;
		this.version = version;
		this.id = id;
		LEVELS[id] = this;
	}

	public String getName() {
		return this.name;
	}

	public int getVersion() {
		return this.version;
	}

	public LevelType levelByVersion(int version) {
		return this == DEFAULT && version == 0 ? DEFAULT_1_1 : this;
	}

	private LevelType setDefault() {
		this.defualt = true;
		return this;
	}

	public boolean isDefault() {
		return this.defualt;
	}

	public int getId() {
		return this.id;
	}

}
