package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class aoi implements aoo {

	private amj a;

	public boolean a(ain var1, World var2) {
		this.a = null;
		int var3 = 0;
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;
		int var7 = 0;
		int var8 = 0;

		for (int var9 = 0; var9 < var1.n_(); ++var9) {
			amj var10 = var1.a(var9);
			if (var10 != null) {
				if (var10.b() == amk.H) {
					++var4;
				} else if (var10.b() == amk.cc) {
					++var6;
				} else if (var10.b() == amk.aW) {
					++var5;
				} else if (var10.b() == amk.aK) {
					++var3;
				} else if (var10.b() == amk.aT) {
					++var7;
				} else if (var10.b() == amk.i) {
					++var7;
				} else if (var10.b() == amk.bL) {
					++var8;
				} else if (var10.b() == amk.G) {
					++var8;
				} else if (var10.b() == amk.bx) {
					++var8;
				} else {
					if (var10.b() != amk.bX) {
						return false;
					}

					++var8;
				}
			}
		}

		var7 += var5 + var8;
		if (var4 <= 3 && var3 <= 1) {
			NBTCompoundTag var16;
			NBTCompoundTag var19;
			if (var4 >= 1 && var3 == 1 && var7 == 0) {
				this.a = new amj(amk.cb);
				if (var6 > 0) {
					var16 = new NBTCompoundTag();
					var19 = new NBTCompoundTag();
					NBTListTag var23 = new NBTListTag();

					for (int var24 = 0; var24 < var1.n_(); ++var24) {
						amj var26 = var1.a(var24);
						if (var26 != null && var26.b() == amk.cc && var26.n() && var26.o().b("Explosion", 10)) {
							var23.addTag((NBTTag) var26.o().m("Explosion"));
						}
					}

					var19.a("Explosions", (NBTTag) var23);
					var19.a("Flight", (byte) var4);
					var16.a("Fireworks", (NBTTag) var19);
					this.a.d(var16);
				}

				return true;
			} else if (var4 == 1 && var3 == 0 && var6 == 0 && var5 > 0 && var8 <= 1) {
				this.a = new amj(amk.cc);
				var16 = new NBTCompoundTag();
				var19 = new NBTCompoundTag();
				byte var22 = 0;
				ArrayList var12 = Lists.newArrayList();

				for (int var13 = 0; var13 < var1.n_(); ++var13) {
					amj var14 = var1.a(var13);
					if (var14 != null) {
						if (var14.b() == amk.aW) {
							var12.add(Integer.valueOf(akw.a[var14.i() & 15]));
						} else if (var14.b() == amk.aT) {
							var19.a("Flicker", true);
						} else if (var14.b() == amk.i) {
							var19.a("Trail", true);
						} else if (var14.b() == amk.bL) {
							var22 = 1;
						} else if (var14.b() == amk.G) {
							var22 = 4;
						} else if (var14.b() == amk.bx) {
							var22 = 2;
						} else if (var14.b() == amk.bX) {
							var22 = 3;
						}
					}
				}

				int[] var25 = new int[var12.size()];

				for (int var27 = 0; var27 < var25.length; ++var27) {
					var25[var27] = ((Integer) var12.get(var27)).intValue();
				}

				var19.a("Colors", var25);
				var19.a("Type", var22);
				var16.a("Explosion", (NBTTag) var19);
				this.a.d(var16);
				return true;
			} else if (var4 == 0 && var3 == 0 && var6 == 1 && var5 > 0 && var5 == var7) {
				ArrayList var15 = Lists.newArrayList();

				for (int var17 = 0; var17 < var1.n_(); ++var17) {
					amj var11 = var1.a(var17);
					if (var11 != null) {
						if (var11.b() == amk.aW) {
							var15.add(Integer.valueOf(akw.a[var11.i() & 15]));
						} else if (var11.b() == amk.cc) {
							this.a = var11.k();
							this.a.b = 1;
						}
					}
				}

				int[] var18 = new int[var15.size()];

				for (int var20 = 0; var20 < var18.length; ++var20) {
					var18[var20] = ((Integer) var15.get(var20)).intValue();
				}

				if (this.a != null && this.a.n()) {
					NBTCompoundTag var21 = this.a.o().m("Explosion");
					if (var21 == null) {
						return false;
					} else {
						var21.a("FadeColors", var18);
						return true;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public amj a(ain var1) {
		return this.a.k();
	}

	public int a() {
		return 10;
	}

	public amj b() {
		return this.a;
	}

	public amj[] b(ain var1) {
		amj[] var2 = new amj[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			amj var4 = var1.a(var3);
			if (var4 != null && var4.b().r()) {
				var2[var3] = new amj(var4.b().q());
			}
		}

		return var2;
	}
}
