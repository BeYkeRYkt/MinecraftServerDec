package net.minecraft;

class aie extends InventorySubcontainer {

	// $FF: synthetic field
	final ContainerAnvil a;

	aie(ContainerAnvil var1, String var2, boolean var3, int var4) {
		super(var2, var3, var4);
		this.a = var1;
	}

	public void update() {
		super.update();
		this.a.a((IInventory) this);
	}
}
