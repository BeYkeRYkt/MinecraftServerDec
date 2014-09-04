package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bmq {

	private static final Logger a = LogManager.getLogger();
	private static Map b = Maps.newHashMap();
	private static Map c = Maps.newHashMap();
	private static Map d = Maps.newHashMap();
	private static Map e = Maps.newHashMap();

	private static void b(Class var0, String var1) {
		b.put(var1, var0);
		c.put(var0, var1);
	}

	static void a(Class var0, String var1) {
		d.put(var1, var0);
		e.put(var0, var1);
	}

	public static String a(bmv var0) {
		return (String) c.get(var0.getClass());
	}

	public static String a(bms var0) {
		return (String) e.get(var0.getClass());
	}

	public static bmv a(NBTCompoundTag var0, World var1) {
		bmv var2 = null;

		try {
			Class var3 = (Class) b.get(var0.j("id"));
			if (var3 != null) {
				var2 = (bmv) var3.newInstance();
			}
		} catch (Exception var4) {
			a.warn("Failed Start with id " + var0.j("id"));
			var4.printStackTrace();
		}

		if (var2 != null) {
			var2.a(var1, var0);
		} else {
			a.warn("Skipping Structure with id " + var0.j("id"));
		}

		return var2;
	}

	public static bms b(NBTCompoundTag var0, World var1) {
		bms var2 = null;

		try {
			Class var3 = (Class) d.get(var0.j("id"));
			if (var3 != null) {
				var2 = (bms) var3.newInstance();
			}
		} catch (Exception var4) {
			a.warn("Failed Piece with id " + var0.j("id"));
			var4.printStackTrace();
		}

		if (var2 != null) {
			var2.a(var1, var0);
		} else {
			a.warn("Skipping Piece with id " + var0.j("id"));
		}

		return var2;
	}

	static {
		b(bjk.class, "Mineshaft");
		b(bmx.class, "Village");
		b(bjm.class, "Fortress");
		b(blq.class, "Stronghold");
		b(blh.class, "Temple");
		b(bkh.class, "Monument");
		bje.a();
		bmy.a();
		bjn.a();
		blr.a();
		bli.a();
		bki.a();
	}
}
