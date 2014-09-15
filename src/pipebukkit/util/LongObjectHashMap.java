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

	public boolean contains(long hash) {
		Entry<V> entry = table[getTableIndex(hash)];
		if (entry == null) {
			return false;
		}
		for (;;) {
			if (entry.hash == hash) {
				return true;
			}
			if (entry.nextEntry == null) {
				return false;
			}
			entry = entry.nextEntry;
		}
	}

	public V get(long hash) {
		Entry<V> entry = table[getTableIndex(hash)];
		if (entry == null) {
			return null;
		}
		for (;;) {
			if (entry.hash == hash) {
				return entry.value;
			}
			if (entry.nextEntry == null) {
				return null;
			}
			entry = entry.nextEntry;
		}
	}

	public void put(long hash, V value) {
		resizeIfNeeded();
		int index = getTableIndex(hash);
		Entry<V> entry = table[index];
		if (entry == null) {
			table[index] = new Entry<V>(hash, value);
			count++;
			return;
		}
		for (;;) {
			if (entry.hash == hash) {
				entry.value = value;
				return;
			}
			if (entry.nextEntry == null) {
				entry.nextEntry = new Entry<V>(hash, value);
				count++;
				return;
			}
			entry = entry.nextEntry;
		}
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
				count--;
			}
			return;
		}
		Entry<V> prevEntry = entry;
		entry = entry.nextEntry;
		for (;;) {
			if (entry.hash == hash) {
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

	private int getTableIndex(long hash) {
		return (int) (hash & (table.length - 1));
	}

	private void resizeIfNeeded() {
		if (count > table.length * 2) {
			LongObjectHashMap<V> resizedMap = new LongObjectHashMap<V>((int) (count));
			for (Entry<V> entry: table) {
				if (entry == null) {
					continue;
				}
				do {
					resizedMap.put(entry.hash, entry.value);
				} while ((entry = entry.nextEntry) != null);
			}
			this.count = resizedMap.count;
			this.table = resizedMap.table;
		}
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
