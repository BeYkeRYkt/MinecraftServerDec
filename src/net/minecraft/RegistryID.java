package net.minecraft;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public class RegistryID implements Registry {

	private final IdentityHashMap<Object, Integer> objToId = new IdentityHashMap<Object, Integer>(512);
	private final List<Object> idToObj = Lists.newArrayList();

	public void register(Object obj, int id) {
		this.objToId.put(obj, id);

		while (this.idToObj.size() <= id) {
			this.idToObj.add(null);
		}

		this.idToObj.set(id, obj);
	}

	public int getId(Object obj) {
		Integer integer = this.objToId.get(obj);
		return integer == null ? -1 : integer.intValue();
	}

	public final Object getObject(int id) {
		return id >= 0 && id < this.idToObj.size() ? this.idToObj.get(id) : null;
	}

	public Iterator<Object> iterator() {
		return Iterators.filter(this.idToObj.iterator(), Predicates.notNull());
	}

}
