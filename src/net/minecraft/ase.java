package net.minecraft;

import java.util.Random;

class ase extends asl {

	// $FF: synthetic field
	final BiomeForest aD;

	ase(BiomeForest var1, int var2, BiomeBase var3) {
		super(var2, var3);
		this.aD = var1;
	}

	public WorldGenTreeAbstract a(Random var1) {
		return var1.nextBoolean() ? BiomeForest.aD : BiomeForest.aE;
	}
}
