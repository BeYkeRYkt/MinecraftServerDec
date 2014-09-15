package net.minecraft;

class air extends wa {

	// $FF: synthetic field
	final aiq a;

	air(aiq var1, String var2, boolean var3, int var4) {
		super(var2, var3, var4);
		this.a = var1;
	}

	public int getMaxStackSize() {
		return 64;
	}

	public void update() {
		super.update();
		this.a.a((IInventory) this);
	}
}
