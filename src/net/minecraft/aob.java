package net.minecraft;

public class aob {

	private String[][] a = new String[][] { { "XXX", "X X" }, { "X X", "XXX", "XXX" }, { "XXX", "X X", "X X" }, { "X X", "X X" } };
	private Item[][] b;

	public aob() {
		this.b = new Item[][] { { Items.LEATHER, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT }, { Items.LEATHER_HELMET, Items.IRON_HELMET, Items.DIAMOND_HELMET, Items.GOLD_HELMET }, { Items.LEATHER_CHESTPLATE, Items.IRON_CHESTPLATE, Items.DIAMOND_CHESTPLATE, Items.GOLD_CHESTPLATE }, { Items.LEATHER_LEGGINS, Items.IRON_LEGGINS, Items.DIAMOND_LEGGINS, Items.GOLD_LEGGINS }, { Items.LEATHER_BOOTS, Items.IRON_BOOTS, Items.DIAMOND_BOOTS, Items.GOLD_BOOTS } };
	}

	public void a(aop var1) {
		for (int var2 = 0; var2 < this.b[0].length; ++var2) {
			Item var3 = this.b[0][var2];

			for (int var4 = 0; var4 < this.b.length - 1; ++var4) {
				Item var5 = this.b[var4 + 1][var2];
				var1.a(new ItemStack(var5), new Object[] { this.a[var4], Character.valueOf('X'), var3 });
			}
		}

	}
}
