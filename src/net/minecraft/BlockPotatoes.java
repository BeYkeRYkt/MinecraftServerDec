package net.minecraft;

public class BlockPotatoes extends BlockCrops {

	protected Item j() {
		return Items.POTATO;
	}

	protected Item l() {
		return Items.POTATO;
	}

	public void dropNaturally(World var1, Position var2, IBlockState var3, float var4, int var5) {
		super.dropNaturally(var1, var2, var3, var4, var5);
		if (!var1.isStatic) {
			if (((Integer) var3.b(a)).intValue() >= 7 && var1.random.nextInt(50) == 0) {
				dropItem(var1, var2, new ItemStack(Items.POISONOUS_POTATO));
			}

		}
	}
}
