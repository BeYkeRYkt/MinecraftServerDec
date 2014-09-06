package net.minecraft;

import java.util.List;
import java.util.Random;

public class bly extends bmk {

	public bly() {
	}

	public bly(int var1, Random var2, bjb var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
	}

	public void a(bms var1, List var2, Random var3) {
		if (this.m != BlockFace.c && this.m != BlockFace.f) {
			this.c((bmh) var1, var2, var3, 1, 1);
		} else {
			this.b((bmh) var1, var2, var3, 1, 1);
		}

	}

	public static bly a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, -1, 0, 5, 5, 5, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bly(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, blr.c());
			this.a(var1, var2, var3, this.d, 1, 1, 0);
			if (this.m != BlockFace.c && this.m != BlockFace.f) {
				this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.AIR.P(), Blocks.AIR.P(), false);
			} else {
				this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.AIR.P(), Blocks.AIR.P(), false);
			}

			return true;
		}
	}
}
