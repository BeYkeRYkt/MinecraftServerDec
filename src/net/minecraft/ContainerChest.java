package net.minecraft;

import pipebukkit.server.inventory.PipeChestInventory;
import pipebukkit.server.inventory.PipeEnderChestInventory;
import pipebukkit.server.inventory.PipeInventory;

public class ContainerChest extends Container {

	private IInventory inventory;
	private int rows;

	public ContainerChest(IInventory var1, IInventory var2, EntityHuman var3) {
		this.inventory = var2;
		this.rows = var2.getSize() / 9;
		var2.onContainerOpen(var3);
		int var4 = (this.rows - 4) * 18;
		int var5;
		int var6;
		for (var5 = 0; var5 < this.rows; ++var5) {
			for (var6 = 0; var6 < 9; ++var6) {
				this.addSlot(new Slot(var2, var6 + var5 * 9, 8 + var6 * 18, 18 + var5 * 18));
			}
		}

		for (var5 = 0; var5 < 3; ++var5) {
			for (var6 = 0; var6 < 9; ++var6) {
				this.addSlot(new Slot(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, 103 + var5 * 18 + var4));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.addSlot(new Slot(var1, var5, 8 + var5 * 18, 161 + var4));
		}

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
			if (var2 < this.rows * 9) {
				if (!this.a(var5, this.rows * 9, this.slots.size(), true)) {
					return null;
				}
			} else if (!this.a(var5, 0, this.rows * 9, false)) {
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
		this.inventory.onContainerClose(var1);
	}

	public IInventory getInventory() {
		return this.inventory;
	}

	@Override
	public PipeInventory getPipeInventory() {
		if (inventory instanceof InventoryEnderChest) {
			return new PipeEnderChestInventory(inventory);
		}
		return new PipeChestInventory(inventory);
	}

}
