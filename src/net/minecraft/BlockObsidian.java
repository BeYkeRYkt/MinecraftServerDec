package net.minecraft;

import java.util.Random;

public class BlockObsidian extends Block {

	public BlockObsidian() {
		super(Material.STONE);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public Item a(BlockState var1, Random var2, int var3) {
		return Item.getItemOf(Blocks.OBSIDIAN);
	}

	public MaterialMapColor g(BlockState var1) {
		return MaterialMapColor.J;
	}
}
