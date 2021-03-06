package net.minecraft;

import java.util.Random;

public class BlockMelon extends Block {

	protected BlockMelon() {
		super(Material.PUMPKIN);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		return Items.MELON;
	}

	public int getDropCount(Random var1) {
		return 3 + var1.nextInt(5);
	}

	public int getDropCount(int var1, Random var2) {
		return Math.min(9, this.getDropCount(var2) + var2.nextInt(1 + var1));
	}
}
