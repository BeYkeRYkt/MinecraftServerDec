package net.minecraft;

import java.util.List;
import java.util.Random;

public class bjv extends bkb {

	public bjv() {
	}

	public bjv(int var1, Random var2, bjb var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
	}

	public void a(bms var1, List var2, Random var3) {
		this.a((bkf) var1, var2, var3, 1, 0, true);
		this.b((bkf) var1, var2, var3, 0, 1, true);
		this.c((bkf) var1, var2, var3, 0, 1, true);
	}

	public static bjv a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bjv(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		this.a(var1, var3, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 0, 2, 0, 4, 5, 4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 0, 2, 4, 0, 5, 4, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 4, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		this.a(var1, var3, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);

		for (int var4 = 0; var4 <= 4; ++var4) {
			for (int var5 = 0; var5 <= 4; ++var5) {
				this.b(var1, Blocks.NETHER_BRICK.P(), var4, -1, var5, var3);
			}
		}

		return true;
	}
}
