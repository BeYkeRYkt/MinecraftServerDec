package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class bnj extends bnn {

	private static final List a = Lists.newArrayList((Object[]) (new vl[] { new vl(amk.i, 0, 1, 3, 3), new vl(amk.j, 0, 1, 5, 10), new vl(amk.k, 0, 1, 3, 5), new vl(amk.P, 0, 1, 3, 15), new vl(amk.e, 0, 1, 3, 15), new vl(amk.b, 0, 1, 1, 5), new vl(amk.l, 0, 1, 1, 5), new vl(amk.Z, 0, 1, 1, 5), new vl(amk.Y, 0, 1, 1, 5), new vl(amk.aa, 0, 1, 1, 5), new vl(amk.ab, 0, 1, 1, 5), new vl(Item.getItemOf(aty.Z), 0, 3, 7, 5), new vl(Item.getItemOf(aty.g), 0, 3, 7, 5), new vl(amk.aA, 0, 1, 1, 3),
			new vl(amk.ck, 0, 1, 1, 1), new vl(amk.cl, 0, 1, 1, 1), new vl(amk.cm, 0, 1, 1, 1) }));
	private boolean b;

	public bnj() {
	}

	public bnj(bnk var1, int var2, Random var3, bjb var4, PaintingDirection var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
	}

	public static bnj a(bnk var0, List var1, Random var2, int var3, int var4, int var5, PaintingDirection var6, int var7) {
		bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 10, 6, 7, var6);
		return a(var8) && bms.a(var1, var8) == null ? new bnj(var0, var7, var2, var8, var6) : null;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Chest", this.b);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getBoolean("Chest");
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 6 - 1, 0);
		}

		this.a(var1, var3, 0, 1, 0, 9, 4, 6, aty.a.P(), aty.a.P(), false);
		this.a(var1, var3, 0, 0, 0, 9, 0, 6, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 0, 4, 0, 9, 4, 6, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 0, 5, 0, 9, 5, 6, aty.U.P(), aty.U.P(), false);
		this.a(var1, var3, 1, 5, 1, 8, 5, 5, aty.a.P(), aty.a.P(), false);
		this.a(var1, var3, 1, 1, 0, 2, 3, 0, aty.f.P(), aty.f.P(), false);
		this.a(var1, var3, 0, 1, 0, 0, 4, 0, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 3, 1, 0, 3, 4, 0, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 0, 1, 6, 0, 4, 6, aty.r.P(), aty.r.P(), false);
		this.a(var1, aty.f.P(), 3, 3, 1, var3);
		this.a(var1, var3, 3, 1, 2, 3, 3, 2, aty.f.P(), aty.f.P(), false);
		this.a(var1, var3, 4, 1, 3, 5, 3, 3, aty.f.P(), aty.f.P(), false);
		this.a(var1, var3, 0, 1, 1, 0, 3, 5, aty.f.P(), aty.f.P(), false);
		this.a(var1, var3, 1, 1, 6, 5, 3, 6, aty.f.P(), aty.f.P(), false);
		this.a(var1, var3, 5, 1, 0, 5, 3, 0, aty.aO.P(), aty.aO.P(), false);
		this.a(var1, var3, 9, 1, 0, 9, 3, 0, aty.aO.P(), aty.aO.P(), false);
		this.a(var1, var3, 6, 1, 4, 9, 4, 6, aty.e.P(), aty.e.P(), false);
		this.a(var1, aty.k.P(), 7, 1, 5, var3);
		this.a(var1, aty.k.P(), 8, 1, 5, var3);
		this.a(var1, aty.bi.P(), 9, 2, 5, var3);
		this.a(var1, aty.bi.P(), 9, 2, 4, var3);
		this.a(var1, var3, 7, 2, 4, 8, 2, 5, aty.a.P(), aty.a.P(), false);
		this.a(var1, aty.e.P(), 6, 1, 3, var3);
		this.a(var1, aty.al.P(), 6, 2, 3, var3);
		this.a(var1, aty.al.P(), 6, 3, 3, var3);
		this.a(var1, aty.T.P(), 8, 1, 1, var3);
		this.a(var1, aty.bj.P(), 0, 2, 2, var3);
		this.a(var1, aty.bj.P(), 0, 2, 4, var3);
		this.a(var1, aty.bj.P(), 2, 2, 6, var3);
		this.a(var1, aty.bj.P(), 4, 2, 6, var3);
		this.a(var1, aty.aO.P(), 2, 1, 4, var3);
		this.a(var1, aty.aB.P(), 2, 2, 4, var3);
		this.a(var1, aty.f.P(), 1, 1, 5, var3);
		this.a(var1, aty.ad.a(this.a(aty.ad, 3)), 2, 1, 5, var3);
		this.a(var1, aty.ad.a(this.a(aty.ad, 1)), 1, 1, 4, var3);
		if (!this.b && var3.b((fd) (new Position(this.a(5, 5), this.d(1), this.b(5, 5))))) {
			this.b = true;
			this.a(var1, var3, var2, 5, 1, 5, a, 3 + var2.nextInt(6));
		}

		int var4;
		for (var4 = 6; var4 <= 8; ++var4) {
			if (this.a(var1, var4, 0, -1, var3).c().r() == Material.AIR && this.a(var1, var4, -1, -1, var3).c().r() != Material.AIR) {
				this.a(var1, aty.aw.a(this.a(aty.aw, 3)), var4, 0, -1, var3);
			}
		}

		for (var4 = 0; var4 < 7; ++var4) {
			for (int var5 = 0; var5 < 10; ++var5) {
				this.b(var1, var5, 6, var4, var3);
				this.b(var1, aty.e.P(), var5, -1, var4, var3);
			}
		}

		this.a(var1, var3, 7, 1, 1, 1);
		return true;
	}

	protected int c(int var1, int var2) {
		return 3;
	}

}
