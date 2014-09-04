package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class bnk extends bnp {

	public arz a;
	public boolean b;
	public int c;
	public bne d;
	public List e;
	public List f = Lists.newArrayList();
	public List g = Lists.newArrayList();

	public bnk() {
	}

	public bnk(arz var1, int var2, Random var3, int var4, int var5, List var6, int var7) {
		super((bnk) null, 0, var3, var4, var5);
		this.a = var1;
		this.e = var6;
		this.c = var7;
		arm var8 = var1.a(new dt(var4, 0, var5), arm.ad);
		this.b = var8 == arm.r || var8 == arm.G;
		this.a(this.b);
	}

	public arz e() {
		return this.a;
	}
}
