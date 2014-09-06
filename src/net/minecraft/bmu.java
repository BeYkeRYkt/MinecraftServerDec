package net.minecraft;

import java.util.Random;

public abstract class bmu {

	protected bec a;

	protected bmu() {
		this.a = Blocks.AIR.P();
	}

	public abstract void a(Random var1, int var2, int var3, int var4, boolean var5);

	public bec a() {
		return this.a;
	}
}
