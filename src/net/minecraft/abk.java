package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class abk {

	private World a;
	private boolean b;
	private int c = -1;
	private int d;
	private int e;
	private abi f;
	private int g;
	private int h;
	private int i;

	public abk(World var1) {
		this.a = var1;
	}

	public void a() {
		if (this.a.w()) {
			this.c = 0;
		} else if (this.c != 2) {
			if (this.c == 0) {
				float var1 = this.a.c(0.0F);
				if ((double) var1 < 0.5D || (double) var1 > 0.501D) {
					return;
				}

				this.c = this.a.s.nextInt(10) == 0 ? 1 : 2;
				this.b = false;
				if (this.c == 2) {
					return;
				}
			}

			if (this.c != -1) {
				if (!this.b) {
					if (!this.b()) {
						return;
					}

					this.b = true;
				}

				if (this.e > 0) {
					--this.e;
				} else {
					this.e = 2;
					if (this.d > 0) {
						this.c();
						--this.d;
					} else {
						this.c = 2;
					}

				}
			}
		}
	}

	private boolean b() {
		List var1 = this.a.j;
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			ahd var3 = (ahd) var2.next();
			if (!var3.v()) {
				this.f = this.a.ae().a(new dt(var3), 1);
				if (this.f != null && this.f.c() >= 10 && this.f.d() >= 20 && this.f.e() >= 20) {
					dt var4 = this.f.a();
					float var5 = (float) this.f.b();
					boolean var6 = false;
					int var7 = 0;

					while (true) {
						if (var7 < 10) {
							float var8 = this.a.s.nextFloat() * 3.1415927F * 2.0F;
							this.g = var4.n() + (int) ((double) (uv.b(var8) * var5) * 0.9D);
							this.h = var4.o();
							this.i = var4.p() + (int) ((double) (uv.a(var8) * var5) * 0.9D);
							var6 = false;
							Iterator var9 = this.a.ae().b().iterator();

							while (var9.hasNext()) {
								abi var10 = (abi) var9.next();
								if (var10 != this.f && var10.a(new dt(this.g, this.h, this.i))) {
									var6 = true;
									break;
								}
							}

							if (var6) {
								++var7;
								continue;
							}
						}

						if (var6) {
							return false;
						}

						brw var11 = this.a(new dt(this.g, this.h, this.i));
						if (var11 != null) {
							this.e = 0;
							this.d = 20;
							return true;
						}
						break;
					}
				}
			}
		}

		return false;
	}

	private boolean c() {
		brw var1 = this.a(new dt(this.g, this.h, this.i));
		if (var1 == null) {
			return false;
		} else {
			agj var2;
			try {
				var2 = new agj(this.a);
				var2.a(this.a.E(new dt(var2)), (xq) null);
				var2.m(false);
			} catch (Exception var4) {
				var4.printStackTrace();
				return false;
			}

			var2.b(var1.a, var1.b, var1.c, this.a.s.nextFloat() * 360.0F, 0.0F);
			this.a.d((Entity) var2);
			dt var3 = this.f.a();
			var2.a(var3, this.f.b());
			return true;
		}
	}

	private brw a(dt var1) {
		for (int var2 = 0; var2 < 10; ++var2) {
			dt var3 = var1.a(this.a.s.nextInt(16) - 8, this.a.s.nextInt(6) - 3, this.a.s.nextInt(16) - 8);
			if (this.f.a(var3) && arg.a(xo.a, this.a, var3)) {
				return new brw((double) var3.n(), (double) var3.o(), (double) var3.p());
			}
		}

		return null;
	}
}
