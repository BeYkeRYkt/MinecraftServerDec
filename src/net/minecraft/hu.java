package net.minecraft;

import java.util.Iterator;

public class hu extends hj {

	private final String b;

	public hu(String var1) {
		this.b = var1;
	}

	public String g() {
		return this.b;
	}

	public String e() {
		return this.b;
	}

	public hu h() {
		hu var1 = new hu(this.b);
		var1.a(this.b().m());
		Iterator var2 = this.a().iterator();

		while (var2.hasNext()) {
			ho var3 = (ho) var2.next();
			var1.a(var3.f());
		}

		return var1;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof hu)) {
			return false;
		} else {
			hu var2 = (hu) var1;
			return this.b.equals(var2.b) && super.equals(var1);
		}
	}

	public String toString() {
		return "SelectorComponent{pattern=\'" + this.b + '\'' + ", siblings=" + this.a + ", style=" + this.b() + '}';
	}

	// $FF: synthetic method
	public ho f() {
		return this.h();
	}
}
