package net.minecraft;

import java.util.Random;

public class BlockCocoa extends avb implements atz {

	public static final bew a = bew.a("age", 0, 2);

	public BlockCocoa() {
		super(Material.PLANT);
		this.setBlockState(this.L.b().a(N, BlockFace.NORTH).a(a, Integer.valueOf(0)));
		this.a(true);
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		if (!this.e(var1, var2, var3)) {
			this.f(var1, var2, var3);
		} else if (var1.s.nextInt(5) == 0) {
			int var5 = ((Integer) var3.b(a)).intValue();
			if (var5 < 2) {
				var1.setBlockAt(var2, var3.a(a, Integer.valueOf(var5 + 1)), 2);
			}
		}

	}

	public boolean e(World var1, Position var2, IBlockState var3) {
		var2 = var2.getRelative((BlockFace) var3.b(N));
		IBlockState var4 = var1.getBlockState(var2);
		return var4.getBlock() == Blocks.LOG && var4.b(BlockWood.a) == EnumWoodType.d;
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public AxisAlignedBB a(World var1, Position var2, IBlockState var3) {
		this.a(var1, var2);
		return super.a(var1, var2, var3);
	}

	public void a(ard var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		BlockFace var4 = (BlockFace) var3.b(N);
		int var5 = ((Integer) var3.b(a)).intValue();
		int var6 = 4 + var5 * 2;
		int var7 = 5 + var5 * 2;
		float var8 = (float) var6 / 2.0F;
		switch (aum.a[var4.ordinal()]) {
			case 1:
				this.a((8.0F - var8) / 16.0F, (12.0F - (float) var7) / 16.0F, (15.0F - (float) var6) / 16.0F, (8.0F + var8) / 16.0F, 0.75F, 0.9375F);
				break;
			case 2:
				this.a((8.0F - var8) / 16.0F, (12.0F - (float) var7) / 16.0F, 0.0625F, (8.0F + var8) / 16.0F, 0.75F, (1.0F + (float) var6) / 16.0F);
				break;
			case 3:
				this.a(0.0625F, (12.0F - (float) var7) / 16.0F, (8.0F - var8) / 16.0F, (1.0F + (float) var6) / 16.0F, 0.75F, (8.0F + var8) / 16.0F);
				break;
			case 4:
				this.a((15.0F - (float) var6) / 16.0F, (12.0F - (float) var7) / 16.0F, (8.0F - var8) / 16.0F, 0.9375F, 0.75F, (8.0F + var8) / 16.0F);
		}

	}

	public void a(World var1, Position var2, IBlockState var3, EntityLiving var4, ItemStack var5) {
		BlockFace var6 = BlockFace.fromDirection((double) var4.yaw);
		var1.setBlockAt(var2, var3.a(N, var6), 2);
	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		if (!var3.k().c()) {
			var3 = BlockFace.NORTH;
		}

		return this.getBlockState().a(N, var3.getOpposite()).a(a, Integer.valueOf(0));
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (!this.e(var1, var2, var3)) {
			this.f(var1, var2, var3);
		}

	}

	private void f(World var1, Position var2, IBlockState var3) {
		var1.setBlockAt(var2, Blocks.AIR.getBlockState(), 3);
		this.b(var1, var2, var3, 0);
	}

	public void a(World var1, Position var2, IBlockState var3, float var4, int var5) {
		int var6 = ((Integer) var3.b(a)).intValue();
		byte var7 = 1;
		if (var6 >= 2) {
			var7 = 3;
		}

		for (int var8 = 0; var8 < var7; ++var8) {
			a(var1, var2, new ItemStack(Items.DYE, 1, akv.m.b()));
		}

	}

	public int j(World var1, Position var2) {
		return akv.m.b();
	}

	public boolean a(World var1, Position var2, IBlockState var3, boolean var4) {
		return ((Integer) var3.b(a)).intValue() < 2;
	}

	public boolean a(World var1, Random var2, Position var3, IBlockState var4) {
		return true;
	}

	public void b(World var1, Random var2, Position var3, IBlockState var4) {
		var1.setBlockAt(var3, var4.a(a, Integer.valueOf(((Integer) var4.b(a)).intValue() + 1)), 2);
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(N, BlockFace.fromDirection(var1)).a(a, Integer.valueOf((var1 & 15) >> 2));
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(N)).toDirection();
		var3 |= ((Integer) var1.b(a)).intValue() << 2;
		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { N, a });
	}

}
