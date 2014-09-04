package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

public class ayn extends atg {

	private static final List a = Lists.newArrayList((Object[]) (new String[] { "harp", "bd", "snare", "hat", "bassattack" }));

	public ayn() {
		super(bof.d);
		this.a(akf.d);
	}

	public void a(World var1, dt var2, bec var3, atr var4) {
		boolean var5 = var1.z(var2);
		bcm var6 = var1.s(var2);
		if (var6 instanceof bdi) {
			bdi var7 = (bdi) var6;
			if (var7.f != var5) {
				if (var5) {
					var7.a(var1, var2);
				}

				var7.f = var5;
			}
		}

	}

	public boolean a(World var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			bcm var9 = var1.s(var2);
			if (var9 instanceof bdi) {
				bdi var10 = (bdi) var9;
				var10.b();
				var10.a(var1, var2);
			}

			return true;
		}
	}

	public void a(World var1, dt var2, ahd var3) {
		if (!var1.D) {
			bcm var4 = var1.s(var2);
			if (var4 instanceof bdi) {
				((bdi) var4).a(var1, var2);
			}

		}
	}

	public bcm a(World var1, int var2) {
		return new bdi();
	}

	private String b(int var1) {
		if (var1 < 0 || var1 >= a.size()) {
			var1 = 0;
		}

		return (String) a.get(var1);
	}

	public boolean a(World var1, dt var2, bec var3, int var4, int var5) {
		float var6 = (float) Math.pow(2.0D, (double) (var5 - 12) / 12.0D);
		var1.a((double) var2.n() + 0.5D, (double) var2.o() + 0.5D, (double) var2.p() + 0.5D, "note." + this.b(var4), 3.0F, var6);
		var1.a(ew.x, (double) var2.n() + 0.5D, (double) var2.o() + 1.2D, (double) var2.p() + 0.5D, (double) var5 / 24.0D, 0.0D, 0.0D, new int[0]);
		return true;
	}

	public int b() {
		return 3;
	}

}
