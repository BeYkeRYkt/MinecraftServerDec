package net.minecraft;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class eb {

	public static Iterable a(Class var0, Iterable var1) {
		return new ee(var0, (Iterable[]) b(Iterable.class, var1), (ec) null);
	}

	public static Iterable a(Iterable var0) {
		return b(a(Object.class, var0));
	}

	private static Iterable b(Iterable var0) {
		return Iterables.transform(var0, new ed((ec) null));
	}

	private static Object[] b(Class var0, Iterable var1) {
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Object var4 = var3.next();
			var2.add(var4);
		}

		return (Object[]) var2.toArray(b(var0, var2.size()));
	}

	private static Object[] b(Class var0, int var1) {
		return (Object[]) ((Object[]) Array.newInstance(var0, var1));
	}

	// $FF: synthetic method
	static Object[] a(Class var0, int var1) {
		return b(var0, var1);
	}
}
