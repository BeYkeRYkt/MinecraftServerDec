package net.minecraft;

public class alk extends Item {

	public alk() {
		this.maxStackSize = 1;
		this.setDurability(64);
		this.setCreativeModeTab(CreativeModeTab.TOOLS);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		var4 = var4.a(var5);
		if (!var2.a(var4, var5, var1)) {
			return false;
		} else {
			if (var3.p(var4).getBlock().r() == Material.AIR) {
				var3.a((double) var4.getX() + 0.5D, (double) var4.getY() + 0.5D, (double) var4.getZ() + 0.5D, "fire.ignite", 1.0F, rnd.nextFloat() * 0.4F + 0.8F);
				var3.a(var4, Blocks.FIRE.P());
			}

			var1.a(1, (EntityLiving) var2);
			return true;
		}
	}
}
