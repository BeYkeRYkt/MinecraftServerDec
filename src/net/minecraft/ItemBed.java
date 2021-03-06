package net.minecraft;

public class ItemBed extends Item {

	public ItemBed() {
		this.setCreativeModeTab(CreativeModeTab.DECORATIONS);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var3.isStatic) {
			return true;
		} else if (var5 != BlockFace.UP) {
			return false;
		} else {
			IBlockState var9 = var3.getBlockState(var4);
			Block var10 = var9.getBlock();
			boolean var11 = var10.f(var3, var4);
			if (!var11) {
				var4 = var4.getUp();
			}

			int var12 = MathHelper.toFixedPointInt((double) (var2.yaw * 4.0F / 360.0F) + 0.5D) & 3;
			BlockFace var13 = BlockFace.fromDirection(var12);
			Position var14 = var4.getRelative(var13);
			boolean var15 = var10.f(var3, var14);
			boolean var16 = var3.d(var4) || var11;
			boolean var17 = var3.d(var14) || var15;
			if (var2.a(var4, var5, var1) && var2.a(var14, var5, var1)) {
				if (var16 && var17 && World.a((ard) var3, var4.getDown()) && World.a((ard) var3, var14.getDown())) {
					int var18 = var13.toDirection();
					IBlockState var19 = Blocks.BED.getBlockState().a(BlockBed.b, Boolean.valueOf(false)).a(BlockBed.N, var13).a(BlockBed.a, atq.b);
					if (var3.setBlockAt(var4, var19, 3)) {
						IBlockState var20 = var19.a(BlockBed.a, atq.a);
						var3.setBlockAt(var14, var20, 3);
					}

					--var1.amount;
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
}
