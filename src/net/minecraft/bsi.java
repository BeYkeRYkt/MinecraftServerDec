package net.minecraft;

import java.util.List;

public class bsi implements bsk {

	private final String j;

	public bsi(String var1) {
		this.j = var1;
		bsk.a.put(var1, this);
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
