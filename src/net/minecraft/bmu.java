package net.minecraft;

import java.util.Random;

public abstract class bmu {

	protected BlockState a;

	protected bmu() {
		this.a = Blocks.AIR.getBlockState();
	}

	public abstract void a(Random var1, int var2, int var3, int var4, boolean var5);

	public BlockState a() {
		return this.a;
	}
}
