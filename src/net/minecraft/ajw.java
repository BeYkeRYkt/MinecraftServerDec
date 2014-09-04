package net.minecraft;

import java.util.List;

public class ajw extends alq {

	public ajw() {
		this.h = 1;
		this.a(akf.e);
	}

	public amj a(amj var1, World var2, ahd var3) {
		float var4 = 1.0F;
		float var5 = var3.B + (var3.z - var3.B) * var4;
		float var6 = var3.A + (var3.y - var3.A) * var4;
		double var7 = var3.p + (var3.s - var3.p) * (double) var4;
		double var9 = var3.q + (var3.t - var3.q) * (double) var4 + (double) var3.aR();
		double var11 = var3.r + (var3.u - var3.r) * (double) var4;
		brw var13 = new brw(var7, var9, var11);
		float var14 = uv.b(-var6 * 0.017453292F - 3.1415927F);
		float var15 = uv.a(-var6 * 0.017453292F - 3.1415927F);
		float var16 = -uv.b(-var5 * 0.017453292F);
		float var17 = uv.a(-var5 * 0.017453292F);
		float var18 = var15 * var16;
		float var20 = var14 * var16;
		double var21 = 5.0D;
		brw var23 = var13.b((double) var18 * var21, (double) var17 * var21, (double) var20 * var21);
		bru var24 = var2.a(var13, var23, true);
		if (var24 == null) {
			return var1;
		} else {
			brw var25 = var3.d(var4);
			boolean var26 = false;
			float var27 = 1.0F;
			List var28 = var2.b((Entity) var3, var3.aQ().a(var25.a * var21, var25.b * var21, var25.c * var21).b((double) var27, (double) var27, (double) var27));

			for (int var29 = 0; var29 < var28.size(); ++var29) {
				Entity var30 = (Entity) var28.get(var29);
				if (var30.ad()) {
					float var31 = var30.ao();
					brt var32 = var30.aQ().b((double) var31, (double) var31, (double) var31);
					if (var32.a(var13)) {
						var26 = true;
					}
				}
			}

			if (var26) {
				return var1;
			} else {
				if (var24.a == brv.b) {
					dt var33 = var24.a();
					if (var2.p(var33).c() == aty.aH) {
						var33 = var33.b();
					}

					adu var34 = new adu(var2, (double) ((float) var33.n() + 0.5F), (double) ((float) var33.o() + 1.0F), (double) ((float) var33.p() + 0.5F));
					var34.y = (float) (((uv.c((double) (var3.y * 4.0F / 360.0F) + 0.5D) & 3) - 1) * 90);
					if (!var2.a((Entity) var34, var34.aQ().b(-0.1D, -0.1D, -0.1D)).isEmpty()) {
						return var1;
					}

					if (!var2.D) {
						var2.d((Entity) var34);
					}

					if (!var3.by.d) {
						--var1.b;
					}

					var3.b(ty.J[alq.b((alq) this)]);
				}

				return var1;
			}
		}
	}
}
