package net.minecraft;

import java.util.List;
import java.util.Random;

public class blw extends bmk {

	private int a;

	public blw() {
	}

	public blw(int var1, Random var2, bjb var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
		this.a = var4 != BlockFace.c && var4 != BlockFace.d ? var3.c() : var3.e();
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Steps", this.a);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = var1.getInt("Steps");
	}

	public static bjb a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5) {
		boolean var6 = true;
		bjb var7 = bjb.a(var2, var3, var4, -1, -1, 0, 5, 5, 4, var5);
		bms var8 = bms.a(var0, var7);
		if (var8 == null) {
			return null;
		} else {
			if (var8.c().b == var7.b) {
				for (int var9 = 3; var9 >= 1; --var9) {
					var7 = bjb.a(var2, var3, var4, -1, -1, 0, 5, 5, var9 - 1, var5);
					if (!var8.c().a(var7)) {
						return bjb.a(var2, var3, var4, -1, -1, 0, 5, 5, var9, var5);
					}
				}
			}

			return null;
		}
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			for (int var4 = 0; var4 < this.a; ++var4) {
				this.a(var1, Blocks.STONEBRICK.P(), 0, 0, var4, var3);
				this.a(var1, Blocks.STONEBRICK.P(), 1, 0, var4, var3);
				this.a(var1, Blocks.STONEBRICK.P(), 2, 0, var4, var3);
				this.a(var1, Blocks.STONEBRICK.P(), 3, 0, var4, var3);
				this.a(var1, Blocks.STONEBRICK.P(), 4, 0, var4, var3);

				for (int var5 = 1; var5 <= 3; ++var5) {
					this.a(var1, Blocks.STONEBRICK.P(), 0, var5, var4, var3);
					this.a(var1, Blocks.AIR.P(), 1, var5, var4, var3);
					this.a(var1, Blocks.AIR.P(), 2, var5, var4, var3);
					this.a(var1, Blocks.AIR.P(), 3, var5, var4, var3);
					this.a(var1, Blocks.STONEBRICK.P(), 4, var5, var4, var3);
				}

				this.a(var1, Blocks.STONEBRICK.P(), 0, 4, var4, var3);
				this.a(var1, Blocks.STONEBRICK.P(), 1, 4, var4, var3);
				this.a(var1, Blocks.STONEBRICK.P(), 2, 4, var4, var3);
				this.a(var1, Blocks.STONEBRICK.P(), 3, 4, var4, var3);
				this.a(var1, Blocks.STONEBRICK.P(), 4, 4, var4, var3);
			}

			return true;
		}
	}
}
