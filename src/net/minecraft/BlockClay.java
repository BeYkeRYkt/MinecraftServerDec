package net.minecraft;

import java.util.Random;

public class BlockClay extends Block {

	public BlockClay() {
		super(Material.CLAY);
		this.a(CreativeModeTab.b);
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.aI;
	}

	public int a(Random var1) {
		return 4;
	}
}
