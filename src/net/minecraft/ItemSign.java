package net.minecraft;

public class ItemSign extends Item {

	public ItemSign() {
		this.maxStackSize = 16;
		this.setCreativeModeTab(CreativeModeTab.DECORATIONS);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var5 == BlockFace.a) {
			return false;
		} else if (!var3.p(var4).getBlock().r().isBuildable()) {
			return false;
		} else {
			var4 = var4.a(var5);
			if (!var2.a(var4, var5, var1)) {
				return false;
			} else if (!Blocks.STANDING_SIGN.c(var3, var4)) {
				return false;
			} else if (var3.D) {
				return true;
			} else {
				if (var5 == BlockFace.b) {
					int var9 = DataTypesConverter.toFixedPointInt((double) ((var2.yaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
					var3.a(var4, Blocks.STANDING_SIGN.P().a(BlockStandingSign.a, Integer.valueOf(var9)), 3);
				} else {
					var3.a(var4, Blocks.WALL_SIGN.P().a(BlockWallSign.a, var5), 3);
				}

				--var1.b;
				TileEntity var10 = var3.s(var4);
				if (var10 instanceof TileEntitySign && !ItemBlock.a(var3, var4, var1)) {
					var2.a((TileEntitySign) var10);
				}

				return true;
			}
		}
	}
}
