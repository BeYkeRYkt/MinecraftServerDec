package net.minecraft;

import java.util.Random;

public class auc extends Block {

	protected auc(Material var1) {
		super(var1);
		this.a(true);
		float var2 = 0.2F;
		this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var2 * 3.0F, 0.5F + var2);
		this.a(CreativeModeTab.DECORATIONS);
	}

	protected auc() {
		this(Material.PLANT);
	}

	public boolean c(World var1, Position var2) {
		return super.c(var1, var2) && this.c(var1.getBlockState(var2.b()).getBlock());
	}

	protected boolean c(Block var1) {
		return var1 == Blocks.GRASS || var1 == Blocks.DIRT || var1 == Blocks.FARMLAND;
	}

	public void a(World var1, Position var2, BlockState var3, Block var4) {
		super.a(var1, var2, var3, var4);
		this.e(var1, var2, var3);
	}

	public void b(World var1, Position var2, BlockState var3, Random var4) {
		this.e(var1, var2, var3);
	}

	protected void e(World var1, Position var2, BlockState var3) {
		if (!this.f(var1, var2, var3)) {
			this.b(var1, var2, var3, 0);
			var1.a(var2, Blocks.AIR.getBlockState(), 3);
		}

	}

	public boolean f(World var1, Position var2, BlockState var3) {
		return this.c(var1.getBlockState(var2.b()).getBlock());
	}

	public AxisAlignedBB a(World var1, Position var2, BlockState var3) {
		return null;
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}
}
