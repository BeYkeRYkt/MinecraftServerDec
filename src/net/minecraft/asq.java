package net.minecraft;

import java.util.Random;

public class asq extends arm {

	private static final bil aD = new bil(false);

	protected asq(int var1) {
		super(var1);
		this.au.add(new arq(abt.class, 1, 2, 6));
		this.as.A = 1;
		this.as.B = 4;
		this.as.C = 20;
	}

	public bhc a(Random var1) {
		return (bhc) (var1.nextInt(5) > 0 ? aD : this.aA);
	}

	protected arm d(int var1) {
		asr var2 = new asr(var1, this);
		var2.ap = (this.ap + 1.0F) * 0.5F;
		var2.an = this.an * 0.5F + 0.3F;
		var2.ao = this.ao * 0.5F + 1.2F;
		return var2;
	}

	public void a(World var1, Random var2, dt var3) {
		ag.a(avk.c);

		for (int var4 = 0; var4 < 7; ++var4) {
			int var5 = var2.nextInt(16) + 8;
			int var6 = var2.nextInt(16) + 8;
			int var7 = var2.nextInt(var1.m(var3.a(var5, 0, var6)).o() + 32);
			ag.b(var1, var2, var3.a(var5, var7, var6));
		}

		super.a(var1, var2, var3);
	}

}
