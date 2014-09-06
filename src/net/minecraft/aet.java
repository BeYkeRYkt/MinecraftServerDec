package net.minecraft;

import java.util.Random;

class aet extends zb {

	private EntityEnderman a;

	public aet(EntityEnderman var1) {
		this.a = var1;
	}

	public boolean a() {
		return !this.a.o.Q().b("mobGriefing") ? false : (this.a.ck().getBlock().r() == Material.AIR ? false : this.a.bb().nextInt(2000) == 0);
	}

	public void e() {
		Random var1 = this.a.bb();
		World var2 = this.a.o;
		int var3 = DataTypesConverter.toFixedPointInt(this.a.locationX - 1.0D + var1.nextDouble() * 2.0D);
		int var4 = DataTypesConverter.toFixedPointInt(this.a.locationY + var1.nextDouble() * 2.0D);
		int var5 = DataTypesConverter.toFixedPointInt(this.a.locationZ - 1.0D + var1.nextDouble() * 2.0D);
		Position var6 = new Position(var3, var4, var5);
		Block var7 = var2.p(var6).getBlock();
		Block var8 = var2.p(var6.b()).getBlock();
		if (this.a(var2, var6, this.a.ck().getBlock(), var7, var8)) {
			var2.a(var6, this.a.ck(), 3);
			this.a.a(aty.a.P());
		}

	}

	private boolean a(World var1, Position var2, Block var3, Block var4, Block var5) {
		return !var3.c(var1, var2) ? false : (var4.r() != Material.AIR ? false : (var5.r() == Material.AIR ? false : var5.d()));
	}
}
