package net.minecraft;

public class ItemFireball extends Item {

	public ItemFireball() {
		this.setCreativeModeTab(CreativeModeTab.MISC);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var3.isStatic) {
			return true;
		} else {
			var4 = var4.a(var5);
			if (!var2.a(var4, var5, var1)) {
				return false;
			} else {
				if (var3.getBlockState(var4).getBlock().getMaterial() == Material.AIR) {
					var3.makeSound((double) var4.getX() + 0.5D, (double) var4.getY() + 0.5D, (double) var4.getZ() + 0.5D, "item.fireCharge.use", 1.0F, (rnd.nextFloat() - rnd.nextFloat()) * 0.2F + 1.0F);
					var3.a(var4, Blocks.FIRE.getBlockState());
				}

				if (!var2.playerProperties.instabuild) {
					--var1.amount;
				}

				return true;
			}
		}
	}
}
