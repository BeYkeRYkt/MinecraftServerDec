package net.minecraft;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class bmx extends bmv {

	private boolean c;

	public bmx() {
	}

	public bmx(World var1, Random var2, int var3, int var4, int var5) {
		super(var3, var4);
		List var6 = bmy.a(var2, var5);
		bnk var7 = new bnk(var1.v(), 0, var2, (var3 << 4) + 2, (var4 << 4) + 2, var6, var5);
		this.a.add(var7);
		var7.a(var7, this.a, var2);
		List var8 = var7.g;
		List var9 = var7.f;

		int var10;
		while (!var8.isEmpty() || !var9.isEmpty()) {
			bms var11;
			if (var8.isEmpty()) {
				var10 = var2.nextInt(var9.size());
				var11 = (bms) var9.remove(var10);
				var11.a((bms) var7, (List) this.a, var2);
			} else {
				var10 = var2.nextInt(var8.size());
				var11 = (bms) var8.remove(var10);
				var11.a((bms) var7, (List) this.a, var2);
			}
		}

		this.c();
		var10 = 0;
		Iterator var13 = this.a.iterator();

		while (var13.hasNext()) {
			bms var12 = (bms) var13.next();
			if (!(var12 instanceof bno)) {
				++var10;
			}
		}

		this.c = var10 > 2;
	}

	public boolean d() {
		return this.c;
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.a("Valid", this.c);
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		this.c = var1.n("Valid");
	}
}
