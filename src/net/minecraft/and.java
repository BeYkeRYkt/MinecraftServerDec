package net.minecraft;

public class and extends Item {

	public and() {
		this.c(1);
		this.d(238);
		this.a(CreativeModeTab.i);
	}

	public boolean a(ItemStack var1, World var2, Block var3, Position var4, EntityLiving var5) {
		if (var3.r() != bof.j && var3 != aty.G && var3 != aty.H && var3 != aty.bn && var3 != aty.bS && var3 != aty.L) {
			return super.a(var1, var2, var3, var4, var5);
		} else {
			var1.a(1, var5);
			return true;
		}
	}

	public boolean b(Block var1) {
		return var1 == aty.G || var1 == aty.af || var1 == aty.bS;
	}

	public float a(ItemStack var1, Block var2) {
		return var2 != aty.G && var2.r() != bof.j ? (var2 == aty.L ? 5.0F : super.a(var1, var2)) : 15.0F;
	}
}
