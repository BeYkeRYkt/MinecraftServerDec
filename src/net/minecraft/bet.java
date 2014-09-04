package net.minecraft;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;

public class bet extends bes<Boolean> {

	private final ImmutableSet<Boolean> a = ImmutableSet.of(Boolean.valueOf(true), Boolean.valueOf(false));

	protected bet(String var1) {
		super(var1, Boolean.class);
	}

	public Collection<Boolean> c() {
		return this.a;
	}

	public static bet a(String var0) {
		return new bet(var0);
	}

	public String a(Boolean var1) {
		return var1.toString();
	}
}
