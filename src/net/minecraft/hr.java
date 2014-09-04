package net.minecraft;

public class hr {

	private final hs a;
	private final ho b;

	public hr(hs var1, ho var2) {
		this.a = var1;
		this.b = var2;
	}

	public hs a() {
		return this.a;
	}

	public ho b() {
		return this.b;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (var1 != null && this.getClass() == var1.getClass()) {
			hr var2 = (hr) var1;
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
		return "HoverEvent{action=" + this.a + ", value=\'" + this.b + '\'' + '}';
	}

	public int hashCode() {
		int var1 = this.a.hashCode();
		var1 = 31 * var1 + (this.b != null ? this.b.hashCode() : 0);
		return var1;
	}
}
