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

	private static final Logger logger = LogManager.getLogger();
	private List<NBTTag> list = Lists.newArrayList();
	private byte contentTagId = 0;

	void write(DataOutput output) throws IOException {
		if (!this.list.isEmpty()) {
			this.contentTagId = ((NBTTag) this.list.get(0)).getId();
		} else {
			this.contentTagId = 0;
		}

		output.writeByte(this.contentTagId);
		output.writeInt(this.list.size());

		for (int var2 = 0; var2 < this.list.size(); ++var2) {
			((NBTTag) this.list.get(var2)).write(output);
		}

	}

	void read(DataInput input, int currentDepth, NBTReadLimiter limit) throws IOException {
		if (currentDepth > 512) {
			throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
		} else {
			limit.onBytesRead(8L);
			this.contentTagId = input.readByte();
			int length = input.readInt();
			this.list = Lists.newArrayList();

			for (int i = 0; i < length; ++i) {
				NBTTag tag = NBTTag.byId(this.contentTagId);
				tag.read(input, currentDepth + 1, limit);
				this.list.add(tag);
			}

		}
	}

	public byte getId() {
		return (byte) 9;
	}

	public String toString() {
		String string = "[";
		int number = 0;

		for (Iterator<NBTTag> iterator = this.list.iterator(); iterator.hasNext(); ++number) {
			NBTTag var4 = iterator.next();
			string = string + "" + number + ':' + var4 + ',';
		}

		return string + "]";
	}

	public void addTag(NBTTag tag) {
		if (this.contentTagId == 0) {
			this.contentTagId = tag.getId();
		} else if (this.contentTagId != tag.getId()) {
			logger.warn("Adding mismatching tag types to tag list");
			return;
		}

		this.list.add(tag);
	}

	public void setTag(int index, NBTTag tag) {
		if (index >= 0 && index < this.list.size()) {
			if (this.contentTagId == 0) {
				this.contentTagId = tag.getId();
			} else if (this.contentTagId != tag.getId()) {
				logger.warn("Adding mismatching tag types to tag list");
				return;
			}

			this.list.set(index, tag);
		} else {
			logger.warn("index out of bounds to set tag in tag list");
		}
	}

	public NBTTag removeTag(int index) {
		return this.list.remove(index);
	}

	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public NBTCompoundTag getCompound(int index) {
		if (index >= 0 && index < this.list.size()) {
			NBTTag tag = this.list.get(index);
			return tag.getId() == 10 ? (NBTCompoundTag) tag : new NBTCompoundTag();
		} else {
			return new NBTCompoundTag();
		}
	}

	public int[] getIntArray(int index) {
		if (index >= 0 && index < this.list.size()) {
			NBTTag tag = this.list.get(index);
			return tag.getId() == 11 ? ((NBTIntArrayTag) tag).getContent() : new int[0];
		} else {
			return new int[0];
		}
	}

	public double getDouble(int index) {
		if (index >= 0 && index < this.list.size()) {
			NBTTag tag = this.list.get(index);
			return tag.getId() == 6 ? ((NBTDoubleTag) tag).toDouble() : 0.0D;
		} else {
			return 0.0D;
		}
	}

	public float getFloat(int index) {
		if (index >= 0 && index < this.list.size()) {
			NBTTag tag = this.list.get(index);
			return tag.getId() == 5 ? ((NBTFloatTag) tag).toFloat() : 0.0F;
		} else {
			return 0.0F;
		}
	}

	public String getString(int index) {
		if (index >= 0 && index < this.list.size()) {
			NBTTag tag = this.list.get(index);
			return tag.getId() == 8 ? tag.getAsString() : tag.toString();
		} else {
			return "";
		}
	}

	public NBTTag getTag(int index) {
		return (index >= 0 && index < this.list.size() ? this.list.get(index) : new NBTEndTag());
	}

	public int getSize() {
		return this.list.size();
	}

	public NBTTag getCopy() {
		NBTListTag copy = new NBTListTag();
		copy.contentTagId = this.contentTagId;

		Iterator<NBTTag> it = this.list.iterator();
		while (it.hasNext()) {
			NBTTag var3 = it.next();
			NBTTag var4 = var3.getCopy();
			copy.list.add(var4);
		}

		return copy;
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTListTag var2 = (NBTListTag) var1;
			if (this.contentTagId == var2.contentTagId) {
				return this.list.equals(var2.list);
			}
		}

		return false;
	}

	public int hashCode() {
		return super.hashCode() ^ this.list.hashCode();
	}

	public int getContentTagId() {
		return this.contentTagId;
	}

}
