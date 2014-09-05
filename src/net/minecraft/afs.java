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
			AttributeInstance var3 = (AttributeInstance) var2.next();
			var1.addTag((NBTTag) a(var3));
		}

		return var1;
	}

	private static NBTCompoundTag a(AttributeInstance var0) {
		NBTCompoundTag var1 = new NBTCompoundTag();
		xy var2 = var0.a();
		var1.put("Name", var2.a());
		var1.put("Base", var0.b());
		Collection var3 = var0.c();
		if (var3 != null && !var3.isEmpty()) {
			NBTListTag var4 = new NBTListTag();
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				AttributeModifier var6 = (AttributeModifier) var5.next();
				if (var6.isSerializable()) {
					var4.addTag((NBTTag) a(var6));
				}
			}

			var1.put("Modifiers", (NBTTag) var4);
		}

		return var1;
	}

	private static NBTCompoundTag a(AttributeModifier var0) {
		NBTCompoundTag var1 = new NBTCompoundTag();
		var1.put("Name", var0.getName());
		var1.put("Amount", var0.getAmount());
		var1.put("Operation", var0.getOperation());
		var1.put("UUIDMost", var0.getUUID().getMostSignificantBits());
		var1.put("UUIDLeast", var0.getUUID().getLeastSignificantBits());
		return var1;
	}

	public static void a(yc var0, NBTListTag var1) {
		for (int var2 = 0; var2 < var1.getSize(); ++var2) {
			NBTCompoundTag var3 = var1.getCompound(var2);
			AttributeInstance var4 = var0.a(var3.getString("Name"));
			if (var4 != null) {
				a(var4, var3);
			} else {
				f.warn("Ignoring unknown attribute \'" + var3.getString("Name") + "\'");
			}
		}

	}

	private static void a(AttributeInstance var0, NBTCompoundTag var1) {
		var0.a(var1.getDouble("Base"));
		if (var1.isTagAssignableFrom("Modifiers", 9)) {
			NBTListTag var2 = var1.getList("Modifiers", 10);

			for (int var3 = 0; var3 < var2.getSize(); ++var3) {
				AttributeModifier var4 = a(var2.getCompound(var3));
				if (var4 != null) {
					AttributeModifier var5 = var0.a(var4.getUUID());
					if (var5 != null) {
						var0.c(var5);
					}

					var0.b(var4);
				}
			}
		}

	}

	public static AttributeModifier a(NBTCompoundTag var0) {
		UUID var1 = new UUID(var0.getLong("UUIDMost"), var0.getLong("UUIDLeast"));

		try {
			return new AttributeModifier(var1, var0.getString("Name"), var0.getDouble("Amount"), var0.getInt("Operation"));
		} catch (Exception var3) {
			f.warn("Unable to create attribute: " + var3.getMessage());
			return null;
		}
	}

}
