package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

class qr {

	private final List b;
	private final aqm c;
	private short[] d;
	private int e;
	private int f;
	private long g;
	// $FF: synthetic field
	final qq a;

	public qr(qq var1, int var2, int var3) {
		this.a = var1;
		this.b = Lists.newArrayList();
		this.d = new short[64];
		this.c = new aqm(var2, var3);
		var1.a().b.c(var2, var3);
	}

	public void a(EntityPlayer var1) {
		if (this.b.contains(var1)) {
			qq.c().debug("Failed to add player. {} already is in chunk {}, {}", new Object[] { var1, Integer.valueOf(this.c.a), Integer.valueOf(this.c.b) });
		} else {
			if (this.b.isEmpty()) {
				this.g = qq.a(this.a).K();
			}

			this.b.add(var1);
			var1.f.add(this.c);
		}
	}

	public void b(EntityPlayer var1) {
		if (this.b.contains(var1)) {
			bfh var2 = qq.a(this.a).a(this.c.a, this.c.b);
			if (var2.i()) {
				var1.a.a((Packet) (new jq(var2, true, 0)));
			}

			this.b.remove(var1);
			var1.f.remove(this.c);
			if (this.b.isEmpty()) {
				long var3 = (long) this.c.a + 2147483647L | (long) this.c.b + 2147483647L << 32;
				this.a(var2);
				qq.b(this.a).d(var3);
				qq.c(this.a).remove(this);
				if (this.e > 0) {
					qq.d(this.a).remove(this);
				}

				this.a.a().b.b(this.c.a, this.c.b);
			}

		}
	}

	public void a() {
		this.a(qq.a(this.a).a(this.c.a, this.c.b));
	}

	private void a(bfh var1) {
		var1.c(var1.w() + qq.a(this.a).K() - this.g);
		this.g = qq.a(this.a).K();
	}

	public void a(int var1, int var2, int var3) {
		if (this.e == 0) {
			qq.d(this.a).add(this);
		}

		this.f |= 1 << (var2 >> 4);
		if (this.e < 64) {
			short var4 = (short) (var1 << 12 | var3 << 8 | var2);

			for (int var5 = 0; var5 < this.e; ++var5) {
				if (this.d[var5] == var4) {
					return;
				}
			}

			this.d[this.e++] = var4;
		}

	}

	public void a(Packet var1) {
		for (int var2 = 0; var2 < this.b.size(); ++var2) {
			EntityPlayer var3 = (EntityPlayer) this.b.get(var2);
			if (!var3.f.contains(this.c)) {
				var3.a.a(var1);
			}
		}

	}

	public void b() {
		if (this.e != 0) {
			int var1;
			int var2;
			int var3;
			if (this.e == 1) {
				var1 = (this.d[0] >> 12 & 15) + this.c.a * 16;
				var2 = this.d[0] & 255;
				var3 = (this.d[0] >> 8 & 15) + this.c.b * 16;
				Position var4 = new Position(var1, var2, var3);
				this.a((Packet) (new iw(qq.a(this.a), var4)));
				if (qq.a(this.a).p(var4).c().x()) {
					this.a(qq.a(this.a).s(var4));
				}
			} else {
				int var7;
				if (this.e == 64) {
					var1 = this.c.a * 16;
					var2 = this.c.b * 16;
					this.a((Packet) (new jq(qq.a(this.a).a(this.c.a, this.c.b), false, this.f)));

					for (var3 = 0; var3 < 16; ++var3) {
						if ((this.f & 1 << var3) != 0) {
							var7 = var3 << 4;
							List var5 = qq.a(this.a).a(var1, var7, var2, var1 + 16, var7 + 16, var2 + 16);

							for (int var6 = 0; var6 < var5.size(); ++var6) {
								this.a((bcm) var5.get(var6));
							}
						}
					}
				} else {
					this.a((Packet) (new ja(this.e, this.d, qq.a(this.a).a(this.c.a, this.c.b))));

					for (var1 = 0; var1 < this.e; ++var1) {
						var2 = (this.d[var1] >> 12 & 15) + this.c.a * 16;
						var3 = this.d[var1] & 255;
						var7 = (this.d[var1] >> 8 & 15) + this.c.b * 16;
						Position var8 = new Position(var2, var3, var7);
						if (qq.a(this.a).p(var8).c().x()) {
							this.a(qq.a(this.a).s(var8));
						}
					}
				}
			}

			this.e = 0;
			this.f = 0;
		}
	}

	private void a(bcm var1) {
		if (var1 != null) {
			Packet var2 = var1.x_();
			if (var2 != null) {
				this.a(var2);
			}
		}

	}

	// $FF: synthetic method
	static aqm a(qr var0) {
		return var0.c;
	}

	// $FF: synthetic method
	static List b(qr var0) {
		return var0.b;
	}
}
