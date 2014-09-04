package net.minecraft;

import com.google.common.collect.Lists;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NBTListTag extends NBTTag {

	private static final Logger b = LogManager.getLogger();
	private List c = Lists.newArrayList();
	private byte d = 0;

	void write(DataOutput var1) throws IOException {
		if (!this.c.isEmpty()) {
			this.d = ((NBTTag) this.c.get(0)).getId();
		} else {
			this.d = 0;
		}

		var1.writeByte(this.d);
		var1.writeInt(this.c.size());

		for (int var2 = 0; var2 < this.c.size(); ++var2) {
			((NBTTag) this.c.get(var2)).write(var1);
		}

	}

	void read(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
		if (var2 > 512) {
			throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
		} else {
			var3.a(8L);
			this.d = var1.readByte();
			int var4 = var1.readInt();
			this.c = Lists.newArrayList();

			for (int var5 = 0; var5 < var4; ++var5) {
				NBTTag var6 = NBTTag.byId(this.d);
				var6.read(var1, var2 + 1, var3);
				this.c.add(var6);
			}

		}
	}

	public byte getId() {
		return (byte) 9;
	}

	public String toString() {
		String var1 = "[";
		int var2 = 0;

		for (Iterator var3 = this.c.iterator(); var3.hasNext(); ++var2) {
			NBTTag var4 = (NBTTag) var3.next();
			var1 = var1 + "" + var2 + ':' + var4 + ',';
		}

		return var1 + "]";
	}

	public void a(NBTTag var1) {
		if (this.d == 0) {
			this.d = var1.getId();
		} else if (this.d != var1.getId()) {
			b.warn("Adding mismatching tag types to tag list");
			return;
		}

		this.c.add(var1);
	}

	public void a(int var1, NBTTag var2) {
		if (var1 >= 0 && var1 < this.c.size()) {
			if (this.d == 0) {
				this.d = var2.getId();
			} else if (this.d != var2.getId()) {
				b.warn("Adding mismatching tag types to tag list");
				return;
			}

			this.c.set(var1, var2);
		} else {
			b.warn("index out of bounds to set tag in tag list");
		}
	}

	public NBTTag a(int var1) {
		return (NBTTag) this.c.remove(var1);
	}

	public boolean c_() {
		return this.c.isEmpty();
	}

	public NBTCompoundTag b(int var1) {
		if (var1 >= 0 && var1 < this.c.size()) {
			NBTTag var2 = (NBTTag) this.c.get(var1);
			return var2.getId() == 10 ? (NBTCompoundTag) var2 : new NBTCompoundTag();
		} else {
			return new NBTCompoundTag();
		}
	}

	public int[] c(int var1) {
		if (var1 >= 0 && var1 < this.c.size()) {
			NBTTag var2 = (NBTTag) this.c.get(var1);
			return var2.getId() == 11 ? ((NBTIntArrayTag) var2).c() : new int[0];
		} else {
			return new int[0];
		}
	}

	public double d(int var1) {
		if (var1 >= 0 && var1 < this.c.size()) {
			NBTTag var2 = (NBTTag) this.c.get(var1);
			return var2.getId() == 6 ? ((NBTDoubleTag) var2).g() : 0.0D;
		} else {
			return 0.0D;
		}
	}

	public float e(int var1) {
		if (var1 >= 0 && var1 < this.c.size()) {
			NBTTag var2 = (NBTTag) this.c.get(var1);
			return var2.getId() == 5 ? ((NBTFloatTag) var2).h() : 0.0F;
		} else {
			return 0.0F;
		}
	}

	public String f(int var1) {
		if (var1 >= 0 && var1 < this.c.size()) {
			NBTTag var2 = (NBTTag) this.c.get(var1);
			return var2.getId() == 8 ? var2.a_() : var2.toString();
		} else {
			return "";
		}
	}

	public NBTTag g(int var1) {
		return (NBTTag) (var1 >= 0 && var1 < this.c.size() ? (NBTTag) this.c.get(var1) : new NBTEndTag());
	}

	public int c() {
		return this.c.size();
	}

	public NBTTag getCopy() {
		NBTListTag var1 = new NBTListTag();
		var1.d = this.d;
		Iterator var2 = this.c.iterator();

		while (var2.hasNext()) {
			NBTTag var3 = (NBTTag) var2.next();
			NBTTag var4 = var3.getCopy();
			var1.c.add(var4);
		}

		return var1;
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTListTag var2 = (NBTListTag) var1;
			if (this.d == var2.d) {
				return this.c.equals(var2.c);
			}
		}

		return false;
	}

	public int hashCode() {
		return super.hashCode() ^ this.c.hashCode();
	}

	public int f() {
		return this.d;
	}

}
