package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class blz extends bmk {

	private static final List a = Lists.newArrayList((Object[]) (new vl[] { new vl(amk.aL, 0, 1, 3, 20), new vl(amk.aK, 0, 2, 7, 20), new vl(amk.bV, 0, 1, 1, 1), new vl(amk.aQ, 0, 1, 1, 1) }));
	private boolean b;

	public blz() {
	}

	public blz(int var1, Random var2, bjb var3, ej var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
		this.b = var3.d() > 6;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Tall", this.b);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getBoolean("Tall");
	}

	public static blz a(List var0, Random var1, int var2, int var3, int var4, ej var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -4, -1, 0, 14, 11, 15, var5);
		if (!a(var7) || bms.a(var0, var7) != null) {
			var7 = bjb.a(var2, var3, var4, -4, -1, 0, 14, 6, 15, var5);
			if (!a(var7) || bms.a(var0, var7) != null) {
				return null;
			}
		}

		return new blz(var6, var1, var7, var5);
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			byte var4 = 11;
			if (!this.b) {
				var4 = 6;
			}

			this.a(var1, var3, 0, 0, 0, 13, var4 - 1, 14, true, var2, blr.c());
			this.a(var1, var2, var3, this.d, 4, 1, 0);
			this.a(var1, var3, var2, 0.07F, 2, 1, 1, 11, 4, 13, aty.G.P(), aty.G.P(), false);
			boolean var5 = true;
			boolean var6 = true;

			int var7;
			for (var7 = 1; var7 <= 13; ++var7) {
				if ((var7 - 1) % 4 == 0) {
					this.a(var1, var3, 1, 1, var7, 1, 4, var7, aty.f.P(), aty.f.P(), false);
					this.a(var1, var3, 12, 1, var7, 12, 4, var7, aty.f.P(), aty.f.P(), false);
					this.a(var1, aty.aa.P(), 2, 3, var7, var3);
					this.a(var1, aty.aa.P(), 11, 3, var7, var3);
					if (this.b) {
						this.a(var1, var3, 1, 6, var7, 1, 9, var7, aty.f.P(), aty.f.P(), false);
						this.a(var1, var3, 12, 6, var7, 12, 9, var7, aty.f.P(), aty.f.P(), false);
					}
				} else {
					this.a(var1, var3, 1, 1, var7, 1, 4, var7, aty.X.P(), aty.X.P(), false);
					this.a(var1, var3, 12, 1, var7, 12, 4, var7, aty.X.P(), aty.X.P(), false);
					if (this.b) {
						this.a(var1, var3, 1, 6, var7, 1, 9, var7, aty.X.P(), aty.X.P(), false);
						this.a(var1, var3, 12, 6, var7, 12, 9, var7, aty.X.P(), aty.X.P(), false);
					}
				}
			}

			for (var7 = 3; var7 < 12; var7 += 2) {
				this.a(var1, var3, 3, 1, var7, 4, 3, var7, aty.X.P(), aty.X.P(), false);
				this.a(var1, var3, 6, 1, var7, 7, 3, var7, aty.X.P(), aty.X.P(), false);
				this.a(var1, var3, 9, 1, var7, 10, 3, var7, aty.X.P(), aty.X.P(), false);
			}

			if (this.b) {
				this.a(var1, var3, 1, 5, 1, 3, 5, 13, aty.f.P(), aty.f.P(), false);
				this.a(var1, var3, 10, 5, 1, 12, 5, 13, aty.f.P(), aty.f.P(), false);
				this.a(var1, var3, 4, 5, 1, 9, 5, 2, aty.f.P(), aty.f.P(), false);
				this.a(var1, var3, 4, 5, 12, 9, 5, 13, aty.f.P(), aty.f.P(), false);
				this.a(var1, aty.f.P(), 9, 5, 11, var3);
				this.a(var1, aty.f.P(), 8, 5, 11, var3);
				this.a(var1, aty.f.P(), 9, 5, 10, var3);
				this.a(var1, var3, 3, 6, 2, 3, 6, 12, aty.aO.P(), aty.aO.P(), false);
				this.a(var1, var3, 10, 6, 2, 10, 6, 10, aty.aO.P(), aty.aO.P(), false);
				this.a(var1, var3, 4, 6, 2, 9, 6, 2, aty.aO.P(), aty.aO.P(), false);
				this.a(var1, var3, 4, 6, 12, 8, 6, 12, aty.aO.P(), aty.aO.P(), false);
				this.a(var1, aty.aO.P(), 9, 6, 11, var3);
				this.a(var1, aty.aO.P(), 8, 6, 11, var3);
				this.a(var1, aty.aO.P(), 9, 6, 10, var3);
				var7 = this.a(aty.au, 3);
				this.a(var1, aty.au.a(var7), 10, 1, 13, var3);
				this.a(var1, aty.au.a(var7), 10, 2, 13, var3);
				this.a(var1, aty.au.a(var7), 10, 3, 13, var3);
				this.a(var1, aty.au.a(var7), 10, 4, 13, var3);
				this.a(var1, aty.au.a(var7), 10, 5, 13, var3);
				this.a(var1, aty.au.a(var7), 10, 6, 13, var3);
				this.a(var1, aty.au.a(var7), 10, 7, 13, var3);
				byte var8 = 7;
				byte var9 = 7;
				this.a(var1, aty.aO.P(), var8 - 1, 9, var9, var3);
				this.a(var1, aty.aO.P(), var8, 9, var9, var3);
				this.a(var1, aty.aO.P(), var8 - 1, 8, var9, var3);
				this.a(var1, aty.aO.P(), var8, 8, var9, var3);
				this.a(var1, aty.aO.P(), var8 - 1, 7, var9, var3);
				this.a(var1, aty.aO.P(), var8, 7, var9, var3);
				this.a(var1, aty.aO.P(), var8 - 2, 7, var9, var3);
				this.a(var1, aty.aO.P(), var8 + 1, 7, var9, var3);
				this.a(var1, aty.aO.P(), var8 - 1, 7, var9 - 1, var3);
				this.a(var1, aty.aO.P(), var8 - 1, 7, var9 + 1, var3);
				this.a(var1, aty.aO.P(), var8, 7, var9 - 1, var3);
				this.a(var1, aty.aO.P(), var8, 7, var9 + 1, var3);
				this.a(var1, aty.aa.P(), var8 - 2, 8, var9, var3);
				this.a(var1, aty.aa.P(), var8 + 1, 8, var9, var3);
				this.a(var1, aty.aa.P(), var8 - 1, 8, var9 - 1, var3);
				this.a(var1, aty.aa.P(), var8 - 1, 8, var9 + 1, var3);
				this.a(var1, aty.aa.P(), var8, 8, var9 - 1, var3);
				this.a(var1, aty.aa.P(), var8, 8, var9 + 1, var3);
			}

			this.a(var1, var3, var2, 3, 3, 5, vl.a(a, new vl[] { amk.cd.a(var2, 1, 5, 2) }), 1 + var2.nextInt(4));
			if (this.b) {
				this.a(var1, aty.a.P(), 12, 9, 1, var3);
				this.a(var1, var3, var2, 12, 8, 1, vl.a(a, new vl[] { amk.cd.a(var2, 1, 5, 2) }), 1 + var2.nextInt(4));
			}

			return true;
		}
	}

}
