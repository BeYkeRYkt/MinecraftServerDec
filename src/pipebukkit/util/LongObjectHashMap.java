package pipebukkit.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LongObjectHashMap<V> implements Iterable<V> {

	private Entry<V>[] table;

	private int count = 0;

	public LongObjectHashMap() {
		this(512);
	}

	@SuppressWarnings("unchecked")
	public LongObjectHashMap(int tableSize) {
		table = (Entry<V>[]) Array.newInstance(Entry.class, tableSize);
	}

	public boolean contains(long key) {
		Entry<V> entry = table[getTableIndex(key)];
		if (entry == null) {
			return false;
		}
		for (;;) {
			if (entry.key == key) {
				return true;
			}
			if (entry.nextEntry == null) {
				return false;
			}
			entry = entry.nextEntry;
		}
	}

	public V get(long key) {
		Entry<V> entry = table[getTableIndex(key)];
		if (entry == null) {
			return null;
		}
		for (;;) {
			if (entry.key == key) {
				return entry.value;
			}
			if (entry.nextEntry == null) {
				return null;
			}
			entry = entry.nextEntry;
		}
	}

	public void put(long key, V value) {
		resizeIfNeeded();
		int index = getTableIndex(key);
		Entry<V> entry = table[index];
		if (entry == null) {
			table[index] = new Entry<V>(key, value);
			count++;
			return;
		}
		for (;;) {
			if (entry.key == key) {
				entry.value = value;
				return;
			}
			if (entry.nextEntry == null) {
				entry.nextEntry = new Entry<V>(key, value);
				count++;
				return;
			}
			entry = entry.nextEntry;
		}
	}

	public void remove(long key) {
		int index = getTableIndex(key);
		Entry<V> entry = table[index];
		if (entry == null) {
			return;
		}
		if (entry.nextEntry == null) {
			if (entry.key == key) {
				table[index] = null;
				count--;
			}
			return;
		}
		Entry<V> prevEntry = entry;
		entry = entry.nextEntry;
		for (;;) {
			if (entry.key == key) {
				prevEntry.nextEntry = entry.nextEntry;
				count--;
				entry.nextEntry = entry;
				return;
			}
			if (entry.nextEntry == null) {
				return;
			}
			prevEntry = entry;
			entry = entry.nextEntry;
		}
	}

	public int count() {
		return count;
	}

	private int getTableIndex(long key) {
		key = key ^= key >>> 20 ^ key >>> 12;
		key = key ^ key >>> 7 ^ key >>> 4;
		key = key ^ key >>> 32;
		return (int) (key & (table.length - 1));
	}

	private void resizeIfNeeded() {
		if (count > table.length * 2) {
			LongObjectHashMap<V> resizedMap = new LongObjectHashMap<V>((int) (count));
			for (Entry<V> entry: table) {
				if (entry == null) {
					continue;
				}
				do {
					resizedMap.put(entry.key, entry.value);
				} while ((entry = entry.nextEntry) != null);
			}
			this.count = resizedMap.count;
			this.table = resizedMap.table;
		}
	}

	private static class Entry<V> {

		protected long key;
		protected V value;

		protected Entry<V> nextEntry;

		public Entry(long key, V value) {
			this.key = key;
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

		@Override
		public boolean hasNext() {
			return iteratedElements < count;
		}

		@Override
		public V next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			iteratedElements++;
			if (prevReturnedEntry == null) {
				for (;;) {
					prevReturnedEntry = table[tableIndex];
					if (prevReturnedEntry == null) {
						tableIndex++;
					} else {
						return prevReturnedEntry.value;
					}
				}
			}
			if (prevReturnedEntry.nextEntry != null) {
				prevReturnedEntry = prevReturnedEntry.nextEntry;
				return prevReturnedEntry.value;
			}
			for (;;) {
				tableIndex++;
				prevReturnedEntry = table[tableIndex];
				if (prevReturnedEntry != null) {
					return prevReturnedEntry.value;
				}
			}
		}

	}

}
