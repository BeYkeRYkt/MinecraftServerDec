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
			writeTag(entry.getKey(), entry.getValue(), output);
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

	public boolean isTagAssignableFrom(String key, int tagId) {
		byte keyTagId = this.getTagId(key);
		if (keyTagId == tagId) {
			return true;
		} else if (tagId != 99) {
			return false;
		} else {
			return keyTagId > 0 && keyTagId < 7;
		}
	}

	public byte getByte(String key) {
		try {
			return !this.isTagAssignableFrom(key, 99) ? 0 : ((NBTNumberTag) this.compound.get(key)).toByte();
		} catch (ClassCastException ex) {
			return (byte) 0;
		}
	}

	public short getShort(String key) {
		try {
			return !this.isTagAssignableFrom(key, 99) ? 0 : ((NBTNumberTag) this.compound.get(key)).toShort();
		} catch (ClassCastException ex) {
			return (short) 0;
		}
	}

	public int getInt(String key) {
		try {
			return !this.isTagAssignableFrom(key, 99) ? 0 : ((NBTNumberTag) this.compound.get(key)).toInt();
		} catch (ClassCastException ex) {
			return 0;
		}
	}

	public long getLong(String key) {
		try {
			return !this.isTagAssignableFrom(key, 99) ? 0L : ((NBTNumberTag) this.compound.get(key)).toLong();
		} catch (ClassCastException var3) {
			return 0L;
		}
	}

	public float getFloat(String key) {
		try {
			return !this.isTagAssignableFrom(key, 99) ? 0.0F : ((NBTNumberTag) this.compound.get(key)).toFloat();
		} catch (ClassCastException ex) {
			return 0.0F;
		}
	}

	public double getDouble(String key) {
		try {
			return !this.isTagAssignableFrom(key, 99) ? 0.0D : ((NBTNumberTag) this.compound.get(key)).toDouble();
		} catch (ClassCastException ex) {
			return 0.0D;
		}
	}

	public String getString(String key) {
		try {
			return !this.isTagAssignableFrom(key, 8) ? "" : (this.compound.get(key)).getAsString();
		} catch (ClassCastException ex) {
			return "";
		}
	}

	public byte[] getByteArray(String key) {
		try {
			return !this.isTagAssignableFrom(key, 7) ? new byte[0] : ((NBTByteArrayTag) this.compound.get(key)).getContent();
		} catch (ClassCastException ex) {
			throw new ReportedException(this.generateCrashReport(key, 7, ex));
		}
	}

	public int[] getIntArray(String key) {
		try {
			return !this.isTagAssignableFrom(key, 11) ? new int[0] : ((NBTIntArrayTag) this.compound.get(key)).getContent();
		} catch (ClassCastException var3) {
			throw new ReportedException(this.generateCrashReport(key, 11, var3));
		}
	}

	public NBTCompoundTag getCompound(String key) {
		try {
			return !this.isTagAssignableFrom(key, 10) ? new NBTCompoundTag() : (NBTCompoundTag) this.compound.get(key);
		} catch (ClassCastException ex) {
			throw new ReportedException(this.generateCrashReport(key, 10, ex));
		}
	}

	public NBTListTag getList(String key, int contentTagId) {
		try {
			if (this.getTagId(key) != 9) {
				return new NBTListTag();
			} else {
				NBTListTag list = (NBTListTag) this.compound.get(key);
				return list.getSize() > 0 && list.getContentTagId() != contentTagId ? new NBTListTag() : list;
			}
		} catch (ClassCastException ex) {
			throw new ReportedException(this.generateCrashReport(key, 9, ex));
		}
	}

	public boolean getBoolean(String key) {
		return this.getByte(key) != 0;
	}

	public void remove(String key) {
		this.compound.remove(key);
	}

	public String toString() {
		String string = "{";

		String var3;
		for (Iterator<String> it = this.compound.keySet().iterator(); it.hasNext(); string = string + var3 + ':' + this.compound.get(var3) + ',') {
			var3 = it.next();
		}

		return string + "}";
	}

	public boolean isEmpty() {
		return this.compound.isEmpty();
	}

	private CrashReport generateCrashReport(final String key, final int tagId, ClassCastException ex) {
		CrashReport crashReport = CrashReport.generateCrashReport(ex, "Reading NBT data");
		CrashReportSystemDetails crashReportDetails = crashReport.generateSystemDetails("Corrupt NBT tag", 1);
		crashReportDetails.addDetails("Tag type found", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return names[compound.get(key).getId()];
			}
		});
		crashReportDetails.addDetails("Tag type expected", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return names[tagId];
			}
		});
		crashReportDetails.addDetails("Tag name", (Object) key);
		return crashReport;
	}

	public NBTTag getCopy() {
		NBTCompoundTag tag = new NBTCompoundTag();
		Iterator<String> it = this.compound.keySet().iterator();

		while (it.hasNext()) {
			String var3 = (String) it.next();
			tag.put(var3, ((NBTTag) this.compound.get(var3)).getCopy());
		}

		return tag;
	}

	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			NBTCompoundTag tag = (NBTCompoundTag) obj;
			return this.compound.entrySet().equals(tag.compound.entrySet());
		} else {
			return false;
		}
	}

	public int hashCode() {
		return super.hashCode() ^ this.compound.hashCode();
	}

	private static void writeTag(String key, NBTTag tag, DataOutput output) throws IOException {
		output.writeByte(tag.getId());
		if (tag.getId() != 0) {
			output.writeUTF(key);
			tag.write(output);
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
		} catch (IOException ex) {
			CrashReport crashReport = CrashReport.generateCrashReport(ex, "Loading NBT data");
			CrashReportSystemDetails crashReportDetails = crashReport.generateSystemDetails("NBT Tag");
			crashReportDetails.addDetails("Tag name", (Object) key);
			crashReportDetails.addDetails("Tag type", (Object) Byte.valueOf(tagId));
			throw new ReportedException(crashReport);
		}
	}

	public void copyFrom(NBTCompoundTag inputCompundTag) {
		for (Entry<String, NBTTag> entry : inputCompundTag.compound.entrySet()) {
			String inputKey = entry.getKey();
			NBTTag inputTag = entry.getValue();
			if (inputTag.getId() == 10) {
				if (isTagAssignableFrom(inputKey, 10)) {
					getCompound(inputKey).copyFrom((NBTCompoundTag) inputTag);
				} else {
					put(inputKey, inputTag.getCopy());
				}
			} else {
				put(inputKey, inputTag.getCopy());
			}
		}
	}

}
