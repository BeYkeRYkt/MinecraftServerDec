package net.minecraft;

import java.util.Random;

public class BlockIce extends awt {

	public BlockIce() {
		super(Material.ICE, false);
		this.K = 0.98F;
		this.a(true);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public void a(World var1, EntityHuman var2, Position var3, bec var4, TileEntity var5) {
		var2.b(StatisticList.H[Block.getBlockId((Block) this)]);
		var2.a(0.025F);
		if (this.G() && aph.e(var2)) {
			ItemStack var8 = this.i(var4);
			if (var8 != null) {
				a(var1, var3, var8);
			}
		} else {
			if (var1.worldProvider.n()) {
				var1.g(var3);
				return;
			}

			int var6 = aph.f(var2);
			this.b(var1, var3, var4, var6);
			Material var7 = var1.p(var3.b()).getBlock().r();
			if (var7.isSolid() || var7.isLiquid()) {
				var1.a(var3, Blocks.FLOWING_WATER.P());
			}
		}

	}

	public int a(Random var1) {
		return 0;
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (var1.b(arf.b, var2) > 11 - this.n()) {
			if (var1.worldProvider.n()) {
				var1.g(var2);
			} else {
				this.b(var1, var2, var1.p(var2), 0);
				var1.a(var2, Blocks.WATER.P());
			}
		}
	}

	public int i() {
		return 0;
	}
}
