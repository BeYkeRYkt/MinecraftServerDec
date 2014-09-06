package net.minecraft;

final class DispenseBehaviorPumpkin extends eg {

	private boolean b = true;

	protected ItemStack b(dz var1, ItemStack var2) {
		World var3 = var1.i();
		Position var4 = var1.d().a(BlockDispenser.b(var1.f()));
		BlockPumpkin var5 = (BlockPumpkin) Blocks.PUMPKIN;
		if (var3.d(var4) && var5.d(var3, var4)) {
			if (!var3.D) {
				var3.a(var4, var5.P(), 3);
			}

			--var2.b;
		} else {
			this.b = false;
		}

		return var2;
	}

	protected void a(dz var1) {
		if (this.b) {
			var1.i().b(1000, var1.d(), 0);
		} else {
			var1.i().b(1001, var1.d(), 0);
		}

	}
}
