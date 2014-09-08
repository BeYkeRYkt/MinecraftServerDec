package net.minecraft;

import java.util.List;
import java.util.Random;

public class bmc extends bmk {

	public bmc() {
	}

	public bmc(int var1, Random var2, bjb var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
	}

	public void a(bms var1, List var2, Random var3) {
		this.a((bmh) var1, var2, var3, 1, 1);
	}

	public static bmc a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, -1, 0, 9, 5, 11, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bmc(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 8, 4, 10, true, var2, blr.c());
			this.a(var1, var2, var3, this.d, 1, 1, 0);
			this.a(var1, var3, 1, 1, 10, 3, 3, 10, Blocks.AIR.getBlockState(), Blocks.AIR.getBlockState(), false);
			this.a(var1, var3, 4, 1, 1, 4, 3, 1, false, var2, blr.c());
			this.a(var1, var3, 4, 1, 3, 4, 3, 3, false, var2, blr.c());
			this.a(var1, var3, 4, 1, 7, 4, 3, 7, false, var2, blr.c());
			this.a(var1, var3, 4, 1, 9, 4, 3, 9, false, var2, blr.c());
			this.a(var1, var3, 4, 1, 4, 4, 3, 6, Blocks.IRON_BARS.getBlockState(), Blocks.IRON_BARS.getBlockState(), false);
			this.a(var1, var3, 5, 1, 5, 7, 3, 5, Blocks.IRON_BARS.getBlockState(), Blocks.IRON_BARS.getBlockState(), false);
			this.a(var1, Blocks.IRON_BARS.getBlockState(), 4, 3, 2, var3);
			this.a(var1, Blocks.IRON_BARS.getBlockState(), 4, 3, 8, var3);
			this.a(var1, Blocks.IRON_DOOR.a(this.a(Blocks.IRON_DOOR, 3)), 4, 1, 2, var3);
			this.a(var1, Blocks.IRON_DOOR.a(this.a(Blocks.IRON_DOOR, 3) + 8), 4, 2, 2, var3);
			this.a(var1, Blocks.IRON_DOOR.a(this.a(Blocks.IRON_DOOR, 3)), 4, 1, 8, var3);
			this.a(var1, Blocks.IRON_DOOR.a(this.a(Blocks.IRON_DOOR, 3) + 8), 4, 2, 8, var3);
			return true;
		}
	}
}
