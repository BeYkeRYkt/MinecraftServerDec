package net.minecraft;

import pipebukkit.server.inventory.PipeBeaconInventory;
import pipebukkit.server.inventory.PipeInventory;

public class ContainerBeacon extends Container {

	private IInventory inventory;
	private final SlotBeacon slot;

	public ContainerBeacon(IInventory playerinventory, IInventory beaconinventory) {
		this.inventory = beaconinventory;
		this.addSlot(this.slot = new SlotBeacon(this, beaconinventory, 0, 136, 110));
		byte var3 = 36;
		short var4 = 137;

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerinventory, j + i * 9 + 9, var3 + j * 18, var4 + i * 18));
			}
		}

		for (int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(playerinventory, i, var3 + i * 18, 58 + var4));
		}

	}

	public void addSlotListener(ICrafting icrafting) {
		super.addSlotListener(icrafting);
		icrafting.sendContainerProperties(this, this.inventory);
	}

	public IInventory getInventory() {
		return this.inventory;
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
			if (var2 == 0) {
				if (!this.a(var5, 1, 37, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (!this.slot.hasItem() && this.slot.a(var5) && var5.amount == 1) {
				if (!this.a(var5, 0, 1, false)) {
					return null;
				}
			} else if (var2 >= 1 && var2 < 28) {
				if (!this.a(var5, 28, 37, false)) {
					return null;
				}
			} else if (var2 >= 28 && var2 < 37) {
				if (!this.a(var5, 1, 28, false)) {
					return null;
				}
			} else if (!this.a(var5, 1, 37, false)) {
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

	@Override
	public PipeInventory getPipeInventory() {
		return new PipeBeaconInventory(getInventory());
	}
}
