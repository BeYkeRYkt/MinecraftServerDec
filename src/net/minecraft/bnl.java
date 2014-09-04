package net.minecraft;

import java.util.List;
import java.util.Random;

public class bnl extends bno {

	private int a;

	public bnl() {
	}

	public bnl(bnk var1, int var2, Random var3, bjb var4, ej var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
		this.a = Math.max(var4.c(), var4.e());
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Length", this.a);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = var1.getInt("Length");
	}

	public void a(bms var1, List var2, Random var3) {
		boolean var4 = false;

		int var5;
		bms var6;
		for (var5 = var3.nextInt(5); var5 < this.a - 8; var5 += 2 + var3.nextInt(5)) {
			var6 = this.a((bnk) var1, var2, var3, 0, var5);
			if (var6 != null) {
				var5 += Math.max(var6.l.c(), var6.l.e());
				var4 = true;
			}
		}

		for (var5 = var3.nextInt(5); var5 < this.a - 8; var5 += 2 + var3.nextInt(5)) {
			var6 = this.b((bnk) var1, var2, var3, 0, var5);
			if (var6 != null) {
				var5 += Math.max(var6.l.c(), var6.l.e());
				var4 = true;
			}
		}

		if (var4 && var3.nextInt(3) > 0 && this.m != null) {
			switch (bmz.a[this.m.ordinal()]) {
				case 1:
					bmy.b((bnk) var1, var2, var3, this.l.a - 1, this.l.b, this.l.c, ej.e, this.d());
					break;
				case 2:
					bmy.b((bnk) var1, var2, var3, this.l.a - 1, this.l.b, this.l.f - 2, ej.e, this.d());
					break;
				case 3:
					bmy.b((bnk) var1, var2, var3, this.l.a, this.l.b, this.l.c - 1, ej.c, this.d());
					break;
				case 4:
					bmy.b((bnk) var1, var2, var3, this.l.d - 2, this.l.b, this.l.c - 1, ej.c, this.d());
			}
		}

		if (var4 && var3.nextInt(3) > 0 && this.m != null) {
			switch (bmz.a[this.m.ordinal()]) {
				case 1:
					bmy.b((bnk) var1, var2, var3, this.l.d + 1, this.l.b, this.l.c, ej.f, this.d());
					break;
				case 2:
					bmy.b((bnk) var1, var2, var3, this.l.d + 1, this.l.b, this.l.f - 2, ej.f, this.d());
					break;
				case 3:
					bmy.b((bnk) var1, var2, var3, this.l.a, this.l.b, this.l.f + 1, ej.d, this.d());
					break;
				case 4:
					bmy.b((bnk) var1, var2, var3, this.l.d - 2, this.l.b, this.l.f + 1, ej.d, this.d());
			}
		}

	}

	public static bjb a(bnk var0, List var1, Random var2, int var3, int var4, int var5, ej var6) {
		for (int var7 = 7 * NumberConverter.a(var2, 3, 5); var7 >= 7; var7 -= 7) {
			bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 3, 3, var7, var6);
			if (bms.a(var1, var8) == null) {
				return var8;
			}
		}

		return null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		bec var4 = this.a(aty.n.P());
		bec var5 = this.a(aty.e.P());

		for (int var6 = this.l.a; var6 <= this.l.d; ++var6) {
			for (int var7 = this.l.c; var7 <= this.l.f; ++var7) {
				dt var8 = new dt(var6, 64, var7);
				if (var3.b((fd) var8)) {
					var8 = var1.r(var8).b();
					var1.a(var8, var4, 2);
					var1.a(var8.b(), var5, 2);
				}
			}
		}

		return true;
	}
}
