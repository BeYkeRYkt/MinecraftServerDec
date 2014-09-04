package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ans {

	public static final String a = null;
	public static final String b;
	public static final String c = "+0-1-2-3&4-4+13";
	public static final String d;
	public static final String e;
	public static final String f;
	public static final String g;
	public static final String h;
	public static final String i;
	public static final String j;
	public static final String k;
	public static final String l;
	public static final String m;
	public static final String n;
	private static final Map o = Maps.newHashMap();
	private static final Map p = Maps.newHashMap();
	private static final Map q;
	private static final String[] r;

	public static boolean a(int var0, int var1) {
		return (var0 & 1 << var1) != 0;
	}

	private static int c(int var0, int var1) {
		return a(var0, var1) ? 1 : 0;
	}

	private static int d(int var0, int var1) {
		return a(var0, var1) ? 0 : 1;
	}

	public static int a(int var0) {
		return a(var0, 5, 4, 3, 2, 1);
	}

	public static int a(Collection var0) {
		int var1 = 3694022;
		if (var0 != null && !var0.isEmpty()) {
			float var2 = 0.0F;
			float var3 = 0.0F;
			float var4 = 0.0F;
			float var5 = 0.0F;
			Iterator var6 = var0.iterator();

			while (var6.hasNext()) {
				wq var7 = (wq) var6.next();
				if (var7.f()) {
					int var8 = wp.a[var7.a()].k();

					for (int var9 = 0; var9 <= var7.c(); ++var9) {
						var2 += (float) (var8 >> 16 & 255) / 255.0F;
						var3 += (float) (var8 >> 8 & 255) / 255.0F;
						var4 += (float) (var8 >> 0 & 255) / 255.0F;
						++var5;
					}
				}
			}

			if (var5 == 0.0F) {
				return 0;
			} else {
				var2 = var2 / var5 * 255.0F;
				var3 = var3 / var5 * 255.0F;
				var4 = var4 / var5 * 255.0F;
				return (int) var2 << 16 | (int) var3 << 8 | (int) var4;
			}
		} else {
			return var1;
		}
	}

	public static boolean b(Collection var0) {
		Iterator var1 = var0.iterator();

		wq var2;
		do {
			if (!var1.hasNext()) {
				return true;
			}

			var2 = (wq) var1.next();
		} while (var2.e());

		return false;
	}

	public static String c(int var0) {
		int var1 = a(var0);
		return r[var1];
	}

	private static int a(boolean var0, boolean var1, boolean var2, int var3, int var4, int var5, int var6) {
		int var7 = 0;
		if (var0) {
			var7 = d(var6, var4);
		} else if (var3 != -1) {
			if (var3 == 0 && h(var6) == var4) {
				var7 = 1;
			} else if (var3 == 1 && h(var6) > var4) {
				var7 = 1;
			} else if (var3 == 2 && h(var6) < var4) {
				var7 = 1;
			}
		} else {
			var7 = c(var6, var4);
		}

		if (var1) {
			var7 *= var5;
		}

		if (var2) {
			var7 *= -1;
		}

		return var7;
	}

	private static int h(int var0) {
		int var1;
		for (var1 = 0; var0 > 0; ++var1) {
			var0 &= var0 - 1;
		}

		return var1;
	}

	private static int a(String var0, int var1, int var2, int var3) {
		if (var1 < var0.length() && var2 >= 0 && var1 < var2) {
			int var4 = var0.indexOf(124, var1);
			int var5;
			int var17;
			if (var4 >= 0 && var4 < var2) {
				var5 = a(var0, var1, var4 - 1, var3);
				if (var5 > 0) {
					return var5;
				} else {
					var17 = a(var0, var4 + 1, var2, var3);
					return var17 > 0 ? var17 : 0;
				}
			} else {
				var5 = var0.indexOf(38, var1);
				if (var5 >= 0 && var5 < var2) {
					var17 = a(var0, var1, var5 - 1, var3);
					if (var17 <= 0) {
						return 0;
					} else {
						int var18 = a(var0, var5 + 1, var2, var3);
						return var18 <= 0 ? 0 : (var17 > var18 ? var17 : var18);
					}
				} else {
					boolean var6 = false;
					boolean var7 = false;
					boolean var8 = false;
					boolean var9 = false;
					boolean var10 = false;
					byte var11 = -1;
					int var12 = 0;
					int var13 = 0;
					int var14 = 0;

					for (int var15 = var1; var15 < var2; ++var15) {
						char var16 = var0.charAt(var15);
						if (var16 >= 48 && var16 <= 57) {
							if (var6) {
								var13 = var16 - 48;
								var7 = true;
							} else {
								var12 *= 10;
								var12 += var16 - 48;
								var8 = true;
							}
						} else if (var16 == 42) {
							var6 = true;
						} else if (var16 == 33) {
							if (var8) {
								var14 += a(var9, var7, var10, var11, var12, var13, var3);
								var9 = false;
								var10 = false;
								var6 = false;
								var7 = false;
								var8 = false;
								var13 = 0;
								var12 = 0;
								var11 = -1;
							}

							var9 = true;
						} else if (var16 == 45) {
							if (var8) {
								var14 += a(var9, var7, var10, var11, var12, var13, var3);
								var9 = false;
								var10 = false;
								var6 = false;
								var7 = false;
								var8 = false;
								var13 = 0;
								var12 = 0;
								var11 = -1;
							}

							var10 = true;
						} else if (var16 != 61 && var16 != 60 && var16 != 62) {
							if (var16 == 43 && var8) {
								var14 += a(var9, var7, var10, var11, var12, var13, var3);
								var9 = false;
								var10 = false;
								var6 = false;
								var7 = false;
								var8 = false;
								var13 = 0;
								var12 = 0;
								var11 = -1;
							}
						} else {
							if (var8) {
								var14 += a(var9, var7, var10, var11, var12, var13, var3);
								var9 = false;
								var10 = false;
								var6 = false;
								var7 = false;
								var8 = false;
								var13 = 0;
								var12 = 0;
								var11 = -1;
							}

							if (var16 == 61) {
								var11 = 0;
							} else if (var16 == 60) {
								var11 = 2;
							} else if (var16 == 62) {
								var11 = 1;
							}
						}
					}

					if (var8) {
						var14 += a(var9, var7, var10, var11, var12, var13, var3);
					}

					return var14;
				}
			}
		} else {
			return 0;
		}
	}

	public static List b(int var0, boolean var1) {
		ArrayList var2 = null;
		wp[] var3 = wp.a;
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			wp var6 = var3[var5];
			if (var6 != null && (!var6.j() || var1)) {
				String var7 = (String) o.get(Integer.valueOf(var6.d()));
				if (var7 != null) {
					int var8 = a(var7, 0, var7.length(), var0);
					if (var8 > 0) {
						int var9 = 0;
						String var10 = (String) p.get(Integer.valueOf(var6.d()));
						if (var10 != null) {
							var9 = a(var10, 0, var10.length(), var0);
							if (var9 < 0) {
								var9 = 0;
							}
						}

						if (var6.b()) {
							var8 = 1;
						} else {
							var8 = 1200 * (var8 * 3 + (var8 - 1) * 2);
							var8 >>= var9;
							var8 = (int) Math.round((double) var8 * var6.h());
							if ((var0 & 16384) != 0) {
								var8 = (int) Math.round((double) var8 * 0.75D + 0.5D);
							}
						}

						if (var2 == null) {
							var2 = Lists.newArrayList();
						}

						wq var11 = new wq(var6.d(), var8, var9);
						if ((var0 & 16384) != 0) {
							var11.a(true);
						}

						var2.add(var11);
					}
				}
			}
		}

		return var2;
	}

	private static int a(int var0, int var1, boolean var2, boolean var3, boolean var4) {
		if (var4) {
			if (!a(var0, var1)) {
				return 0;
			}
		} else if (var2) {
			var0 &= ~(1 << var1);
		} else if (var3) {
			if ((var0 & 1 << var1) == 0) {
				var0 |= 1 << var1;
			} else {
				var0 &= ~(1 << var1);
			}
		} else {
			var0 |= 1 << var1;
		}

		return var0;
	}

	public static int a(int var0, String var1) {
		byte var2 = 0;
		int var3 = var1.length();
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		boolean var7 = false;
		int var8 = 0;

		for (int var9 = var2; var9 < var3; ++var9) {
			char var10 = var1.charAt(var9);
			if (var10 >= 48 && var10 <= 57) {
				var8 *= 10;
				var8 += var10 - 48;
				var4 = true;
			} else if (var10 == 33) {
				if (var4) {
					var0 = a(var0, var8, var6, var5, var7);
					var7 = false;
					var5 = false;
					var6 = false;
					var4 = false;
					var8 = 0;
				}

				var5 = true;
			} else if (var10 == 45) {
				if (var4) {
					var0 = a(var0, var8, var6, var5, var7);
					var7 = false;
					var5 = false;
					var6 = false;
					var4 = false;
					var8 = 0;
				}

				var6 = true;
			} else if (var10 == 43) {
				if (var4) {
					var0 = a(var0, var8, var6, var5, var7);
					var7 = false;
					var5 = false;
					var6 = false;
					var4 = false;
					var8 = 0;
				}
			} else if (var10 == 38) {
				if (var4) {
					var0 = a(var0, var8, var6, var5, var7);
					var7 = false;
					var5 = false;
					var6 = false;
					var4 = false;
					var8 = 0;
				}

				var7 = true;
			}
		}

		if (var4) {
			var0 = a(var0, var8, var6, var5, var7);
		}

		return var0 & 32767;
	}

	public static int a(int var0, int var1, int var2, int var3, int var4, int var5) {
		return (a(var0, var1) ? 16 : 0) | (a(var0, var2) ? 8 : 0) | (a(var0, var3) ? 4 : 0) | (a(var0, var4) ? 2 : 0) | (a(var0, var5) ? 1 : 0);
	}

	static {
		o.put(Integer.valueOf(wp.l.d()), "0 & !1 & !2 & !3 & 0+6");
		b = "-0+1-2-3&4-4+13";
		o.put(Integer.valueOf(wp.c.d()), "!0 & 1 & !2 & !3 & 1+6");
		h = "+0+1-2-3&4-4+13";
		o.put(Integer.valueOf(wp.n.d()), "0 & 1 & !2 & !3 & 0+6");
		f = "+0-1+2-3&4-4+13";
		o.put(Integer.valueOf(wp.h.d()), "0 & !1 & 2 & !3");
		d = "-0-1+2-3&4-4+13";
		o.put(Integer.valueOf(wp.u.d()), "!0 & !1 & 2 & !3 & 2+6");
		e = "-0+3-4+13";
		o.put(Integer.valueOf(wp.t.d()), "!0 & !1 & !2 & 3 & 3+6");
		o.put(Integer.valueOf(wp.i.d()), "!0 & !1 & 2 & 3");
		o.put(Integer.valueOf(wp.d.d()), "!0 & 1 & !2 & 3 & 3+6");
		g = "+0-1-2+3&4-4+13";
		o.put(Integer.valueOf(wp.g.d()), "0 & !1 & !2 & 3 & 3+6");
		l = "-0+1+2-3+13&4-4";
		o.put(Integer.valueOf(wp.r.d()), "!0 & 1 & 2 & !3 & 2+6");
		o.put(Integer.valueOf(wp.p.d()), "!0 & 1 & 2 & 3 & 2+6");
		m = "+0-1+2+3+13&4-4";
		o.put(Integer.valueOf(wp.o.d()), "0 & !1 & 2 & 3 & 2+6");
		n = "+0+1-2+3&4-4+13";
		o.put(Integer.valueOf(wp.j.d()), "0 & 1 & !2 & 3");
		j = "+5-6-7";
		p.put(Integer.valueOf(wp.c.d()), "5");
		p.put(Integer.valueOf(wp.e.d()), "5");
		p.put(Integer.valueOf(wp.g.d()), "5");
		p.put(Integer.valueOf(wp.l.d()), "5");
		p.put(Integer.valueOf(wp.i.d()), "5");
		p.put(Integer.valueOf(wp.h.d()), "5");
		p.put(Integer.valueOf(wp.m.d()), "5");
		p.put(Integer.valueOf(wp.u.d()), "5");
		p.put(Integer.valueOf(wp.j.d()), "5");
		i = "-5+6-7";
		k = "+14&13-13";
		q = Maps.newHashMap();
		r = new String[] { "potion.prefix.mundane", "potion.prefix.uninteresting", "potion.prefix.bland", "potion.prefix.clear", "potion.prefix.milky", "potion.prefix.diffuse", "potion.prefix.artless", "potion.prefix.thin", "potion.prefix.awkward", "potion.prefix.flat", "potion.prefix.bulky", "potion.prefix.bungling", "potion.prefix.buttered", "potion.prefix.smooth", "potion.prefix.suave", "potion.prefix.debonair", "potion.prefix.thick", "potion.prefix.elegant", "potion.prefix.fancy",
				"potion.prefix.charming", "potion.prefix.dashing", "potion.prefix.refined", "potion.prefix.cordial", "potion.prefix.sparkling", "potion.prefix.potent", "potion.prefix.foul", "potion.prefix.odorless", "potion.prefix.rank", "potion.prefix.harsh", "potion.prefix.acrid", "potion.prefix.gross", "potion.prefix.stinky" };
	}
}
