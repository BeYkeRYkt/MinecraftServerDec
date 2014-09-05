package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import java.util.Iterator;

public class bek {

	private final Predicate[][][] a;
	private final int b;
	private final int c;
	private final int d;

	public bek(Predicate[][][] var1) {
		this.a = var1;
		this.b = var1.length;
		if (this.b > 0) {
			this.c = var1[0].length;
			if (this.c > 0) {
				this.d = var1[0][0].length;
			} else {
				this.d = 0;
			}
		} else {
			this.c = 0;
			this.d = 0;
		}

	}

	public int b() {
		return this.c;
	}

	public int c() {
		return this.d;
	}

	private bem a(Position var1, ej var2, ej var3, LoadingCache var4) {
		for (int var5 = 0; var5 < this.d; ++var5) {
			for (int var6 = 0; var6 < this.c; ++var6) {
				for (int var7 = 0; var7 < this.b; ++var7) {
					if (!this.a[var7][var6][var5].apply(var4.getUnchecked(a(var1, var2, var3, var5, var6, var7)))) {
						return null;
					}
				}
			}
		}

		return new bem(var1, var2, var3, var4);
	}

	public bem a(World var1, Position var2) {
		LoadingCache var3 = CacheBuilder.newBuilder().build(new bel(var1));
		int var4 = Math.max(Math.max(this.d, this.c), this.b);
		Iterator var5 = Position.a(var2, var2.a(var4 - 1, var4 - 1, var4 - 1)).iterator();

		while (var5.hasNext()) {
			Position var6 = (Position) var5.next();
			ej[] var7 = ej.values();
			int var8 = var7.length;

			for (int var9 = 0; var9 < var8; ++var9) {
				ej var10 = var7[var9];
				ej[] var11 = ej.values();
				int var12 = var11.length;

				for (int var13 = 0; var13 < var12; ++var13) {
					ej var14 = var11[var13];
					if (var14 != var10 && var14 != var10.d()) {
						bem var15 = this.a(var6, var10, var14, var3);
						if (var15 != null) {
							return var15;
						}
					}
				}
			}
		}

		return null;
	}

	protected static Position a(Position var0, ej var1, ej var2, int var3, int var4, int var5) {
		if (var1 != var2 && var1 != var2.d()) {
			fd var6 = new fd(var1.g(), var1.h(), var1.i());
			fd var7 = new fd(var2.g(), var2.h(), var2.i());
			fd var8 = var6.d(var7);
			return var0.a(var7.n() * -var4 + var8.n() * var3 + var6.n() * var5, var7.o() * -var4 + var8.o() * var3 + var6.o() * var5, var7.p() * -var4 + var8.p() * var3 + var6.p() * var5);
		} else {
			throw new IllegalArgumentException("Invalid forwards & up combination");
		}
	}
}
