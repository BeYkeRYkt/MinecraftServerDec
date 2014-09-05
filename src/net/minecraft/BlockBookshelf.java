package net.minecraft;

import java.util.Random;

public class BlockBookshelf extends Block {

	public BlockBookshelf() {
		super(Material.WOOD);
		this.a(CreativeModeTab.b);
	}

	public int a(Random var1) {
		return 3;
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.aL;
	}
}
