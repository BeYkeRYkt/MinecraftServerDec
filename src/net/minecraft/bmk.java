package net.minecraft;

import java.util.List;
import java.util.Random;

abstract class bmk extends bms {

	protected bml d;

	public bmk() {
		this.d = bml.a;
	}

	protected bmk(int var1) {
		super(var1);
		this.d = bml.a;
	}

	protected void a(NBTCompoundTag var1) {
		var1.put("EntryDoor", this.d.name());
	}

	protected void b(NBTCompoundTag var1) {
		this.d = bml.valueOf(var1.getString("EntryDoor"));
	}

	protected void a(World var1, Random var2, bjb var3, bml var4, int var5, int var6, int var7) {
		switch (blu.a[var4.ordinal()]) {
			case 1:
			default:
				this.a(var1, var3, var5, var6, var7, var5 + 3 - 1, var6 + 3 - 1, var7, aty.a.P(), aty.a.P(), false);
				break;
			case 2:
				this.a(var1, aty.bf.P(), var5, var6, var7, var3);
				this.a(var1, aty.bf.P(), var5, var6 + 1, var7, var3);
				this.a(var1, aty.bf.P(), var5, var6 + 2, var7, var3);
				this.a(var1, aty.bf.P(), var5 + 1, var6 + 2, var7, var3);
				this.a(var1, aty.bf.P(), var5 + 2, var6 + 2, var7, var3);
				this.a(var1, aty.bf.P(), var5 + 2, var6 + 1, var7, var3);
				this.a(var1, aty.bf.P(), var5 + 2, var6, var7, var3);
				this.a(var1, aty.ao.P(), var5 + 1, var6, var7, var3);
				this.a(var1, aty.ao.a(8), var5 + 1, var6 + 1, var7, var3);
				break;
			case 3:
				this.a(var1, aty.a.P(), var5 + 1, var6, var7, var3);
				this.a(var1, aty.a.P(), var5 + 1, var6 + 1, var7, var3);
				this.a(var1, aty.bi.P(), var5, var6, var7, var3);
				this.a(var1, aty.bi.P(), var5, var6 + 1, var7, var3);
				this.a(var1, aty.bi.P(), var5, var6 + 2, var7, var3);
				this.a(var1, aty.bi.P(), var5 + 1, var6 + 2, var7, var3);
				this.a(var1, aty.bi.P(), var5 + 2, var6 + 2, var7, var3);
				this.a(var1, aty.bi.P(), var5 + 2, var6 + 1, var7, var3);
				this.a(var1, aty.bi.P(), var5 + 2, var6, var7, var3);
				break;
			case 4:
				this.a(var1, aty.bf.P(), var5, var6, var7, var3);
				this.a(var1, aty.bf.P(), var5, var6 + 1, var7, var3);
				this.a(var1, aty.bf.P(), var5, var6 + 2, var7, var3);
				this.a(var1, aty.bf.P(), var5 + 1, var6 + 2, var7, var3);
				this.a(var1, aty.bf.P(), var5 + 2, var6 + 2, var7, var3);
				this.a(var1, aty.bf.P(), var5 + 2, var6 + 1, var7, var3);
				this.a(var1, aty.bf.P(), var5 + 2, var6, var7, var3);
				this.a(var1, aty.aA.P(), var5 + 1, var6, var7, var3);
				this.a(var1, aty.aA.a(8), var5 + 1, var6 + 1, var7, var3);
				this.a(var1, aty.aG.a(this.a(aty.aG, 4)), var5 + 2, var6 + 1, var7 + 1, var3);
				this.a(var1, aty.aG.a(this.a(aty.aG, 3)), var5 + 2, var6 + 1, var7 - 1, var3);
		}

	}

	protected bml a(Random var1) {
		int var2 = var1.nextInt(5);
		switch (var2) {
			case 0:
			case 1:
			default:
				return bml.a;
			case 2:
				return bml.b;
			case 3:
				return bml.c;
			case 4:
				return bml.d;
		}
	}

	protected bms a(bmh var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (blu.b[this.m.ordinal()]) {
				case 1:
					return blr.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.c - 1, this.m, this.d());
				case 2:
					return blr.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.f + 1, this.m, this.d());
				case 3:
					return blr.a(var1, var2, var3, this.l.a - 1, this.l.b + var5, this.l.c + var4, this.m, this.d());
				case 4:
					return blr.a(var1, var2, var3, this.l.d + 1, this.l.b + var5, this.l.c + var4, this.m, this.d());
			}
		}

		return null;
	}

	protected bms b(bmh var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (blu.b[this.m.ordinal()]) {
				case 1:
					return blr.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, PaintingDirection.e, this.d());
				case 2:
					return blr.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, PaintingDirection.e, this.d());
				case 3:
					return blr.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, PaintingDirection.c, this.d());
				case 4:
					return blr.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, PaintingDirection.c, this.d());
			}
		}

		return null;
	}

	protected bms c(bmh var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (blu.b[this.m.ordinal()]) {
				case 1:
					return blr.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, PaintingDirection.f, this.d());
				case 2:
					return blr.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, PaintingDirection.f, this.d());
				case 3:
					return blr.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, PaintingDirection.d, this.d());
				case 4:
					return blr.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, PaintingDirection.d, this.d());
			}
		}

		return null;
	}

	protected static boolean a(bjb var0) {
		return var0 != null && var0.b > 10;
	}
}
