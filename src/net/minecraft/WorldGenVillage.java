package net.minecraft;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class WorldGenVillage extends StructureGenerator {

	public static final List d = Arrays.asList(new BiomeBase[] { BiomeBase.PLAINS, BiomeBase.DESERT, BiomeBase.SAVANNA });
	private int f;
	private int g;
	private int h;

	public WorldGenVillage() {
		this.g = 32;
		this.h = 8;
	}

	public WorldGenVillage(Map var1) {
		this();
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((String) var3.getKey()).equals("size")) {
				this.f = MathHelper.a((String) var3.getValue(), this.f, 0);
			} else if (((String) var3.getKey()).equals("distance")) {
				this.g = MathHelper.a((String) var3.getValue(), this.g, this.h + 1);
			}
		}

	}

	public String getName() {
		return "Village";
	}

	protected boolean a(int var1, int var2) {
		int var3 = var1;
		int var4 = var2;
		if (var1 < 0) {
			var1 -= this.g - 1;
		}

		if (var2 < 0) {
			var2 -= this.g - 1;
		}

		int var5 = var1 / this.g;
		int var6 = var2 / this.g;
		Random var7 = this.c.a(var5, var6, 10387312);
		var5 *= this.g;
		var6 *= this.g;
		var5 += var7.nextInt(this.g - this.h);
		var6 += var7.nextInt(this.g - this.h);
		if (var3 == var5 && var4 == var6) {
			boolean var8 = this.c.v().a(var3 * 16 + 8, var4 * 16 + 8, 0, d);
			if (var8) {
				return true;
			}
		}

		return false;
	}

	protected StructureStart b(int var1, int var2) {
		return new bmx(this.c, this.b, var1, var2, this.f);
	}

}
