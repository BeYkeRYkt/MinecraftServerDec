package net.minecraft;

public class ann extends aju {

	private final atr b;
	private String[] c;

	public ann(atr var1, boolean var2) {
		super(var1);
		this.b = var1;
		if (var2) {
			this.d(0);
			this.a(true);
		}

	}

	public int a(int var1) {
		return var1;
	}

	public ann a(String[] var1) {
		this.c = var1;
		return this;
	}

	public String e_(amj var1) {
		if (this.c == null) {
			return super.e_(var1);
		} else {
			int var2 = var1.i();
			return var2 >= 0 && var2 < this.c.length ? super.e_(var1) + "." + this.c[var2] : super.e_(var1);
		}
	}
}
