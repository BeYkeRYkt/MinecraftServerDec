package net.minecraft;

final class om extends eg {

	protected ItemStack b(dz var1, ItemStack var2) {
		World var3 = var1.i();
		Position var4 = var1.d().a(BlockDispenser.b(var1.f()));
		if (var3.d(var4)) {
			if (!var3.D) {
				bec var5 = Blocks.COMMAND_BLOCK.P().a(BlockCommand.a, Boolean.valueOf(false));
				var3.a(var4, var5, 3);
				aju.a(var3, var4, var2);
				var3.c(var1.d(), var1.e());
			}

			--var2.b;
		}

		return var2;
	}

	protected void a(dz var1) {
	}

	protected void a(dz var1, PaintingDirection var2) {
	}
}
