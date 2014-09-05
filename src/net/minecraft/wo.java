package net.minecraft;

public class wo extends MobEffectList {

	public wo(int var1, BlockNameInfo var2, boolean var3, int var4) {
		super(var1, var2, var3, var4);
	}

	public boolean b() {
		return true;
	}

	public boolean shouldTick(int var1, int var2) {
		return var1 >= 1;
	}
}
