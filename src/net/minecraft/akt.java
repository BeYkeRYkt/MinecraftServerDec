package net.minecraft;

public class akt extends Item {

	private Block a;

	public akt(Block var1) {
		this.a = var1;
		this.setCreativeModeTab(CreativeModeTab.REDSTONE);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var5 != PaintingDirection.b) {
			return false;
		} else {
			bec var9 = var3.p(var4);
			Block var10 = var9.getBlock();
			if (!var10.f(var3, var4)) {
				var4 = var4.a(var5);
			}

			if (!var2.a(var4, var5, var1)) {
				return false;
			} else if (!this.a.c(var3, var4)) {
				return false;
			} else {
				a(var3, var4, PaintingDirection.a((double) var2.yaw), this.a);
				--var1.b;
				return true;
			}
		}
	}

	public static void a(World var0, Position var1, PaintingDirection var2, Block var3) {
		Position var4 = var1.a(var2.e());
		Position var5 = var1.a(var2.f());
		int var6 = (var0.p(var5).getBlock().t() ? 1 : 0) + (var0.p(var5.a()).getBlock().t() ? 1 : 0);
		int var7 = (var0.p(var4).getBlock().t() ? 1 : 0) + (var0.p(var4.a()).getBlock().t() ? 1 : 0);
		boolean var8 = var0.p(var5).getBlock() == var3 || var0.p(var5.a()).getBlock() == var3;
		boolean var9 = var0.p(var4).getBlock() == var3 || var0.p(var4.a()).getBlock() == var3;
		boolean var10 = false;
		if (var8 && !var9 || var7 > var6) {
			var10 = true;
		}

		Position var11 = var1.a();
		bec var12 = var3.P().a(BlockDoor.a, var2).a(BlockDoor.M, var10 ? avh.b : avh.a);
		var0.a(var1, var12.a(BlockDoor.O, avg.b), 2);
		var0.a(var11, var12.a(BlockDoor.O, avg.a), 2);
		var0.c(var1, var3);
		var0.c(var11, var3);
	}
}
