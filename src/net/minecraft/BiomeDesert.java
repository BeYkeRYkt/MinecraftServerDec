package net.minecraft;

import java.util.Random;

public class BiomeDesert extends BiomeBase {

	public BiomeDesert(int var1) {
		super(var1);
		this.au.clear();
		this.ak = Blocks.SAND.getBlockState();
		this.al = Blocks.SAND.getBlockState();
		this.as.A = -999;
		this.as.D = 2;
		this.as.F = 50;
		this.as.G = 10;
		this.au.clear();
	}

	public void a(World var1, Random var2, Position var3) {
		super.a(var1, var2, var3);
		if (var2.nextInt(1000) == 0) {
			int var4 = var2.nextInt(16) + 8;
			int var5 = var2.nextInt(16) + 8;
			Position var6 = var1.m(var3.a(var4, 0, var5)).a();
			(new bhn()).b(var1, var2, var6);
		}

	}
}
