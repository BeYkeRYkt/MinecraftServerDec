package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class bev extends bes<Enum> {

	private final ImmutableSet a;
	private final Map b = Maps.newHashMap();

	protected bev(String var1, Class var2, Collection var3) {
		super(var1, var2);
		this.a = ImmutableSet.copyOf(var3);
		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			Enum var5 = (Enum) var4.next();
			String var6 = ((va) var5).l();
			if (this.b.containsKey(var6)) {
				throw new IllegalArgumentException("Multiple values have the same name \'" + var6 + "\'");
			}

			this.b.put(var6, var5);
		}

	}

	public Collection c() {
		return this.a;
	}

	public String a(Enum var1) {
		return ((va) var1).l();
	}

	public static bev a(String var0, Class var1) {
		return a(var0, var1, Predicates.alwaysTrue());
	}

	public static bev a(String var0, Class var1, Predicate var2) {
		return a(var0, var1, Collections2.filter(Lists.newArrayList(var1.getEnumConstants()), var2));
	}

	public static bev a(String var0, Class var1, Enum... var2) {
		return a(var0, var1, (Collection) Lists.newArrayList((Object[]) var2));
	}

	public static bev a(String var0, Class var1, Collection var2) {
		return new bev(var0, var1, var2);
	}

}
