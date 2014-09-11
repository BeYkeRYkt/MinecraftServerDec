package pipebukkit.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LongObjectHashMap<V> implements Iterable<V> {

	private Entry<V>[] table;

	private int size = 0;

	@SuppressWarnings("unchecked")
	public LongObjectHashMap() {
		table = (Entry<V>[]) Array.newInstance(Entry.class, 8192);
	}

	public V get(long hash) {
		Entry<V> entry = table[getTableIndex(hash)];
		if (entry == null) {
			return null;
		}
		do {
			if (entry.hash == hash) {
				return entry.value;
			}
		} while ((entry = entry.nextEntry) != null);
		return null;
	}

	public void put(long hash, V value) {
		int index = getTableIndex(hash);
		Entry<V> entry = table[index];
		if (entry == null) {
			table[index] = new Entry<V>(hash, value);
			return;
		}
		for (;entry.nextEntry != null; entry = entry.nextEntry) {
			if (entry.hash == hash) {
				entry.value = value;
				return;
			}
		}
		entry.nextEntry = new Entry<V>(hash, value);
		size++;
	}

	public boolean contains(long hash) {
		Entry<V> entry = table[getTableIndex(hash)];
		if (entry == null) {
			return false;
		}
		do {
			if (entry.hash == hash) {
				return true;
			}
		} while ((entry = entry.nextEntry) != null);
		return false;
	}

	public void remove(long hash) {
		int index = getTableIndex(hash);
		Entry<V> entry = table[index];
		if (entry == null) {
			return;
		}
		if (entry.nextEntry == null) {
			if (entry.hash == hash) {
				table[index] = null;
				size--;
			}
			return;
		}
		Entry<V> prevEntry = entry;
		entry = entry.nextEntry;
		do {
			if (entry.hash == hash) {
				prevEntry.nextEntry = entry.nextEntry;
				size--;
				return;
			}
			prevEntry = entry;
			entry = entry.nextEntry;
		} while (entry != null);
	}

	public int count() {
		return size;
	}

	private int getTableIndex(long hash) {
		return (int) (hash & (table.length - 1));
	}

	private static class Entry<V> {

		protected long hash;
		protected V value;

		protected Entry<V> nextEntry;

		public Entry(long hash, V value) {
			this.hash = hash;
			this.value = value;
		}

	}

	@Override
	public Iterator<V> iterator() {
		return new LongObjectHashMapIterator();
	}

	private class LongObjectHashMapIterator implements Iterator<V> {

		private int iteratedElements = 0;
		private int tableIndex = 0;
		private Entry<V> prevReturnedEntry = null;
		private boolean removeCalled = false;

		@Override
		public boolean hasNext() {
			return iteratedElements < size;
		}

		@Override
		public V next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			removeCalled = false;
			iteratedElements++;
			if (prevReturnedEntry == null) {
				while ((prevReturnedEntry = table[tableIndex]) == null) {
					tableIndex++;
				}
				return prevReturnedEntry.value;
			}
			if (prevReturnedEntry.nextEntry != null) {
				prevReturnedEntry = prevReturnedEntry.nextEntry;
				return prevReturnedEntry.value;
			}
			do {
				tableIndex++;
			} while ((prevReturnedEntry = table[tableIndex]) == null);
			return prevReturnedEntry.value;
		}

		@Override
		public void remove() {
			if (prevReturnedEntry == null || removeCalled) {
				throw new IllegalStateException();
			}
			LongObjectHashMap.this.remove(prevReturnedEntry.hash);
			removeCalled = true;
			iteratedElements--;
		}

	}

}
