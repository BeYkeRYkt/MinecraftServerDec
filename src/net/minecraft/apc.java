package net.minecraft;

public class apc extends apf {

	private static final String[] E = new String[] { "all", "undead", "arthropods" };
	private static final int[] F = new int[] { 1, 5, 5 };
	private static final int[] G = new int[] { 11, 8, 8 };
	private static final int[] H = new int[] { 20, 20, 20 };
	public final int a;

	public apc(int var1, BlockNameInfo var2, int var3, int var4) {
		super(var1, var2, var3, apg.g);
		this.a = var4;
	}

	public int a(int var1) {
		return F[this.a] + (var1 - 1) * G[this.a];
	}

	public int b(int var1) {
		return this.a(var1) + H[this.a];
	}

	public int b() {
		return 5;
	}

	public float a(int var1, xs var2) {
		return this.a == 0 ? (float) var1 * 1.25F : (this.a == 1 && var2 == xs.b ? (float) var1 * 2.5F : (this.a == 2 && var2 == xs.c ? (float) var1 * 2.5F : 0.0F));
	}

	public String a() {
		return "enchantment.damage." + E[this.a];
	}

	public boolean a(apf var1) {
		return !(var1 instanceof apc);
	}

	public boolean a(ItemStack var1) {
		return var1.getItem() instanceof ajr ? true : super.a(var1);
	}

	public void a(EntityLiving var1, Entity var2, int var3) {
		if (var2 instanceof EntityLiving) {
			EntityLiving var4 = (EntityLiving) var2;
			if (this.a == 2 && var4.by() == xs.c) {
				int var5 = 20 + var1.bb().nextInt(10 * var3);
				var4.c(new MobEffect(MobEffectList.d.H, var5, 3));
			}
		}

	}

}
