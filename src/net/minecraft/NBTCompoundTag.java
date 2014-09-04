package net.minecraft;

import com.google.common.collect.Maps;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NBTCompoundTag extends NBTTag {

	private static final Logger b = LogManager.getLogger();
	private Map c = Maps.newHashMap();

	void write(DataOutput var1) throws IOException {
		Iterator var2 = this.c.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			NBTTag var4 = (NBTTag) this.c.get(var3);
			a(var3, var4, var1);
		}

		var1.writeByte(0);
	}

	void read(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
		if (var2 > 512) {
			throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
		} else {
			this.c.clear();

			byte var4;
			while ((var4 = a(var1, var3)) != 0) {
				String var5 = b(var1, var3);
				var3.a((long) (16 * var5.length()));
				NBTTag var6 = a(var4, var5, var1, var2 + 1, var3);
				this.c.put(var5, var6);
			}

		}
	}

	public Set c() {
		return this.c.keySet();
	}

	public byte getId() {
		return (byte) 10;
	}

	public void a(String var1, NBTTag var2) {
		this.c.put(var1, var2);
	}

	public void a(String var1, byte var2) {
		this.c.put(var1, new NBTByteTag(var2));
	}

	public void a(String var1, short var2) {
		this.c.put(var1, new NBTShortTag(var2));
	}

	public void a(String var1, int var2) {
		this.c.put(var1, new NBTIntTag(var2));
	}

	public void a(String var1, long var2) {
		this.c.put(var1, new NBTLongTag(var2));
	}

	public void a(String var1, float var2) {
		this.c.put(var1, new NBTFloatTag(var2));
	}

	public void a(String var1, double var2) {
		this.c.put(var1, new NBTDoubleTag(var2));
	}

	public void a(String var1, String var2) {
		this.c.put(var1, new NBTStringTag(var2));
	}

	public void a(String var1, byte[] var2) {
		this.c.put(var1, new NBTByteArrayTag(var2));
	}

	public void a(String var1, int[] var2) {
		this.c.put(var1, new NBTIntArrayTag(var2));
	}

	public void a(String var1, boolean var2) {
		this.a(var1, (byte) (var2 ? 1 : 0));
	}

	public NBTTag a(String var1) {
		return (NBTTag) this.c.get(var1);
	}

	public byte b(String var1) {
		NBTTag var2 = (NBTTag) this.c.get(var1);
		return var2 != null ? var2.getId() : 0;
	}

	public boolean c(String var1) {
		return this.c.containsKey(var1);
	}

	public boolean b(String var1, int var2) {
		byte var3 = this.b(var1);
		if (var3 == var2) {
			return true;
		} else if (var2 != 99) {
			if (var3 > 0) {
				;
			}

			return false;
		} else {
			return var3 == 1 || var3 == 2 || var3 == 3 || var3 == 4 || var3 == 5 || var3 == 6;
		}
	}

	public byte d(String var1) {
		try {
			return !this.b(var1, 99) ? 0 : ((ge) this.c.get(var1)).f();
		} catch (ClassCastException var3) {
			return (byte) 0;
		}
	}

	public short e(String var1) {
		try {
			return !this.b(var1, 99) ? 0 : ((ge) this.c.get(var1)).e();
		} catch (ClassCastException var3) {
			return (short) 0;
		}
	}

	public int f(String var1) {
		try {
			return !this.b(var1, 99) ? 0 : ((ge) this.c.get(var1)).d();
		} catch (ClassCastException var3) {
			return 0;
		}
	}

	public long g(String var1) {
		try {
			return !this.b(var1, 99) ? 0L : ((ge) this.c.get(var1)).c();
		} catch (ClassCastException var3) {
			return 0L;
		}
	}

	public float h(String var1) {
		try {
			return !this.b(var1, 99) ? 0.0F : ((ge) this.c.get(var1)).h();
		} catch (ClassCastException var3) {
			return 0.0F;
		}
	}

	public double i(String var1) {
		try {
			return !this.b(var1, 99) ? 0.0D : ((ge) this.c.get(var1)).g();
		} catch (ClassCastException var3) {
			return 0.0D;
		}
	}

	public String j(String var1) {
		try {
			return !this.b(var1, 8) ? "" : ((NBTTag) this.c.get(var1)).a_();
		} catch (ClassCastException var3) {
			return "";
		}
	}

	public byte[] k(String var1) {
		try {
			return !this.b(var1, 7) ? new byte[0] : ((NBTByteArrayTag) this.c.get(var1)).c();
		} catch (ClassCastException var3) {
			throw new u(this.a(var1, 7, var3));
		}
	}

	public int[] l(String var1) {
		try {
			return !this.b(var1, 11) ? new int[0] : ((NBTIntArrayTag) this.c.get(var1)).c();
		} catch (ClassCastException var3) {
			throw new u(this.a(var1, 11, var3));
		}
	}

	public NBTCompoundTag m(String var1) {
		try {
			return !this.b(var1, 10) ? new NBTCompoundTag() : (NBTCompoundTag) this.c.get(var1);
		} catch (ClassCastException var3) {
			throw new u(this.a(var1, 10, var3));
		}
	}

	public NBTListTag c(String var1, int var2) {
		try {
			if (this.b(var1) != 9) {
				return new NBTListTag();
			} else {
				NBTListTag var3 = (NBTListTag) this.c.get(var1);
				return var3.c() > 0 && var3.f() != var2 ? new NBTListTag() : var3;
			}
		} catch (ClassCastException var4) {
			throw new u(this.a(var1, 9, var4));
		}
	}

	public boolean n(String var1) {
		return this.d(var1) != 0;
	}

	public void o(String var1) {
		this.c.remove(var1);
	}

	public String toString() {
		String var1 = "{";

		String var3;
		for (Iterator var2 = this.c.keySet().iterator(); var2.hasNext(); var1 = var1 + var3 + ':' + this.c.get(var3) + ',') {
			var3 = (String) var2.next();
		}

		return var1 + "}";
	}

	public boolean c_() {
		return this.c.isEmpty();
	}

	private CrashReport a(String var1, int var2, ClassCastException var3) {
		CrashReport var4 = CrashReport.a(var3, "Reading NBT data");
		j var5 = var4.a("Corrupt NBT tag", 1);
		var5.a("Tag type found", (Callable) (new fo(this, var1)));
		var5.a("Tag type expected", (Callable) (new fp(this, var2)));
		var5.a("Tag name", (Object) var1);
		return var4;
	}

	public NBTTag getCopy() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		Iterator var2 = this.c.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			var1.a(var3, ((NBTTag) this.c.get(var3)).getCopy());
		}

		return var1;
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTCompoundTag var2 = (NBTCompoundTag) var1;
			return this.c.entrySet().equals(var2.c.entrySet());
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.c.hashCode();
	}

	private static void a(String var0, NBTTag var1, DataOutput var2) throws IOException {
		var2.writeByte(var1.getId());
		if (var1.getId() != 0) {
			var2.writeUTF(var0);
			var1.write(var2);
		}
	}

	private static byte a(DataInput var0, NBTReadLimiter var1) throws IOException {
		return var0.readByte();
	}

	private static String b(DataInput var0, NBTReadLimiter var1) throws IOException {
		return var0.readUTF();
	}

	static NBTTag a(byte var0, String var1, DataInput var2, int var3, NBTReadLimiter var4) {
		NBTTag var5 = NBTTag.byId(var0);

		try {
			var5.read(var2, var3, var4);
			return var5;
		} catch (IOException var9) {
			CrashReport var7 = CrashReport.a(var9, "Loading NBT data");
			j var8 = var7.a("NBT Tag");
			var8.a("Tag name", (Object) var1);
			var8.a("Tag type", (Object) Byte.valueOf(var0));
			throw new u(var7);
		}
	}

	public void a(NBTCompoundTag var1) {
		Iterator var2 = var1.c.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			NBTTag var4 = (NBTTag) var1.c.get(var3);
			if (var4.getId() == 10) {
				if (this.b(var3, 10)) {
					NBTCompoundTag var5 = this.m(var3);
					var5.a((NBTCompoundTag) var4);
				} else {
					this.a(var3, var4.getCopy());
				}
			} else {
				this.a(var3, var4.getCopy());
			}
		}

	}

	// $FF: synthetic method
	static Map b(NBTCompoundTag var0) {
		return var0.c;
	}

}
