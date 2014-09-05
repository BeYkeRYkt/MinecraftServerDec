package net.minecraft;

import java.util.Random;

class afe extends zb {

	private EntityGhast a;

	public afe(EntityGhast var1) {
		this.a = var1;
		this.a(1);
	}

	public boolean a() {
		yn var1 = this.a.q();
		if (!var1.a()) {
			return true;
		} else {
			double var2 = var1.d() - this.a.locationX;
			double var4 = var1.e() - this.a.locationY;
			double var6 = var1.f() - this.a.locationZ;
			double var8 = var2 * var2 + var4 * var4 + var6 * var6;
			return var8 < 1.0D || var8 > 3600.0D;
		}
	}

	public boolean b() {
		return false;
	}

	public void c() {
		Random var1 = this.a.bb();
		double var2 = this.a.locationX + (double) ((var1.nextFloat() * 2.0F - 1.0F) * 16.0F);
		double var4 = this.a.locationY + (double) ((var1.nextFloat() * 2.0F - 1.0F) * 16.0F);
		double var6 = this.a.locationZ + (double) ((var1.nextFloat() * 2.0F - 1.0F) * 16.0F);
		this.a.q().a(var2, var4, var6, 1.0D);
	}
}
