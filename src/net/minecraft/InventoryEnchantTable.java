package net.minecraft;

class InventoryEnchantTable extends InventorySubcontainer {

	final ContainerEnchantTable enchantTableContainer;

	InventoryEnchantTable(ContainerEnchantTable enchantTableContainer, String name, boolean hasCustomName, int size) {
		super(name, hasCustomName, size);
		this.enchantTableContainer = enchantTableContainer;
	}

	public int getMaxStackSize() {
		return 64;
	}

	public void update() {
		super.update();
		this.enchantTableContainer.a((IInventory) this);
	}

}
