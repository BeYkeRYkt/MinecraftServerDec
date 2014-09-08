package net.minecraft;

public class BlockOreBlock extends Block {

	private final MaterialMapColor a;

	public BlockOreBlock(MaterialMapColor var1) {
		super(Material.ORE);
		this.a = var1;
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public MaterialMapColor g(BlockState var1) {
		return this.a;
	}
}
