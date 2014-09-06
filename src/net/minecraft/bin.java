package net.minecraft;

import java.util.Random;

public class bin extends bhp {

	private Block a;

	public bin(Block var1) {
		this.a = var1;
	}

	public boolean b(World var1, Random var2, Position var3) {
		if (var1.p(var3.a()).getBlock() != Blocks.STONE) {
			return false;
		} else if (var1.p(var3.b()).getBlock() != Blocks.STONE) {
			return false;
		} else if (var1.p(var3).getBlock().r() != Material.AIR && var1.p(var3).getBlock() != Blocks.STONE) {
			return false;
		} else {
			int var4 = 0;
			if (var1.p(var3.e()).getBlock() == Blocks.STONE) {
				++var4;
			}

			if (var1.p(var3.f()).getBlock() == Blocks.STONE) {
				++var4;
			}

			if (var1.p(var3.c()).getBlock() == Blocks.STONE) {
				++var4;
			}

			if (var1.p(var3.d()).getBlock() == Blocks.STONE) {
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

			if (var4 == 3 && var5 == 1) {
				var1.a(var3, this.a.P(), 2);
				var1.a(this.a, var3, var2);
			}

			return true;
		}
	}
}
