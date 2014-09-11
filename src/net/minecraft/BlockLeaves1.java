package net.minecraft;

import com.google.common.base.Predicate;

public class BlockLeaves1 extends BlockLeaves {

	public static final bev P = bev.a("variant", EnumWoodType.class, (Predicate) (new ayq()));

	public BlockLeaves1() {
		this.setBlockState(this.L.b().a(P, EnumWoodType.a).a(b, Boolean.valueOf(true)).a(a, Boolean.valueOf(true)));
	}

	protected void a(World var1, Position var2, BlockState var3, int var4) {
		if (var3.b(P) == EnumWoodType.a && var1.s.nextInt(var4) == 0) {
			a(var1, var2, new ItemStack(Items.APPLE, 1, 0));
		}

	}

	protected int d(BlockState var1) {
		return var1.b(P) == EnumWoodType.d ? 40 : super.d(var1);
	}

	protected ItemStack i(BlockState var1) {
		return new ItemStack(Item.getItemOf((Block) this), 1, ((EnumWoodType) var1.b(P)).a());
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(P, this.b(var1)).a(a, Boolean.valueOf((var1 & 4) == 0)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	public int c(BlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((EnumWoodType) var1.b(P)).a();
		if (!((Boolean) var1.b(a)).booleanValue()) {
			var3 |= 4;
		}

		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	public EnumWoodType b(int var1) {
		return EnumWoodType.a((var1 & 3) % 4);
	}

	protected bed e() {
		return new bed(this, new bex[] { P, b, a });
	}

	public int a(BlockState var1) {
		return ((EnumWoodType) var1.b(P)).a();
	}

	public void a(World var1, EntityHuman var2, Position var3, BlockState var4, TileEntity var5) {
		if (!var1.isStatic && var2.bY() != null && var2.bY().getItem() == Items.SHEARS) {
			var2.b(StatisticList.MINE_BLOCK_COUNT[Block.getBlockId((Block) this)]);
			a(var1, var3, new ItemStack(Item.getItemOf((Block) this), 1, ((EnumWoodType) var4.b(P)).a()));
		} else {
			super.a(var1, var2, var3, var4, var5);
		}
	}

}
