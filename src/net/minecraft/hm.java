package net.minecraft;

public class hm {

	private final hn a;
	private final String b;

	public hm(hn var1, String var2) {
		this.a = var1;
		this.b = var2;
	}

	public hn a() {
		return this.a;
	}

	public String b() {
		return this.b;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (var1 != null && this.getClass() == var1.getClass()) {
			hm var2 = (hm) var1;
			if (this.a != var2.a) {
				return false;
			} else {
				if (this.b != null) {
					if (!this.b.equals(var2.b)) {
						return false;
					}
				} else if (var2.b != null) {
					return false;
				}

				return true;
			}
		} else {
			return false;
		}
	}

	public String toString() {
		return "ClickEvent{action=" + this.a + ", value=\'" + this.b + '\'' + '}';
	}

	public int hashCode() {
		int var1 = this.a.hashCode();
		var1 = 31 * var1 + (this.b != null ? this.b.hashCode() : 0);
		return var1;
	}
}
