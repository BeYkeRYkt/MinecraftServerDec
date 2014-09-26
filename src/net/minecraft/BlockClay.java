package net.minecraft;

import java.util.Random;

public class BlockClay extends Block {

	public BlockClay() {
		super(Material.CLAY);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		return Items.CLAY_BALL;
	}

	public int getDropCount(Random var1) {
		return 4;
	}
}
