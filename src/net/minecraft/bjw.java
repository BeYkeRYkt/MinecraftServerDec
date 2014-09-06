package net.minecraft;

import java.util.List;
import java.util.Random;

public class bjw extends bkb {

	private boolean b;

	public bjw() {
	}

	public bjw(int var1, Random var2, bjb var3, PaintingDirection var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
		this.b = var2.nextInt(3) == 0;
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getBoolean("Chest");
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Chest", this.b);
	}

	public void a(bms var1, List var2, Random var3) {
		this.b((bkf) var1, var2, var3, 0, 1, true);
	}

	public static bjw a(List var0, Random var1, int var2, int var3, int var4, PaintingDirection var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bjw(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		this.a(var1, var3, 0, 0, 0, 4, 1, 4, Blocks.by.P(), Blocks.by.P(), false);
		this.a(var1, var3, 0, 2, 0, 4, 5, 4, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 4, 2, 0, 4, 5, 4, Blocks.by.P(), Blocks.by.P(), false);
		this.a(var1, var3, 4, 3, 1, 4, 4, 1, Blocks.bz.P(), Blocks.bz.P(), false);
		this.a(var1, var3, 4, 3, 3, 4, 4, 3, Blocks.bz.P(), Blocks.bz.P(), false);
		this.a(var1, var3, 0, 2, 0, 0, 5, 0, Blocks.by.P(), Blocks.by.P(), false);
		this.a(var1, var3, 0, 2, 4, 3, 5, 4, Blocks.by.P(), Blocks.by.P(), false);
		this.a(var1, var3, 1, 3, 4, 1, 4, 4, Blocks.bz.P(), Blocks.by.P(), false);
		this.a(var1, var3, 3, 3, 4, 3, 4, 4, Blocks.bz.P(), Blocks.by.P(), false);
		if (this.b && var3.b((fd) (new Position(this.a(3, 3), this.d(2), this.b(3, 3))))) {
			this.b = false;
			this.a(var1, var3, var2, 3, 2, 3, a, 2 + var2.nextInt(4));
		}

		this.a(var1, var3, 0, 6, 0, 4, 6, 4, Blocks.by.P(), Blocks.by.P(), false);

		for (int var4 = 0; var4 <= 4; ++var4) {
			for (int var5 = 0; var5 <= 4; ++var5) {
				this.b(var1, Blocks.by.P(), var4, -1, var5, var3);
			}
		}

		return true;
	}
}
