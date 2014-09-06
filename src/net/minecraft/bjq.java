package net.minecraft;

import java.util.List;
import java.util.Random;

public class bjq extends bkb {

	private int b;

	public bjq() {
	}

	public bjq(int var1, Random var2, bjb var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
		this.b = var2.nextInt();
	}

	public static bjq a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, -3, 0, 5, 10, 8, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bjq(var6, var1, var7, var5) : null;
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getInt("Seed");
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Seed", this.b);
	}

	public boolean a(World var1, Random var2, bjb var3) {
		Random var4 = new Random((long) this.b);

		int var5;
		int var6;
		int var7;
		for (var5 = 0; var5 <= 4; ++var5) {
			for (var6 = 3; var6 <= 4; ++var6) {
				var7 = var4.nextInt(8);
				this.a(var1, var3, var5, var6, 0, var5, var6, var7, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
			}
		}

		var5 = var4.nextInt(8);
		this.a(var1, var3, 0, 5, 0, 0, 5, var5, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		var5 = var4.nextInt(8);
		this.a(var1, var3, 4, 5, 0, 4, 5, var5, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);

		for (var5 = 0; var5 <= 4; ++var5) {
			var6 = var4.nextInt(5);
			this.a(var1, var3, var5, 2, 0, var5, 2, var6, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
		}

		for (var5 = 0; var5 <= 4; ++var5) {
			for (var6 = 0; var6 <= 1; ++var6) {
				var7 = var4.nextInt(3);
				this.a(var1, var3, var5, var6, 0, var5, var6, var7, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
			}
		}

		return true;
	}
}
