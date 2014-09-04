package net.minecraft;

public class ei extends fb {

	private final Object a;

	public ei(Object var1) {
		this.a = var1;
	}

	public Object a(Object var1) {
		Object var2 = super.a(var1);
		return var2 == null ? this.a : var2;
	}
}
