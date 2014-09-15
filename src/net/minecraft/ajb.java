package net.minecraft;

public class ajb extends Container {

	public InventoryCrafting a = new InventoryCrafting(this, 2, 2);
	public IInventory f = new aji();
	public boolean g;
	private final EntityHuman h;

	public ajb(PlayerInventory var1, boolean var2, EntityHuman var3) {
		this.g = var2;
		this.h = var3;
		this.addSlot((Slot) (new ajj(var1.d, this.a, this.f, 0, 144, 36)));

		int var4;
		int var5;
		for (var4 = 0; var4 < 2; ++var4) {
			for (var5 = 0; var5 < 2; ++var5) {
				this.addSlot(new Slot(this.a, var5 + var4 * 2, 88 + var5 * 18, 26 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 4; ++var4) {
			this.addSlot((Slot) (new ajc(this, var1, var1.n_() - 1 - var4, 8, 8 + var4 * 18, var4)));
		}

		for (var4 = 0; var4 < 3; ++var4) {
			for (var5 = 0; var5 < 9; ++var5) {
				this.addSlot(new Slot(var1, var5 + (var4 + 1) * 9, 8 + var5 * 18, 84 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.addSlot(new Slot(var1, var4, 8 + var4 * 18, 142));
		}

		this.a((IInventory) this.a);
	}

	public void a(IInventory var1) {
		this.f.a(0, CraftingManager.getInstance().a(this.a, this.h.world));
	}

	public void onClose(EntityHuman var1) {
		super.onClose(var1);

		for (int var2 = 0; var2 < 4; ++var2) {
			ItemStack var3 = this.a.b(var2);
			if (var3 != null) {
				var1.dropItem(var3, false);
			}
		}

		this.f.a(0, (ItemStack) null);
	}

	public boolean a(EntityHuman var1) {
		return true;
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.slots.get(var2);
		if (var4 != null && var4.hasItem()) {
			ItemStack var5 = var4.getItemStack();
			var3 = var5.getCopy();
			if (var2 == 0) {
				if (!this.a(var5, 9, 45, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (var2 >= 1 && var2 < 5) {
				if (!this.a(var5, 9, 45, false)) {
					return null;
				}
			} else if (var2 >= 5 && var2 < 9) {
				if (!this.a(var5, 9, 45, false)) {
					return null;
				}
			} else if (var3.getItem() instanceof ItemArmor && !((Slot) this.slots.get(5 + ((ItemArmor) var3.getItem()).b)).hasItem()) {
				int var6 = 5 + ((ItemArmor) var3.getItem()).b;
				if (!this.a(var5, var6, var6 + 1, false)) {
					return null;
				}
			} else if (var2 >= 9 && var2 < 36) {
				if (!this.a(var5, 36, 45, false)) {
					return null;
				}
			} else if (var2 >= 36 && var2 < 45) {
				if (!this.a(var5, 9, 36, false)) {
					return null;
				}
			} else if (!this.a(var5, 9, 45, false)) {
				return null;
			}

			if (var5.amount == 0) {
				var4.d((ItemStack) null);
			} else {
				var4.update();
			}

			if (var5.amount == var3.amount) {
				return null;
			}

			var4.a(var1, var5);
		}

		return var3;
	}

	public boolean a(ItemStack var1, Slot var2) {
		return var2.inventory != this.f && super.a(var1, var2);
	}
}
