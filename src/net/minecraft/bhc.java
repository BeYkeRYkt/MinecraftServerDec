package net.minecraft;

import java.util.Random;

public abstract class bhc extends bhp {

	public bhc(boolean var1) {
		super(var1);
	}

	protected boolean a(Block var1) {
		return var1.r() == Material.AIR || var1.r() == Material.LEAVES || var1 == Blocks.GRASS || var1 == Blocks.DIRT || var1 == Blocks.LOG || var1 == Blocks.LOG2 || var1 == Blocks.SAPLING || var1 == Blocks.VINE;
	}

	public void a(World var1, Random var2, Position var3) {
	}

	protected void a(World var1, Position var2) {
		if (var1.p(var2).getBlock() != Blocks.DIRT) {
			this.a(var1, var2, Blocks.DIRT.P());
		}

	}
}
