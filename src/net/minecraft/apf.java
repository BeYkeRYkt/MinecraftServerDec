package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public abstract class apf {

	private static final apf[] a = new apf[256];
	public static final apf[] b;
	private static final Map E = Maps.newHashMap();
	public static final apf c = new apu(0, new BlockNameInfo("protection"), 10, 0);
	public static final apf d = new apu(1, new BlockNameInfo("fire_protection"), 5, 1);
	public static final apf e = new apu(2, new BlockNameInfo("feather_falling"), 5, 2);
	public static final apf f = new apu(3, new BlockNameInfo("blast_protection"), 2, 3);
	public static final apf g = new apu(4, new BlockNameInfo("projectile_protection"), 5, 4);
	public static final apf h = new apt(5, new BlockNameInfo("respiration"), 2);
	public static final apf i = new apy(6, new BlockNameInfo("aqua_affinity"), 2);
	public static final apf j = new apv(7, new BlockNameInfo("thorns"), 1);
	public static final apf k = new apx(8, new BlockNameInfo("depth_strider"), 2);
	public static final apf l = new apc(16, new BlockNameInfo("sharpness"), 10, 0);
	public static final apf m = new apc(17, new BlockNameInfo("smite"), 5, 1);
	public static final apf n = new apc(18, new BlockNameInfo("bane_of_arthropods"), 5, 2);
	public static final apf o = new apr(19, new BlockNameInfo("knockback"), 5);
	public static final apf p = new app(20, new BlockNameInfo("fire_aspect"), 2);
	public static final apf q = new aps(21, new BlockNameInfo("looting"), 2, apg.g);
	public static final apf r = new ape(32, new BlockNameInfo("efficiency"), 10);
	public static final apf s = new apw(33, new BlockNameInfo("silk_touch"), 1);
	public static final apf t = new apd(34, new BlockNameInfo("unbreaking"), 5);
	public static final apf u = new aps(35, new BlockNameInfo("fortune"), 2, apg.h);
	public static final apf v = new aoy(48, new BlockNameInfo("power"), 10);
	public static final apf w = new apb(49, new BlockNameInfo("punch"), 2);
	public static final apf x = new aoz(50, new BlockNameInfo("flame"), 2);
	public static final apf y = new apa(51, new BlockNameInfo("infinity"), 1);
	public static final apf z = new aps(61, new BlockNameInfo("luck_of_the_sea"), 2, apg.i);
	public static final apf A = new apq(62, new BlockNameInfo("lure"), 2, apg.i);
	public final int B;
	private final int F;
	public apg C;
	protected String D;

	public static apf c(int var0) {
		return var0 >= 0 && var0 < a.length ? a[var0] : null;
	}

	protected apf(int var1, BlockNameInfo var2, int var3, apg var4) {
		this.B = var1;
		this.F = var3;
		this.C = var4;
		if (a[var1] != null) {
			throw new IllegalArgumentException("Duplicate enchantment id!");
		} else {
			a[var1] = this;
			E.put(var2, this);
		}
	}

	public static apf b(String var0) {
		return (apf) E.get(new BlockNameInfo(var0));
	}

	public static String[] c() {
		String[] var0 = new String[E.size()];
		int var1 = 0;

		BlockNameInfo var3;
		for (Iterator var2 = E.keySet().iterator(); var2.hasNext(); var0[var1++] = var3.toString()) {
			var3 = (BlockNameInfo) var2.next();
		}

		return var0;
	}

	public int d() {
		return this.F;
	}

	public int e() {
		return 1;
	}

	public int b() {
		return 1;
	}

	public int a(int var1) {
		return 1 + var1 * 10;
	}

	public int b(int var1) {
		return this.a(var1) + 5;
	}

	public int a(int var1, wh var2) {
		return 0;
	}

	public float a(int var1, xs var2) {
		return 0.0F;
	}

	public boolean a(apf var1) {
		return this != var1;
	}

	public apf c(String var1) {
		this.D = var1;
		return this;
	}

	public String a() {
		return "enchantment." + this.D;
	}

	public String d(int var1) {
		String var2 = fi.a(this.a());
		return var2 + " " + fi.a("enchantment.level." + var1);
	}

	public boolean a(ItemStack var1) {
		return this.C.a(var1.getItem());
	}

	public void a(EntityLiving var1, Entity var2, int var3) {
	}

	public void b(EntityLiving var1, Entity var2, int var3) {
	}

	static {
		ArrayList var0 = Lists.newArrayList();
		apf[] var1 = a;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			apf var4 = var1[var3];
			if (var4 != null) {
				var0.add(var4);
			}
		}

		b = (apf[]) var0.toArray(new apf[var0.size()]);
	}
}
