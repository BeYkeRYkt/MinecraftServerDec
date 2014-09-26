package net.minecraft;

import pipebukkit.server.inventory.PipeBrewingStandInventory;
import pipebukkit.server.inventory.PipeInventory;

public class ContainerBrewingStand extends Container {

	private IInventory inventory;
	private final Slot f;
	private int g;

	public ContainerBrewingStand(InventoryPlayer var1, IInventory var2) {
		this.inventory = var2;
		this.addSlot((Slot) (new aik(var1.owner, var2, 0, 56, 46)));
		this.addSlot((Slot) (new aik(var1.owner, var2, 1, 79, 53)));
		this.addSlot((Slot) (new aik(var1.owner, var2, 2, 102, 46)));
		this.f = this.addSlot((Slot) (new aij(this, var2, 3, 79, 17)));

		int var3;
		for (var3 = 0; var3 < 3; ++var3) {
			for (int var4 = 0; var4 < 9; ++var4) {
				this.addSlot(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.addSlot(new Slot(var1, var3, 8 + var3 * 18, 142));
		}

	}

	public void addSlotListener(ICrafting var1) {
		super.addSlotListener(var1);
		var1.sendContainerProperties(this, this.inventory);
	}

	public void b() {
		super.b();

		for (int var1 = 0; var1 < this.listeners.size(); ++var1) {
			ICrafting var2 = (ICrafting) this.listeners.get(var1);
			if (this.g != this.inventory.getProperty(0)) {
				var2.sendContainerProperty(this, 0, this.inventory.getProperty(0));
			}
		}

		this.g = this.inventory.getProperty(0);
	}

	public boolean isContainerValid(EntityHuman var1) {
		return this.inventory.canInteract(var1);
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.slots.get(var2);
		if (var4 != null && var4.hasItem()) {
			ItemStack var5 = var4.getItemStack();
			var3 = var5.getCopy();
			if ((var2 < 0 || var2 > 2) && var2 != 3) {
				if (!this.f.hasItem() && this.f.a(var5)) {
					if (!this.a(var5, 3, 4, false)) {
						return null;
					}
				} else if (aik.b_(var3)) {
					if (!this.a(var5, 0, 3, false)) {
						return null;
					}
				} else if (var2 >= 4 && var2 < 31) {
					if (!this.a(var5, 31, 40, false)) {
						return null;
					}
				} else if (var2 >= 31 && var2 < 40) {
					if (!this.a(var5, 4, 31, false)) {
						return null;
					}
				} else if (!this.a(var5, 4, 40, false)) {
					return null;
				}
			} else {
				if (!this.a(var5, 4, 40, true)) {
					return null;
				}

				var4.a(var5, var3);
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

	@Override
	public PipeInventory getPipeInventory() {
		return new PipeBrewingStandInventory(inventory);
	}

}
