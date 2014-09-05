package net.minecraft;

import org.apache.commons.lang3.Validate;

public class eh extends RegistryMaterials {

	private final Object d;
	private Object e;

	public eh(Object var1) {
		this.d = var1;
	}

	public void a(int var1, Object var2, Object var3) {
		if (this.d.equals(var2)) {
			this.e = var3;
		}

		super.a(var1, var2, var3);
	}

	public void a() {
		Validate.notNull(this.d);
	}

	public Object a(Object var1) {
		Object var2 = super.a(var1);
		return var2 == null ? this.e : var2;
	}

	public Object a(int var1) {
		Object var2 = super.a(var1);
		return var2 == null ? this.e : var2;
	}
}
