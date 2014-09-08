package net.minecraft;

import com.google.common.base.Predicate;

public class BlockLeaves2 extends BlockLeaves {

	public static final bev P = bev.a("variant", ayx.class, (Predicate) (new ayh()));

	public BlockLeaves2() {
		this.setBlockState(this.L.b().a(P, ayx.e).a(b, Boolean.valueOf(true)).a(a, Boolean.valueOf(true)));
	}

	protected void a(World var1, Position var2, BlockState var3, int var4) {
		if (var3.b(P) == ayx.f && var1.s.nextInt(var4) == 0) {
			a(var1, var2, new ItemStack(Items.APPLE, 1, 0));
		}

	}

	public int a(BlockState var1) {
		return ((ayx) var1.b(P)).a();
	}

	public int j(World var1, Position var2) {
		BlockState var3 = var1.getBlockState(var2);
		return var3.getBlock().c(var3) & 3;
	}

	protected ItemStack i(BlockState var1) {
		return new ItemStack(Item.getItemOf((Block) this), 1, ((ayx) var1.b(P)).a() - 4);
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(P, this.b(var1)).a(a, Boolean.valueOf((var1 & 4) == 0)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	public int c(BlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((ayx) var1.b(P)).a() - 4;
		if (!((Boolean) var1.b(a)).booleanValue()) {
			var3 |= 4;
		}

		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	public ayx b(int var1) {
		return ayx.a((var1 & 3) + 4);
	}

	protected bed e() {
		return new bed(this, new bex[] { P, b, a });
	}

	public void a(World var1, EntityHuman var2, Position var3, BlockState var4, TileEntity var5) {
		if (!var1.D && var2.bY() != null && var2.bY().getItem() == Items.SHEARS) {
			var2.b(StatisticList.MINE_BLOCK_COUNT[Block.getBlockId((Block) this)]);
			a(var1, var3, new ItemStack(Item.getItemOf((Block) this), 1, ((ayx) var4.b(P)).a() - 4));
		} else {
			super.a(var1, var2, var3, var4, var5);
		}
	}

}
