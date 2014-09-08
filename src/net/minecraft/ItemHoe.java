package net.minecraft;

public class ItemHoe extends Item {

	protected EnumToolMaterial a;

	public ItemHoe(EnumToolMaterial var1) {
		this.a = var1;
		this.maxStackSize = 1;
		this.setDurability(var1.a());
		this.setCreativeModeTab(CreativeModeTab.TOOLS);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (!var2.a(var4.a(var5), var5, var1)) {
			return false;
		} else {
			bec var9 = var3.p(var4);
			Block var10 = var9.getBlock();
			if (var5 != BlockFace.DOWN && var3.p(var4.a()).getBlock().r() == Material.AIR) {
				if (var10 == Blocks.GRASS) {
					return this.a(var1, var2, var3, var4, Blocks.FARMLAND.P());
				}

				if (var10 == Blocks.DIRT) {
					switch (alp.a[((avd) var9.b(BlockDirt.a)).ordinal()]) {
						case 1:
							return this.a(var1, var2, var3, var4, Blocks.FARMLAND.P());
						case 2:
							return this.a(var1, var2, var3, var4, Blocks.DIRT.P().a(BlockDirt.a, avd.a));
					}
				}
			}

			return false;
		}
	}

	protected boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, bec var5) {
		var3.a((double) ((float) var4.getX() + 0.5F), (double) ((float) var4.getY() + 0.5F), (double) ((float) var4.getZ() + 0.5F), var5.getBlock().H.c(), (var5.getBlock().H.d() + 1.0F) / 2.0F, var5.getBlock().H.e() * 0.8F);
		if (var3.D) {
			return true;
		} else {
			var3.a(var4, var5);
			var1.a(1, (EntityLiving) var2);
			return true;
		}
	}

	public String g() {
		return this.a.toString();
	}
}
