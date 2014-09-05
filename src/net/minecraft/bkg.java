package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class bkg extends bmm {

	private int f;
	private int g;
	public static final List d = Arrays.asList(new arm[] { arm.p, arm.N, arm.w, arm.z, arm.A });
	private static final List h = Lists.newArrayList();

	public bkg() {
		this.f = 32;
		this.g = 5;
	}

	public bkg(Map var1) {
		this();
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((String) var3.getKey()).equals("spacing")) {
				this.f = DataTypesConverter.a((String) var3.getValue(), this.f, 1);
			} else if (((String) var3.getKey()).equals("separation")) {
				this.g = DataTypesConverter.a((String) var3.getValue(), this.g, 1);
			}
		}

	}

	public String a() {
		return "Monument";
	}

	protected boolean a(int var1, int var2) {
		int var3 = var1;
		int var4 = var2;
		if (var1 < 0) {
			var1 -= this.f - 1;
		}

		if (var2 < 0) {
			var2 -= this.f - 1;
		}

		int var5 = var1 / this.f;
		int var6 = var2 / this.f;
		Random var7 = this.c.a(var5, var6, 10387313);
		var5 *= this.f;
		var6 *= this.f;
		var5 += (var7.nextInt(this.f - this.g) + var7.nextInt(this.f - this.g)) / 2;
		var6 += (var7.nextInt(this.f - this.g) + var7.nextInt(this.f - this.g)) / 2;
		if (var3 == var5 && var4 == var6) {
			if (this.c.v().a(new Position(var3 * 16 + 8, 64, var4 * 16 + 8), (arm) null) != arm.N) {
				return false;
			}

			boolean var8 = this.c.v().a(var3 * 16 + 8, var4 * 16 + 8, 29, d);
			if (var8) {
				return true;
			}
		}

		return false;
	}

	protected bmv b(int var1, int var2) {
		return new bkh(this.c, this.b, var1, var2);
	}

	public List b() {
		return h;
	}

	static {
		h.add(new arq(EntityGuardian.class, 1, 2, 4));
	}
}
