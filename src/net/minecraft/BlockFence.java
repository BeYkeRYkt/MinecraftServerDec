package net.minecraft;

import java.util.List;

public class BlockFence extends Block {

	public static final bet a = bet.a("north");
	public static final bet b = bet.a("east");
	public static final bet M = bet.a("south");
	public static final bet N = bet.a("west");

	public BlockFence(Material var1) {
		super(var1);
		this.j(this.L.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)));
		this.a(CreativeModeTab.DECORATIONS);
	}

	public void a(World var1, Position var2, bec var3, AxisAlignedBB var4, List var5, Entity var6) {
		boolean var7 = this.e(var1, var2.c());
		boolean var8 = this.e(var1, var2.d());
		boolean var9 = this.e(var1, var2.e());
		boolean var10 = this.e(var1, var2.f());
		float var11 = 0.375F;
		float var12 = 0.625F;
		float var13 = 0.375F;
		float var14 = 0.625F;
		if (var7) {
			var13 = 0.0F;
		}

		if (var8) {
			var14 = 1.0F;
		}

		if (var7 || var8) {
			this.a(var11, 0.0F, var13, var12, 1.5F, var14);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		var13 = 0.375F;
		var14 = 0.625F;
		if (var9) {
			var11 = 0.0F;
		}

		if (var10) {
			var12 = 1.0F;
		}

		if (var9 || var10 || !var7 && !var8) {
			this.a(var11, 0.0F, var13, var12, 1.5F, var14);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		if (var7) {
			var13 = 0.0F;
		}

		if (var8) {
			var14 = 1.0F;
		}

		this.a(var11, 0.0F, var13, var12, 1.0F, var14);
	}

	public void a(ard var1, Position var2) {
		boolean var3 = this.e(var1, var2.c());
		boolean var4 = this.e(var1, var2.d());
		boolean var5 = this.e(var1, var2.e());
		boolean var6 = this.e(var1, var2.f());
		float var7 = 0.375F;
		float var8 = 0.625F;
		float var9 = 0.375F;
		float var10 = 0.625F;
		if (var3) {
			var9 = 0.0F;
		}

		if (var4) {
			var10 = 1.0F;
		}

		if (var5) {
			var7 = 0.0F;
		}

		if (var6) {
			var8 = 1.0F;
		}

		this.a(var7, 0.0F, var9, var8, 1.0F, var10);
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean b(ard var1, Position var2) {
		return false;
	}

	public boolean e(ard var1, Position var2) {
		Block var3 = var1.p(var2).getBlock();
		return var3 == Blocks.BARRIER ? false : ((!(var3 instanceof BlockFence) || var3.material != this.material) && !(var3 instanceof BlockFenceGate) ? (var3.material.k() && var3.d() ? var3.material != Material.PUMPKIN : false) : true);
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		return var1.D ? true : ItemLeash.a(var4, var1, var2);
	}

	public int c(bec var1) {
		return 0;
	}

	public bec a(bec var1, ard var2, Position var3) {
		return var1.a(a, Boolean.valueOf(this.e(var2, var3.c()))).a(b, Boolean.valueOf(this.e(var2, var3.f()))).a(M, Boolean.valueOf(this.e(var2, var3.d()))).a(N, Boolean.valueOf(this.e(var2, var3.e())));
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b, N, M });
	}

}
