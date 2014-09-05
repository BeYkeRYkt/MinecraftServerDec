package net.minecraft;

import java.util.Iterator;

public class hy extends hj {

	private final String b;

	public hy(String var1) {
		this.b = var1;
	}

	public String g() {
		return this.b;
	}

	public String e() {
		return this.b;
	}

	public hy h() {
		hy var1 = new hy(this.b);
		var1.a(this.b().m());
		Iterator var2 = this.a().iterator();

		while (var2.hasNext()) {
			IJSONComponent var3 = (IJSONComponent) var2.next();
			var1.a(var3.f());
		}

		return var1;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof hy)) {
			return false;
		} else {
			hy var2 = (hy) var1;
			return this.b.equals(var2.g()) && super.equals(var1);
		}
	}

	public String toString() {
		return "TextComponent{text=\'" + this.b + '\'' + ", siblings=" + this.a + ", style=" + this.b() + '}';
	}

	// $FF: synthetic method
	public IJSONComponent f() {
		return this.h();
	}
}
