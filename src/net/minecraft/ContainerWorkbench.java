package net.minecraft;

import pipebukkit.server.inventory.PipeCraftingInventory;
import pipebukkit.server.inventory.PipeInventory;

public class ContainerWorkbench extends Container {

	public InventoryResult resultInventory = new InventoryResult();
	public InventoryCrafting craftingInventory;
	private World world;
	private Position position;

	public ContainerWorkbench(InventoryPlayer playerInventory, World var2, Position var3) {
		this.world = var2;
		this.position = var3;
		craftingInventory = new InventoryCrafting(playerInventory.owner, this, 3, 3);
		this.addSlot((Slot) (new ajj(playerInventory.owner, this.craftingInventory, this.resultInventory, 0, 124, 35)));

		int var4;
		int var5;
		for (var4 = 0; var4 < 3; ++var4) {
			for (var5 = 0; var5 < 3; ++var5) {
				this.addSlot(new Slot(this.craftingInventory, var5 + var4 * 3, 30 + var5 * 18, 17 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 3; ++var4) {
			for (var5 = 0; var5 < 9; ++var5) {
				this.addSlot(new Slot(playerInventory, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.addSlot(new Slot(playerInventory, var4, 8 + var4 * 18, 142));
		}

		this.a((IInventory) this.craftingInventory);
	}

	public void a(IInventory var1) {
		this.resultInventory.setItem(0, CraftingManager.getInstance().a(this.craftingInventory, this.world));
	}

	public void onClose(EntityHuman var1) {
		super.onClose(var1);
		if (!this.world.isStatic) {
			for (int var2 = 0; var2 < 9; ++var2) {
				ItemStack var3 = this.craftingInventory.splitWithoutUpdate(var2);
				if (var3 != null) {
					var1.dropItem(var3, false);
				}
			}

		}
	}

	public boolean a(EntityHuman var1) {
		return this.world.getBlockState(this.position).getBlock() != Blocks.CRAFTING_TABLE ? false : var1.getDistanceSquared((double) this.position.getX() + 0.5D, (double) this.position.getY() + 0.5D, (double) this.position.getZ() + 0.5D) <= 64.0D;
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		Slot var4 = (Slot) this.slots.get(var2);
		if (var4 != null && var4.hasItem()) {
			ItemStack var5 = var4.getItemStack();
			var3 = var5.getCopy();
			if (var2 == 0) {
				if (!this.a(var5, 10, 46, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (var2 >= 10 && var2 < 37) {
				if (!this.a(var5, 37, 46, false)) {
					return null;
				}
			} else if (var2 >= 37 && var2 < 46) {
				if (!this.a(var5, 10, 37, false)) {
					return null;
				}
			} else if (!this.a(var5, 10, 46, false)) {
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
		return var2.inventory != this.resultInventory && super.a(var1, var2);
	}

	@Override
	public PipeInventory getPipeInventory() {
		return new PipeCraftingInventory(craftingInventory, resultInventory);
	}
}
