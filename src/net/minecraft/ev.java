package net.minecraft;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Iterator;
import java.util.Map;

public class ev extends fb implements eq {

	protected final er a = new er();
	protected final Map b;

	public ev() {
		this.b = ((BiMap) this.c).inverse();
	}

	public void a(int var1, Object var2, Object var3) {
		this.a.a(var3, var1);
		this.a(var2, var3);
	}

	protected Map b() {
		return HashBiMap.create();
	}

	public Object a(Object var1) {
		return super.a(var1);
	}

	public Object c(Object var1) {
		return this.b.get(var1);
	}

	public boolean d(Object var1) {
		return super.d(var1);
	}

	public int b(Object var1) {
		return this.a.b(var1);
	}

	public Object a(int var1) {
		return this.a.a(var1);
	}

	public Iterator iterator() {
		return this.a.iterator();
	}
}
