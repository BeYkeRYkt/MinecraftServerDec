package net.minecraft;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.ClassUtils;

public class EntitySlice<T> extends AbstractSet<T> {

	private final Class<T> mainClazz;

	private final Multimap<Class<T>, T> values = HashMultimap.create();
	private final Set<Class<T>> registeredClasses = Sets.newIdentityHashSet();

	public EntitySlice(Class<T> mainClass) {
		this.mainClazz = mainClass;
		this.registeredClasses.add(mainClass);
	}

	public void a(Class<T> clazz) {
		Iterator<T> it = this.values.get(this.a(clazz, false)).iterator();

		while (it.hasNext()) {
			T var3 = it.next();
			if (clazz.isAssignableFrom(var3.getClass())) {
				this.values.put(clazz, var3);
			}
		}

		this.registeredClasses.add(clazz);
	}

	protected Class a(Class var1, boolean var2) {
		Iterator var3 = ClassUtils.hierarchy(var1, ClassUtils.Interfaces.INCLUDE).iterator();

		Class var4;
		do {
			if (!var3.hasNext()) {
				throw new IllegalArgumentException("Don\'t know how to search for " + var1);
			}

			var4 = (Class) var3.next();
		} while (!this.registeredClasses.contains(var4));

		if (var4 == this.mainClazz && var2) {
			this.a(var1);
		}

		return var4;
	}

	public boolean add(T value) {
		for (Class<T> registeredClass : registeredClasses) {
			if (registeredClass.isAssignableFrom(value.getClass())) {
				values.put(registeredClass, value);
			}
		}
		return true;
	}

	public boolean remove(Object value) {
		boolean wasSomethingRemoved = false;
		for (Class<T> registeredClass : registeredClasses) {
			if (registeredClass.isAssignableFrom(value.getClass())) {
				wasSomethingRemoved |= this.values.remove(registeredClass, value);
			}
		}
		return wasSomethingRemoved;
	}

	public Iterable<T> getValues(final Class<T> clazz) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				Iterator<T> iterators = values.get(a(clazz, true)).iterator();
				return Iterators.filter(iterators, clazz);
			}
		};
	}

	public Iterator iterator() {
		Iterator var1 = this.values.get(this.mainClazz).iterator();
		return new ue(this, var1);
	}

	public int size() {
		return this.values.get(this.mainClazz).size();
	}

}
