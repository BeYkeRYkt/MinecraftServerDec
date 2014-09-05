package net.minecraft;

public class ale extends Item {

	public ale() {
		this.a(CreativeModeTab.f);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var3.D) {
			return true;
		} else {
			var4 = var4.a(var5);
			if (!var2.a(var4, var5, var1)) {
				return false;
			} else {
				if (var3.p(var4).c().r() == Material.AIR) {
					var3.a((double) var4.n() + 0.5D, (double) var4.o() + 0.5D, (double) var4.p() + 0.5D, "item.fireCharge.use", 1.0F, (rnd.nextFloat() - rnd.nextFloat()) * 0.2F + 1.0F);
					var3.a(var4, aty.ab.P());
				}

				if (!var2.by.instabuild) {
					--var1.b;
				}

				return true;
			}
		}
	}
}
