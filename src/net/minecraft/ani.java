package net.minecraft;

public class ani extends aju {

	private final awq b;
	private final awq c;

	public ani(Block var1, awq var2, awq var3) {
		super(var1);
		this.b = var2;
		this.c = var3;
		this.d(0);
		this.a(true);
	}

	public int a(int var1) {
		return var1;
	}

	public String e_(ItemStack var1) {
		return this.b.b(var1.i());
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var1.b == 0) {
			return false;
		} else if (!var2.a(var4.a(var5), var5, var1)) {
			return false;
		} else {
			Object var9 = this.b.a(var1);
			bec var10 = var3.p(var4);
			if (var10.c() == this.b) {
				bex var11 = this.b.l();
				Comparable var12 = var10.b(var11);
				awr var13 = (awr) var10.b(awq.a);
				if ((var5 == PaintingDirection.b && var13 == awr.b || var5 == PaintingDirection.a && var13 == awr.a) && var12 == var9) {
					bec var14 = this.c.P().a(var11, var12);
					if (var3.b(this.c.a(var3, var4, var14)) && var3.a(var4, var14, 3)) {
						var3.a((double) ((float) var4.n() + 0.5F), (double) ((float) var4.o() + 0.5F), (double) ((float) var4.p() + 0.5F), this.c.H.b(), (this.c.H.d() + 1.0F) / 2.0F, this.c.H.e() * 0.8F);
						--var1.b;
					}

					return true;
				}
			}

			return this.a(var1, var3, var4.a(var5), var9) ? true : super.a(var1, var2, var3, var4, var5, var6, var7, var8);
		}
	}

	private boolean a(ItemStack var1, World var2, Position var3, Object var4) {
		bec var5 = var2.p(var3);
		if (var5.c() == this.b) {
			Comparable var6 = var5.b(this.b.l());
			if (var6 == var4) {
				bec var7 = this.c.P().a(this.b.l(), var6);
				if (var2.b(this.c.a(var2, var3, var7)) && var2.a(var3, var7, 3)) {
					var2.a((double) ((float) var3.n() + 0.5F), (double) ((float) var3.o() + 0.5F), (double) ((float) var3.p() + 0.5F), this.c.H.b(), (this.c.H.d() + 1.0F) / 2.0F, this.c.H.e() * 0.8F);
					--var1.b;
				}

				return true;
			}
		}

		return false;
	}
}
