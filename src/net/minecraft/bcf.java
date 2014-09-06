package net.minecraft;

import java.util.Random;

public abstract class bcf extends BlockStepAbstract {

	public static final bev b = bev.a("variant", ayx.class);

	public bcf() {
		super(Material.WOOD);
		bec var1 = this.L.b();
		if (!this.j()) {
			var1 = var1.a(a, awr.b);
		}

		this.j(var1.a(b, ayx.a));
		this.a(CreativeModeTab.b);
	}

	public Item a(bec var1, Random var2, int var3) {
		return Item.getItemOf((Block) aty.bM);
	}

	public String b(int var1) {
		return super.a() + "." + ayx.a(var1).c();
	}

	public bex l() {
		return b;
	}

	public Object a(ItemStack var1) {
		return ayx.a(var1.i() & 7);
	}

	public bec a(int var1) {
		bec var2 = this.P().a(b, ayx.a(var1 & 7));
		if (!this.j()) {
			var2 = var2.a(a, (var1 & 8) == 0 ? awr.b : awr.a);
		}

		return var2;
	}

	public int c(bec var1) {
		byte var2 = 0;
		int var3 = var2 | ((ayx) var1.b(b)).a();
		if (!this.j() && var1.b(a) == awr.a) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return this.j() ? new bed(this, new bex[] { b }) : new bed(this, new bex[] { a, b });
	}

	public int a(bec var1) {
		return ((ayx) var1.b(b)).a();
	}

}
