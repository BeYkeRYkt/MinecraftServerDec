package net.minecraft;

import java.util.concurrent.Callable;

class ahc implements Callable {

	// $FF: synthetic field
	final ItemStack a;
	// $FF: synthetic field
	final PlayerInventory b;

	ahc(PlayerInventory var1, ItemStack var2) {
		this.b = var1;
		this.a = var2;
	}

	public String a() {
		return this.a.q();
	}

	// $FF: synthetic method
	public Object call() {
		return this.a();
	}
}
