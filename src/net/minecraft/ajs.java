package net.minecraft;

public class ajs extends aju {

	public ajs() {
		super(aty.cK);
		this.h = 16;
		this.a(akf.c);
		this.a(true);
		this.d(0);
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		if (var5 == ej.a) {
			return false;
		} else if (!var3.p(var4).c().r().a()) {
			return false;
		} else {
			var4 = var4.a(var5);
			if (!var2.a(var4, var5, var1)) {
				return false;
			} else if (!aty.cK.c(var3, var4)) {
				return false;
			} else if (var3.D) {
				return true;
			} else {
				if (var5 == ej.b) {
					int var9 = NumberConverter.c((double) ((var2.y + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
					var3.a(var4, aty.cK.P().a(baw.a, Integer.valueOf(var9)), 3);
				} else {
					var3.a(var4, aty.cL.P().a(bbz.a, var5), 3);
				}

				--var1.b;
				bcm var10 = var3.s(var4);
				if (var10 instanceof bci) {
					((bci) var10).a(var1);
				}

				return true;
			}
		}
	}

	public String a(amj var1) {
		String var2 = "item.banner.";
		akv var3 = this.h(var1);
		var2 = var2 + var3.d() + ".name";
		return fi.a(var2);
	}

	private akv h(amj var1) {
		NBTCompoundTag var2 = var1.a("BlockEntityTag", false);
		akv var3 = null;
		if (var2 != null && var2.c("Base")) {
			var3 = akv.a(var2.f("Base"));
		} else {
			var3 = akv.a(var1.i());
		}

		return var3;
	}
}
