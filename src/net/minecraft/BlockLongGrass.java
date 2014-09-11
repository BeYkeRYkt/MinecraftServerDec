package net.minecraft;

import java.util.Random;

public class BlockLongGrass extends auc implements atz {

	public static final bev a = bev.a("type", EnumGrassType.class);

	protected BlockLongGrass() {
		super(Material.REPLACEABLE_PLANT);
		this.setBlockState(this.L.b().a(a, EnumGrassType.a));
		float var1 = 0.4F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
	}

	public boolean f(World var1, Position var2, BlockState var3) {
		return this.c(var1.getBlockState(var2.b()).getBlock());
	}

	public boolean f(World var1, Position var2) {
		return true;
	}

	public Item a(BlockState var1, Random var2, int var3) {
		return var2.nextInt(8) == 0 ? Items.WHEAT_SEEDS : null;
	}

	public int a(int var1, Random var2) {
		return 1 + var2.nextInt(var1 * 2 + 1);
	}

	public void a(World var1, EntityHuman var2, Position var3, BlockState var4, TileEntity var5) {
		if (!var1.isStatic && var2.bY() != null && var2.bY().getItem() == Items.SHEARS) {
			var2.b(StatisticList.MINE_BLOCK_COUNT[Block.getBlockId((Block) this)]);
			a(var1, var3, new ItemStack(Blocks.TALLGRASS, 1, ((EnumGrassType) var4.b(a)).a()));
		} else {
			super.a(var1, var2, var3, var4, var5);
		}

	}

	public int j(World var1, Position var2) {
		BlockState var3 = var1.getBlockState(var2);
		return var3.getBlock().c(var3);
	}

	public boolean a(World var1, Position var2, BlockState var3, boolean var4) {
		return var3.b(a) != EnumGrassType.a;
	}

	public boolean a(World var1, Random var2, Position var3, BlockState var4) {
		return true;
	}

	public void b(World var1, Random var2, Position var3, BlockState var4) {
		avk var5 = avk.c;
		if (var4.b(a) == EnumGrassType.c) {
			var5 = avk.d;
		}

		if (Blocks.DOUBLE_PLANT.c(var1, var3)) {
			Blocks.DOUBLE_PLANT.a(var1, var3, var5, 2);
		}

	}

	public BlockState a(int var1) {
		return this.getBlockState().a(a, EnumGrassType.a(var1));
	}

	public int c(BlockState var1) {
		return ((EnumGrassType) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
