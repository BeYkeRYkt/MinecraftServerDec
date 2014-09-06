package net.minecraft;

public class aov {

	private String[][] a = new String[][] { { "XXX", " # ", " # " }, { "X", "#", "#" }, { "XX", "X#", " #" }, { "XX", " #", " #" } };
	private Object[][] b;

	public aov() {
		this.b = new Object[][] { { Blocks.PLANKS, Blocks.COBBLESTONE, Items.j, Items.i, Items.k }, { Items.o, Items.s, Items.b, Items.w, Items.D }, { Items.n, Items.r, Items.IRON_PICKAXE, Items.v, Items.C }, { Items.p, Items.t, Items.c, Items.x, Items.E }, { Items.I, Items.J, Items.K, Items.L, Items.M } };
	}

	public void a(aop var1) {
		for (int var2 = 0; var2 < this.b[0].length; ++var2) {
			Object var3 = this.b[0][var2];

			for (int var4 = 0; var4 < this.b.length - 1; ++var4) {
				Item var5 = (Item) this.b[var4 + 1][var2];
				var1.a(new ItemStack(var5), new Object[] { this.a[var4], Character.valueOf('#'), Items.y, Character.valueOf('X'), var3 });
			}
		}

		var1.a(new ItemStack(Items.be), new Object[] { " #", "# ", Character.valueOf('#'), Items.j });
	}
}
