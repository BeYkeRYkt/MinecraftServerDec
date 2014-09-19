package net.minecraft;

final class DispenseBehaviorPumpkin extends DispenseBehaviorItem {

	private boolean b = true;

	protected ItemStack b(ISourceBlock var1, ItemStack var2) {
		World var3 = var1.getWorld();
		Position var4 = var1.getPosition().getRelative(BlockDispenser.b(var1.getData()));
		BlockPumpkin var5 = (BlockPumpkin) Blocks.PUMPKIN;
		if (var3.d(var4) && var5.d(var3, var4)) {
			if (!var3.isStatic) {
				var3.setBlockAt(var4, var5.getBlockState(), 3);
			}

			--var2.amount;
		} else {
			this.b = false;
		}

		return var2;
	}

	protected void a(ISourceBlock var1) {
		if (this.b) {
			var1.getWorld().triggerEffect(1000, var1.getPosition(), 0);
		} else {
			var1.getWorld().triggerEffect(1001, var1.getPosition(), 0);
		}

	}
}
