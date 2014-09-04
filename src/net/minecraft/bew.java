package net.minecraft;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;

public class bew extends bes<Integer> {

	private final ImmutableSet<Integer> a;

	protected bew(String var1, int var2, int var3) {
		super(var1, Integer.class);
		if (var2 < 0) {
			throw new IllegalArgumentException("Min value of " + var1 + " must be 0 or greater");
		} else if (var3 <= var2) {
			throw new IllegalArgumentException("Max value of " + var1 + " must be greater than min (" + var2 + ")");
		} else {
			HashSet var4 = Sets.newHashSet();

			for (int var5 = var2; var5 <= var3; ++var5) {
				var4.add(Integer.valueOf(var5));
			}

			this.a = ImmutableSet.copyOf((Collection) var4);
		}
	}

	public Collection c() {
		return this.a;
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (var1 != null && this.getClass() == var1.getClass()) {
			if (!super.equals(var1)) {
				return false;
			} else {
				bew var2 = (bew) var1;
				return this.a.equals(var2.a);
			}
		} else {
			return false;
		}
	}

	public int hashCode() {
		int var1 = super.hashCode();
		var1 = 31 * var1 + this.a.hashCode();
		return var1;
	}

	public static bew a(String var0, int var1, int var2) {
		return new bew(var0, var1, var2);
	}

	public String a(Integer var1) {
		return var1.toString();
	}
}
