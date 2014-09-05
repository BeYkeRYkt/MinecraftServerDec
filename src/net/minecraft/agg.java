package net.minecraft;

import java.util.Random;

public class agg implements xq {

	public int a;

	public void a(Random var1) {
		int var2 = var1.nextInt(5);
		if (var2 <= 1) {
			this.a = MobEffectList.c.H;
		} else if (var2 <= 2) {
			this.a = MobEffectList.g.H;
		} else if (var2 <= 3) {
			this.a = MobEffectList.l.H;
		} else if (var2 <= 4) {
			this.a = MobEffectList.p.H;
		}

	}
}
