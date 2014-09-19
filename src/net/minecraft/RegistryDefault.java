package net.minecraft;

public class RegistryDefault extends RegistrySimple {

	private final Object a;

	public RegistryDefault(Object var1) {
		this.a = var1;
	}

	public Object getByName(Object var1) {
		Object var2 = super.getByName(var1);
		return var2 == null ? this.a : var2;
	}
}
