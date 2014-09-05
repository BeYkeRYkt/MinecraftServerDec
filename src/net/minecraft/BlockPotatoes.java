package net.minecraft;

public class BlockPotatoes extends BlockCrops {

	protected Item j() {
		return amk.bS;
	}

	protected Item l() {
		return amk.bS;
	}

	public void a(World var1, Position var2, bec var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		if (!var1.D) {
			if (((Integer) var3.b(a)).intValue() >= 7 && var1.s.nextInt(50) == 0) {
				a(var1, var2, new ItemStack(amk.bU));
			}

		}
	}
}
