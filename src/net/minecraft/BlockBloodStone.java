package net.minecraft;

public class BlockBloodStone extends Block {

	public BlockBloodStone() {
		super(Material.STONE);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public MaterialMapColor getMapColor(IBlockState var1) {
		return MaterialMapColor.K;
	}
}
