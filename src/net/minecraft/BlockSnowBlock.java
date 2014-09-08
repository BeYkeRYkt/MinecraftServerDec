package net.minecraft;

import java.util.Random;

public class BlockSnowBlock extends Block {

	protected BlockSnowBlock() {
		super(Material.SNOW_BLOCK);
		this.a(true);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public Item a(BlockState var1, Random var2, int var3) {
		return Items.SNOWBALL;
	}

	public int a(Random var1) {
		return 4;
	}

	public void b(World var1, Position var2, BlockState var3, Random var4) {
		if (var1.b(arf.b, var2) > 11) {
			this.b(var1, var2, var1.getBlockState(var2), 0);
			var1.g(var2);
		}

	}
}
