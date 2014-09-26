package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

public class IntCache {

	private static int cacheSize = 256;
	private static List<int[]> tcache = Lists.newArrayList();
	private static List<int[]> tallocated = Lists.newArrayList();
	private static List<int[]> cache = Lists.newArrayList();
	private static List<int[]> allocated = Lists.newArrayList();

	public static synchronized int[] allocate(int size) {
		int[] array;
		if (size <= 256) {
			if (tcache.isEmpty()) {
				array = new int[256];
				tallocated.add(array);
				return array;
			} else {
				array = (int[]) tcache.remove(tcache.size() - 1);
				tallocated.add(array);
				return array;
			}
		} else if (size > cacheSize) {
			cacheSize = size;
			cache.clear();
			allocated.clear();
			array = new int[cacheSize];
			allocated.add(array);
			return array;
		} else if (cache.isEmpty()) {
			array = new int[cacheSize];
			allocated.add(array);
			return array;
		} else {
			array = (int[]) cache.remove(cache.size() - 1);
			allocated.add(array);
			return array;
		}
	}

	public static synchronized void deallocate() {
		if (!cache.isEmpty()) {
			cache.remove(cache.size() - 1);
		}

		if (!tcache.isEmpty()) {
			tcache.remove(tcache.size() - 1);
		}

		cache.addAll(allocated);
		tcache.addAll(tallocated);
		allocated.clear();
		tallocated.clear();
	}

	public static synchronized String getInfo() {
		return "cache: " + cache.size() + ", tcache: " + tcache.size() + ", allocated: " + allocated.size() + ", tallocated: " + tallocated.size();
	}

}
