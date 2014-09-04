package net.minecraft;

import com.google.common.collect.Maps;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public class NBTCompoundTag extends NBTTag {

	private Map<String, NBTTag> compound = Maps.newHashMap();

	void write(DataOutput output) throws IOException {

		for (Entry<String, NBTTag> entry : compound.entrySet()) {
			a(entry.getKey(), entry.getValue(), output);
		}

		output.writeByte(0);
	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limit) throws IOException {
		if (currentDepth > 512) {
			throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
		} else {
			this.compound.clear();

			byte tagId;
			while ((tagId = readTagId(input, limit)) != 0) {
				String key = readKey(input, limit);
				limit.onBytesRead((long) (16 * key.length()));
				NBTTag tag = readTag(tagId, key, input, currentDepth + 1, limit);
				this.compound.put(key, tag);
			}

		}
	}

	public Set<String> getKeys() {
		return this.compound.keySet();
	}

	public byte getId() {
		return (byte) 10;
	}

	public void put(String key, NBTTag tag) {
		this.compound.put(key, tag);
	}

	public void put(String key, byte b) {
		this.compound.put(key, new NBTByteTag(b));
	}

	public void put(String key, short s) {
		this.compound.put(key, new NBTShortTag(s));
	}

	public void put(String key, int i) {
		this.compound.put(key, new NBTIntTag(i));
	}

	public void put(String key, long l) {
		this.compound.put(key, new NBTLongTag(l));
	}

	public void put(String key, float f) {
		this.compound.put(key, new NBTFloatTag(f));
	}

	public void put(String key, double d) {
		this.compound.put(key, new NBTDoubleTag(d));
	}

	public void put(String key, String string) {
		this.compound.put(key, new NBTStringTag(string));
	}

	public void put(String key, byte[] barray) {
		this.compound.put(key, new NBTByteArrayTag(barray));
	}

	public void put(String key, int[] iarray) {
		this.compound.put(key, new NBTIntArrayTag(iarray));
	}

	public void put(String key, boolean bool) {
		this.put(key, (byte) (bool ? 1 : 0));
	}

	public NBTTag getTag(String key) {
		return this.compound.get(key);
	}

	public byte getTagId(String key) {
		NBTTag var2 = (NBTTag) this.compound.get(key);
		return var2 != null ? var2.getId() : 0;
	}

	public boolean hasKey(String key) {
		return this.compound.containsKey(key);
	}

	public boolean b(String key, int tagId) {
		byte id = this.getTagId(key);
		if (id == tagId) {
			return true;
		} else if (tagId != 99) {
			return false;
		} else {
			return id == 1 || id == 2 || id == 3 || id == 4 || id == 5 || id == 6;
		}
	}

	public byte d(String var1) {
		try {
			return !this.b(var1, 99) ? 0 : ((NBTNumberTag) this.compound.get(var1)).toByte();
		} catch (ClassCastException var3) {
			return (byte) 0;
		}
	}

	public short e(String var1) {
		try {
			return !this.b(var1, 99) ? 0 : ((NBTNumberTag) this.compound.get(var1)).toShort();
		} catch (ClassCastException var3) {
			return (short) 0;
		}
	}

	public int f(String var1) {
		try {
			return !this.b(var1, 99) ? 0 : ((NBTNumberTag) this.compound.get(var1)).toInt();
		} catch (ClassCastException var3) {
			return 0;
		}
	}

	public long g(String var1) {
		try {
			return !this.b(var1, 99) ? 0L : ((NBTNumberTag) this.compound.get(var1)).toLong();
		} catch (ClassCastException var3) {
			return 0L;
		}
	}

	public float h(String var1) {
		try {
			return !this.b(var1, 99) ? 0.0F : ((NBTNumberTag) this.compound.get(var1)).toFloat();
		} catch (ClassCastException var3) {
			return 0.0F;
		}
	}

	public double i(String var1) {
		try {
			return !this.b(var1, 99) ? 0.0D : ((NBTNumberTag) this.compound.get(var1)).toDouble();
		} catch (ClassCastException var3) {
			return 0.0D;
		}
	}

	public String j(String var1) {
		try {
			return !this.b(var1, 8) ? "" : ((NBTTag) this.compound.get(var1)).getAsString();
		} catch (ClassCastException var3) {
			return "";
		}
	}

	public byte[] k(String var1) {
		try {
			return !this.b(var1, 7) ? new byte[0] : ((NBTByteArrayTag) this.compound.get(var1)).getContent();
		} catch (ClassCastException var3) {
			throw new u(this.a(var1, 7, var3));
		}
	}

	public int[] l(String var1) {
		try {
			return !this.b(var1, 11) ? new int[0] : ((NBTIntArrayTag) this.compound.get(var1)).getContent();
		} catch (ClassCastException var3) {
			throw new u(this.a(var1, 11, var3));
		}
	}

	public NBTCompoundTag m(String var1) {
		try {
			return !this.b(var1, 10) ? new NBTCompoundTag() : (NBTCompoundTag) this.compound.get(var1);
		} catch (ClassCastException var3) {
			throw new u(this.a(var1, 10, var3));
		}
	}

	public NBTListTag c(String var1, int var2) {
		try {
			if (this.getTagId(var1) != 9) {
				return new NBTListTag();
			} else {
				NBTListTag var3 = (NBTListTag) this.compound.get(var1);
				return var3.getSize() > 0 && var3.getContentTagId() != var2 ? new NBTListTag() : var3;
			}
		} catch (ClassCastException var4) {
			throw new u(this.a(var1, 9, var4));
		}
	}

	public boolean n(String var1) {
		return this.d(var1) != 0;
	}

	public void o(String var1) {
		this.compound.remove(var1);
	}

	public String toString() {
		String var1 = "{";

		String var3;
		for (Iterator<String> var2 = this.compound.keySet().iterator(); var2.hasNext(); var1 = var1 + var3 + ':' + this.compound.get(var3) + ',') {
			var3 = (String) var2.next();
		}

		return var1 + "}";
	}

	public boolean c_() {
		return this.compound.isEmpty();
	}

	private CrashReport a(String var1, int var2, ClassCastException var3) {
		CrashReport var4 = CrashReport.a(var3, "Reading NBT data");
		j var5 = var4.a("Corrupt NBT tag", 1);
		var5.a("Tag type found", (Callable<?>) (new fo(this, var1)));
		var5.a("Tag type expected", (Callable<?>) (new fp(this, var2)));
		var5.a("Tag name", (Object) var1);
		return var4;
	}

	public NBTTag getCopy() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		Iterator<String> var2 = this.compound.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			var1.put(var3, ((NBTTag) this.compound.get(var3)).getCopy());
		}

		return var1;
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTCompoundTag var2 = (NBTCompoundTag) var1;
			return this.compound.entrySet().equals(var2.compound.entrySet());
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.compound.hashCode();
	}

	private static void a(String var0, NBTTag var1, DataOutput var2) throws IOException {
		var2.writeByte(var1.getId());
		if (var1.getId() != 0) {
			var2.writeUTF(var0);
			var1.write(var2);
		}
	}

	private static byte readTagId(DataInput input, NBTReadLimiter limiter) throws IOException {
		return input.readByte();
	}

	private static String readKey(DataInput input, NBTReadLimiter limiter) throws IOException {
		return input.readUTF();
	}

	static NBTTag readTag(byte tagId, String key, DataInput input, int currentDepth, NBTReadLimiter limit) {
		NBTTag tag = NBTTag.byId(tagId);

		try {
			tag.read(input, currentDepth, limit);
			return tag;
		} catch (IOException var9) {
			CrashReport crashReport = CrashReport.a(var9, "Loading NBT data");
			j var8 = crashReport.a("NBT Tag");
			var8.a("Tag name", (Object) key);
			var8.a("Tag type", (Object) Byte.valueOf(tagId));
			throw new u(crashReport);
		}
	}

	public void a(NBTCompoundTag var1) {
		Iterator<String> var2 = var1.compound.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			NBTTag var4 = (NBTTag) var1.compound.get(var3);
			if (var4.getId() == 10) {
				if (this.b(var3, 10)) {
					NBTCompoundTag var5 = this.m(var3);
					var5.a((NBTCompoundTag) var4);
				} else {
					this.put(var3, var4.getCopy());
				}
			} else {
				this.put(var3, var4.getCopy());
			}
		}

	}

	// $FF: synthetic method
	static Map<String, NBTTag> b(NBTCompoundTag var0) {
		return var0.compound;
	}

}
