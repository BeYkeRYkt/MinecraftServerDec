package net.minecraft;

import java.util.List;
import java.util.Random;

public class bjk extends bmv {

	public bjk() {
	}

	public bjk(World var1, Random var2, int var3, int var4) {
		super(var3, var4);
		bji var5 = new bji(0, var2, (var3 << 4) + 2, (var4 << 4) + 2);
		this.a.add(var5);
		var5.a((bms) var5, (List) this.a, var2);
		this.c();
		this.a(var1, var2, 10);
	}
}
