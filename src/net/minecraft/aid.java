package net.minecraft;

import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class aid extends aib {

	private static final Logger f = LogManager.getLogger();
	private vq g = new aji();
	private vq h = new aie(this, "Repair", true, 2);
	private World i;
	private dt j;
	public int a;
	private int k;
	private String l;
	private final ahd m;

	public aid(ahb var1, World var2, dt var3, ahd var4) {
		this.j = var3;
		this.i = var2;
		this.m = var4;
		this.a(new ajk(this.h, 0, 27, 47));
		this.a(new ajk(this.h, 1, 76, 47));
		this.a((ajk) (new aif(this, this.g, 2, 134, 47, var2, var3)));

		int var5;
		for (var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 9; ++var6) {
				this.a(new ajk(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, 84 + var5 * 18));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.a(new ajk(var1, var5, 8 + var5 * 18, 142));
		}

	}

	public void a(vq var1) {
		super.a(var1);
		if (var1 == this.h) {
			this.e();
		}

	}

	public void e() {
		boolean var1 = false;
		boolean var2 = true;
		boolean var3 = true;
		boolean var4 = true;
		boolean var5 = true;
		boolean var6 = true;
		boolean var7 = true;
		amj var8 = this.h.a(0);
		this.a = 1;
		int var9 = 0;
		byte var10 = 0;
		byte var11 = 0;
		if (var8 == null) {
			this.g.a(0, (amj) null);
			this.a = 0;
		} else {
			amj var12 = var8.k();
			amj var13 = this.h.a(1);
			Map var14 = aph.a(var12);
			boolean var15 = false;
			int var25 = var10 + var8.A() + (var13 == null ? 0 : var13.A());
			this.k = 0;
			int var16;
			if (var13 != null) {
				var15 = var13.b() == amk.cd && amk.cd.h(var13).getSize() > 0;
				int var17;
				int var18;
				if (var12.e() && var12.b().a(var8, var13)) {
					var16 = Math.min(var12.h(), var12.j() / 4);
					if (var16 <= 0) {
						this.g.a(0, (amj) null);
						this.a = 0;
						return;
					}

					for (var17 = 0; var16 > 0 && var17 < var13.b; ++var17) {
						var18 = var12.h() - var16;
						var12.b(var18);
						++var9;
						var16 = Math.min(var12.h(), var12.j() / 4);
					}

					this.k = var17;
				} else {
					if (!var15 && (var12.b() != var13.b() || !var12.e())) {
						this.g.a(0, (amj) null);
						this.a = 0;
						return;
					}

					int var20;
					if (var12.e() && !var15) {
						var16 = var8.j() - var8.h();
						var17 = var13.j() - var13.h();
						var18 = var17 + var12.j() * 12 / 100;
						int var19 = var16 + var18;
						var20 = var12.j() - var19;
						if (var20 < 0) {
							var20 = 0;
						}

						if (var20 < var12.i()) {
							var12.b(var20);
							var9 += 2;
						}
					}

					Map var26 = aph.a(var13);
					Iterator var27 = var26.keySet().iterator();

					while (var27.hasNext()) {
						var18 = ((Integer) var27.next()).intValue();
						apf var28 = apf.c(var18);
						if (var28 != null) {
							var20 = var14.containsKey(Integer.valueOf(var18)) ? ((Integer) var14.get(Integer.valueOf(var18))).intValue() : 0;
							int var21 = ((Integer) var26.get(Integer.valueOf(var18))).intValue();
							int var10000;
							if (var20 == var21) {
								++var21;
								var10000 = var21;
							} else {
								var10000 = Math.max(var21, var20);
							}

							var21 = var10000;
							boolean var22 = var28.a(var8);
							if (this.m.by.instabuild || var8.b() == amk.cd) {
								var22 = true;
							}

							Iterator var23 = var14.keySet().iterator();

							while (var23.hasNext()) {
								int var24 = ((Integer) var23.next()).intValue();
								if (var24 != var18 && !var28.a(apf.c(var24))) {
									var22 = false;
									++var9;
								}
							}

							if (var22) {
								if (var21 > var28.b()) {
									var21 = var28.b();
								}

								var14.put(Integer.valueOf(var18), Integer.valueOf(var21));
								int var29 = 0;
								switch (var28.d()) {
									case 1:
										var29 = 8;
										break;
									case 2:
										var29 = 4;
									case 3:
									case 4:
									case 6:
									case 7:
									case 8:
									case 9:
									default:
										break;
									case 5:
										var29 = 2;
										break;
									case 10:
										var29 = 1;
								}

								if (var15) {
									var29 = Math.max(1, var29 / 2);
								}

								var9 += var29 * var21;
							}
						}
					}
				}
			}

			if (StringUtils.isBlank(this.l)) {
				if (var8.s()) {
					var11 = 1;
					var9 += var11;
					var12.r();
				}
			} else if (!this.l.equals(var8.q())) {
				var11 = 1;
				var9 += var11;
				var12.c(this.l);
			}

			this.a = var25 + var9;
			if (var9 <= 0) {
				var12 = null;
			}

			if (var11 == var9 && var11 > 0 && this.a >= 40) {
				this.a = 39;
			}

			if (this.a >= 40 && !this.m.by.instabuild) {
				var12 = null;
			}

			if (var12 != null) {
				var16 = var12.A();
				if (var13 != null && var16 < var13.A()) {
					var16 = var13.A();
				}

				var16 = var16 * 2 + 1;
				var12.c(var16);
				aph.a(var14, var12);
			}

			this.g.a(0, var12);
			this.b();
		}
	}

	public void a(ail var1) {
		super.a(var1);
		var1.a(this, 0, this.a);
	}

	public void b(ahd var1) {
		super.b(var1);
		if (!this.i.D) {
			for (int var2 = 0; var2 < this.h.n_(); ++var2) {
				amj var3 = this.h.b(var2);
				if (var3 != null) {
					var1.a(var3, false);
				}
			}

		}
	}

	public boolean a(ahd var1) {
		return this.i.p(this.j).c() != aty.cf ? false : var1.e((double) this.j.n() + 0.5D, (double) this.j.o() + 0.5D, (double) this.j.p() + 0.5D) <= 64.0D;
	}

	public amj b(ahd var1, int var2) {
		amj var3 = null;
		ajk var4 = (ajk) this.c.get(var2);
		if (var4 != null && var4.e()) {
			amj var5 = var4.d();
			var3 = var5.k();
			if (var2 == 2) {
				if (!this.a(var5, 3, 39, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (var2 != 0 && var2 != 1) {
				if (var2 >= 3 && var2 < 39 && !this.a(var5, 0, 2, false)) {
					return null;
				}
			} else if (!this.a(var5, 3, 39, false)) {
				return null;
			}

			if (var5.b == 0) {
				var4.d((amj) null);
			} else {
				var4.f();
			}

			if (var5.b == var3.b) {
				return null;
			}

			var4.a(var1, var5);
		}

		return var3;
	}

	public void a(String var1) {
		this.l = var1;
		if (this.a(2).e()) {
			amj var2 = this.a(2).d();
			if (StringUtils.isBlank(var1)) {
				var2.r();
			} else {
				var2.c(this.l);
			}
		}

		this.e();
	}

	// $FF: synthetic method
	static vq a(aid var0) {
		return var0.h;
	}

	// $FF: synthetic method
	static int b(aid var0) {
		return var0.k;
	}

}
