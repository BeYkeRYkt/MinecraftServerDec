package net.minecraft;

import java.util.Random;

public class BlockBookshelf extends Block {

	public BlockBookshelf() {
		super(Material.WOOD);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int a(Random var1) {
		return 3;
	}

	public Item a(BlockState var1, Random var2, int var3) {
		return Items.BOOK;
	}
}
