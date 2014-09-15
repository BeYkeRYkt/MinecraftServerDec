package net.minecraft;

class LongHashMapEntry<T> {

	final long longHash;
	T b;
	LongHashMapEntry<T> c;
	final int d;

	LongHashMapEntry(int var1, long var2, T var4, LongHashMapEntry<T> var5) {
		this.b = var4;
		this.c = var5;
		this.longHash = var2;
		this.d = var1;
	}

	public final long a() {
		return this.longHash;
	}

	public final Object b() {
		return this.b;
	}

	public final boolean equals(Object obj) {
		if (!(obj instanceof LongHashMapEntry)) {
			return false;
		} else {
			LongHashMapEntry<T> var2 = (LongHashMapEntry<T>) obj;
			Long var3 = Long.valueOf(this.a());
			Long var4 = Long.valueOf(var2.a());
			if (var3 == var4 || var3 != null && var3.equals(var4)) {
				Object var5 = this.b();
				Object var6 = var2.b();
				if (var5 == var6 || var5 != null && var5.equals(var6)) {
					return true;
				}
			}

			return false;
		}
	}

	public final int hashCode() {
		return LongHashMap.f(this.longHash);
	}

	public final String toString() {
		return this.a() + "=" + this.b();
	}

}
