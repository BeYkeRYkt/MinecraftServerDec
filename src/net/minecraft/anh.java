package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class anh extends alq {

	private static final String[] a = new String[] { "skeleton", "wither", "zombie", "char", "creeper" };

	public anh() {
		this.a(akf.c);
		this.d(0);
		this.a(true);
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		if (var5 == ej.a) {
			return false;
		} else {
			bec var9 = var3.p(var4);
			atr var10 = var9.c();
			boolean var11 = var10.f(var3, var4);
			if (!var11) {
				if (!var3.p(var4).c().r().a()) {
					return false;
				}

				var4 = var4.a(var5);
			}

			if (!var2.a(var4, var5, var1)) {
				return false;
			} else if (!aty.ce.c(var3, var4)) {
				return false;
			} else {
				if (!var3.D) {
					var3.a(var4, aty.ce.P().a(baj.a, var5), 3);
					int var12 = 0;
					if (var5 == ej.b) {
						var12 = NumberConverter.c((double) (var2.y * 16.0F / 360.0F) + 0.5D) & 15;
					}

					bcm var13 = var3.s(var4);
					if (var13 instanceof bdm) {
						bdm var14 = (bdm) var13;
						if (var1.i() == 3) {
							GameProfile var15 = null;
							if (var1.n()) {
								NBTCompoundTag var16 = var1.o();
								if (var16.b("SkullOwner", 10)) {
									var15 = ga.a(var16.m("SkullOwner"));
								} else if (var16.b("SkullOwner", 8) && var16.j("SkullOwner").length() > 0) {
									var15 = new GameProfile((UUID) null, var16.j("SkullOwner"));
								}
							}

							var14.a(var15);
						} else {
							var14.a(var1.i());
						}

						var14.b(var12);
						aty.ce.a(var3, var4, var14);
					}

					--var1.b;
				}

				return true;
			}
		}
	}

	public int a(int var1) {
		return var1;
	}

	public String e_(amj var1) {
		int var2 = var1.i();
		if (var2 < 0 || var2 >= a.length) {
			var2 = 0;
		}

		return super.a() + "." + a[var2];
	}

	public String a(amj var1) {
		if (var1.i() == 3 && var1.n()) {
			if (var1.o().b("SkullOwner", 8)) {
				return fi.a("item.skull.player.name", new Object[] { var1.o().j("SkullOwner") });
			}

			if (var1.o().b("SkullOwner", 10)) {
				NBTCompoundTag var2 = var1.o().m("SkullOwner");
				if (var2.b("Name", 8)) {
					return fi.a("item.skull.player.name", new Object[] { var2.j("Name") });
				}
			}
		}

		return super.a(var1);
	}

	public boolean a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.b("SkullOwner", 8) && var1.j("SkullOwner").length() > 0) {
			GameProfile var2 = new GameProfile((UUID) null, var1.j("SkullOwner"));
			var2 = bdm.b(var2);
			var1.a("SkullOwner", (NBTTag) ga.a(new NBTCompoundTag(), var2));
			return true;
		} else {
			return false;
		}
	}

}
