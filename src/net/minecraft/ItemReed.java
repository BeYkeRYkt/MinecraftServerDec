package net.minecraft;

public class ItemReed extends Item {

	private Block a;

	public ItemReed(Block var1) {
		this.a = var1;
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		BlockState var9 = var3.getBlockState(var4);
		Block var10 = var9.getBlock();
		if (var10 == Blocks.SNOW_LAYER && ((Integer) var9.b(BlockSnow.a)).intValue() < 1) {
			var5 = BlockFace.UP;
		} else if (!var10.f(var3, var4)) {
			var4 = var4.a(var5);
		}

		if (!var2.a(var4, var5, var1)) {
			return false;
		} else if (var1.amount == 0) {
			return false;
		} else {
			if (var3.a(this.a, var4, false, var5, (Entity) null, var1)) {
				BlockState var11 = this.a.a(var3, var4, var5, var6, var7, var8, 0, var2);
				if (var3.a(var4, var11, 3)) {
					var11 = var3.getBlockState(var4);
					if (var11.getBlock() == this.a) {
						ItemBlock.a(var3, var4, var1);
						var11.getBlock().a(var3, var4, var11, (EntityLiving) var2, var1);
					}

					var3.makeSound((double) ((float) var4.getX() + 0.5F), (double) ((float) var4.getY() + 0.5F), (double) ((float) var4.getZ() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
					--var1.amount;
					return true;
				}
			}

			return false;
		}
	}
}
