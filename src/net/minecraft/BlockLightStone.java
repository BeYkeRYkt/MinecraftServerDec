package net.minecraft;

import java.util.Random;

public class BlockLightStone extends Block {

	public BlockLightStone(Material var1) {
		super(var1);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int getDropCount(int var1, Random var2) {
		return MathHelper.a(this.getDropCount(var2) + var2.nextInt(var1 + 1), 1, 4);
	}

	public int getDropCount(Random var1) {
		return 2 + var1.nextInt(3);
	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		return Items.GLOWSTONE_DUST;
	}

	public MaterialMapColor getMapColor(IBlockState var1) {
		return MaterialMapColor.d;
	}
}
