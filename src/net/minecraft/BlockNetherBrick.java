package net.minecraft;

public class BlockNetherBrick extends Block {

	public BlockNetherBrick() {
		super(Material.STONE);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public MaterialMapColor getMapColor(IBlockState var1) {
		return MaterialMapColor.K;
	}
}
