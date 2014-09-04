package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public enum adz {

	a("RIDEABLE", 0, 0, "MinecartRideable"), b("CHEST", 1, 1, "MinecartChest"), c("FURNACE", 2, 2, "MinecartFurnace"), d("TNT", 3, 3, "MinecartTNT"), e("SPAWNER", 4, 4, "MinecartSpawner"), f("HOPPER", 5, 5, "MinecartHopper"), g("COMMAND_BLOCK", 6, 6, "MinecartCommandBlock");
	private static final Map h = Maps.newHashMap();
	private final int i;
	private final String j;
	// $FF: synthetic field
	private static final adz[] k = new adz[] { a, b, c, d, e, f, g };

	private adz(String var1, int var2, int var3, String var4) {
		this.i = var3;
		this.j = var4;
	}

	public int a() {
		return this.i;
	}

	public String b() {
		return this.j;
	}

	public static adz a(int var0) {
		adz var1 = (adz) h.get(Integer.valueOf(var0));
		return var1 == null ? a : var1;
	}

	static {
		adz[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			adz var3 = var0[var2];
			h.put(Integer.valueOf(var3.a()), var3);
		}

	}
}
