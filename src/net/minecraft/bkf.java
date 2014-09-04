package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class bkf extends bjp {

	public bkc b;
	public List c;
	public List d;
	public List e = Lists.newArrayList();

	public bkf() {
	}

	public bkf(Random var1, int var2, int var3) {
		super(var1, var2, var3);
		this.c = Lists.newArrayList();
		bkc[] var4 = bjn.b();
		int var5 = var4.length;

		int var6;
		bkc var7;
		for (var6 = 0; var6 < var5; ++var6) {
			var7 = var4[var6];
			var7.c = 0;
			this.c.add(var7);
		}

		this.d = Lists.newArrayList();
		var4 = bjn.c();
		var5 = var4.length;

		for (var6 = 0; var6 < var5; ++var6) {
			var7 = var4[var6];
			var7.c = 0;
			this.d.add(var7);
		}

	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
	}
}
