package net.minecraft;

class aif extends Slot {

	// $FF: synthetic field
	final World a;
	// $FF: synthetic field
	final Position b;
	// $FF: synthetic field
	final ContainerAnvil c;

	aif(ContainerAnvil var1, IInventory var2, int var3, int var4, int var5, World var6, Position var7) {
		super(var2, var3, var4, var5);
		this.c = var1;
		this.a = var6;
		this.b = var7;
	}

	public boolean a(ItemStack var1) {
		return false;
	}

	public boolean a(EntityHuman var1) {
		return (var1.playerProperties.instabuild || var1.bz >= this.c.a) && this.c.a > 0 && this.hasItem();
	}

	public void a(EntityHuman var1, ItemStack var2) {
		if (!var1.playerProperties.instabuild) {
			var1.a(-this.c.a);
		}

		ContainerAnvil.a(this.c).a(0, (ItemStack) null);
		if (ContainerAnvil.b(this.c) > 0) {
			ItemStack var3 = ContainerAnvil.a(this.c).a(1);
			if (var3 != null && var3.amount > ContainerAnvil.b(this.c)) {
				var3.amount -= ContainerAnvil.b(this.c);
				ContainerAnvil.a(this.c).a(1, var3);
			} else {
				ContainerAnvil.a(this.c).a(1, (ItemStack) null);
			}
		} else {
			ContainerAnvil.a(this.c).a(1, (ItemStack) null);
		}

		this.c.a = 0;
		BlockState var5 = this.a.getBlockState(this.b);
		if (!var1.playerProperties.instabuild && !this.a.D && var5.getBlock() == Blocks.ANVIL && var1.bb().nextFloat() < 0.12F) {
			int var4 = ((Integer) var5.b(BlockAnvil.b)).intValue();
			++var4;
			if (var4 > 2) {
				this.a.g(this.b);
				this.a.b(1020, this.b, 0);
			} else {
				this.a.a(this.b, var5.a(BlockAnvil.b, Integer.valueOf(var4)), 2);
				this.a.b(1021, this.b, 0);
			}
		} else if (!this.a.D) {
			this.a.b(1021, this.b, 0);
		}

	}
}
