package net.minecraft;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class ef extends UnmodifiableIterator {

	private int a;
	private final Iterable[] b;
	private final Iterator[] c;
	private final Object[] d;

	private ef(Class var1, Iterable[] var2) {
		this.a = -2;
		this.b = var2;
		this.c = (Iterator[]) eb.a(Iterator.class, this.b.length);

		for (int var3 = 0; var3 < this.b.length; ++var3) {
			this.c[var3] = var2[var3].iterator();
		}

		this.d = eb.a(var1, this.c.length);
	}

	private void b() {
		this.a = -1;
		Arrays.fill(this.c, (Object) null);
		Arrays.fill(this.d, (Object) null);
	}

	public boolean hasNext() {
		if (this.a == -2) {
			this.a = 0;
			Iterator[] var5 = this.c;
			int var2 = var5.length;

			for (int var3 = 0; var3 < var2; ++var3) {
				Iterator var4 = var5[var3];
				if (!var4.hasNext()) {
					this.b();
					break;
				}
			}

			return true;
		} else {
			if (this.a >= this.c.length) {
				for (this.a = this.c.length - 1; this.a >= 0; --this.a) {
					Iterator var1 = this.c[this.a];
					if (var1.hasNext()) {
						break;
					}

					if (this.a == 0) {
						this.b();
						break;
					}

					var1 = this.b[this.a].iterator();
					this.c[this.a] = var1;
					if (!var1.hasNext()) {
						this.b();
						break;
					}
				}
			}

			return this.a >= 0;
		}
	}

	public Object[] a() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		} else {
			while (this.a < this.c.length) {
				this.d[this.a] = this.c[this.a].next();
				++this.a;
			}

			return (Object[]) this.d.clone();
		}
	}

	// $FF: synthetic method
	public Object next() {
		return this.a();
	}

	// $FF: synthetic method
	ef(Class var1, Iterable[] var2, ec var3) {
		this(var1, var2);
	}
}
