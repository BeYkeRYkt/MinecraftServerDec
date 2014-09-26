package net.minecraft;

import pipebukkit.server.inventory.PipeChestInventory;
import pipebukkit.server.inventory.PipeHorseInventory;
import pipebukkit.server.inventory.PipeInventory;

public class ContainerHorse extends Container {

	private IInventory a;
	private EntityHorse f;

	public ContainerHorse(IInventory var1, IInventory var2, EntityHorse var3, EntityHuman var4) {
		this.a = var2;
		this.f = var3;
		byte var5 = 3;
		var2.onContainerOpen(var4);
		int var6 = (var5 - 4) * 18;
		this.addSlot(new aiz(this, var2, 0, 8, 18));
		this.addSlot(new aja(this, var2, 1, 8, 36, var3));
		int var7;
		int var8;
		if (var3.cu()) {
			for (var7 = 0; var7 < var5; ++var7) {
				for (var8 = 0; var8 < 5; ++var8) {
					this.addSlot(new Slot(var2, 2 + var8 + var7 * 5, 80 + var8 * 18, 18 + var7 * 18));
				}
			}
		}

		for (var7 = 0; var7 < 3; ++var7) {
			for (var8 = 0; var8 < 9; ++var8) {
				this.addSlot(new Slot(var1, var8 + var7 * 9 + 9, 8 + var8 * 18, 102 + var7 * 18 + var6));
			}
		}

		for (var7 = 0; var7 < 9; ++var7) {
			this.addSlot(new Slot(var1, var7, 8 + var7 * 18, 160 + var6));
		}

	}

	public boolean isContainerValid(EntityHuman var1) {
		return this.a.canInteract(var1) && this.f.isAlive() && this.f.g((Entity) var1) < 8.0F;
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.slots.get(var2);
		if (var4 != null && var4.hasItem()) {
			ItemStack var5 = var4.getItemStack();
			var3 = var5.getCopy();
			if (var2 < this.a.getSize()) {
				if (!this.a(var5, this.a.getSize(), this.slots.size(), true)) {
					return null;
				}
			} else if (this.getSlot(1).a(var5) && !this.getSlot(1).hasItem()) {
				if (!this.a(var5, 1, 2, false)) {
					return null;
				}
			} else if (this.getSlot(0).a(var5)) {
				if (!this.a(var5, 0, 1, false)) {
					return null;
				}
			} else if (this.a.getSize() <= 2 || !this.a(var5, 2, this.a.getSize(), false)) {
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
		this.a.onContainerClose(var1);
	}

	@Override
	public PipeInventory getPipeInventory() {
		if (a.getSize() == 2) {
			return new PipeHorseInventory(a);
		} else {
			return new PipeChestInventory(a);
		}
	}

}
