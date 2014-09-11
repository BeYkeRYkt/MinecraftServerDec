package net.minecraft;

public class ItemFish extends ItemFood {

	private final boolean b;

	public ItemFish(boolean var1) {
		super(0, 0.0F, false);
		this.b = var1;
	}

	public int h(ItemStack var1) {
		ali var2 = ali.a(var1);
		return this.b && var2.g() ? var2.e() : var2.c();
	}

	public float i(ItemStack var1) {
		ali var2 = ali.a(var1);
		return this.b && var2.g() ? var2.f() : var2.d();
	}

	public String j(ItemStack var1) {
		return ali.a(var1) == ali.d ? PotionBrewer.m : null;
	}

	protected void c(ItemStack var1, World var2, EntityHuman var3) {
		ali var4 = ali.a(var1);
		if (var4 == ali.d) {
			var3.c(new MobEffect(MobEffectList.POISON.id, 1200, 3));
			var3.c(new MobEffect(MobEffectList.HUNGER.id, 300, 2));
			var3.c(new MobEffect(MobEffectList.CONFUSION.id, 300, 1));
		}

		super.c(var1, var2, var3);
	}

	public String getName(ItemStack var1) {
		ali var2 = ali.a(var1);
		return this.getName() + "." + var2.b() + "." + (this.b && var2.g() ? "cooked" : "raw");
	}
}
