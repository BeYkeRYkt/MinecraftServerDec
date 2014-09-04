package net.minecraft;

import java.util.Random;

public class ayu extends atr {

	public ayu() {
		super(bof.e);
		this.a(akf.b);
	}

	public alq a(bec var1, Random var2, int var3) {
		return this == aty.q ? amk.h : (this == aty.ag ? amk.i : (this == aty.x ? amk.aW : (this == aty.bP ? amk.bO : (this == aty.co ? amk.cg : alq.a((atr) this)))));
	}

	public int a(Random var1) {
		return this == aty.x ? 4 + var1.nextInt(5) : 1;
	}

	public int a(int var1, Random var2) {
		if (var1 > 0 && alq.a((atr) this) != this.a((bec) this.O().a().iterator().next(), var2, var1)) {
			int var3 = var2.nextInt(var1 + 2) - 1;
			if (var3 < 0) {
				var3 = 0;
			}

			return this.a(var2) * (var3 + 1);
		} else {
			return this.a(var2);
		}
	}

	public void a(World var1, dt var2, bec var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		if (this.a(var3, var1.s, var5) != alq.a((atr) this)) {
			int var6 = 0;
			if (this == aty.q) {
				var6 = NumberConverter.a(var1.s, 0, 2);
			} else if (this == aty.ag) {
				var6 = NumberConverter.a(var1.s, 3, 7);
			} else if (this == aty.bP) {
				var6 = NumberConverter.a(var1.s, 3, 7);
			} else if (this == aty.x) {
				var6 = NumberConverter.a(var1.s, 2, 5);
			} else if (this == aty.co) {
				var6 = NumberConverter.a(var1.s, 2, 5);
			}

			this.b(var1, var2, var6);
		}

	}

	public int j(World var1, dt var2) {
		return 0;
	}

	public int a(bec var1) {
		return this == aty.x ? akv.l.b() : 0;
	}
}
