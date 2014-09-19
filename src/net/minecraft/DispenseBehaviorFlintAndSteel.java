package net.minecraft;

final class DispenseBehaviorFlintAndSteel extends DispenseBehaviorItem {

	private boolean b = true;

	protected ItemStack b(ISourceBlock var1, ItemStack var2) {
		World var3 = var1.i();
		Position var4 = var1.d().getRelative(BlockDispenser.b(var1.f()));
		if (var3.d(var4)) {
			var3.a(var4, Blocks.FIRE.getBlockState());
			if (var2.a(1, var3.random)) {
				var2.amount = 0;
			}
		} else if (var3.getBlockState(var4).getBlock() == Blocks.TNT) {
			Blocks.TNT.d(var3, var4, Blocks.TNT.getBlockState().a(BlockTNT.a, Boolean.valueOf(true)));
			var3.g(var4);
		} else {
			this.b = false;
		}

		return var2;
	}

	protected void a(ISourceBlock var1) {
		if (this.b) {
			var1.i().triggerEffect(1000, var1.d(), 0);
		} else {
			var1.i().triggerEffect(1001, var1.d(), 0);
		}

	}
}
