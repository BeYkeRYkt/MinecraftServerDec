package net.minecraft;

import java.util.Random;

public class asu extends arm {

	private static final big aD = new big();
	private static final bio aE = new bio(false);
	private static final bib aF = new bib(false, false);
	private static final bib aG = new bib(false, true);
	private static final bhg aH = new bhg(aty.Y, 0);
	private int aI;

	public asu(int var1, int var2) {
		super(var1);
		this.aI = var2;
		this.au.add(new arq(acu.class, 8, 4, 4));
		this.as.A = 10;
		if (var2 != 1 && var2 != 2) {
			this.as.C = 1;
			this.as.E = 1;
		} else {
			this.as.C = 7;
			this.as.D = 1;
			this.as.E = 3;
		}

	}

	public bhc a(Random var1) {
		return (bhc) ((this.aI == 1 || this.aI == 2) && var1.nextInt(3) == 0 ? (this.aI != 2 && var1.nextInt(13) != 0 ? aF : aG) : (var1.nextInt(3) == 0 ? aD : aE));
	}

	public bhp b(Random var1) {
		return var1.nextInt(5) > 0 ? new biq(bbi.c) : new biq(bbi.b);
	}

	public void a(World var1, Random var2, Position var3) {
		int var4;
		int var5;
		int var6;
		int var7;
		if (this.aI == 1 || this.aI == 2) {
			var4 = var2.nextInt(3);

			for (var5 = 0; var5 < var4; ++var5) {
				var6 = var2.nextInt(16) + 8;
				var7 = var2.nextInt(16) + 8;
				Position var8 = var1.m(var3.a(var6, 0, var7));
				aH.b(var1, var2, var8);
			}
		}

		ag.a(avk.d);

		for (var4 = 0; var4 < 7; ++var4) {
			var5 = var2.nextInt(16) + 8;
			var6 = var2.nextInt(16) + 8;
			var7 = var2.nextInt(var1.m(var3.a(var5, 0, var6)).o() + 32);
			ag.b(var1, var2, var3.a(var5, var7, var6));
		}

		super.a(var1, var2, var3);
	}

	public void a(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
		if (this.aI == 1 || this.aI == 2) {
			this.ak = aty.c.P();
			this.al = aty.d.P();
			if (var6 > 1.75D) {
				this.ak = aty.d.P().a(BlockDirt.a, avd.b);
			} else if (var6 > -0.95D) {
				this.ak = aty.d.P().a(BlockDirt.a, avd.c);
			}
		}

		this.b(var1, var2, var3, var4, var5, var6);
	}

	protected arm d(int var1) {
		return this.az == arm.V.az ? (new asu(var1, 2)).a(5858897, true).a("Mega Spruce Taiga").a(5159473).a(0.25F, 0.8F).a(new aro(this.an, this.ao)) : super.d(var1);
	}

}
