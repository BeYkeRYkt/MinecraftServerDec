package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class bji extends bms {

	private List a = Lists.newLinkedList();

	public bji() {
	}

	public bji(int var1, Random var2, int var3, int var4) {
		super(var1);
		this.l = new bjb(var3, 50, var4, var3 + 7 + var2.nextInt(6), 54 + var2.nextInt(6), var4 + 7 + var2.nextInt(6));
	}

	public void a(bms var1, List var2, Random var3) {
		int var4 = this.d();
		int var6 = this.l.d() - 3 - 1;
		if (var6 <= 0) {
			var6 = 1;
		}

		int var5;
		bms var7;
		bjb var8;
		for (var5 = 0; var5 < this.l.c(); var5 += 4) {
			var5 += var3.nextInt(this.l.c());
			if (var5 + 3 > this.l.c()) {
				break;
			}

			var7 = bje.a(var1, var2, var3, this.l.a + var5, this.l.b + var3.nextInt(var6) + 1, this.l.c - 1, ej.c, var4);
			if (var7 != null) {
				var8 = var7.c();
				this.a.add(new bjb(var8.a, var8.b, this.l.c, var8.d, var8.e, this.l.c + 1));
			}
		}

		for (var5 = 0; var5 < this.l.c(); var5 += 4) {
			var5 += var3.nextInt(this.l.c());
			if (var5 + 3 > this.l.c()) {
				break;
			}

			var7 = bje.a(var1, var2, var3, this.l.a + var5, this.l.b + var3.nextInt(var6) + 1, this.l.f + 1, ej.d, var4);
			if (var7 != null) {
				var8 = var7.c();
				this.a.add(new bjb(var8.a, var8.b, this.l.f - 1, var8.d, var8.e, this.l.f));
			}
		}

		for (var5 = 0; var5 < this.l.e(); var5 += 4) {
			var5 += var3.nextInt(this.l.e());
			if (var5 + 3 > this.l.e()) {
				break;
			}

			var7 = bje.a(var1, var2, var3, this.l.a - 1, this.l.b + var3.nextInt(var6) + 1, this.l.c + var5, ej.e, var4);
			if (var7 != null) {
				var8 = var7.c();
				this.a.add(new bjb(this.l.a, var8.b, var8.c, this.l.a + 1, var8.e, var8.f));
			}
		}

		for (var5 = 0; var5 < this.l.e(); var5 += 4) {
			var5 += var3.nextInt(this.l.e());
			if (var5 + 3 > this.l.e()) {
				break;
			}

			var7 = bje.a(var1, var2, var3, this.l.d + 1, this.l.b + var3.nextInt(var6) + 1, this.l.c + var5, ej.f, var4);
			if (var7 != null) {
				var8 = var7.c();
				this.a.add(new bjb(this.l.d - 1, var8.b, var8.c, this.l.d, var8.e, var8.f));
			}
		}

	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, this.l.a, this.l.b, this.l.c, this.l.d, this.l.b, this.l.f, aty.d.P(), aty.a.P(), true);
			this.a(var1, var3, this.l.a, this.l.b + 1, this.l.c, this.l.d, Math.min(this.l.b + 3, this.l.e), this.l.f, aty.a.P(), aty.a.P(), false);
			Iterator var4 = this.a.iterator();

			while (var4.hasNext()) {
				bjb var5 = (bjb) var4.next();
				this.a(var1, var3, var5.a, var5.e - 2, var5.c, var5.d, var5.e, var5.f, aty.a.P(), aty.a.P(), false);
			}

			this.a(var1, var3, this.l.a, this.l.b + 4, this.l.c, this.l.d, this.l.e, this.l.f, aty.a.P(), false);
			return true;
		}
	}

	protected void a(NBTCompoundTag var1) {
		NBTListTag var2 = new NBTListTag();
		Iterator var3 = this.a.iterator();

		while (var3.hasNext()) {
			bjb var4 = (bjb) var3.next();
			var2.addTag((NBTTag) var4.g());
		}

		var1.a("Entrances", (NBTTag) var2);
	}

	protected void b(NBTCompoundTag var1) {
		NBTListTag var2 = var1.c("Entrances", 11);

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			this.a.add(new bjb(var2.getIntArray(var3)));
		}

	}
}
