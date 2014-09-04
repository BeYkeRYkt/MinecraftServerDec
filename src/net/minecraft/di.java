package net.minecraft;

public class di extends Exception {

	private final Object[] a;

	public di(String var1, Object... var2) {
		super(var1);
		this.a = var2;
	}

	public Object[] a() {
		return this.a;
	}
}
