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

public class fz {

	public static NBTCompoundTag a(InputStream var0) throws IOException {
		DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0)));

		NBTCompoundTag var2;
		try {
			var2 = a((DataInput) var1, NBTReadLimiter.notlimited);
		} finally {
			var1.close();
		}

		return var2;
	}

	public static void a(NBTCompoundTag var0, OutputStream var1) throws IOException {
		DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var1)));

		try {
			a(var0, (DataOutput) var2);
		} finally {
			var2.close();
		}

	}

	public static NBTCompoundTag a(DataInputStream var0) throws IOException {
		return a((DataInput) var0, NBTReadLimiter.notlimited);
	}

	public static NBTCompoundTag a(DataInput var0, NBTReadLimiter var1) throws IOException {
		NBTTag var2 = a(var0, 0, var1);
		if (var2 instanceof NBTCompoundTag) {
			return (NBTCompoundTag) var2;
		} else {
			throw new IOException("Root tag must be a named compound tag");
		}
	}

	public static void a(NBTCompoundTag var0, DataOutput var1) throws IOException {
		a((NBTTag) var0, var1);
	}

	private static void a(NBTTag var0, DataOutput var1) throws IOException {
		var1.writeByte(var0.getId());
		if (var0.getId() != 0) {
			var1.writeUTF("");
			var0.write(var1);
		}
	}

	private static NBTTag a(DataInput var0, int var1, NBTReadLimiter var2) throws IOException {
		byte var3 = var0.readByte();
		if (var3 == 0) {
			return new NBTEndTag();
		} else {
			var0.readUTF();
			NBTTag var4 = NBTTag.byId(var3);

			try {
				var4.read(var0, var1, var2);
				return var4;
			} catch (IOException var8) {
				CrashReport var6 = CrashReport.generateCrashReport(var8, "Loading NBT data");
				CrashReportSystemDetails var7 = var6.generateSystemDetails("NBT Tag");
				var7.addDetails("Tag name", (Object) "[UNNAMED TAG]");
				var7.addDetails("Tag type", (Object) Byte.valueOf(var3));
				throw new ReportedException(var6);
			}
		}
	}
}
