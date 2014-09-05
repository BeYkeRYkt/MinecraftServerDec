package net.minecraft;

import java.util.Random;

class aev extends zb {

	private aer a;

	public aev(aer var1) {
		this.a = var1;
	}

	public boolean a() {
		return !this.a.o.Q().b("mobGriefing") ? false : (this.a.ck().c().r() != Material.AIR ? false : this.a.bb().nextInt(20) == 0);
	}

	public void e() {
		Random var1 = this.a.bb();
		World var2 = this.a.o;
		int var3 = DataTypesConverter.toFixedPointInt(this.a.locationX - 2.0D + var1.nextDouble() * 4.0D);
		int var4 = DataTypesConverter.toFixedPointInt(this.a.locationY + var1.nextDouble() * 3.0D);
		int var5 = DataTypesConverter.toFixedPointInt(this.a.locationZ - 2.0D + var1.nextDouble() * 4.0D);
		Position var6 = new Position(var3, var4, var5);
		bec var7 = var2.p(var6);
		Block var8 = var7.c();
		if (aer.co().contains(var8)) {
			this.a.a(var7);
			var2.a(var6, aty.a.P());
		}

	}
}
