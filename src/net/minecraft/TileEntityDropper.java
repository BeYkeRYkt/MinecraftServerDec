package net.minecraft;

public class TileEntityDropper extends TileEntityDispenser {

	public String getName() {
		return this.hasCustomName() ? this.customName : "container.dropper";
	}

	public String getInventoryType() {
		return "minecraft:dropper";
	}
}
