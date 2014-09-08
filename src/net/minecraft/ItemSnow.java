package net.minecraft;

public class ItemSnow extends ItemBlock {

	public ItemSnow(Block var1) {
		super(var1);
		this.setDurability(0);
		this.a(true);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var1.b == 0) {
			return false;
		} else if (!var2.a(var4, var5, var1)) {
			return false;
		} else {
			bec var9 = var3.p(var4);
			Block var10 = var9.getBlock();
			if (var10 != this.block && var5 != BlockFace.UP) {
				var4 = var4.a(var5);
				var9 = var3.p(var4);
				var10 = var9.getBlock();
			}

			if (var10 == this.block) {
				int var11 = ((Integer) var9.b(BlockSnow.a)).intValue();
				if (var11 <= 7) {
					bec var12 = var9.a(BlockSnow.a, Integer.valueOf(var11 + 1));
					if (var3.b(this.block.a(var3, var4, var12)) && var3.a(var4, var12, 2)) {
						var3.a((double) ((float) var4.getX() + 0.5F), (double) ((float) var4.getY() + 0.5F), (double) ((float) var4.getZ() + 0.5F), this.block.H.b(), (this.block.H.d() + 1.0F) / 2.0F, this.block.H.e() * 0.8F);
						--var1.b;
						return true;
					}
				}
			}

			return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
		}
	}

	public int a(int var1) {
		return var1;
	}
}
