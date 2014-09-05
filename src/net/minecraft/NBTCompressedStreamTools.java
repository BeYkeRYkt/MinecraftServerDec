package net.minecraft;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class NBTCompressedStreamTools {

	public static NBTCompoundTag readTag(InputStream input) throws IOException {
		DataInputStream stream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(input)));

		NBTCompoundTag tag;
		try {
			tag = readTag((DataInput) stream, NBTReadLimiter.notlimited);
		} finally {
			stream.close();
		}

		return tag;
	}

	public static void writeTag(NBTCompoundTag tag, OutputStream output) throws IOException {
		DataOutputStream stream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(output)));

		try {
			writeTag(tag, (DataOutput) stream);
		} finally {
			stream.close();
		}

	}

	public static NBTCompoundTag readTag(DataInputStream input) throws IOException {
		return readTag(input, NBTReadLimiter.notlimited);
	}

	public static NBTCompoundTag readTag(DataInput input, NBTReadLimiter limit) throws IOException {
		NBTTag tag = readTag(input, 0, limit);
		if (tag instanceof NBTCompoundTag) {
			return (NBTCompoundTag) tag;
		} else {
			throw new IOException("Root tag must be a named compound tag");
		}
	}

	public static void writeTag(NBTCompoundTag tag, DataOutput output) throws IOException {
		writeTag((NBTTag) tag, output);
	}

	private static void writeTag(NBTTag tag, DataOutput output) throws IOException {
		output.writeByte(tag.getId());
		if (tag.getId() != 0) {
			output.writeUTF("");
			tag.write(output);
		}
	}

	private static NBTTag readTag(DataInput input, int idk, NBTReadLimiter limit) throws IOException {
		byte tagId = input.readByte();
		if (tagId == 0) {
			return new NBTEndTag();
		} else {
			input.readUTF();
			NBTTag tag = NBTTag.byId(tagId);
			try {
				tag.read(input, idk, limit);
				return tag;
			} catch (IOException var8) {
				CrashReport crashReport = CrashReport.generateCrashReport(var8, "Loading NBT data");
				CrashReportSystemDetails crashReportDetails = crashReport.generateSystemDetails("NBT Tag");
				crashReportDetails.addDetails("Tag name", (Object) "[UNNAMED TAG]");
				crashReportDetails.addDetails("Tag type", (Object) Byte.valueOf(tagId));
				throw new ReportedException(crashReport);
			}
		}
	}

}
