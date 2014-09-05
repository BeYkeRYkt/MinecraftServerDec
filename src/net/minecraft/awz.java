package net.minecraft;

import java.util.Random;

public class awz extends Block {

	public static final bev a = bev.a("variant", axa.class);
	private final Block b;

	public awz(bof var1, Block var2) {
		super(var1);
		this.j(this.L.b().a(a, axa.l));
		this.b = var2;
	}

	public int a(Random var1) {
		return Math.max(0, var1.nextInt(10) - 7);
	}

	public Item a(bec var1, Random var2, int var3) {
		return Item.getItemOf(this.b);
	}

	public bec a(World var1, Position var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P();
	}

	public bec a(int var1) {
		return this.P().a(a, axa.a(var1));
	}

	public int c(bec var1) {
		return ((axa) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
