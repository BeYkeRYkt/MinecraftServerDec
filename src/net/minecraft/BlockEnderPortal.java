package net.minecraft;

import java.util.List;
import java.util.Random;

public class BlockEnderPortal extends atg {

	protected BlockEnderPortal(Material var1) {
		super(var1);
		this.a(1.0F);
	}

	public TileEntity a(World var1, int var2) {
		return new TileEntityEnderPortal();
	}

	public void a(ard var1, Position var2) {
		float var3 = 0.0625F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
	}

	public void a(World var1, Position var2, BlockState var3, AxisAlignedBB var4, List var5, Entity var6) {
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public int a(Random var1) {
		return 0;
	}

	public void a(World var1, Position var2, BlockState var3, Entity var4) {
		if (var4.vehicle == null && var4.l == null && !var1.D) {
			var4.c(1);
		}

	}

	public MaterialMapColor g(BlockState var1) {
		return MaterialMapColor.J;
	}
}
