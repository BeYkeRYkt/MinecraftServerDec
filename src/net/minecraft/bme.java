package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class bme extends bmk {

	private static final List b = Lists.newArrayList((Object[]) (new vl[] { new vl(amk.j, 0, 1, 5, 10), new vl(amk.k, 0, 1, 3, 5), new vl(amk.aC, 0, 4, 9, 5), new vl(amk.h, 0, 3, 8, 10), new vl(amk.P, 0, 1, 3, 15), new vl(amk.e, 0, 1, 3, 15), new vl(amk.b, 0, 1, 1, 1) }));
	protected int a;

	public bme() {
	}

	public bme(int var1, Random var2, bjb var3, ej var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
		this.a = var2.nextInt(5);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Type", this.a);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = var1.f("Type");
	}

	public void a(bms var1, List var2, Random var3) {
		this.a((bmh) var1, var2, var3, 4, 1);
		this.b((bmh) var1, var2, var3, 1, 4);
		this.c((bmh) var1, var2, var3, 1, 4);
	}

	public static bme a(List var0, Random var1, int var2, int var3, int var4, ej var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -4, -1, 0, 11, 7, 11, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bme(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 10, 6, 10, true, var2, blr.c());
			this.a(var1, var2, var3, this.d, 4, 1, 0);
			this.a(var1, var3, 4, 1, 10, 6, 3, 10, aty.a.P(), aty.a.P(), false);
			this.a(var1, var3, 0, 1, 4, 0, 3, 6, aty.a.P(), aty.a.P(), false);
			this.a(var1, var3, 10, 1, 4, 10, 3, 6, aty.a.P(), aty.a.P(), false);
			int var4;
			switch (this.a) {
				case 0:
					this.a(var1, aty.bf.P(), 5, 1, 5, var3);
					this.a(var1, aty.bf.P(), 5, 2, 5, var3);
					this.a(var1, aty.bf.P(), 5, 3, 5, var3);
					this.a(var1, aty.aa.P(), 4, 3, 5, var3);
					this.a(var1, aty.aa.P(), 6, 3, 5, var3);
					this.a(var1, aty.aa.P(), 5, 3, 4, var3);
					this.a(var1, aty.aa.P(), 5, 3, 6, var3);
					this.a(var1, aty.U.P(), 4, 1, 4, var3);
					this.a(var1, aty.U.P(), 4, 1, 5, var3);
					this.a(var1, aty.U.P(), 4, 1, 6, var3);
					this.a(var1, aty.U.P(), 6, 1, 4, var3);
					this.a(var1, aty.U.P(), 6, 1, 5, var3);
					this.a(var1, aty.U.P(), 6, 1, 6, var3);
					this.a(var1, aty.U.P(), 5, 1, 4, var3);
					this.a(var1, aty.U.P(), 5, 1, 6, var3);
					break;
				case 1:
					for (var4 = 0; var4 < 5; ++var4) {
						this.a(var1, aty.bf.P(), 3, 1, 3 + var4, var3);
						this.a(var1, aty.bf.P(), 7, 1, 3 + var4, var3);
						this.a(var1, aty.bf.P(), 3 + var4, 1, 3, var3);
						this.a(var1, aty.bf.P(), 3 + var4, 1, 7, var3);
					}

					this.a(var1, aty.bf.P(), 5, 1, 5, var3);
					this.a(var1, aty.bf.P(), 5, 2, 5, var3);
					this.a(var1, aty.bf.P(), 5, 3, 5, var3);
					this.a(var1, aty.i.P(), 5, 4, 5, var3);
					break;
				case 2:
					for (var4 = 1; var4 <= 9; ++var4) {
						this.a(var1, aty.e.P(), 1, 3, var4, var3);
						this.a(var1, aty.e.P(), 9, 3, var4, var3);
					}

					for (var4 = 1; var4 <= 9; ++var4) {
						this.a(var1, aty.e.P(), var4, 3, 1, var3);
						this.a(var1, aty.e.P(), var4, 3, 9, var3);
					}

					this.a(var1, aty.e.P(), 5, 1, 4, var3);
					this.a(var1, aty.e.P(), 5, 1, 6, var3);
					this.a(var1, aty.e.P(), 5, 3, 4, var3);
					this.a(var1, aty.e.P(), 5, 3, 6, var3);
					this.a(var1, aty.e.P(), 4, 1, 5, var3);
					this.a(var1, aty.e.P(), 6, 1, 5, var3);
					this.a(var1, aty.e.P(), 4, 3, 5, var3);
					this.a(var1, aty.e.P(), 6, 3, 5, var3);

					for (var4 = 1; var4 <= 3; ++var4) {
						this.a(var1, aty.e.P(), 4, var4, 4, var3);
						this.a(var1, aty.e.P(), 6, var4, 4, var3);
						this.a(var1, aty.e.P(), 4, var4, 6, var3);
						this.a(var1, aty.e.P(), 6, var4, 6, var3);
					}

					this.a(var1, aty.aa.P(), 5, 3, 5, var3);

					for (var4 = 2; var4 <= 8; ++var4) {
						this.a(var1, aty.f.P(), 2, 3, var4, var3);
						this.a(var1, aty.f.P(), 3, 3, var4, var3);
						if (var4 <= 3 || var4 >= 7) {
							this.a(var1, aty.f.P(), 4, 3, var4, var3);
							this.a(var1, aty.f.P(), 5, 3, var4, var3);
							this.a(var1, aty.f.P(), 6, 3, var4, var3);
						}

						this.a(var1, aty.f.P(), 7, 3, var4, var3);
						this.a(var1, aty.f.P(), 8, 3, var4, var3);
					}

					this.a(var1, aty.au.a(this.a(aty.au, ej.e.a())), 9, 1, 3, var3);
					this.a(var1, aty.au.a(this.a(aty.au, ej.e.a())), 9, 2, 3, var3);
					this.a(var1, aty.au.a(this.a(aty.au, ej.e.a())), 9, 3, 3, var3);
					this.a(var1, var3, var2, 3, 4, 8, vl.a(b, new vl[] { amk.cd.b(var2) }), 1 + var2.nextInt(4));
			}

			return true;
		}
	}

}
