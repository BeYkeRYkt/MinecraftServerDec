package net.minecraft;

import java.util.Random;

public class blo extends bln {

	private boolean e;

	public blo() {
	}

	public blo(Random var1, int var2, int var3) {
		super(var1, var2, 64, var3, 7, 5, 9);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Witch", this.e);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.e = var1.getBoolean("Witch");
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (!this.a(var1, var3, 0)) {
			return false;
		} else {
			this.a(var1, var3, 1, 1, 1, 5, 1, 7, aty.f.a(ayx.b.a()), aty.f.a(ayx.b.a()), false);
			this.a(var1, var3, 1, 4, 2, 5, 4, 7, aty.f.a(ayx.b.a()), aty.f.a(ayx.b.a()), false);
			this.a(var1, var3, 2, 1, 0, 4, 1, 0, aty.f.a(ayx.b.a()), aty.f.a(ayx.b.a()), false);
			this.a(var1, var3, 2, 2, 2, 3, 3, 2, aty.f.a(ayx.b.a()), aty.f.a(ayx.b.a()), false);
			this.a(var1, var3, 1, 2, 3, 1, 3, 6, aty.f.a(ayx.b.a()), aty.f.a(ayx.b.a()), false);
			this.a(var1, var3, 5, 2, 3, 5, 3, 6, aty.f.a(ayx.b.a()), aty.f.a(ayx.b.a()), false);
			this.a(var1, var3, 2, 2, 7, 4, 3, 7, aty.f.a(ayx.b.a()), aty.f.a(ayx.b.a()), false);
			this.a(var1, var3, 1, 0, 2, 1, 3, 2, aty.r.P(), aty.r.P(), false);
			this.a(var1, var3, 5, 0, 2, 5, 3, 2, aty.r.P(), aty.r.P(), false);
			this.a(var1, var3, 1, 0, 7, 1, 3, 7, aty.r.P(), aty.r.P(), false);
			this.a(var1, var3, 5, 0, 7, 5, 3, 7, aty.r.P(), aty.r.P(), false);
			this.a(var1, aty.aO.P(), 2, 3, 2, var3);
			this.a(var1, aty.aO.P(), 3, 3, 7, var3);
			this.a(var1, aty.a.P(), 1, 3, 4, var3);
			this.a(var1, aty.a.P(), 5, 3, 4, var3);
			this.a(var1, aty.a.P(), 5, 3, 5, var3);
			this.a(var1, aty.ca.P().a(BlockFlowerPot.b, awf.r), 1, 3, 5, var3);
			this.a(var1, aty.ai.P(), 3, 2, 6, var3);
			this.a(var1, aty.bE.P(), 4, 2, 6, var3);
			this.a(var1, aty.aO.P(), 1, 2, 1, var3);
			this.a(var1, aty.aO.P(), 5, 2, 1, var3);
			int var4 = this.a(aty.ad, 3);
			int var5 = this.a(aty.ad, 1);
			int var6 = this.a(aty.ad, 0);
			int var7 = this.a(aty.ad, 2);
			this.a(var1, var3, 0, 4, 1, 6, 4, 1, aty.bU.a(var4), aty.bU.a(var4), false);
			this.a(var1, var3, 0, 4, 2, 0, 4, 7, aty.bU.a(var6), aty.bU.a(var6), false);
			this.a(var1, var3, 6, 4, 2, 6, 4, 7, aty.bU.a(var5), aty.bU.a(var5), false);
			this.a(var1, var3, 0, 4, 8, 6, 4, 8, aty.bU.a(var7), aty.bU.a(var7), false);

			int var8;
			int var9;
			for (var8 = 2; var8 <= 7; var8 += 5) {
				for (var9 = 1; var9 <= 5; var9 += 4) {
					this.b(var1, aty.r.P(), var9, -1, var8, var3);
				}
			}

			if (!this.e) {
				var8 = this.a(2, 5);
				var9 = this.d(2);
				int var10 = this.b(2, 5);
				if (var3.b((fd) (new Position(var8, var9, var10)))) {
					this.e = true;
					agi var11 = new agi(var1);
					var11.b((double) var8 + 0.5D, (double) var9, (double) var10 + 0.5D, 0.0F, 0.0F);
					var11.a(var1.E(new Position(var8, var9, var10)), (xq) null);
					var1.d((Entity) var11);
				}
			}

			return true;
		}
	}
}
