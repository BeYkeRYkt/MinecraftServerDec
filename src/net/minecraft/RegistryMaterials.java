package net.minecraft;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Iterator;
import java.util.Map;

public class RegistryMaterials extends RegistrySimple implements Registry {

	protected final RegistryID a = new RegistryID();
	protected final Map b;

	public RegistryMaterials() {
		this.b = ((BiMap) this.c).inverse();
	}

	public void register(int var1, Object var2, Object var3) {
		this.a.register(var3, var1);
		this.a(var2, var3);
	}

	protected Map b() {
		return HashBiMap.create();
	}

	public Object getByName(Object var1) {
		return super.getByName(var1);
	}

	public Object c(Object var1) {
		return this.b.get(var1);
	}

	public boolean d(Object var1) {
		return super.d(var1);
	}

	public int getBlockId(Object var1) {
		return this.a.getId(var1);
	}

	public Object getById(int var1) {
		return this.a.getObject(var1);
	}

	public Iterator<Object> iterator() {
		return this.a.iterator();
	}

}
