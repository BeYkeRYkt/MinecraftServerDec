package net.minecraft;

public class ItemGoldenApple extends ItemFood {

	public ItemGoldenApple(int var1, float var2, boolean var3) {
		super(var1, var2, var3);
		this.a(true);
	}

	public amx g(ItemStack var1) {
		return var1.getDurability() == 0 ? amx.c : amx.d;
	}

	protected void c(ItemStack var1, World var2, EntityHuman var3) {
		if (!var2.D) {
			var3.c(new MobEffect(MobEffectList.x.H, 2400, 0));
		}

		if (var1.getDurability() > 0) {
			if (!var2.D) {
				var3.c(new MobEffect(MobEffectList.l.H, 600, 4));
				var3.c(new MobEffect(MobEffectList.m.H, 6000, 0));
				var3.c(new MobEffect(MobEffectList.n.H, 6000, 0));
			}
		} else {
			super.c(var1, var2, var3);
		}

	}
}
