package net.minecraft;

import com.google.common.collect.AbstractIterator;

class dx extends AbstractIterator {

	private dy b;
	// $FF: synthetic field
	final dw a;

	dx(dw var1) {
		this.a = var1;
		this.b = null;
	}

	protected dy a() {
		if (this.b == null) {
			this.b = new dy(this.a.a.getX(), this.a.a.getY(), this.a.a.getZ(), (du) null);
			return this.b;
		} else if (this.b.equals(this.a.b)) {
			return (dy) this.endOfData();
		} else {
			int var1 = this.b.getX();
			int var2 = this.b.getY();
			int var3 = this.b.getZ();
			if (var1 < this.a.b.getX()) {
				++var1;
			} else if (var2 < this.a.b.getY()) {
				var1 = this.a.a.getX();
				++var2;
			} else if (var3 < this.a.b.getZ()) {
				var1 = this.a.a.getX();
				var2 = this.a.a.getY();
				++var3;
			}

			this.b.b = var1;
			this.b.c = var2;
			this.b.d = var3;
			return this.b;
		}
	}

	// $FF: synthetic method
	protected Object computeNext() {
		return this.a();
	}
}
