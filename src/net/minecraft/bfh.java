package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bfh {

	private static final Logger c = LogManager.getLogger();
	private final bfm[] d;
	private final byte[] e;
	private final int[] f;
	private final boolean[] g;
	private boolean h;
	private final World i;
	private final int[] j;
	public final int a;
	public final int b;
	private boolean k;
	private final Map l;
	private final uc[] m;
	private boolean n;
	private boolean o;
	private boolean p;
	private boolean q;
	private boolean r;
	private long s;
	private int t;
	private long u;
	private int v;
	private ConcurrentLinkedQueue w;

	public bfh(World var1, int var2, int var3) {
		this.d = new bfm[16];
		this.e = new byte[256];
		this.f = new int[256];
		this.g = new boolean[256];
		this.l = Maps.newHashMap();
		this.v = 4096;
		this.w = Queues.newConcurrentLinkedQueue();
		this.m = (uc[]) (new uc[16]);
		this.i = var1;
		this.a = var2;
		this.b = var3;
		this.j = new int[256];

		for (int var4 = 0; var4 < this.m.length; ++var4) {
			this.m[var4] = new uc(Entity.class);
		}

		Arrays.fill(this.f, -999);
		Arrays.fill(this.e, (byte) -1);
	}

	public bfh(World var1, bgk var2, int var3, int var4) {
		this(var1, var3, var4);
		short var5 = 256;
		boolean var6 = !var1.t.o();

		for (int var7 = 0; var7 < 16; ++var7) {
			for (int var8 = 0; var8 < 16; ++var8) {
				for (int var9 = 0; var9 < var5; ++var9) {
					int var10 = var7 * var5 * 16 | var8 * var5 | var9;
					bec var11 = var2.a(var10);
					if (var11.c().r() != bof.a) {
						int var12 = var9 >> 4;
						if (this.d[var12] == null) {
							this.d[var12] = new bfm(var12 << 4, var6);
						}

						this.d[var12].a(var7, var9 & 15, var8, var11);
					}
				}
			}
		}

	}

	public boolean a(int var1, int var2) {
		return var1 == this.a && var2 == this.b;
	}

	public int f(dt var1) {
		return this.b(var1.n() & 15, var1.p() & 15);
	}

	public int b(int var1, int var2) {
		return this.j[var2 << 4 | var1];
	}

	public int g() {
		for (int var1 = this.d.length - 1; var1 >= 0; --var1) {
			if (this.d[var1] != null) {
				return this.d[var1].d();
			}
		}

		return 0;
	}

	public bfm[] h() {
		return this.d;
	}

	public void b() {
		int var1 = this.g();
		this.t = Integer.MAX_VALUE;

		for (int var2 = 0; var2 < 16; ++var2) {
			int var3 = 0;

			while (var3 < 16) {
				this.f[var2 + (var3 << 4)] = -999;
				int var4 = var1 + 16;

				while (true) {
					if (var4 > 0) {
						if (this.e(var2, var4 - 1, var3) == 0) {
							--var4;
							continue;
						}

						this.j[var3 << 4 | var2] = var4;
						if (var4 < this.t) {
							this.t = var4;
						}
					}

					if (!this.i.t.o()) {
						var4 = 15;
						int var5 = var1 + 16 - 1;

						do {
							int var6 = this.e(var2, var5, var3);
							if (var6 == 0 && var4 != 15) {
								var6 = 1;
							}

							var4 -= var6;
							if (var4 > 0) {
								bfm var7 = this.d[var5 >> 4];
								if (var7 != null) {
									var7.a(var2, var5 & 15, var3, var4);
									this.i.n(new dt((this.a << 4) + var2, var5, (this.b << 4) + var3));
								}
							}

							--var5;
						} while (var5 > 0 && var4 > 0);
					}

					++var3;
					break;
				}
			}
		}

		this.q = true;
	}

	private void d(int var1, int var2) {
		this.g[var1 + var2 * 16] = true;
		this.k = true;
	}

	private void h(boolean var1) {
		this.i.B.a("recheckGaps");
		if (this.i.a(new dt(this.a * 16 + 8, 0, this.b * 16 + 8), (int) 16)) {
			for (int var2 = 0; var2 < 16; ++var2) {
				for (int var3 = 0; var3 < 16; ++var3) {
					if (this.g[var2 + var3 * 16]) {
						this.g[var2 + var3 * 16] = false;
						int var4 = this.b(var2, var3);
						int var5 = this.a * 16 + var2;
						int var6 = this.b * 16 + var3;
						int var7 = Integer.MAX_VALUE;

						Iterator var8;
						ej var9;
						for (var8 = en.a.iterator(); var8.hasNext(); var7 = Math.min(var7, this.i.b(var5 + var9.g(), var6 + var9.i()))) {
							var9 = (ej) var8.next();
						}

						this.c(var5, var6, var7);
						var8 = en.a.iterator();

						while (var8.hasNext()) {
							var9 = (ej) var8.next();
							this.c(var5 + var9.g(), var6 + var9.i(), var4);
						}

						if (var1) {
							this.i.B.b();
							return;
						}
					}
				}
			}

			this.k = false;
		}

		this.i.B.b();
	}

	private void c(int var1, int var2, int var3) {
		int var4 = this.i.m(new dt(var1, 0, var2)).o();
		if (var4 > var3) {
			this.a(var1, var2, var3, var4 + 1);
		} else if (var4 < var3) {
			this.a(var1, var2, var4, var3 + 1);
		}

	}

	private void a(int var1, int var2, int var3, int var4) {
		if (var4 > var3 && this.i.a(new dt(var1, 0, var2), (int) 16)) {
			for (int var5 = var3; var5 < var4; ++var5) {
				this.i.c(arf.a, new dt(var1, var5, var2));
			}

			this.q = true;
		}

	}

	private void d(int var1, int var2, int var3) {
		int var4 = this.j[var3 << 4 | var1] & 255;
		int var5 = var4;
		if (var2 > var4) {
			var5 = var2;
		}

		while (var5 > 0 && this.e(var1, var5 - 1, var3) == 0) {
			--var5;
		}

		if (var5 != var4) {
			this.i.a(var1 + this.a * 16, var3 + this.b * 16, var5, var4);
			this.j[var3 << 4 | var1] = var5;
			int var6 = this.a * 16 + var1;
			int var7 = this.b * 16 + var3;
			int var8;
			int var13;
			if (!this.i.t.o()) {
				bfm var9;
				if (var5 < var4) {
					for (var8 = var5; var8 < var4; ++var8) {
						var9 = this.d[var8 >> 4];
						if (var9 != null) {
							var9.a(var1, var8 & 15, var3, 15);
							this.i.n(new dt((this.a << 4) + var1, var8, (this.b << 4) + var3));
						}
					}
				} else {
					for (var8 = var4; var8 < var5; ++var8) {
						var9 = this.d[var8 >> 4];
						if (var9 != null) {
							var9.a(var1, var8 & 15, var3, 0);
							this.i.n(new dt((this.a << 4) + var1, var8, (this.b << 4) + var3));
						}
					}
				}

				var8 = 15;

				while (var5 > 0 && var8 > 0) {
					--var5;
					var13 = this.e(var1, var5, var3);
					if (var13 == 0) {
						var13 = 1;
					}

					var8 -= var13;
					if (var8 < 0) {
						var8 = 0;
					}

					bfm var10 = this.d[var5 >> 4];
					if (var10 != null) {
						var10.a(var1, var5 & 15, var3, var8);
					}
				}
			}

			var8 = this.j[var3 << 4 | var1];
			var13 = var4;
			int var14 = var8;
			if (var8 < var4) {
				var13 = var8;
				var14 = var4;
			}

			if (var8 < this.t) {
				this.t = var8;
			}

			if (!this.i.t.o()) {
				Iterator var11 = en.a.iterator();

				while (var11.hasNext()) {
					ej var12 = (ej) var11.next();
					this.a(var6 + var12.g(), var7 + var12.i(), var13, var14);
				}

				this.a(var6, var7, var13, var14);
			}

			this.q = true;
		}
	}

	public int b(dt var1) {
		return this.a(var1).n();
	}

	private int e(int var1, int var2, int var3) {
		return this.f(var1, var2, var3).n();
	}

	private atr f(int var1, int var2, int var3) {
		atr var4 = aty.a;
		if (var2 >= 0 && var2 >> 4 < this.d.length) {
			bfm var5 = this.d[var2 >> 4];
			if (var5 != null) {
				try {
					var4 = var5.b(var1, var2 & 15, var3);
				} catch (Throwable var8) {
					CrashReport var7 = CrashReport.a(var8, "Getting block");
					throw new u(var7);
				}
			}
		}

		return var4;
	}

	public atr a(int var1, int var2, int var3) {
		try {
			return this.f(var1 & 15, var2, var3 & 15);
		} catch (u var6) {
			j var5 = var6.a().a("Block being got");
			var5.a("Location", (Callable) (new bfi(this, var1, var2, var3)));
			throw var6;
		}
	}

	public atr a(dt var1) {
		try {
			return this.f(var1.n() & 15, var1.o(), var1.p() & 15);
		} catch (u var4) {
			j var3 = var4.a().a("Block being got");
			var3.a("Location", (Callable) (new bfj(this, var1)));
			throw var4;
		}
	}

	public bec g(dt var1) {
		if (this.i.G() == are.g) {
			bec var7 = null;
			if (var1.o() == 60) {
				var7 = aty.cv.P();
			}

			if (var1.o() == 70) {
				var7 = bgp.b(var1.n(), var1.p());
			}

			return var7 == null ? aty.a.P() : var7;
		} else {
			try {
				if (var1.o() >= 0 && var1.o() >> 4 < this.d.length) {
					bfm var2 = this.d[var1.o() >> 4];
					if (var2 != null) {
						int var8 = var1.n() & 15;
						int var9 = var1.o() & 15;
						int var5 = var1.p() & 15;
						return var2.a(var8, var9, var5);
					}
				}

				return aty.a.P();
			} catch (Throwable var6) {
				CrashReport var3 = CrashReport.a(var6, "Getting block state");
				j var4 = var3.a("Block being got");
				var4.a("Location", (Callable) (new bfk(this, var1)));
				throw new u(var3);
			}
		}
	}

	private int g(int var1, int var2, int var3) {
		if (var2 >> 4 >= this.d.length) {
			return 0;
		} else {
			bfm var4 = this.d[var2 >> 4];
			return var4 != null ? var4.c(var1, var2 & 15, var3) : 0;
		}
	}

	public int c(dt var1) {
		return this.g(var1.n() & 15, var1.o(), var1.p() & 15);
	}

	public bec a(dt var1, bec var2) {
		int var3 = var1.n() & 15;
		int var4 = var1.o();
		int var5 = var1.p() & 15;
		int var6 = var5 << 4 | var3;
		if (var4 >= this.f[var6] - 1) {
			this.f[var6] = -999;
		}

		int var7 = this.j[var6];
		bec var8 = this.g(var1);
		if (var8 == var2) {
			return null;
		} else {
			atr var9 = var2.c();
			atr var10 = var8.c();
			bfm var11 = this.d[var4 >> 4];
			boolean var12 = false;
			if (var11 == null) {
				if (var9 == aty.a) {
					return null;
				}

				var11 = this.d[var4 >> 4] = new bfm(var4 >> 4 << 4, !this.i.t.o());
				var12 = var4 >= var7;
			}

			var11.a(var3, var4 & 15, var5, var2);
			if (var10 != var9) {
				if (!this.i.D) {
					var10.b(this.i, var1, var8);
				} else if (var10 instanceof avs) {
					this.i.t(var1);
				}
			}

			if (var11.b(var3, var4 & 15, var5) != var9) {
				return null;
			} else {
				if (var12) {
					this.b();
				} else {
					int var13 = var9.n();
					int var14 = var10.n();
					if (var13 > 0) {
						if (var4 >= var7) {
							this.d(var3, var4 + 1, var5);
						}
					} else if (var4 == var7 - 1) {
						this.d(var3, var4, var5);
					}

					if (var13 != var14 && (var13 < var14 || this.a(arf.a, var1) > 0 || this.a(arf.b, var1) > 0)) {
						this.d(var3, var5);
					}
				}

				bcm var15;
				if (var10 instanceof avs) {
					var15 = this.a(var1, bfl.c);
					if (var15 != null) {
						var15.E();
					}
				}

				if (!this.i.D && var10 != var9) {
					var9.c(this.i, var1, var2);
				}

				if (var9 instanceof avs) {
					var15 = this.a(var1, bfl.c);
					if (var15 == null) {
						var15 = ((avs) var9).a(this.i, var9.c(var2));
						this.i.a(var1, var15);
					}

					if (var15 != null) {
						var15.E();
					}
				}

				this.q = true;
				return var8;
			}
		}
	}

	public int a(arf var1, dt var2) {
		int var3 = var2.n() & 15;
		int var4 = var2.o();
		int var5 = var2.p() & 15;
		bfm var6 = this.d[var4 >> 4];
		return var6 == null ? (this.d(var2) ? var1.c : 0) : (var1 == arf.a ? (this.i.t.o() ? 0 : var6.d(var3, var4 & 15, var5)) : (var1 == arf.b ? var6.e(var3, var4 & 15, var5) : var1.c));
	}

	public void a(arf var1, dt var2, int var3) {
		int var4 = var2.n() & 15;
		int var5 = var2.o();
		int var6 = var2.p() & 15;
		bfm var7 = this.d[var5 >> 4];
		if (var7 == null) {
			var7 = this.d[var5 >> 4] = new bfm(var5 >> 4 << 4, !this.i.t.o());
			this.b();
		}

		this.q = true;
		if (var1 == arf.a) {
			if (!this.i.t.o()) {
				var7.a(var4, var5 & 15, var6, var3);
			}
		} else if (var1 == arf.b) {
			var7.b(var4, var5 & 15, var6, var3);
		}

	}

	public int a(dt var1, int var2) {
		int var3 = var1.n() & 15;
		int var4 = var1.o();
		int var5 = var1.p() & 15;
		bfm var6 = this.d[var4 >> 4];
		if (var6 == null) {
			return !this.i.t.o() && var2 < arf.a.c ? arf.a.c - var2 : 0;
		} else {
			int var7 = this.i.t.o() ? 0 : var6.d(var3, var4 & 15, var5);
			var7 -= var2;
			int var8 = var6.e(var3, var4 & 15, var5);
			if (var8 > var7) {
				var7 = var8;
			}

			return var7;
		}
	}

	public void a(Entity var1) {
		this.r = true;
		int var2 = NumberConverter.c(var1.s / 16.0D);
		int var3 = NumberConverter.c(var1.u / 16.0D);
		if (var2 != this.a || var3 != this.b) {
			c.warn("Wrong location! (" + var2 + ", " + var3 + ") should be (" + this.a + ", " + this.b + "), " + var1, new Object[] { var1 });
			var1.J();
		}

		int var4 = NumberConverter.c(var1.t / 16.0D);
		if (var4 < 0) {
			var4 = 0;
		}

		if (var4 >= this.m.length) {
			var4 = this.m.length - 1;
		}

		var1.ad = true;
		var1.ae = this.a;
		var1.af = var4;
		var1.ag = this.b;
		this.m[var4].add(var1);
	}

	public void b(Entity var1) {
		this.a(var1, var1.af);
	}

	public void a(Entity var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		if (var2 >= this.m.length) {
			var2 = this.m.length - 1;
		}

		this.m[var2].remove(var1);
	}

	public boolean d(dt var1) {
		int var2 = var1.n() & 15;
		int var3 = var1.o();
		int var4 = var1.p() & 15;
		return var3 >= this.j[var4 << 4 | var2];
	}

	private bcm i(dt var1) {
		atr var2 = this.a(var1);
		return !var2.x() ? null : ((avs) var2).a(this.i, this.c(var1));
	}

	public bcm a(dt var1, bfl var2) {
		bcm var3 = (bcm) this.l.get(var1);
		if (var3 == null) {
			if (var2 == bfl.a) {
				var3 = this.i(var1);
				this.i.a(var1, var3);
			} else if (var2 == bfl.b) {
				this.w.add(var1);
			}
		} else if (var3.x()) {
			this.l.remove(var1);
			return null;
		}

		return var3;
	}

	public void a(bcm var1) {
		this.a(var1.v(), var1);
		if (this.h) {
			this.i.a(var1);
		}

	}

	public void a(dt var1, bcm var2) {
		var2.a(this.i);
		var2.a(var1);
		if (this.a(var1) instanceof avs) {
			if (this.l.containsKey(var1)) {
				((bcm) this.l.get(var1)).y();
			}

			var2.D();
			this.l.put(var1, var2);
		}
	}

	public void e(dt var1) {
		if (this.h) {
			bcm var2 = (bcm) this.l.remove(var1);
			if (var2 != null) {
				var2.y();
			}
		}

	}

	public void c() {
		this.h = true;
		this.i.a(this.l.values());

		for (int var1 = 0; var1 < this.m.length; ++var1) {
			Iterator var2 = this.m[var1].iterator();

			while (var2.hasNext()) {
				Entity var3 = (Entity) var2.next();
				var3.ah();
			}

			this.i.b((Collection) this.m[var1]);
		}

	}

	public void d() {
		this.h = false;
		Iterator var1 = this.l.values().iterator();

		while (var1.hasNext()) {
			bcm var2 = (bcm) var1.next();
			this.i.b(var2);
		}

		for (int var3 = 0; var3 < this.m.length; ++var3) {
			this.i.c((Collection) this.m[var3]);
		}

	}

	public void e() {
		this.q = true;
	}

	public void a(Entity var1, brt var2, List var3, Predicate var4) {
		int var5 = NumberConverter.c((var2.b - 2.0D) / 16.0D);
		int var6 = NumberConverter.c((var2.e + 2.0D) / 16.0D);
		var5 = NumberConverter.a(var5, 0, this.m.length - 1);
		var6 = NumberConverter.a(var6, 0, this.m.length - 1);

		for (int var7 = var5; var7 <= var6; ++var7) {
			Iterator var8 = this.m[var7].iterator();

			while (var8.hasNext()) {
				Entity var9 = (Entity) var8.next();
				if (var9 != var1 && var9.aQ().b(var2) && (var4 == null || var4.apply(var9))) {
					var3.add(var9);
					Entity[] var10 = var9.aC();
					if (var10 != null) {
						for (int var11 = 0; var11 < var10.length; ++var11) {
							var9 = var10[var11];
							if (var9 != var1 && var9.aQ().b(var2) && (var4 == null || var4.apply(var9))) {
								var3.add(var9);
							}
						}
					}
				}
			}
		}

	}

	public void a(Class var1, brt var2, List var3, Predicate var4) {
		int var5 = NumberConverter.c((var2.b - 2.0D) / 16.0D);
		int var6 = NumberConverter.c((var2.e + 2.0D) / 16.0D);
		var5 = NumberConverter.a(var5, 0, this.m.length - 1);
		var6 = NumberConverter.a(var6, 0, this.m.length - 1);

		for (int var7 = var5; var7 <= var6; ++var7) {
			Iterator var8 = this.m[var7].b(var1).iterator();

			while (var8.hasNext()) {
				Entity var9 = (Entity) var8.next();
				if (var9.aQ().b(var2) && (var4 == null || var4.apply(var9))) {
					var3.add(var9);
				}
			}
		}

	}

	public boolean a(boolean var1) {
		if (var1) {
			if (this.r && this.i.K() != this.s || this.q) {
				return true;
			}
		} else if (this.r && this.i.K() >= this.s + 600L) {
			return true;
		}

		return this.q;
	}

	public Random a(long var1) {
		return new Random(this.i.J() + (long) (this.a * this.a * 4987142) + (long) (this.a * 5947611) + (long) (this.b * this.b) * 4392871L + (long) (this.b * 389711) ^ var1);
	}

	public boolean f() {
		return false;
	}

	public void a(bfe var1, bfe var2, int var3, int var4) {
		boolean var5 = var1.a(var3, var4 - 1);
		boolean var6 = var1.a(var3 + 1, var4);
		boolean var7 = var1.a(var3, var4 + 1);
		boolean var8 = var1.a(var3 - 1, var4);
		boolean var9 = var1.a(var3 - 1, var4 - 1);
		boolean var10 = var1.a(var3 + 1, var4 + 1);
		boolean var11 = var1.a(var3 - 1, var4 + 1);
		boolean var12 = var1.a(var3 + 1, var4 - 1);
		if (var6 && var7 && var10) {
			if (!this.n) {
				var1.a(var2, var3, var4);
			} else {
				var1.a(var2, this, var3, var4);
			}
		}

		bfh var13;
		if (var8 && var7 && var11) {
			var13 = var1.d(var3 - 1, var4);
			if (!var13.n) {
				var1.a(var2, var3 - 1, var4);
			} else {
				var1.a(var2, var13, var3 - 1, var4);
			}
		}

		if (var5 && var6 && var12) {
			var13 = var1.d(var3, var4 - 1);
			if (!var13.n) {
				var1.a(var2, var3, var4 - 1);
			} else {
				var1.a(var2, var13, var3, var4 - 1);
			}
		}

		if (var9 && var5 && var8) {
			var13 = var1.d(var3 - 1, var4 - 1);
			if (!var13.n) {
				var1.a(var2, var3 - 1, var4 - 1);
			} else {
				var1.a(var2, var13, var3 - 1, var4 - 1);
			}
		}

	}

	public dt h(dt var1) {
		int var2 = var1.n() & 15;
		int var3 = var1.p() & 15;
		int var4 = var2 | var3 << 4;
		dt var5 = new dt(var1.n(), this.f[var4], var1.p());
		if (var5.o() == -999) {
			int var6 = this.g() + 15;
			var5 = new dt(var1.n(), var6, var1.p());
			int var7 = -1;

			while (var5.o() > 0 && var7 == -1) {
				atr var8 = this.a(var5);
				bof var9 = var8.r();
				if (!var9.c() && !var9.d()) {
					var5 = var5.b();
				} else {
					var7 = var5.o() + 1;
				}
			}

			this.f[var4] = var7;
		}

		return new dt(var1.n(), this.f[var4], var1.p());
	}

	public void b(boolean var1) {
		if (this.k && !this.i.t.o() && !var1) {
			this.h(this.i.D);
		}

		this.p = true;
		if (!this.o && this.n) {
			this.n();
		}

		while (!this.w.isEmpty()) {
			dt var2 = (dt) this.w.poll();
			if (this.a(var2, bfl.c) == null && this.a(var2).x()) {
				bcm var3 = this.i(var2);
				this.i.a(var2, var3);
				this.i.b(var2, var2);
			}
		}

	}

	public boolean i() {
		return this.p && this.n && this.o;
	}

	public aqm j() {
		return new aqm(this.a, this.b);
	}

	public boolean c(int var1, int var2) {
		if (var1 < 0) {
			var1 = 0;
		}

		if (var2 >= 256) {
			var2 = 255;
		}

		for (int var3 = var1; var3 <= var2; var3 += 16) {
			bfm var4 = this.d[var3 >> 4];
			if (var4 != null && !var4.a()) {
				return false;
			}
		}

		return true;
	}

	public void a(bfm[] var1) {
		if (this.d.length != var1.length) {
			c.warn("Could not set level chunk sections, array length is " + var1.length + " instead of " + this.d.length);
		} else {
			for (int var2 = 0; var2 < this.d.length; ++var2) {
				this.d[var2] = var1[var2];
			}

		}
	}

	public arm a(dt var1, arz var2) {
		int var3 = var1.n() & 15;
		int var4 = var1.p() & 15;
		int var5 = this.e[var4 << 4 | var3] & 255;
		arm var6;
		if (var5 == 255) {
			var6 = var2.a(var1, arm.q);
			var5 = var6.az;
			this.e[var4 << 4 | var3] = (byte) (var5 & 255);
		}

		var6 = arm.e(var5);
		return var6 == null ? arm.q : var6;
	}

	public byte[] k() {
		return this.e;
	}

	public void a(byte[] var1) {
		if (this.e.length != var1.length) {
			c.warn("Could not set level chunk biomes, array length is " + var1.length + " instead of " + this.e.length);
		} else {
			for (int var2 = 0; var2 < this.e.length; ++var2) {
				this.e[var2] = var1[var2];
			}

		}
	}

	public void l() {
		this.v = 0;
	}

	public void m() {
		dt var1 = new dt(this.a << 4, 0, this.b << 4);

		for (int var2 = 0; var2 < 8; ++var2) {
			if (this.v >= 4096) {
				return;
			}

			int var3 = this.v % 16;
			int var4 = this.v / 16 % 16;
			int var5 = this.v / 256;
			++this.v;

			for (int var6 = 0; var6 < 16; ++var6) {
				dt var7 = var1.a(var4, (var3 << 4) + var6, var5);
				boolean var8 = var6 == 0 || var6 == 15 || var4 == 0 || var4 == 15 || var5 == 0 || var5 == 15;
				if (this.d[var3] == null && var8 || this.d[var3] != null && this.d[var3].b(var4, var6, var5).r() == bof.a) {
					ej[] var9 = ej.values();
					int var10 = var9.length;

					for (int var11 = 0; var11 < var10; ++var11) {
						ej var12 = var9[var11];
						dt var13 = var7.a(var12);
						if (this.i.p(var13).c().p() > 0) {
							this.i.x(var13);
						}
					}

					this.i.x(var7);
				}
			}
		}

	}

	public void n() {
		this.n = true;
		this.o = true;
		dt var1 = new dt(this.a << 4, 0, this.b << 4);
		if (!this.i.t.o()) {
			if (this.i.a(var1.a(-1, 0, -1), var1.a(16, 63, 16))) {
				label42: for (int var2 = 0; var2 < 16; ++var2) {
					for (int var3 = 0; var3 < 16; ++var3) {
						if (!this.e(var2, var3)) {
							this.o = false;
							break label42;
						}
					}
				}

				if (this.o) {
					Iterator var5 = en.a.iterator();

					while (var5.hasNext()) {
						ej var6 = (ej) var5.next();
						int var4 = var6.c() == em.a ? 16 : 1;
						this.i.f(var1.a(var6, var4)).a(var6.d());
					}

					this.y();
				}
			} else {
				this.o = false;
			}
		}

	}

	private void y() {
		for (int var1 = 0; var1 < this.g.length; ++var1) {
			this.g[var1] = true;
		}

		this.h(false);
	}

	private void a(ej var1) {
		if (this.n) {
			int var2;
			if (var1 == ej.f) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(15, var2);
				}
			} else if (var1 == ej.e) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(0, var2);
				}
			} else if (var1 == ej.d) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 15);
				}
			} else if (var1 == ej.c) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 0);
				}
			}

		}
	}

	private boolean e(int var1, int var2) {
		dt var3 = new dt(this.a << 4, 0, this.b << 4);
		int var4 = this.g();
		boolean var5 = false;
		boolean var6 = false;

		int var7;
		dt var8;
		for (var7 = var4 + 16 - 1; var7 > 63 || var7 > 0 && !var6; --var7) {
			var8 = var3.a(var1, var7, var2);
			int var9 = this.b(var8);
			if (var9 == 255 && var7 < 63) {
				var6 = true;
			}

			if (!var5 && var9 > 0) {
				var5 = true;
			} else if (var5 && var9 == 0 && !this.i.x(var8)) {
				return false;
			}
		}

		for (; var7 > 0; --var7) {
			var8 = var3.a(var1, var7, var2);
			if (this.a(var8).p() > 0) {
				this.i.x(var8);
			}
		}

		return true;
	}

	public boolean o() {
		return this.h;
	}

	public World p() {
		return this.i;
	}

	public int[] q() {
		return this.j;
	}

	public void a(int[] var1) {
		if (this.j.length != var1.length) {
			c.warn("Could not set level chunk heightmap, array length is " + var1.length + " instead of " + this.j.length);
		} else {
			for (int var2 = 0; var2 < this.j.length; ++var2) {
				this.j[var2] = var1[var2];
			}

		}
	}

	public Map r() {
		return this.l;
	}

	public uc[] s() {
		return this.m;
	}

	public boolean t() {
		return this.n;
	}

	public void d(boolean var1) {
		this.n = var1;
	}

	public boolean u() {
		return this.o;
	}

	public void e(boolean var1) {
		this.o = var1;
	}

	public void f(boolean var1) {
		this.q = var1;
	}

	public void g(boolean var1) {
		this.r = var1;
	}

	public void b(long var1) {
		this.s = var1;
	}

	public int v() {
		return this.t;
	}

	public long w() {
		return this.u;
	}

	public void c(long var1) {
		this.u = var1;
	}

}
