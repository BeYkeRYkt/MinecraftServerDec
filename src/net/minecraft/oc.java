package net.minecraft;

public abstract class oc extends eg {

	public ItemStack b(dz var1, ItemStack var2) {
		World var3 = var1.i();
		ex var4 = BlockDispenser.a(var1);
		PaintingDirection var5 = BlockDispenser.b(var1.f());
		aho var6 = this.a(var3, var4);
		var6.c((double) var5.g(), (double) ((float) var5.h() + 0.1F), (double) var5.i(), this.b(), this.a());
		var3.d((Entity) var6);
		var2.a(1);
		return var2;
	}

	protected void a(dz var1) {
		var1.i().b(1002, var1.d(), 0);
	}

	protected abstract aho a(World var1, ex var2);

	protected float a() {
		return 6.0F;
	}

	protected float b() {
		return 1.1F;
	}
}
