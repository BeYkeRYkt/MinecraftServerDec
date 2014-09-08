package net.minecraft;

import java.util.List;
import java.util.Random;

public class bnd extends bnn {

	public bnd() {
	}

	public bnd(bnk var1, int var2, Random var3, bjb var4, BlockFace var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
	}

	public static bjb a(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6) {
		bjb var7 = bjb.a(var3, var4, var5, 0, 0, 0, 3, 4, 2, var6);
		return bms.a(var1, var7) != null ? null : var7;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 4 - 1, 0);
		}

		this.a(var1, var3, 0, 0, 0, 2, 3, 1, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
		this.a(var1, Blocks.FENCE.getBlockState(), 1, 0, 0, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 1, 1, 0, var3);
		this.a(var1, Blocks.FENCE.getBlockState(), 1, 2, 0, var3);
		this.a(var1, Blocks.WOOL.a(akv.a.b()), 1, 3, 0, var3);
		boolean var4 = this.m == BlockFace.EAST || this.m == BlockFace.NORTH;
		this.a(var1, Blocks.TORCH.getBlockState().a(BlockTorch.a, this.m.e()), var4 ? 2 : 0, 3, 0, var3);
		this.a(var1, Blocks.TORCH.getBlockState().a(BlockTorch.a, this.m), 1, 3, 1, var3);
		this.a(var1, Blocks.TORCH.getBlockState().a(BlockTorch.a, this.m.f()), var4 ? 0 : 2, 3, 0, var3);
		this.a(var1, Blocks.TORCH.getBlockState().a(BlockTorch.a, this.m.getOpposite()), 1, 3, -1, var3);
		return true;
	}
}
