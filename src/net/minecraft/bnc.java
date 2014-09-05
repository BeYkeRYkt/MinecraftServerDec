package net.minecraft;

import java.util.List;
import java.util.Random;

public class bnc extends bnn {

	private Block a;
	private Block b;

	public bnc() {
	}

	public bnc(bnk var1, int var2, Random var3, bjb var4, ej var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
		this.a = this.a(var3);
		this.b = this.a(var3);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("CA", Block.c.b(this.a));
		var1.put("CB", Block.c.b(this.b));
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = Block.c(var1.getInt("CA"));
		this.b = Block.c(var1.getInt("CB"));
	}

	private Block a(Random var1) {
		switch (var1.nextInt(5)) {
			case 0:
				return aty.cb;
			case 1:
				return aty.cc;
			default:
				return aty.aj;
		}
	}

	public static bnc a(bnk var0, List var1, Random var2, int var3, int var4, int var5, ej var6, int var7) {
		bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 7, 4, 9, var6);
		return a(var8) && bms.a(var1, var8) == null ? new bnc(var0, var7, var2, var8, var6) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 4 - 1, 0);
		}

		this.a(var1, var3, 0, 1, 0, 6, 4, 8, aty.a.P(), aty.a.P(), false);
		this.a(var1, var3, 1, 0, 1, 2, 0, 7, aty.ak.P(), aty.ak.P(), false);
		this.a(var1, var3, 4, 0, 1, 5, 0, 7, aty.ak.P(), aty.ak.P(), false);
		this.a(var1, var3, 0, 0, 0, 0, 0, 8, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 6, 0, 0, 6, 0, 8, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 1, 0, 0, 5, 0, 0, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 1, 0, 8, 5, 0, 8, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 3, 0, 1, 3, 0, 7, aty.j.P(), aty.j.P(), false);

		int var4;
		for (var4 = 1; var4 <= 7; ++var4) {
			this.a(var1, this.a.a(DataTypesConverter.a(var2, 2, 7)), 1, 1, var4, var3);
			this.a(var1, this.a.a(DataTypesConverter.a(var2, 2, 7)), 2, 1, var4, var3);
			this.a(var1, this.b.a(DataTypesConverter.a(var2, 2, 7)), 4, 1, var4, var3);
			this.a(var1, this.b.a(DataTypesConverter.a(var2, 2, 7)), 5, 1, var4, var3);
		}

		for (var4 = 0; var4 < 9; ++var4) {
			for (int var5 = 0; var5 < 7; ++var5) {
				this.b(var1, var5, 4, var4, var3);
				this.b(var1, aty.d.P(), var5, -1, var4, var3);
			}
		}

		return true;
	}
}
