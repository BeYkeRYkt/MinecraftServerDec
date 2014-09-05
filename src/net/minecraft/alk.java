package net.minecraft;

public class alk extends Item {

	public alk() {
		this.maxStackSize = 1;
		this.d(64);
		this.a(CreativeModeTab.i);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, ej var5, float var6, float var7, float var8) {
		var4 = var4.a(var5);
		if (!var2.a(var4, var5, var1)) {
			return false;
		} else {
			if (var3.p(var4).c().r() == bof.a) {
				var3.a((double) var4.n() + 0.5D, (double) var4.o() + 0.5D, (double) var4.p() + 0.5D, "fire.ignite", 1.0F, rnd.nextFloat() * 0.4F + 0.8F);
				var3.a(var4, aty.ab.P());
			}

			var1.a(1, (EntityLiving) var2);
			return true;
		}
	}
}
