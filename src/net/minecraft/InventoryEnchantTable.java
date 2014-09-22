package net.minecraft;

import org.bukkit.inventory.InventoryHolder;

class InventoryEnchantTable extends InventorySubcontainer {

	final ContainerEnchantTable enchantTableContainer;
	private TileEntityEnchantTable table;

	InventoryEnchantTable(TileEntityEnchantTable table, ContainerEnchantTable enchantTableContainer, String name, boolean hasCustomName, int size) {
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

	@Override
	public InventoryHolder getHolder() {
		return table.getHolder();
	}

}
