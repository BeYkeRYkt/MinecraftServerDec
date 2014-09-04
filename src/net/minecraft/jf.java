package net.minecraft;

import java.io.IOException;
import java.util.List;

public class jf implements id<ik> {

	private int a;
	private amj[] b;

	public jf() {
	}

	public jf(int var1, List var2) {
		this.a = var1;
		this.b = new amj[var2.size()];

		for (int var3 = 0; var3 < this.b.length; ++var3) {
			amj var4 = (amj) var2.get(var3);
			this.b[var3] = var4 == null ? null : var4.k();
		}

	}

	public void a(hd var1) throws IOException {
		this.a = var1.readUnsignedByte();
		short var2 = var1.readShort();
		this.b = new amj[var2];

		for (int var3 = 0; var3 < var2; ++var3) {
			this.b[var3] = var1.i();
		}

	}

	public void b(hd var1) {
		var1.writeByte(this.a);
		var1.writeShort(this.b.length);
		amj[] var2 = this.b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			amj var5 = var2[var4];
			var1.a(var5);
		}

	}

	public void a(ik var1) {
		var1.a(this);
	}
}
