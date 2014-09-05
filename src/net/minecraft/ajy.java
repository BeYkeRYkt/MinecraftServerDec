package net.minecraft;

public class ajy extends Item {

	public ajy() {
		this.a(CreativeModeTab.k);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		bru var4 = this.a(var2, var3, true);
		if (var4 == null) {
			return var1;
		} else {
			if (var4.a == brv.b) {
				Position var5 = var4.a();
				if (!var2.a(var3, var5)) {
					return var1;
				}

				if (!var3.a(var5.a(var4.b), var4.b, var1)) {
					return var1;
				}

				if (var2.p(var5).c().r() == Material.WATER) {
					--var1.b;
					var3.b(ty.J[Item.getId((Item) this)]);
					if (var1.b <= 0) {
						return new ItemStack(amk.bz);
					}

					if (!var3.playerInventory.a(new ItemStack(amk.bz))) {
						var3.a(new ItemStack(amk.bz, 1, 0), false);
					}
				}
			}

			return var1;
		}
	}
}
