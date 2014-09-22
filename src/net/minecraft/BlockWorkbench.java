package net.minecraft;

public class BlockWorkbench extends Block {

	protected BlockWorkbench() {
		super(Material.WOOD);
		this.a(CreativeModeTab.DECORATIONS);
	}

	public boolean interact(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var1.isStatic) {
			return true;
		} else {
			var4.a((IInventoryHasType) (new aut(var1, var2)));
			return true;
		}
	}
}
