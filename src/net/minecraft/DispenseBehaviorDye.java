package net.minecraft;

final class DispenseBehaviorDye extends DispenseBehaviorItem {

	private boolean b = true;

	protected ItemStack b(ISourceBlock var1, ItemStack var2) {
		if (akv.a == akv.a(var2.getWearout())) {
			World var3 = var1.getWorld();
			Position var4 = var1.getPosition().getRelative(BlockDispenser.b(var1.getData()));
			if (ItemDye.a(var2, var3, var4)) {
				if (!var3.isStatic) {
					var3.triggerEffect(2005, var4, 0);
				}
			} else {
				this.b = false;
			}

			return var2;
		} else {
			return super.b(var1, var2);
		}
	}

	protected void a(ISourceBlock var1) {
		if (this.b) {
			var1.getWorld().triggerEffect(1000, var1.getPosition(), 0);
		} else {
			var1.getWorld().triggerEffect(1001, var1.getPosition(), 0);
		}

	}
}
