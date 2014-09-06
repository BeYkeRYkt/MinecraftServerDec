package net.minecraft;

public class aon {

	private Object[][] a;

	public aon() {
		this.a = new Object[][] { { Blocks.GOLD_BLOCK, new ItemStack(Items.k, 9) }, { Blocks.IRON_BLOCK, new ItemStack(Items.j, 9) }, { Blocks.DIAMOND_BLOCK, new ItemStack(Items.i, 9) }, { Blocks.EMERALD_BLOCK, new ItemStack(Items.bO, 9) }, { Blocks.LAPIS_BLOCK, new ItemStack(Items.aW, 9, akv.l.b()) }, { Blocks.REDSTONE_BLOCK, new ItemStack(Items.aC, 9) }, { Blocks.COAL_BLOCK, new ItemStack(Items.h, 9, 0) }, { Blocks.HAY_BLOCK, new ItemStack(Items.O, 9) }, { Blocks.SLIME, new ItemStack(Items.aM, 9) } };
	}

	public void a(aop var1) {
		for (int var2 = 0; var2 < this.a.length; ++var2) {
			Block var3 = (Block) this.a[var2][0];
			ItemStack var4 = (ItemStack) this.a[var2][1];
			var1.a(new ItemStack(var3), new Object[] { "###", "###", "###", Character.valueOf('#'), var4 });
			var1.a(var4, new Object[] { "#", Character.valueOf('#'), var3 });
		}

		var1.a(new ItemStack(Items.k), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.bx });
		var1.a(new ItemStack(Items.bx, 9), new Object[] { "#", Character.valueOf('#'), Items.k });
	}
}
