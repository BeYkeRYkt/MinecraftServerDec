package net.minecraft;

public class BlockHardenedClay extends Block {

	public BlockHardenedClay() {
		super(Material.STONE);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public MaterialMapColor g(IBlockState var1) {
		return MaterialMapColor.q;
	}
}
