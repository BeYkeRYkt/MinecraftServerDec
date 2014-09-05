package net.minecraft;

public class aea extends aed {

	public aea(World var1) {
		super(var1);
	}

	public aea(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public void a(wh var1) {
		super.a(var1);
		this.a(Item.getItemOf((Block) aty.ae), 1, 0.0F);
	}

	public int n_() {
		return 27;
	}

	public adz s() {
		return adz.b;
	}

	public bec u() {
		return aty.ae.P().a(auj.a, PaintingDirection.c);
	}

	public int w() {
		return 8;
	}

	public String k() {
		return "minecraft:chest";
	}

	public Container a(PlayerInventory var1, EntityHuman var2) {
		return new aim(var1, this, var2);
	}
}
