package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Map;

public enum ew {

	a("EXPLOSION_NORMAL", 0, "explode", 0, true), b("EXPLOSION_LARGE", 1, "largeexplode", 1, true), c("EXPLOSION_HUGE", 2, "hugeexplosion", 2, true), d("FIREWORKS_SPARK", 3, "fireworksSpark", 3, false), e("WATER_BUBBLE", 4, "bubble", 4, false), f("WATER_SPLASH", 5, "splash", 5, false), g("WATER_WAKE", 6, "wake", 6, false), h("SUSPENDED", 7, "suspended", 7, false), i("SUSPENDED_DEPTH", 8, "depthsuspend", 8, false), j("CRIT", 9, "crit", 9, false), k("CRIT_MAGIC", 10, "magicCrit", 10, false), l(
			"SMOKE_NORMAL", 11, "smoke", 11, false), m("SMOKE_LARGE", 12, "largesmoke", 12, false), n("SPELL", 13, "spell", 13, false), o("SPELL_INSTANT", 14, "instantSpell", 14, false), p("SPELL_MOB", 15, "mobSpell", 15, false), q("SPELL_MOB_AMBIENT", 16, "mobSpellAmbient", 16, false), r("SPELL_WITCH", 17, "witchMagic", 17, false), s("DRIP_WATER", 18, "dripWater", 18, false), t("DRIP_LAVA", 19, "dripLava", 19, false), u("VILLAGER_ANGRY", 20, "angryVillager", 20, false), v("VILLAGER_HAPPY", 21,
			"happyVillager", 21, false), w("TOWN_AURA", 22, "townaura", 22, false), x("NOTE", 23, "note", 23, false), y("PORTAL", 24, "portal", 24, false), z("ENCHANTMENT_TABLE", 25, "enchantmenttable", 25, false), A("FLAME", 26, "flame", 26, false), B("LAVA", 27, "lava", 27, false), C("FOOTSTEP", 28, "footstep", 28, false), D("CLOUD", 29, "cloud", 29, false), E("REDSTONE", 30, "reddust", 30, false), F("SNOWBALL", 31, "snowballpoof", 31, false), G("SNOW_SHOVEL", 32, "snowshovel", 32, false), H(
			"SLIME", 33, "slime", 33, false), I("HEART", 34, "heart", 34, false), J("BARRIER", 35, "barrier", 35, false), K("ITEM_CRACK", 36, "iconcrack_", 36, false, 2), L("BLOCK_CRACK", 37, "blockcrack_", 37, false, 1), M("BLOCK_DUST", 38, "blockdust_", 38, false, 1), N("WATER_DROP", 39, "droplet", 39, false), O("ITEM_TAKE", 40, "take", 40, false), P("MOB_APPEARANCE", 41, "mobappearance", 41, true);
	private final String Q;
	private final int R;
	private final boolean S;
	private final int T;
	private static final Map U = Maps.newHashMap();
	private static final String[] V;
	// $FF: synthetic field
	private static final ew[] W = new ew[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P };

	private ew(String var1, int var2, String var3, int var4, boolean var5, int var6) {
		this.Q = var3;
		this.R = var4;
		this.S = var5;
		this.T = var6;
	}

	private ew(String var1, int var2, String var3, int var4, boolean var5) {
		this(var1, var2, var3, var4, var5, 0);
	}

	public static String[] a() {
		return V;
	}

	public String b() {
		return this.Q;
	}

	public int c() {
		return this.R;
	}

	public int d() {
		return this.T;
	}

	public boolean e() {
		return this.S;
	}

	public boolean f() {
		return this.T > 0;
	}

	public static ew a(int var0) {
		return (ew) U.get(Integer.valueOf(var0));
	}

	static {
		ArrayList var0 = Lists.newArrayList();
		ew[] var1 = values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			ew var4 = var1[var3];
			U.put(Integer.valueOf(var4.c()), var4);
			if (!var4.b().endsWith("_")) {
				var0.add(var4.b());
			}
		}

		V = (String[]) var0.toArray(new String[var0.size()]);
	}
}
