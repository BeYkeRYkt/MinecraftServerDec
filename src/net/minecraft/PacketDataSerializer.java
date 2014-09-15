package net.minecraft;

import com.google.common.base.Charsets;
import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.util.io.netty.buffer.ByteBufAllocator;
import net.minecraft.util.io.netty.buffer.ByteBufInputStream;
import net.minecraft.util.io.netty.buffer.ByteBufOutputStream;
import net.minecraft.util.io.netty.buffer.ByteBufProcessor;
import net.minecraft.util.io.netty.handler.codec.DecoderException;
import net.minecraft.util.io.netty.handler.codec.EncoderException;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.util.UUID;

public class PacketDataSerializer extends ByteBuf {

	private final ByteBuf byteBuf;

	public PacketDataSerializer(ByteBuf byteBuf) {
		this.byteBuf = byteBuf;
	}

	public static int getPrependLength(int input) {
		for (int i = 1; i < 5; ++i) {
			if ((input & -1 << i * 7) == 0) {
				return i;
			}
		}

		return 5;
	}

	public void writeByteArray(byte[] barray) {
		this.writeVarInt(barray.length);
		this.writeBytes(barray);
	}

	public byte[] readByteArray() {
		byte[] barray = new byte[this.readVarInt()];
		this.readBytes(barray);
		return barray;
	}

	public Position readPosition() {
		return Position.a(this.readLong());
	}

	public void writePosition(Position var1) {
		this.writeLong(var1.g());
	}

	public IChatBaseComponent readJSONComponent() {
		return ChatSerializer.fromJsonString(this.readString(32767));
	}

	public void writeJSONComponent(IChatBaseComponent var1) {
		this.writeString(ChatSerializer.toJsonString(var1));
	}

	public <T extends Enum<T>> Enum<T> readEnum(Class<T> enumClass) {
		return enumClass.getEnumConstants()[readVarInt()];
	}

	public void writeEnum(Enum<?> value) {
		this.writeVarInt(value.ordinal());
	}

	public int readVarInt() {
		int var1 = 0;
		int var2 = 0;

		byte var3;
		do {
			var3 = this.readByte();
			var1 |= (var3 & 127) << var2++ * 7;
			if (var2 > 5) {
				throw new RuntimeException("VarInt too big");
			}
		} while ((var3 & 128) == 128);

		return var1;
	}

	public long readVarLong() {
		long var1 = 0L;
		int var3 = 0;

		byte var4;
		do {
			var4 = this.readByte();
			var1 |= (long) (var4 & 127) << var3++ * 7;
			if (var3 > 10) {
				throw new RuntimeException("VarLong too big");
			}
		} while ((var4 & 128) == 128);

		return var1;
	}

	public void writeUUID(UUID uuid) {
		this.writeLong(uuid.getMostSignificantBits());
		this.writeLong(uuid.getLeastSignificantBits());
	}

	public UUID readUUID() {
		return new UUID(this.readLong(), this.readLong());
	}

	public void writeVarInt(int i) {
		while ((i & -128) != 0) {
			this.writeByte(i & 127 | 128);
			i >>>= 7;
		}

		this.writeByte(i);
	}

	public void writeVarLong(long l) {
		while ((l & -128L) != 0L) {
			this.writeByte((int) (l & 127L) | 128);
			l >>>= 7;
		}

		this.writeByte((int) l);
	}

	public void writeCompound(NBTCompoundTag tag) {
		if (tag == null) {
			this.writeByte(0);
		} else {
			try {
				NBTCompressedStreamTools.writeTag(tag, (DataOutput) (new ByteBufOutputStream(this)));
			} catch (IOException ex) {
				throw new EncoderException(ex);
			}
		}

	}

	public NBTCompoundTag readCompound() throws IOException {
		int index = this.readerIndex();
		byte tagId = this.readByte();
		if (tagId == 0) {
			return null;
		} else {
			this.readerIndex(index);
			return NBTCompressedStreamTools.readTag((new ByteBufInputStream(this)), new NBTReadLimiter(2097152L));
		}
	}

	public void writeItemStack(ItemStack item) {
		if (item == null) {
			this.writeShort(-1);
		} else {
			this.writeShort(Item.getId(item.getItem()));
			this.writeByte(item.amount);
			this.writeShort(item.getDurability());
			NBTCompoundTag compund = null;
			if (item.getItem().usesDurability() || item.getItem().p()) {
				compund = item.getTag();
			}

			this.writeCompound(compund);
		}

	}

	public ItemStack readItemStack() throws IOException {
		ItemStack itemstack = null;
		short var2 = this.readShort();
		if (var2 >= 0) {
			byte var3 = this.readByte();
			short var4 = this.readShort();
			itemstack = new ItemStack(Item.getById(var2), var3, var4);
			itemstack.setTag(this.readCompound());
		}
		return itemstack;
	}

	public String readString(int maxLength) {
		int length = this.readVarInt();
		if (length > maxLength * 4) {
			throw new DecoderException("The received encoded string buffer length is longer than maximum allowed (" + length + " > " + maxLength * 4 + ")");
		} else if (length < 0) {
			throw new DecoderException("The received encoded string buffer length is less than zero! Weird string!");
		} else {
			String string = new String(this.readBytes(length).array(), Charsets.UTF_8);
			if (string.length() > maxLength) {
				throw new DecoderException("The received string length is longer than maximum allowed (" + length + " > " + maxLength + ")");
			} else {
				return string;
			}
		}
	}

	public PacketDataSerializer writeString(String string) {
		byte[] var2 = string.getBytes(Charsets.UTF_8);
		if (var2.length > 32767) {
			throw new EncoderException("String too big (was " + string.length() + " bytes encoded, max " + 32767 + ")");
		} else {
			this.writeVarInt(var2.length);
			this.writeBytes(var2);
			return this;
		}
	}

	public int capacity() {
		return this.byteBuf.capacity();
	}

	public ByteBuf capacity(int var1) {
		return this.byteBuf.capacity(var1);
	}

	public int maxCapacity() {
		return this.byteBuf.maxCapacity();
	}

	public ByteBufAllocator alloc() {
		return this.byteBuf.alloc();
	}

	public ByteOrder order() {
		return this.byteBuf.order();
	}

	public ByteBuf order(ByteOrder var1) {
		return this.byteBuf.order(var1);
	}

	public ByteBuf unwrap() {
		return this.byteBuf.unwrap();
	}

	public boolean isDirect() {
		return this.byteBuf.isDirect();
	}

	public int readerIndex() {
		return this.byteBuf.readerIndex();
	}

	public ByteBuf readerIndex(int var1) {
		return this.byteBuf.readerIndex(var1);
	}

	public int writerIndex() {
		return this.byteBuf.writerIndex();
	}

	public ByteBuf writerIndex(int var1) {
		return this.byteBuf.writerIndex(var1);
	}

	public ByteBuf setIndex(int var1, int var2) {
		return this.byteBuf.setIndex(var1, var2);
	}

	public int readableBytes() {
		return this.byteBuf.readableBytes();
	}

	public int writableBytes() {
		return this.byteBuf.writableBytes();
	}

	public int maxWritableBytes() {
		return this.byteBuf.maxWritableBytes();
	}

	public boolean isReadable() {
		return this.byteBuf.isReadable();
	}

	public boolean isReadable(int var1) {
		return this.byteBuf.isReadable(var1);
	}

	public boolean isWritable() {
		return this.byteBuf.isWritable();
	}

	public boolean isWritable(int var1) {
		return this.byteBuf.isWritable(var1);
	}

	public ByteBuf clear() {
		return this.byteBuf.clear();
	}

	public ByteBuf markReaderIndex() {
		return this.byteBuf.markReaderIndex();
	}

	public ByteBuf resetReaderIndex() {
		return this.byteBuf.resetReaderIndex();
	}

	public ByteBuf markWriterIndex() {
		return this.byteBuf.markWriterIndex();
	}

	public ByteBuf resetWriterIndex() {
		return this.byteBuf.resetWriterIndex();
	}

	public ByteBuf discardReadBytes() {
		return this.byteBuf.discardReadBytes();
	}

	public ByteBuf discardSomeReadBytes() {
		return this.byteBuf.discardSomeReadBytes();
	}

	public ByteBuf ensureWritable(int var1) {
		return this.byteBuf.ensureWritable(var1);
	}

	public int ensureWritable(int var1, boolean var2) {
		return this.byteBuf.ensureWritable(var1, var2);
	}

	public boolean getBoolean(int var1) {
		return this.byteBuf.getBoolean(var1);
	}

	public byte getByte(int var1) {
		return this.byteBuf.getByte(var1);
	}

	public short getUnsignedByte(int var1) {
		return this.byteBuf.getUnsignedByte(var1);
	}

	public short getShort(int var1) {
		return this.byteBuf.getShort(var1);
	}

	public int getUnsignedShort(int var1) {
		return this.byteBuf.getUnsignedShort(var1);
	}

	public int getMedium(int var1) {
		return this.byteBuf.getMedium(var1);
	}

	public int getUnsignedMedium(int var1) {
		return this.byteBuf.getUnsignedMedium(var1);
	}

	public int getInt(int var1) {
		return this.byteBuf.getInt(var1);
	}

	public long getUnsignedInt(int var1) {
		return this.byteBuf.getUnsignedInt(var1);
	}

	public long getLong(int var1) {
		return this.byteBuf.getLong(var1);
	}

	public char getChar(int var1) {
		return this.byteBuf.getChar(var1);
	}

	public float getFloat(int var1) {
		return this.byteBuf.getFloat(var1);
	}

	public double getDouble(int var1) {
		return this.byteBuf.getDouble(var1);
	}

	public ByteBuf getBytes(int var1, ByteBuf var2) {
		return this.byteBuf.getBytes(var1, var2);
	}

	public ByteBuf getBytes(int var1, ByteBuf var2, int var3) {
		return this.byteBuf.getBytes(var1, var2, var3);
	}

	public ByteBuf getBytes(int var1, ByteBuf var2, int var3, int var4) {
		return this.byteBuf.getBytes(var1, var2, var3, var4);
	}

	public ByteBuf getBytes(int var1, byte[] var2) {
		return this.byteBuf.getBytes(var1, var2);
	}

	public ByteBuf getBytes(int var1, byte[] var2, int var3, int var4) {
		return this.byteBuf.getBytes(var1, var2, var3, var4);
	}

	public ByteBuf getBytes(int var1, ByteBuffer var2) {
		return this.byteBuf.getBytes(var1, var2);
	}

	public ByteBuf getBytes(int var1, OutputStream var2, int var3) throws IOException {
		return this.byteBuf.getBytes(var1, var2, var3);
	}

	public int getBytes(int var1, GatheringByteChannel var2, int var3) throws IOException {
		return this.byteBuf.getBytes(var1, var2, var3);
	}

	public ByteBuf setBoolean(int var1, boolean var2) {
		return this.byteBuf.setBoolean(var1, var2);
	}

	public ByteBuf setByte(int var1, int var2) {
		return this.byteBuf.setByte(var1, var2);
	}

	public ByteBuf setShort(int var1, int var2) {
		return this.byteBuf.setShort(var1, var2);
	}

	public ByteBuf setMedium(int var1, int var2) {
		return this.byteBuf.setMedium(var1, var2);
	}

	public ByteBuf setInt(int var1, int var2) {
		return this.byteBuf.setInt(var1, var2);
	}

	public ByteBuf setLong(int var1, long var2) {
		return this.byteBuf.setLong(var1, var2);
	}

	public ByteBuf setChar(int var1, int var2) {
		return this.byteBuf.setChar(var1, var2);
	}

	public ByteBuf setFloat(int var1, float var2) {
		return this.byteBuf.setFloat(var1, var2);
	}

	public ByteBuf setDouble(int var1, double var2) {
		return this.byteBuf.setDouble(var1, var2);
	}

	public ByteBuf setBytes(int var1, ByteBuf var2) {
		return this.byteBuf.setBytes(var1, var2);
	}

	public ByteBuf setBytes(int var1, ByteBuf var2, int var3) {
		return this.byteBuf.setBytes(var1, var2, var3);
	}

	public ByteBuf setBytes(int var1, ByteBuf var2, int var3, int var4) {
		return this.byteBuf.setBytes(var1, var2, var3, var4);
	}

	public ByteBuf setBytes(int var1, byte[] var2) {
		return this.byteBuf.setBytes(var1, var2);
	}

	public ByteBuf setBytes(int var1, byte[] var2, int var3, int var4) {
		return this.byteBuf.setBytes(var1, var2, var3, var4);
	}

	public ByteBuf setBytes(int var1, ByteBuffer var2) {
		return this.byteBuf.setBytes(var1, var2);
	}

	public int setBytes(int var1, InputStream var2, int var3) throws IOException {
		return this.byteBuf.setBytes(var1, var2, var3);
	}

	public int setBytes(int var1, ScatteringByteChannel var2, int var3) throws IOException {
		return this.byteBuf.setBytes(var1, var2, var3);
	}

	public ByteBuf setZero(int var1, int var2) {
		return this.byteBuf.setZero(var1, var2);
	}

	public boolean readBoolean() {
		return this.byteBuf.readBoolean();
	}

	public byte readByte() {
		return this.byteBuf.readByte();
	}

	public short readUnsignedByte() {
		return this.byteBuf.readUnsignedByte();
	}

	public short readShort() {
		return this.byteBuf.readShort();
	}

	public int readUnsignedShort() {
		return this.byteBuf.readUnsignedShort();
	}

	public int readMedium() {
		return this.byteBuf.readMedium();
	}

	public int readUnsignedMedium() {
		return this.byteBuf.readUnsignedMedium();
	}

	public int readInt() {
		return this.byteBuf.readInt();
	}

	public long readUnsignedInt() {
		return this.byteBuf.readUnsignedInt();
	}

	public long readLong() {
		return this.byteBuf.readLong();
	}

	public char readChar() {
		return this.byteBuf.readChar();
	}

	public float readFloat() {
		return this.byteBuf.readFloat();
	}

	public double readDouble() {
		return this.byteBuf.readDouble();
	}

	public ByteBuf readBytes(int var1) {
		return this.byteBuf.readBytes(var1);
	}

	public ByteBuf readSlice(int var1) {
		return this.byteBuf.readSlice(var1);
	}

	public ByteBuf readBytes(ByteBuf var1) {
		return this.byteBuf.readBytes(var1);
	}

	public ByteBuf readBytes(ByteBuf var1, int var2) {
		return this.byteBuf.readBytes(var1, var2);
	}

	public ByteBuf readBytes(ByteBuf var1, int var2, int var3) {
		return this.byteBuf.readBytes(var1, var2, var3);
	}

	public ByteBuf readBytes(byte[] var1) {
		return this.byteBuf.readBytes(var1);
	}

	public ByteBuf readBytes(byte[] var1, int var2, int var3) {
		return this.byteBuf.readBytes(var1, var2, var3);
	}

	public ByteBuf readBytes(ByteBuffer var1) {
		return this.byteBuf.readBytes(var1);
	}

	public ByteBuf readBytes(OutputStream var1, int var2) throws IOException {
		return this.byteBuf.readBytes(var1, var2);
	}

	public int readBytes(GatheringByteChannel var1, int var2) throws IOException {
		return this.byteBuf.readBytes(var1, var2);
	}

	public ByteBuf skipBytes(int var1) {
		return this.byteBuf.skipBytes(var1);
	}

	public ByteBuf writeBoolean(boolean var1) {
		return this.byteBuf.writeBoolean(var1);
	}

	public ByteBuf writeByte(int var1) {
		return this.byteBuf.writeByte(var1);
	}

	public ByteBuf writeShort(int var1) {
		return this.byteBuf.writeShort(var1);
	}

	public ByteBuf writeMedium(int var1) {
		return this.byteBuf.writeMedium(var1);
	}

	public ByteBuf writeInt(int var1) {
		return this.byteBuf.writeInt(var1);
	}

	public ByteBuf writeLong(long var1) {
		return this.byteBuf.writeLong(var1);
	}

	public ByteBuf writeChar(int var1) {
		return this.byteBuf.writeChar(var1);
	}

	public ByteBuf writeFloat(float var1) {
		return this.byteBuf.writeFloat(var1);
	}

	public ByteBuf writeDouble(double var1) {
		return this.byteBuf.writeDouble(var1);
	}

	public ByteBuf writeBytes(ByteBuf var1) {
		return this.byteBuf.writeBytes(var1);
	}

	public ByteBuf writeBytes(ByteBuf var1, int var2) {
		return this.byteBuf.writeBytes(var1, var2);
	}

	public ByteBuf writeBytes(ByteBuf var1, int var2, int var3) {
		return this.byteBuf.writeBytes(var1, var2, var3);
	}

	public ByteBuf writeBytes(byte[] var1) {
		return this.byteBuf.writeBytes(var1);
	}

	public ByteBuf writeBytes(byte[] var1, int var2, int var3) {
		return this.byteBuf.writeBytes(var1, var2, var3);
	}

	public ByteBuf writeBytes(ByteBuffer var1) {
		return this.byteBuf.writeBytes(var1);
	}

	public int writeBytes(InputStream var1, int var2) throws IOException {
		return this.byteBuf.writeBytes(var1, var2);
	}

	public int writeBytes(ScatteringByteChannel var1, int var2) throws IOException {
		return this.byteBuf.writeBytes(var1, var2);
	}

	public ByteBuf writeZero(int var1) {
		return this.byteBuf.writeZero(var1);
	}

	public int indexOf(int var1, int var2, byte var3) {
		return this.byteBuf.indexOf(var1, var2, var3);
	}

	public int bytesBefore(byte var1) {
		return this.byteBuf.bytesBefore(var1);
	}

	public int bytesBefore(int var1, byte var2) {
		return this.byteBuf.bytesBefore(var1, var2);
	}

	public int bytesBefore(int var1, int var2, byte var3) {
		return this.byteBuf.bytesBefore(var1, var2, var3);
	}

	public int forEachByte(ByteBufProcessor var1) {
		return this.byteBuf.forEachByte(var1);
	}

	public int forEachByte(int var1, int var2, ByteBufProcessor var3) {
		return this.byteBuf.forEachByte(var1, var2, var3);
	}

	public int forEachByteDesc(ByteBufProcessor var1) {
		return this.byteBuf.forEachByteDesc(var1);
	}

	public int forEachByteDesc(int var1, int var2, ByteBufProcessor var3) {
		return this.byteBuf.forEachByteDesc(var1, var2, var3);
	}

	public ByteBuf copy() {
		return this.byteBuf.copy();
	}

	public ByteBuf copy(int var1, int var2) {
		return this.byteBuf.copy(var1, var2);
	}

	public ByteBuf slice() {
		return this.byteBuf.slice();
	}

	public ByteBuf slice(int var1, int var2) {
		return this.byteBuf.slice(var1, var2);
	}

	public ByteBuf duplicate() {
		return this.byteBuf.duplicate();
	}

	public int nioBufferCount() {
		return this.byteBuf.nioBufferCount();
	}

	public ByteBuffer nioBuffer() {
		return this.byteBuf.nioBuffer();
	}

	public ByteBuffer nioBuffer(int var1, int var2) {
		return this.byteBuf.nioBuffer(var1, var2);
	}

	public ByteBuffer internalNioBuffer(int var1, int var2) {
		return this.byteBuf.internalNioBuffer(var1, var2);
	}

	public ByteBuffer[] nioBuffers() {
		return this.byteBuf.nioBuffers();
	}

	public ByteBuffer[] nioBuffers(int var1, int var2) {
		return this.byteBuf.nioBuffers(var1, var2);
	}

	public boolean hasArray() {
		return this.byteBuf.hasArray();
	}

	public byte[] array() {
		return this.byteBuf.array();
	}

	public int arrayOffset() {
		return this.byteBuf.arrayOffset();
	}

	public boolean hasMemoryAddress() {
		return this.byteBuf.hasMemoryAddress();
	}

	public long memoryAddress() {
		return this.byteBuf.memoryAddress();
	}

	public String toString(Charset charset) {
		return this.byteBuf.toString(charset);
	}

	public String toString(int var1, int var2, Charset charset) {
		return this.byteBuf.toString(var1, var2, charset);
	}

	public int hashCode() {
		return this.byteBuf.hashCode();
	}

	public boolean equals(Object obj) {
		return this.byteBuf.equals(obj);
	}

	public int compareTo(ByteBuf otherBuf) {
		return this.byteBuf.compareTo(otherBuf);
	}

	public String toString() {
		return this.byteBuf.toString();
	}

	public ByteBuf retain(int var) {
		return this.byteBuf.retain(var);
	}

	public ByteBuf retain() {
		return this.byteBuf.retain();
	}

	public int refCnt() {
		return this.byteBuf.refCnt();
	}

	public boolean release() {
		return this.byteBuf.release();
	}

	public boolean release(int var) {
		return this.byteBuf.release(var);
	}

}
