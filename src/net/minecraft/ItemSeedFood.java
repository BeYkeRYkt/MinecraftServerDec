package net.minecraft;

public class ItemSeedFood extends ItemFood {

	private Block b;
	private Block c;

	public ItemSeedFood(int var1, float var2, Block var3, Block var4) {
		super(var1, var2, false);
		this.b = var3;
		this.c = var4;
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var5 != BlockFace.UP) {
			return false;
		} else if (!var2.a(var4.getRelative(var5), var5, var1)) {
			return false;
		} else if (var3.getBlockState(var4).getBlock() == this.c && var3.d(var4.getUp())) {
			var3.a(var4.getUp(), this.b.getBlockState());
			--var1.amount;
			return true;
		} else {
			return false;
		}
	}
}
