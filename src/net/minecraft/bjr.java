package net.minecraft;

import java.util.List;
import java.util.Random;

public class bjr extends bkb {

	public bjr() {
	}

	public bjr(int var1, Random var2, bjb var3, ej var4) {
		super(var1);
		this.m = var4;
		this.l = var3;
	}

	public void a(bms var1, List var2, Random var3) {
		this.a((bkf) var1, var2, var3, 1, 3, false);
	}

	public static bjr a(List var0, Random var1, int var2, int var3, int var4, ej var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, -3, 0, 5, 10, 19, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bjr(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		this.a(var1, var3, 0, 3, 0, 4, 4, 18, aty.by.P(), aty.by.P(), false);
		this.a(var1, var3, 1, 5, 0, 3, 7, 18, aty.a.P(), aty.a.P(), false);
		this.a(var1, var3, 0, 5, 0, 0, 5, 18, aty.by.P(), aty.by.P(), false);
		this.a(var1, var3, 4, 5, 0, 4, 5, 18, aty.by.P(), aty.by.P(), false);
		this.a(var1, var3, 0, 2, 0, 4, 2, 5, aty.by.P(), aty.by.P(), false);
		this.a(var1, var3, 0, 2, 13, 4, 2, 18, aty.by.P(), aty.by.P(), false);
		this.a(var1, var3, 0, 0, 0, 4, 1, 3, aty.by.P(), aty.by.P(), false);
		this.a(var1, var3, 0, 0, 15, 4, 1, 18, aty.by.P(), aty.by.P(), false);

		for (int var4 = 0; var4 <= 4; ++var4) {
			for (int var5 = 0; var5 <= 2; ++var5) {
				this.b(var1, aty.by.P(), var4, -1, var5, var3);
				this.b(var1, aty.by.P(), var4, -1, 18 - var5, var3);
			}
		}

		this.a(var1, var3, 0, 1, 1, 0, 4, 1, aty.bz.P(), aty.bz.P(), false);
		this.a(var1, var3, 0, 3, 4, 0, 4, 4, aty.bz.P(), aty.bz.P(), false);
		this.a(var1, var3, 0, 3, 14, 0, 4, 14, aty.bz.P(), aty.bz.P(), false);
		this.a(var1, var3, 0, 1, 17, 0, 4, 17, aty.bz.P(), aty.bz.P(), false);
		this.a(var1, var3, 4, 1, 1, 4, 4, 1, aty.bz.P(), aty.bz.P(), false);
		this.a(var1, var3, 4, 3, 4, 4, 4, 4, aty.bz.P(), aty.bz.P(), false);
		this.a(var1, var3, 4, 3, 14, 4, 4, 14, aty.bz.P(), aty.bz.P(), false);
		this.a(var1, var3, 4, 1, 17, 4, 4, 17, aty.bz.P(), aty.bz.P(), false);
		return true;
	}
}
