package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class WorldGenLargeFeature extends StructureGenerator {

	private static final List d = Arrays.asList(new BiomeBase[] { BiomeBase.r, BiomeBase.G, BiomeBase.K, BiomeBase.L, BiomeBase.v });
	private List f;
	private int g;
	private int h;

	public WorldGenLargeFeature() {
		this.f = Lists.newArrayList();
		this.g = 32;
		this.h = 8;
		this.f.add(new arq(EntityWitch.class, 1, 1, 1));
	}

	public WorldGenLargeFeature(Map var1) {
		this();
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((String) var3.getKey()).equals("distance")) {
				this.g = DataTypesConverter.a((String) var3.getValue(), this.g, this.h + 1);
			}
		}

	}

	public String getName() {
		return "Temple";
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
		Random var7 = this.c.a(var5, var6, 14357617);
		var5 *= this.g;
		var6 *= this.g;
		var5 += var7.nextInt(this.g - this.h);
		var6 += var7.nextInt(this.g - this.h);
		if (var3 == var5 && var4 == var6) {
			BiomeBase var8 = this.c.v().a(new Position(var3 * 16 + 8, 0, var4 * 16 + 8));
			if (var8 == null) {
				return false;
			}

			Iterator var9 = d.iterator();

			while (var9.hasNext()) {
				BiomeBase var10 = (BiomeBase) var9.next();
				if (var8 == var10) {
					return true;
				}
			}
		}

		return false;
	}

	protected bmv b(int var1, int var2) {
		return new blh(this.c, this.b, var1, var2);
	}

	public boolean a(Position var1) {
		bmv var2 = this.c(var1);
		if (var2 != null && var2 instanceof blh && !var2.a.isEmpty()) {
			bms var3 = (bms) var2.a.getFirst();
			return var3 instanceof blo;
		} else {
			return false;
		}
	}

	public List b() {
		return this.f;
	}

}
