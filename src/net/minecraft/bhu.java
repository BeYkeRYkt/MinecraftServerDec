package net.minecraft;

import java.util.Random;

public class bhu extends bhp {

	private final Block a;
	private final boolean b;

	public bhu(Block var1, boolean var2) {
		this.a = var1;
		this.b = var2;
	}

	public boolean b(World var1, Random var2, Position var3) {
		if (var1.p(var3.a()).c() != aty.aV) {
			return false;
		} else if (var1.p(var3).c().r() != Material.AIR && var1.p(var3).c() != aty.aV) {
			return false;
		} else {
			int var4 = 0;
			if (var1.p(var3.e()).c() == aty.aV) {
				++var4;
			}

			if (var1.p(var3.f()).c() == aty.aV) {
				++var4;
			}

			if (var1.p(var3.c()).c() == aty.aV) {
				++var4;
			}

			if (var1.p(var3.d()).c() == aty.aV) {
				++var4;
			}

			if (var1.p(var3.b()).c() == aty.aV) {
				++var4;
			}

			int var5 = 0;
			if (var1.d(var3.e())) {
				++var5;
			}

			if (var1.d(var3.f())) {
				++var5;
			}

			if (var1.d(var3.c())) {
				++var5;
			}

			if (var1.d(var3.d())) {
				++var5;
			}

			if (var1.d(var3.b())) {
				++var5;
			}

			if (!this.b && var4 == 4 && var5 == 1 || var4 == 5) {
				var1.a(var3, this.a.P(), 2);
				var1.a(this.a, var3, var2);
			}

			return true;
		}
	}
}
