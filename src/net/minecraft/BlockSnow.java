package net.minecraft;

import java.util.Random;

public class BlockSnow extends Block {

	public static final bew a = bew.a("layers", 1, 8);

	protected BlockSnow() {
		super(Material.PACKED_ICE);
		this.j(this.L.b().a(a, Integer.valueOf(1)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.a(true);
		this.a(CreativeModeTab.c);
		this.h();
	}

	public boolean b(ard var1, Position var2) {
		return ((Integer) var1.p(var2).b(a)).intValue() < 5;
	}

	public brt a(World var1, Position var2, bec var3) {
		int var4 = ((Integer) var3.b(a)).intValue() - 1;
		float var5 = 0.125F;
		return new brt((double) var2.getX() + this.B, (double) var2.getY() + this.C, (double) var2.getZ() + this.D, (double) var2.getX() + this.E, (double) ((float) var2.getY() + (float) var4 * var5), (double) var2.getZ() + this.G);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public void h() {
		this.b(0);
	}

	public void a(ard var1, Position var2) {
		bec var3 = var1.p(var2);
		this.b(((Integer) var3.b(a)).intValue());
	}

	protected void b(int var1) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, (float) var1 / 8.0F, 1.0F);
	}

	public boolean c(World var1, Position var2) {
		bec var3 = var1.p(var2.b());
		Block var4 = var3.getBlock();
		return var4 != aty.aI && var4 != aty.cB ? (var4.r() == Material.LEAVES ? true : (var4 == this && ((Integer) var3.b(a)).intValue() == 7 ? true : var4.c() && var4.material.isSolid())) : false;
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		this.e(var1, var2, var3);
	}

	private boolean e(World var1, Position var2, bec var3) {
		if (!this.c(var1, var2)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		} else {
			return true;
		}
	}

	public void a(World var1, EntityHuman var2, Position var3, bec var4, TileEntity var5) {
		a(var1, var3, new ItemStack(amk.aD, ((Integer) var4.b(a)).intValue() + 1, 0));
		var1.g(var3);
		var2.b(StatisticList.H[Block.a((Block) this)]);
	}

	public Item a(bec var1, Random var2, int var3) {
		return amk.aD;
	}

	public int a(Random var1) {
		return 0;
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (var1.b(arf.b, var2) > 11) {
			this.b(var1, var2, var1.p(var2), 0);
			var1.g(var2);
		}

	}

	public bec a(int var1) {
		return this.P().a(a, Integer.valueOf((var1 & 7) + 1));
	}

	public boolean f(World var1, Position var2) {
		return ((Integer) var1.p(var2).b(a)).intValue() == 1;
	}

	public int c(bec var1) {
		return ((Integer) var1.b(a)).intValue() - 1;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
