package net.minecraft;

public class BlockRedstone extends BlockOreBlock {

	public BlockRedstone(MaterialMapColor var1) {
		super(var1);
		this.a(CreativeModeTab.REDSTONE);
	}

	public boolean isTrappedChest() {
		return true;
	}

	public int getPower(ard var1, Position var2, IBlockState var3, BlockFace var4) {
		return 15;
	}
}
