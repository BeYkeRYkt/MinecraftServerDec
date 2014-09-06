package net.minecraft;

public class aow {

	private String[][] a = new String[][] { { "X", "X", "#" } };
	private Object[][] b;

	public aow() {
		this.b = new Object[][] { { Blocks.PLANKS, Blocks.COBBLESTONE, Items.j, Items.i, Items.k }, { Items.m, Items.q, Items.l, Items.u, Items.B } };
	}

	public void a(aop var1) {
		for (int var2 = 0; var2 < this.b[0].length; ++var2) {
			Object var3 = this.b[0][var2];

			for (int var4 = 0; var4 < this.b.length - 1; ++var4) {
				Item var5 = (Item) this.b[var4 + 1][var2];
				var1.a(new ItemStack(var5), new Object[] { this.a[var4], Character.valueOf('#'), Items.y, Character.valueOf('X'), var3 });
			}
		}

		var1.a(new ItemStack(Items.f, 1), new Object[] { " #X", "# X", " #X", Character.valueOf('X'), Items.F, Character.valueOf('#'), Items.y });
		var1.a(new ItemStack(Items.g, 4), new Object[] { "X", "#", "Y", Character.valueOf('Y'), Items.G, Character.valueOf('X'), Items.ak, Character.valueOf('#'), Items.y });
	}
}
