package net.minecraft;

public class aix extends Container {

	private final IInventory a;

	public aix(PlayerInventory var1, IInventory var2, EntityHuman var3) {
		this.a = var2;
		var2.b(var3);
		byte var4 = 51;

		int var5;
		for (var5 = 0; var5 < var2.n_(); ++var5) {
			this.addSlot(new Slot(var2, var5, 44 + var5 * 18, 20));
		}

		for (var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 9; ++var6) {
				this.addSlot(new Slot(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, var5 * 18 + var4));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.addSlot(new Slot(var1, var5, 8 + var5 * 18, 58 + var4));
		}

	}

	public boolean a(EntityHuman var1) {
		return this.a.a(var1);
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.slots.get(var2);
		if (var4 != null && var4.hasItem()) {
			ItemStack var5 = var4.getItemStack();
			var3 = var5.getCopy();
			if (var2 < this.a.n_()) {
				if (!this.a(var5, this.a.n_(), this.slots.size(), true)) {
					return null;
				}
			} else if (!this.a(var5, 0, this.a.n_(), false)) {
				return null;
			}

			if (var5.amount == 0) {
				var4.d((ItemStack) null);
			} else {
				var4.update();
			}
		}

		return var3;
	}

	public void onClose(EntityHuman var1) {
		super.onClose(var1);
		this.a.c(var1);
	}
}
