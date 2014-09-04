package net.minecraft;

public class amp extends alq {

	private static final eo a = new amq();
	private final adz b;

	public amp(adz var1) {
		this.h = 1;
		this.b = var1;
		this.a(akf.e);
		ave.M.a(this, a);
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		bec var9 = var3.p(var4);
		if (ati.d(var9)) {
			if (!var3.D) {
				atl var10 = var9.c() instanceof ati ? (atl) var9.b(((ati) var9.c()).l()) : atl.a;
				double var11 = 0.0D;
				if (var10.c()) {
					var11 = 0.5D;
				}

				adx var13 = adx.a(var3, (double) var4.n() + 0.5D, (double) var4.o() + 0.0625D + var11, (double) var4.p() + 0.5D, this.b);
				if (var1.s()) {
					var13.a(var1.q());
				}

				var3.d((Entity) var13);
			}

			--var1.b;
			return true;
		} else {
			return false;
		}
	}

	// $FF: synthetic method
	static adz a(amp var0) {
		return var0.b;
	}

}
