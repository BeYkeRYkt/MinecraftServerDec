package net.minecraft;

public class wl extends MobEffectList {

	protected wl(int var1, RegistryObjectName var2, boolean var3, int var4) {
		super(var1, var2, var3, var4);
	}

	public void a(EntityLiving var1, yc var2, int var3) {
		var1.l(var1.bM() - (float) (4 * (var3 + 1)));
		super.a(var1, var2, var3);
	}

	public void b(EntityLiving var1, yc var2, int var3) {
		var1.l(var1.bM() + (float) (4 * (var3 + 1)));
		super.b(var1, var2, var3);
	}
}
