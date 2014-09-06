package net.minecraft;

import java.util.Random;

public class BlockLongGrass extends auc implements atz {

	public static final bev a = bev.a("type", bbi.class);

	protected BlockLongGrass() {
		super(Material.REPLACEABLE_PLANT);
		this.j(this.L.b().a(a, bbi.a));
		float var1 = 0.4F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
	}

	public boolean f(World var1, Position var2, bec var3) {
		return this.c(var1.p(var2.b()).getBlock());
	}

	public boolean f(World var1, Position var2) {
		return true;
	}

	public Item a(bec var1, Random var2, int var3) {
		return var2.nextInt(8) == 0 ? Items.N : null;
	}

	public int a(int var1, Random var2) {
		return 1 + var2.nextInt(var1 * 2 + 1);
	}

	public void a(World var1, EntityHuman var2, Position var3, bec var4, TileEntity var5) {
		if (!var1.D && var2.bY() != null && var2.bY().getItem() == Items.be) {
			var2.b(StatisticList.H[Block.a((Block) this)]);
			a(var1, var3, new ItemStack(Blocks.TALLGRASS, 1, ((bbi) var4.b(a)).a()));
		} else {
			super.a(var1, var2, var3, var4, var5);
		}

	}

	public int j(World var1, Position var2) {
		bec var3 = var1.p(var2);
		return var3.getBlock().c(var3);
	}

	public boolean a(World var1, Position var2, bec var3, boolean var4) {
		return var3.b(a) != bbi.a;
	}

	public boolean a(World var1, Random var2, Position var3, bec var4) {
		return true;
	}

	public void b(World var1, Random var2, Position var3, bec var4) {
		avk var5 = avk.c;
		if (var4.b(a) == bbi.c) {
			var5 = avk.d;
		}

		if (Blocks.DOUBLE_PLANT.c(var1, var3)) {
			Blocks.DOUBLE_PLANT.a(var1, var3, var5, 2);
		}

	}

	public bec a(int var1) {
		return this.P().a(a, bbi.a(var1));
	}

	public int c(bec var1) {
		return ((bbi) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
