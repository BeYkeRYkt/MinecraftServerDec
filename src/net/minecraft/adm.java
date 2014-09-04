package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;

public class adm extends adj {

	public adn c;

	public adm(World var1) {
		super(var1);
	}

	public adm(World var1, dt var2, ej var3) {
		super(var1, var2);
		ArrayList var4 = Lists.newArrayList();
		adn[] var5 = adn.values();
		int var6 = var5.length;

		for (int var7 = 0; var7 < var6; ++var7) {
			adn var8 = var5[var7];
			this.c = var8;
			this.a(var3);
			if (this.j()) {
				var4.add(var8);
			}
		}

		if (!var4.isEmpty()) {
			this.c = (adn) var4.get(this.V.nextInt(var4.size()));
		}

		this.a(var3);
	}

	public void b(NBTCompoundTag var1) {
		var1.a("Motive", this.c.B);
		super.b(var1);
	}

	public void a(NBTCompoundTag var1) {
		String var2 = var1.j("Motive");
		adn[] var3 = adn.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			adn var6 = var3[var5];
			if (var6.B.equals(var2)) {
				this.c = var6;
			}
		}

		if (this.c == null) {
			this.c = adn.a;
		}

		super.a(var1);
	}

	public int l() {
		return this.c.C;
	}

	public int m() {
		return this.c.D;
	}

	public void b(Entity var1) {
		if (this.o.Q().b("doTileDrops")) {
			if (var1 instanceof ahd) {
				ahd var2 = (ahd) var1;
				if (var2.by.instabuild) {
					return;
				}
			}

			this.a(new amj(amk.an), 0.0F);
		}
	}

	public void b(double var1, double var3, double var5, float var7, float var8) {
		dt var9 = new dt(var1 - this.s, var3 - this.t, var5 - this.u);
		dt var10 = this.a.a((fd) var9);
		this.b((double) var10.n(), (double) var10.o(), (double) var10.p());
	}
}
