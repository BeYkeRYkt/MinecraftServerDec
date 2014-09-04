package net.minecraft;

import java.util.List;
import java.util.Random;

public class ajq extends alq {

	public ajq() {
		this.a(akf.c);
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		if (var5 == ej.a) {
			return false;
		} else {
			boolean var9 = var3.p(var4).c().f(var3, var4);
			dt var10 = var9 ? var4 : var4.a(var5);
			if (!var2.a(var10, var5, var1)) {
				return false;
			} else {
				dt var11 = var10.a();
				boolean var12 = !var3.d(var10) && !var3.p(var10).c().f(var3, var10);
				var12 |= !var3.d(var11) && !var3.p(var11).c().f(var3, var11);
				if (var12) {
					return false;
				} else {
					double var13 = (double) var10.n();
					double var15 = (double) var10.o();
					double var17 = (double) var10.p();
					List var19 = var3.b((Entity) null, brt.a(var13, var15, var17, var13 + 1.0D, var15 + 2.0D, var17 + 1.0D));
					if (var19.size() > 0) {
						return false;
					} else {
						if (!var3.D) {
							var3.g(var10);
							var3.g(var11);
							adi var20 = new adi(var3, var13 + 0.5D, var15, var17 + 0.5D);
							float var21 = (float) NumberConverter.d((NumberConverter.g(var2.y - 180.0F) + 22.5F) / 45.0F) * 45.0F;
							var20.b(var13 + 0.5D, var15, var17 + 0.5D, var21, 0.0F);
							this.a(var20, var3.s);
							NBTCompoundTag var22 = var1.o();
							if (var22 != null && var22.isTagAssignableFrom("EntityTag", 10)) {
								NBTCompoundTag var23 = new NBTCompoundTag();
								var20.d(var23);
								var23.copyFrom(var22.getCompound("EntityTag"));
								var20.f(var23);
							}

							var3.d((Entity) var20);
						}

						--var1.b;
						return true;
					}
				}
			}
		}
	}

	private void a(adi var1, Random var2) {
		fa var3 = var1.s();
		float var5 = var2.nextFloat() * 5.0F;
		float var6 = var2.nextFloat() * 20.0F - 10.0F;
		fa var4 = new fa(var3.b() + var5, var3.c() + var6, var3.d());
		var1.a(var4);
		var3 = var1.t();
		var5 = var2.nextFloat() * 10.0F - 5.0F;
		var4 = new fa(var3.b(), var3.c() + var5, var3.d());
		var1.b(var4);
	}
}
