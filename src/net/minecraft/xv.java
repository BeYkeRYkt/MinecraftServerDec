package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.lang3.ObjectUtils;

public class xv {

	private final Entity a;
	private boolean b = true;
	private static final Map c = Maps.newHashMap();
	private final Map d = Maps.newHashMap();
	private boolean e;
	private ReadWriteLock f = new ReentrantReadWriteLock();

	public xv(Entity var1) {
		this.a = var1;
	}

	public void a(int var1, Object var2) {
		Integer var3 = (Integer) c.get(var2.getClass());
		if (var3 == null) {
			throw new IllegalArgumentException("Unknown data type: " + var2.getClass());
		} else if (var1 > 31) {
			throw new IllegalArgumentException("Data value id is too big with " + var1 + "! (Max is " + 31 + ")");
		} else if (this.d.containsKey(Integer.valueOf(var1))) {
			throw new IllegalArgumentException("Duplicate id value for " + var1 + "!");
		} else {
			xw var4 = new xw(var3.intValue(), var1, var2);
			this.f.writeLock().lock();
			this.d.put(Integer.valueOf(var1), var4);
			this.f.writeLock().unlock();
			this.b = false;
		}
	}

	public void a(int var1, int var2) {
		xw var3 = new xw(var2, var1, (Object) null);
		this.f.writeLock().lock();
		this.d.put(Integer.valueOf(var1), var3);
		this.f.writeLock().unlock();
		this.b = false;
	}

	public byte a(int var1) {
		return ((Byte) this.j(var1).b()).byteValue();
	}

	public short b(int var1) {
		return ((Short) this.j(var1).b()).shortValue();
	}

	public int c(int var1) {
		return ((Integer) this.j(var1).b()).intValue();
	}

	public float d(int var1) {
		return ((Float) this.j(var1).b()).floatValue();
	}

	public String e(int var1) {
		return (String) this.j(var1).b();
	}

	public amj f(int var1) {
		return (amj) this.j(var1).b();
	}

	private xw j(int var1) {
		this.f.readLock().lock();

		xw var2;
		try {
			var2 = (xw) this.d.get(Integer.valueOf(var1));
		} catch (Throwable var6) {
			CrashReport var4 = CrashReport.a(var6, "Getting synched entity data");
			j var5 = var4.a("Synched entity data");
			var5.a("Data ID", (Object) Integer.valueOf(var1));
			throw new u(var4);
		}

		this.f.readLock().unlock();
		return var2;
	}

	public fa h(int var1) {
		return (fa) this.j(var1).b();
	}

	public void b(int var1, Object var2) {
		xw var3 = this.j(var1);
		if (ObjectUtils.notEqual(var2, var3.b())) {
			var3.a(var2);
			this.a.i(var1);
			var3.a(true);
			this.e = true;
		}

	}

	public void i(int var1) {
		xw.a(this.j(var1), true);
		this.e = true;
	}

	public boolean a() {
		return this.e;
	}

	public static void a(List var0, hd var1) {
		if (var0 != null) {
			Iterator var2 = var0.iterator();

			while (var2.hasNext()) {
				xw var3 = (xw) var2.next();
				a(var1, var3);
			}
		}

		var1.writeByte(127);
	}

	public List b() {
		ArrayList var1 = null;
		if (this.e) {
			this.f.readLock().lock();
			Iterator var2 = this.d.values().iterator();

			while (var2.hasNext()) {
				xw var3 = (xw) var2.next();
				if (var3.d()) {
					var3.a(false);
					if (var1 == null) {
						var1 = Lists.newArrayList();
					}

					var1.add(var3);
				}
			}

			this.f.readLock().unlock();
		}

		this.e = false;
		return var1;
	}

	public void a(hd var1) {
		this.f.readLock().lock();
		Iterator var2 = this.d.values().iterator();

		while (var2.hasNext()) {
			xw var3 = (xw) var2.next();
			a(var1, var3);
		}

		this.f.readLock().unlock();
		var1.writeByte(127);
	}

	public List c() {
		ArrayList var1 = null;
		this.f.readLock().lock();

		xw var3;
		for (Iterator var2 = this.d.values().iterator(); var2.hasNext(); var1.add(var3)) {
			var3 = (xw) var2.next();
			if (var1 == null) {
				var1 = Lists.newArrayList();
			}
		}

		this.f.readLock().unlock();
		return var1;
	}

	private static void a(hd var0, xw var1) {
		int var2 = (var1.c() << 5 | var1.a() & 31) & 255;
		var0.writeByte(var2);
		switch (var1.c()) {
			case 0:
				var0.writeByte(((Byte) var1.b()).byteValue());
				break;
			case 1:
				var0.writeShort(((Short) var1.b()).shortValue());
				break;
			case 2:
				var0.writeInt(((Integer) var1.b()).intValue());
				break;
			case 3:
				var0.writeFloat(((Float) var1.b()).floatValue());
				break;
			case 4:
				var0.a((String) var1.b());
				break;
			case 5:
				amj var3 = (amj) var1.b();
				var0.a(var3);
				break;
			case 6:
				dt var4 = (dt) var1.b();
				var0.writeInt(var4.n());
				var0.writeInt(var4.o());
				var0.writeInt(var4.p());
				break;
			case 7:
				fa var5 = (fa) var1.b();
				var0.writeFloat(var5.b());
				var0.writeFloat(var5.c());
				var0.writeFloat(var5.d());
		}

	}

	public static List b(hd var0) throws IOException {
		ArrayList var1 = null;

		for (byte var2 = var0.readByte(); var2 != 127; var2 = var0.readByte()) {
			if (var1 == null) {
				var1 = Lists.newArrayList();
			}

			int var3 = (var2 & 224) >> 5;
			int var4 = var2 & 31;
			xw var5 = null;
			switch (var3) {
				case 0:
					var5 = new xw(var3, var4, Byte.valueOf(var0.readByte()));
					break;
				case 1:
					var5 = new xw(var3, var4, Short.valueOf(var0.readShort()));
					break;
				case 2:
					var5 = new xw(var3, var4, Integer.valueOf(var0.readInt()));
					break;
				case 3:
					var5 = new xw(var3, var4, Float.valueOf(var0.readFloat()));
					break;
				case 4:
					var5 = new xw(var3, var4, var0.c(32767));
					break;
				case 5:
					var5 = new xw(var3, var4, var0.i());
					break;
				case 6:
					int var6 = var0.readInt();
					int var7 = var0.readInt();
					int var8 = var0.readInt();
					var5 = new xw(var3, var4, new dt(var6, var7, var8));
					break;
				case 7:
					float var9 = var0.readFloat();
					float var10 = var0.readFloat();
					float var11 = var0.readFloat();
					var5 = new xw(var3, var4, new fa(var9, var10, var11));
			}

			var1.add(var5);
		}

		return var1;
	}

	public boolean d() {
		return this.b;
	}

	public void e() {
		this.e = false;
	}

	static {
		c.put(Byte.class, Integer.valueOf(0));
		c.put(Short.class, Integer.valueOf(1));
		c.put(Integer.class, Integer.valueOf(2));
		c.put(Float.class, Integer.valueOf(3));
		c.put(String.class, Integer.valueOf(4));
		c.put(amj.class, Integer.valueOf(5));
		c.put(dt.class, Integer.valueOf(6));
		c.put(fa.class, Integer.valueOf(7));
	}
}
