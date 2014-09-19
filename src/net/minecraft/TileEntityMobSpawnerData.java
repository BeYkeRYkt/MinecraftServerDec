package net.minecraft;

public class TileEntityMobSpawnerData extends vk {

	private final NBTCompoundTag c;
	private final String d;
	// $FF: synthetic field
	final MobSpawnerAbstract b;

	public TileEntityMobSpawnerData(MobSpawnerAbstract var1, NBTCompoundTag var2) {
		this(var1, var2.getCompound("Properties"), var2.getString("Type"), var2.getInt("Weight"));
	}

	public TileEntityMobSpawnerData(MobSpawnerAbstract var1, NBTCompoundTag var2, String var3) {
		this(var1, var2, var3, 1);
	}

	private TileEntityMobSpawnerData(MobSpawnerAbstract var1, NBTCompoundTag var2, String var3, int var4) {
		super(var4);
		this.b = var1;
		if (var3.equals("Minecart")) {
			if (var2 != null) {
				var3 = MinecartType.byId(var2.getInt("Type")).getName();
			} else {
				var3 = "MinecartRideable";
			}
		}

		this.c = var2;
		this.d = var3;
	}

	public NBTCompoundTag a() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		var1.put("Properties", (NBTTag) this.c);
		var1.put("Type", this.d);
		var1.put("Weight", this.a);
		return var1;
	}

	// $FF: synthetic method
	static String a(TileEntityMobSpawnerData var0) {
		return var0.d;
	}

	// $FF: synthetic method
	static NBTCompoundTag b(TileEntityMobSpawnerData var0) {
		return var0.c;
	}
}
