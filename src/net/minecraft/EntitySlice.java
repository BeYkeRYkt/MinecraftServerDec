package net.minecraft;

import com.google.common.collect.AbstractIterator;
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

	public void registerClass(Class<T> clazz) {
		Iterator<T> it = this.values.get(this.serachSuperClass(clazz, false)).iterator();

		while (it.hasNext()) {
			T value = it.next();
			if (clazz.isAssignableFrom(value.getClass())) {
				this.values.put(clazz, value);
			}
		}

		this.registeredClasses.add(clazz);
	}

	@SuppressWarnings("unchecked")
	protected Class<T> serachSuperClass(Class<T> var1, boolean registerIfNotFound) {
		Iterator<Class<?>> classes = ClassUtils.hierarchy(var1, ClassUtils.Interfaces.INCLUDE).iterator();

		Class<?> clazz;
		do {
			if (!classes.hasNext()) {
				throw new IllegalArgumentException("Don\'t know how to search for " + var1);
			}

			clazz = classes.next();
		} while (!this.registeredClasses.contains(clazz));

		if (clazz == this.mainClazz && registerIfNotFound) {
			this.registerClass(var1);
		}

		return (Class<T>) clazz;
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
				Iterator<T> iterators = values.get(serachSuperClass(clazz, true)).iterator();
				return Iterators.filter(iterators, clazz);
			}
		};
	}

	public Iterator<T> iterator() {
		final Iterator<T> iterator = this.values.get(this.mainClazz).iterator();
		return new AbstractIterator<T>() {
			protected T computeNext() {
				return !iterator.hasNext() ? endOfData() : iterator.next();
			}
		};
	}

	public int size() {
		return this.values.get(this.mainClazz).size();
	}

}
