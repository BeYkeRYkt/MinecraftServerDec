package net.minecraft;

import java.util.Random;

public class BlockDeadBush extends auc {

	protected BlockDeadBush() {
		super(Material.REPLACEABLE_PLANT);
		float var1 = 0.4F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
	}

	protected boolean c(Block var1) {
		return var1 == aty.m || var1 == aty.cz || var1 == aty.cu || var1 == aty.d;
	}

	public boolean f(World var1, Position var2) {
		return true;
	}

	public Item a(bec var1, Random var2, int var3) {
		return null;
	}

	public void a(World var1, EntityHuman var2, Position var3, bec var4, bcm var5) {
		if (!var1.D && var2.bY() != null && var2.bY().getItem() == amk.be) {
			var2.b(ty.H[Block.a((Block) this)]);
			a(var1, var3, new ItemStack(aty.I, 1, 0));
		} else {
			super.a(var1, var2, var3, var4, var5);
		}

	}
}
