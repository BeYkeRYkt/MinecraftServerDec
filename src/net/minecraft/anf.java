package net.minecraft;

public class anf extends Item {

	public anf() {
		this.maxStackSize = 16;
		this.a(CreativeModeTab.c);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var5 == PaintingDirection.a) {
			return false;
		} else if (!var3.p(var4).c().r().isBuildable()) {
			return false;
		} else {
			var4 = var4.a(var5);
			if (!var2.a(var4, var5, var1)) {
				return false;
			} else if (!aty.an.c(var3, var4)) {
				return false;
			} else if (var3.D) {
				return true;
			} else {
				if (var5 == PaintingDirection.b) {
					int var9 = DataTypesConverter.toFixedPointInt((double) ((var2.yaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
					var3.a(var4, aty.an.P().a(BlockStandingSign.a, Integer.valueOf(var9)), 3);
				} else {
					var3.a(var4, aty.ax.P().a(BlockWallSign.a, var5), 3);
				}

				--var1.b;
				bcm var10 = var3.s(var4);
				if (var10 instanceof bdj && !aju.a(var3, var4, var1)) {
					var2.a((bdj) var10);
				}

				return true;
			}
		}
	}
}
