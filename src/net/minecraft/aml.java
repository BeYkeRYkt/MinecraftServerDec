package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class aml extends Item {

	public aml() {
		this.a(CreativeModeTab.i);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		Block var9 = var3.p(var4).c();
		if (var9 instanceof BlockFence) {
			if (var3.D) {
				return true;
			} else {
				a(var2, var3, var4);
				return true;
			}
		} else {
			return false;
		}
	}

	public static boolean a(EntityHuman var0, World var1, Position var2) {
		adl var3 = adl.b(var1, var2);
		boolean var4 = false;
		double var5 = 7.0D;
		int var7 = var2.n();
		int var8 = var2.o();
		int var9 = var2.p();
		List var10 = var1.a(xn.class, new brt((double) var7 - var5, (double) var8 - var5, (double) var9 - var5, (double) var7 + var5, (double) var8 + var5, (double) var9 + var5));
		Iterator var11 = var10.iterator();

		while (var11.hasNext()) {
			xn var12 = (xn) var11.next();
			if (var12.cb() && var12.cc() == var0) {
				if (var3 == null) {
					var3 = adl.a(var1, var2);
				}

				var12.a(var3, true);
				var4 = true;
			}
		}

		return var4;
	}
}
