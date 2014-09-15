package net.minecraft;

import java.util.Random;

public class asr extends asl {

	public asr(int var1, BiomeBase var2) {
		super(var1, var2);
		this.as.A = 2;
		this.as.B = 2;
		this.as.C = 5;
	}

	public void a(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
		this.ak = Blocks.GRASS.getBlockState();
		this.al = Blocks.DIRT.getBlockState();
		if (var6 > 1.75D) {
			this.ak = Blocks.STONE.getBlockState();
			this.al = Blocks.STONE.getBlockState();
		} else if (var6 > -0.5D) {
			this.ak = Blocks.DIRT.getBlockState().a(BlockDirt.a, avd.b);
		}

		this.b(var1, var2, var3, var4, var5, var6);
	}

	public void a(World var1, Random var2, Position var3) {
		this.as.a(var1, var2, this, var3);
	}
}
