package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class azw extends bbl {

	private static Map b = Maps.newHashMap();
	private final boolean M;

	private boolean a(World var1, Position var2, boolean var3) {
		if (!b.containsKey(var1)) {
			b.put(var1, Lists.newArrayList());
		}

		List var4 = (List) b.get(var1);
		if (var3) {
			var4.add(new azx(var2, var1.K()));
		}

		int var5 = 0;

		for (int var6 = 0; var6 < var4.size(); ++var6) {
			azx var7 = (azx) var4.get(var6);
			if (var7.a.equals(var2)) {
				++var5;
				if (var5 >= 8) {
					return true;
				}
			}
		}

		return false;
	}

	protected azw(boolean var1) {
		this.M = var1;
		this.a(true);
		this.a((CreativeModeTab) null);
	}

	public int a(World var1) {
		return 2;
	}

	public void c(World var1, Position var2, bec var3) {
		if (this.M) {
			ej[] var4 = ej.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				ej var7 = var4[var6];
				var1.c(var2.a(var7), (Block) this);
			}
		}

	}

	public void b(World var1, Position var2, bec var3) {
		if (this.M) {
			ej[] var4 = ej.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				ej var7 = var4[var6];
				var1.c(var2.a(var7), (Block) this);
			}
		}

	}

	public int a(ard var1, Position var2, bec var3, ej var4) {
		return this.M && var3.b(a) != var4 ? 15 : 0;
	}

	private boolean g(World var1, Position var2, bec var3) {
		ej var4 = ((ej) var3.b(a)).d();
		return var1.b(var2.a(var4), var4);
	}

	public void a(World var1, Position var2, bec var3, Random var4) {
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		boolean var5 = this.g(var1, var2, var3);
		List var6 = (List) b.get(var1);

		while (var6 != null && !var6.isEmpty() && var1.K() - ((azx) var6.get(0)).b > 60L) {
			var6.remove(0);
		}

		if (this.M) {
			if (var5) {
				var1.a(var2, aty.aE.P().a(a, var3.b(a)), 3);
				if (this.a(var1, var2, true)) {
					var1.a((double) ((float) var2.n() + 0.5F), (double) ((float) var2.o() + 0.5F), (double) ((float) var2.p() + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

					for (int var7 = 0; var7 < 5; ++var7) {
						double var8 = (double) var2.n() + var4.nextDouble() * 0.6D + 0.2D;
						double var10 = (double) var2.o() + var4.nextDouble() * 0.6D + 0.2D;
						double var12 = (double) var2.p() + var4.nextDouble() * 0.6D + 0.2D;
						var1.a(ew.l, var8, var10, var12, 0.0D, 0.0D, 0.0D, new int[0]);
					}

					var1.a(var2, var1.p(var2).c(), 160);
				}
			}
		} else if (!var5 && !this.a(var1, var2, false)) {
			var1.a(var2, aty.aF.P().a(a, var3.b(a)), 3);
		}

	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!this.e(var1, var2, var3)) {
			if (this.M == this.g(var1, var2, var3)) {
				var1.a(var2, (Block) this, this.a(var1));
			}

		}
	}

	public int b(ard var1, Position var2, bec var3, ej var4) {
		return var4 == ej.a ? this.a(var1, var2, var3, var4) : 0;
	}

	public Item a(bec var1, Random var2, int var3) {
		return Item.getItemOf(aty.aF);
	}

	public boolean g() {
		return true;
	}

	public boolean b(Block var1) {
		return var1 == aty.aE || var1 == aty.aF;
	}

}
