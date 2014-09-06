package net.minecraft;

public class ajs extends aju {

	public ajs() {
		super(aty.cK);
		this.maxStackSize = 16;
		this.a(CreativeModeTab.c);
		this.a(true);
		this.d(0);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var5 == PaintingDirection.a) {
			return false;
		} else if (!var3.p(var4).getBlock().r().isBuildable()) {
			return false;
		} else {
			var4 = var4.a(var5);
			if (!var2.a(var4, var5, var1)) {
				return false;
			} else if (!aty.cK.c(var3, var4)) {
				return false;
			} else if (var3.D) {
				return true;
			} else {
				if (var5 == PaintingDirection.b) {
					int var9 = DataTypesConverter.toFixedPointInt((double) ((var2.yaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
					var3.a(var4, aty.cK.P().a(BlockStandingSign.a, Integer.valueOf(var9)), 3);
				} else {
					var3.a(var4, aty.cL.P().a(BlockWallSign.a, var5), 3);
				}

				--var1.b;
				TileEntity var10 = var3.s(var4);
				if (var10 instanceof TileEntityBanner) {
					((TileEntityBanner) var10).a(var1);
				}

				return true;
			}
		}
	}

	public String a(ItemStack var1) {
		String var2 = "item.banner.";
		akv var3 = this.h(var1);
		var2 = var2 + var3.d() + ".name";
		return fi.a(var2);
	}

	private akv h(ItemStack var1) {
		NBTCompoundTag var2 = var1.a("BlockEntityTag", false);
		akv var3 = null;
		if (var2 != null && var2.hasKey("Base")) {
			var3 = akv.a(var2.getInt("Base"));
		} else {
			var3 = akv.a(var1.i());
		}

		return var3;
	}
}
