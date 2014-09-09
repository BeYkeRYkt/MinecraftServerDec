package net.minecraft;

public class bpw {

	private bps a = new bps();
	private bpt[] b = new bpt[32];
	private bpu c;

	public bpw(bpu var1) {
		this.c = var1;
	}

	public bpv a(ard var1, Entity var2, Entity var3, float var4) {
		return this.a(var1, var2, var3.locationX, var3.getBoundingBox().minY, var3.locationZ, var4);
	}

	public bpv a(ard var1, Entity var2, Position var3, float var4) {
		return this.a(var1, var2, (double) ((float) var3.getX() + 0.5F), (double) ((float) var3.getY() + 0.5F), (double) ((float) var3.getZ() + 0.5F), var4);
	}

	private bpv a(ard var1, Entity var2, double var3, double var5, double var7, float var9) {
		this.a.a();
		this.c.a(var1, var2);
		bpt var10 = this.c.a(var2);
		bpt var11 = this.c.a(var2, var3, var5, var7);
		bpv var12 = this.a(var2, var10, var11, var9);
		this.c.a();
		return var12;
	}

	private bpv a(Entity var1, bpt var2, bpt var3, float var4) {
		var2.e = 0.0F;
		var2.f = var2.b(var3);
		var2.g = var2.f;
		this.a.a();
		this.a.a(var2);
		bpt var5 = var2;

		while (!this.a.e()) {
			bpt var6 = this.a.c();
			if (var6.equals(var3)) {
				return this.a(var2, var3);
			}

			if (var6.b(var3) < var5.b(var3)) {
				var5 = var6;
			}

			var6.i = true;
			int var7 = this.c.a(this.b, var1, var6, var3, var4);

			for (int var8 = 0; var8 < var7; ++var8) {
				bpt var9 = this.b[var8];
				float var10 = var6.e + var6.b(var9);
				if (var10 < var4 * 2.0F && (!var9.a() || var10 < var9.e)) {
					var9.h = var6;
					var9.e = var10;
					var9.f = var9.b(var3);
					if (var9.a()) {
						this.a.a(var9, var9.e + var9.f);
					} else {
						var9.g = var9.e + var9.f;
						this.a.a(var9);
					}
				}
			}
		}

		if (var5 == var2) {
			return null;
		} else {
			return this.a(var2, var5);
		}
	}

	private bpv a(bpt var1, bpt var2) {
		int var3 = 1;

		bpt var4;
		for (var4 = var2; var4.h != null; var4 = var4.h) {
			++var3;
		}

		bpt[] var5 = new bpt[var3];
		var4 = var2;
		--var3;

		for (var5[var3] = var2; var4.h != null; var5[var3] = var4) {
			var4 = var4.h;
			--var3;
		}

		return new bpv(var5);
	}
}
