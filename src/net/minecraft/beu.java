package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;

public class beu extends bev {

	protected beu(String var1, Collection var2) {
		super(var1, PaintingDirection.class, var2);
	}

	public static beu a(String var0) {
		return a(var0, Predicates.alwaysTrue());
	}

	public static beu a(String var0, Predicate var1) {
		return a(var0, Collections2.filter(Lists.newArrayList((Object[]) PaintingDirection.values()), var1));
	}

	public static beu a(String var0, Collection var1) {
		return new beu(var0, var1);
	}
}
