package net.minecraft;

public class bcd extends ath {

	public static final bew a = bew.a("power", 0, 15);
	private final int b;

	protected bcd(String var1, bof var2, int var3) {
		super(var2);
		this.j(this.L.b().a(a, Integer.valueOf(0)));
		this.b = var3;
	}

	protected int e(World var1, Position var2) {
		int var3 = Math.min(var1.a(Entity.class, this.a(var2)).size(), this.b);
		if (var3 > 0) {
			float var4 = (float) Math.min(this.b, var3) / (float) this.b;
			return DataTypesConverter.f(var4 * 15.0F);
		} else {
			return 0;
		}
	}

	protected int e(bec var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bec a(bec var1, int var2) {
		return var1.a(a, Integer.valueOf(var2));
	}

	public int a(World var1) {
		return 10;
	}

	public bec a(int var1) {
		return this.P().a(a, Integer.valueOf(var1));
	}

	public int c(bec var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}
