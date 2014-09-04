package net.minecraft;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class afs {

	private static final Logger f = LogManager.getLogger();
	public static final xy a = (new yg((xy) null, "generic.maxHealth", 20.0D, 0.0D, Double.MAX_VALUE)).a("Max Health").a(true);
	public static final xy b = (new yg((xy) null, "generic.followRange", 32.0D, 0.0D, 2048.0D)).a("Follow Range");
	public static final xy c = (new yg((xy) null, "generic.knockbackResistance", 0.0D, 0.0D, 1.0D)).a("Knockback Resistance");
	public static final xy d = (new yg((xy) null, "generic.movementSpeed", 0.699999988079071D, 0.0D, Double.MAX_VALUE)).a("Movement Speed").a(true);
	public static final xy e = new yg((xy) null, "generic.attackDamage", 2.0D, 0.0D, Double.MAX_VALUE);

	public static NBTListTag a(yc var0) {
		NBTListTag var1 = new NBTListTag();
		Iterator var2 = var0.a().iterator();

		while (var2.hasNext()) {
			xz var3 = (xz) var2.next();
			var1.a((NBTTag) a(var3));
		}

		return var1;
	}

	private static NBTCompoundTag a(xz var0) {
		NBTCompoundTag var1 = new NBTCompoundTag();
		xy var2 = var0.a();
		var1.a("Name", var2.a());
		var1.a("Base", var0.b());
		Collection var3 = var0.c();
		if (var3 != null && !var3.isEmpty()) {
			NBTListTag var4 = new NBTListTag();
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				ya var6 = (ya) var5.next();
				if (var6.e()) {
					var4.a((NBTTag) a(var6));
				}
			}

			var1.a("Modifiers", (NBTTag) var4);
		}

		return var1;
	}

	private static NBTCompoundTag a(ya var0) {
		NBTCompoundTag var1 = new NBTCompoundTag();
		var1.a("Name", var0.b());
		var1.a("Amount", var0.d());
		var1.a("Operation", var0.c());
		var1.a("UUIDMost", var0.a().getMostSignificantBits());
		var1.a("UUIDLeast", var0.a().getLeastSignificantBits());
		return var1;
	}

	public static void a(yc var0, NBTListTag var1) {
		for (int var2 = 0; var2 < var1.c(); ++var2) {
			NBTCompoundTag var3 = var1.b(var2);
			xz var4 = var0.a(var3.j("Name"));
			if (var4 != null) {
				a(var4, var3);
			} else {
				f.warn("Ignoring unknown attribute \'" + var3.j("Name") + "\'");
			}
		}

	}

	private static void a(xz var0, NBTCompoundTag var1) {
		var0.a(var1.i("Base"));
		if (var1.b("Modifiers", 9)) {
			NBTListTag var2 = var1.c("Modifiers", 10);

			for (int var3 = 0; var3 < var2.c(); ++var3) {
				ya var4 = a(var2.b(var3));
				if (var4 != null) {
					ya var5 = var0.a(var4.a());
					if (var5 != null) {
						var0.c(var5);
					}

					var0.b(var4);
				}
			}
		}

	}

	public static ya a(NBTCompoundTag var0) {
		UUID var1 = new UUID(var0.g("UUIDMost"), var0.g("UUIDLeast"));

		try {
			return new ya(var1, var0.j("Name"), var0.i("Amount"), var0.f("Operation"));
		} catch (Exception var3) {
			f.warn("Unable to create attribute: " + var3.getMessage());
			return null;
		}
	}

}
