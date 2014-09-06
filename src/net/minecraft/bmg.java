package net.minecraft;

import java.util.List;
import java.util.Random;

public class bmg extends bmk {

	private boolean a;

	public bmg() {
	}

	public bmg(int var1, Random var2, int var3, int var4) {
		super(var1);
		this.a = true;
		this.m = en.a.a(var2);
		this.d = bml.a;
		switch (blu.b[this.m.ordinal()]) {
			case 1:
			case 2:
				this.l = new bjb(var3, 64, var4, var3 + 5 - 1, 74, var4 + 5 - 1);
				break;
			default:
				this.l = new bjb(var3, 64, var4, var3 + 5 - 1, 74, var4 + 5 - 1);
		}

	}

	public bmg(int var1, Random var2, bjb var3, PaintingDirection var4) {
		super(var1);
		this.a = false;
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Source", this.a);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = var1.getBoolean("Source");
	}

	public void a(bms var1, List var2, Random var3) {
		if (this.a) {
			blr.a(blx.class);
		}

		this.a((bmh) var1, var2, var3, 1, 1);
	}

	public static bmg a(List var0, Random var1, int var2, int var3, int var4, PaintingDirection var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, -7, 0, 5, 11, 5, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bmg(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 10, 4, true, var2, blr.c());
			this.a(var1, var2, var3, this.d, 1, 7, 0);
			this.a(var1, var2, var3, bml.a, 1, 1, 4);
			this.a(var1, Blocks.STONEBRICK.P(), 2, 6, 1, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 1, 5, 1, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.a.a()), 1, 6, 1, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 1, 5, 2, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 1, 4, 3, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.a.a()), 1, 5, 3, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 2, 4, 3, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 3, 3, 3, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.a.a()), 3, 4, 3, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 3, 3, 2, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 3, 2, 1, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.a.a()), 3, 3, 1, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 2, 2, 1, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 1, 1, 1, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.a.a()), 1, 2, 1, var3);
			this.a(var1, Blocks.STONEBRICK.P(), 1, 1, 2, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.a.a()), 1, 1, 3, var3);
			return true;
		}
	}
}
