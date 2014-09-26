package net.minecraft;

import pipebukkit.server.inventory.PipeInventory;

class ContainerSheep extends Container {

	final EntitySheep a;

	ContainerSheep(EntitySheep var1) {
		this.a = var1;
	}

	public boolean isContainerValid(EntityHuman var1) {
		return false;
	}

	@Override
	public PipeInventory getPipeInventory() {
		return null;
	}

}
