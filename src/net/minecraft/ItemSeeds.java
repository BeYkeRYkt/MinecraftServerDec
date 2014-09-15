package net.minecraft;

public class ItemSeeds extends Item {

	private Block a;
	private Block b;

	public ItemSeeds(Block var1, Block var2) {
		this.a = var1;
		this.b = var2;
		this.setCreativeModeTab(CreativeModeTab.MATERIALS);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var5 != BlockFace.UP) {
			return false;
		} else if (!var2.a(var4.a(var5), var5, var1)) {
			return false;
		} else if (var3.getBlockState(var4).getBlock() == this.b && var3.d(var4.a())) {
			var3.a(var4.a(), this.a.getBlockState());
			--var1.amount;
			return true;
		} else {
			return false;
		}
	}
}
