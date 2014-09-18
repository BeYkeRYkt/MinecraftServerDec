package net.minecraft;

class InventoryAnvil extends InventorySubcontainer {

	private final ContainerAnvil anvilContainer;

	InventoryAnvil(ContainerAnvil anvilContainer, String name, boolean hasCustomName, int size) {
		super(name, hasCustomName, size);
		this.anvilContainer = anvilContainer;
	}

	public void update() {
		super.update();
		this.anvilContainer.a(this);
	}

}
