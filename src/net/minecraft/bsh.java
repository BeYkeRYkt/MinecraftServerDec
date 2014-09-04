package net.minecraft;

import java.util.List;

public class bsh implements bsk {

	private final String j;

	public bsh(String var1, FormattingCode var2) {
		this.j = var1 + var2.e();
		bsk.a.put(this.j, this);
	}

	public String a() {
		return this.j;
	}

	public int a(List var1) {
		return 0;
	}

	public boolean b() {
		return false;
	}

	public bsl c() {
		return bsl.a;
	}
}
