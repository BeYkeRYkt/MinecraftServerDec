package net.minecraft;

final class DispenseBehaviorCommandBlock extends DispenseBehaviorItem {

	protected ItemStack b(ISourceBlock var1, ItemStack var2) {
		World var3 = var1.getWorld();
		Position var4 = var1.getPosition().getRelative(BlockDispenser.b(var1.getData()));
		if (var3.d(var4)) {
			if (!var3.isStatic) {
				IBlockState var5 = Blocks.COMMAND_BLOCK.getBlockState().a(BlockCommand.a, Boolean.valueOf(false));
				var3.setBlockAt(var4, var5, 3);
				ItemBlock.a(var3, var4, var2);
				var3.c(var1.getPosition(), var1.getBlock());
			}

			--var2.amount;
		}

		return var2;
	}

	protected void a(ISourceBlock var1) {
	}

	protected void a(ISourceBlock var1, BlockFace var2) {
	}
}
