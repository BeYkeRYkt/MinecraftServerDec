package net.minecraft;

import java.util.List;
import java.util.Random;

public class bmi extends bmk {

	private boolean a;
	private boolean b;

	public bmi() {
	}

	public bmi(int var1, Random var2, bjb var3, PaintingDirection var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
		this.a = var2.nextInt(2) == 0;
		this.b = var2.nextInt(2) == 0;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Left", this.a);
		var1.put("Right", this.b);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = var1.getBoolean("Left");
		this.b = var1.getBoolean("Right");
	}

	public void a(bms var1, List var2, Random var3) {
		this.a((bmh) var1, var2, var3, 1, 1);
		if (this.a) {
			this.b((bmh) var1, var2, var3, 1, 2);
		}

		if (this.b) {
			this.c((bmh) var1, var2, var3, 1, 2);
		}

	}

	public static bmi a(List var0, Random var1, int var2, int var3, int var4, PaintingDirection var5, int var6) {
		bjb var7 = bjb.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
		return a(var7) && bms.a(var0, var7) == null ? new bmi(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, blr.c());
			this.a(var1, var2, var3, this.d, 1, 1, 0);
			this.a(var1, var2, var3, bml.a, 1, 1, 6);
			this.a(var1, var3, var2, 0.1F, 1, 2, 1, aty.aa.P());
			this.a(var1, var3, var2, 0.1F, 3, 2, 1, aty.aa.P());
			this.a(var1, var3, var2, 0.1F, 1, 2, 5, aty.aa.P());
			this.a(var1, var3, var2, 0.1F, 3, 2, 5, aty.aa.P());
			if (this.a) {
				this.a(var1, var3, 0, 1, 2, 0, 3, 4, aty.a.P(), aty.a.P(), false);
			}

			if (this.b) {
				this.a(var1, var3, 4, 1, 2, 4, 3, 4, aty.a.P(), aty.a.P(), false);
			}

			return true;
		}
	}
}
