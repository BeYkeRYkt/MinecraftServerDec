package net.minecraft;

public class anc extends Item {

	private Block a;
	private Block b;

	public anc(Block var1, Block var2) {
		this.a = var1;
		this.b = var2;
		this.setCreativeModeTab(CreativeModeTab.MATERIALS);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		if (var5 != PaintingDirection.b) {
			return false;
		} else if (!var2.a(var4.a(var5), var5, var1)) {
			return false;
		} else if (var3.p(var4).getBlock() == this.b && var3.d(var4.a())) {
			var3.a(var4.a(), this.a.P());
			--var1.b;
			return true;
		} else {
			return false;
		}
	}
}
