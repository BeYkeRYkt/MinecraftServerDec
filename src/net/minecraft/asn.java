package net.minecraft;

import java.util.Random;

public class asn extends arm {

	protected boolean aD;

	protected asn(int var1) {
		super(var1);
		this.a(0.8F, 0.4F);
		this.a(e);
		this.au.add(new arq(abt.class, 5, 2, 6));
		this.as.A = -999;
		this.as.B = 4;
		this.as.C = 10;
	}

	public awa a(Random var1, Position var2) {
		double var3 = af.a((double) var2.n() / 200.0D, (double) var2.p() / 200.0D);
		int var5;
		if (var3 < -0.8D) {
			var5 = var1.nextInt(4);
			switch (var5) {
				case 0:
					return awa.g;
				case 1:
					return awa.f;
				case 2:
					return awa.i;
				case 3:
				default:
					return awa.h;
			}
		} else if (var1.nextInt(3) > 0) {
			var5 = var1.nextInt(3);
			return var5 == 0 ? awa.b : (var5 == 1 ? awa.e : awa.j);
		} else {
			return awa.a;
		}
	}

	public void a(World var1, Random var2, Position var3) {
		double var4 = af.a((double) (var3.n() + 8) / 200.0D, (double) (var3.p() + 8) / 200.0D);
		int var6;
		int var7;
		int var8;
		int var9;
		if (var4 < -0.8D) {
			this.as.B = 15;
			this.as.C = 5;
		} else {
			this.as.B = 4;
			this.as.C = 10;
			ag.a(avk.c);

			for (var6 = 0; var6 < 7; ++var6) {
				var7 = var2.nextInt(16) + 8;
				var8 = var2.nextInt(16) + 8;
				var9 = var2.nextInt(var1.m(var3.a(var7, 0, var8)).o() + 32);
				ag.b(var1, var2, var3.a(var7, var9, var8));
			}
		}

		if (this.aD) {
			ag.a(avk.a);

			for (var6 = 0; var6 < 10; ++var6) {
				var7 = var2.nextInt(16) + 8;
				var8 = var2.nextInt(16) + 8;
				var9 = var2.nextInt(var1.m(var3.a(var7, 0, var8)).o() + 32);
				ag.b(var1, var2, var3.a(var7, var9, var8));
			}
		}

		super.a(var1, var2, var3);
	}

	protected arm d(int var1) {
		asn var2 = new asn(var1);
		var2.a("Sunflower Plains");
		var2.aD = true;
		var2.b(9286496);
		var2.aj = 14273354;
		return var2;
	}
}
