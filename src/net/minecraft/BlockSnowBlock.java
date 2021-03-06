package net.minecraft;

import java.util.Random;

public class BlockSnowBlock extends Block {

	protected BlockSnowBlock() {
		super(Material.SNOW_BLOCK);
		this.a(true);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		return Items.SNOWBALL;
	}

	public int getDropCount(Random var1) {
		return 4;
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		if (var1.b(EnumSkyBlock.BLOCK, var2) > 11) {
			this.dropNaturally(var1, var2, var1.getBlockState(var2), 0);
			var1.g(var2);
		}

	}
}
