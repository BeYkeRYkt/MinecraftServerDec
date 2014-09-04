package net.minecraft;

import java.util.Comparator;
import java.util.List;

public class bsa {

	public static final Comparator a = new bsb();
	private final bsd b;
	private final bry c;
	private final String d;
	private int e;
	private boolean f;
	private boolean g;

	public bsa(bsd var1, bry var2, String var3) {
		this.b = var1;
		this.c = var2;
		this.d = var3;
		this.g = true;
	}

	public void a(int var1) {
		if (this.c.c().b()) {
			throw new IllegalStateException("Cannot modify read-only score");
		} else {
			this.c(this.c() + var1);
		}
	}

	public void b(int var1) {
		if (this.c.c().b()) {
			throw new IllegalStateException("Cannot modify read-only score");
		} else {
			this.c(this.c() - var1);
		}
	}

	public void a() {
		if (this.c.c().b()) {
			throw new IllegalStateException("Cannot modify read-only score");
		} else {
			this.a(1);
		}
	}

	public int c() {
		return this.e;
	}

	public void c(int var1) {
		int var2 = this.e;
		this.e = var1;
		if (var2 != var1 || this.g) {
			this.g = false;
			this.f().a(this);
		}

	}

	public bry d() {
		return this.c;
	}

	public String e() {
		return this.d;
	}

	public bsd f() {
		return this.b;
	}

	public boolean g() {
		return this.f;
	}

	public void a(boolean var1) {
		this.f = var1;
	}

	public void a(List var1) {
		this.c(this.c.c().a(var1));
	}

}
