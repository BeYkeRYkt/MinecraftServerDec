package net.minecraft;

import java.util.Random;

public class bba extends Block {

	public static final bev a = bev.a("variant", bbb.class);

	public bba() {
		super(bof.e);
		this.j(this.L.b().a(a, bbb.a));
		this.a(CreativeModeTab.b);
	}

	public Item a(bec var1, Random var2, int var3) {
		return var1.b(a) == bbb.a ? Item.getItemOf(aty.e) : Item.getItemOf(aty.b);
	}

	public int a(bec var1) {
		return ((bbb) var1.b(a)).a();
	}

	public bec a(int var1) {
		return this.P().a(a, bbb.a(var1));
	}

	public int c(bec var1) {
		return ((bbb) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
