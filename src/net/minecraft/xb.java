package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class xb {

	private static final Logger b = LogManager.getLogger();
	private static final Map c = Maps.newHashMap();
	private static final Map d = Maps.newHashMap();
	private static final Map e = Maps.newHashMap();
	private static final Map f = Maps.newHashMap();
	private static final Map g = Maps.newHashMap();
	public static final Map a = Maps.newLinkedHashMap();

	private static void a(Class var0, String var1, int var2) {
		if (c.containsKey(var1)) {
			throw new IllegalArgumentException("ID is already registered: " + var1);
		} else if (e.containsKey(Integer.valueOf(var2))) {
			throw new IllegalArgumentException("ID is already registered: " + var2);
		} else if (var2 == 0) {
			throw new IllegalArgumentException("Cannot register to reserved id: " + var2);
		} else if (var0 == null) {
			throw new IllegalArgumentException("Cannot register null clazz for id: " + var2);
		} else {
			c.put(var1, var0);
			d.put(var0, var1);
			e.put(Integer.valueOf(var2), var0);
			f.put(var0, Integer.valueOf(var2));
			g.put(var1, Integer.valueOf(var2));
		}
	}

	private static void a(Class var0, String var1, int var2, int var3, int var4) {
		a(var0, var1, var2);
		a.put(Integer.valueOf(var2), new xc(var2, var3, var4));
	}

	public static Entity a(String var0, World var1) {
		Entity var2 = null;

		try {
			Class var3 = (Class) c.get(var0);
			if (var3 != null) {
				var2 = (Entity) var3.getConstructor(new Class[] { World.class }).newInstance(new Object[] { var1 });
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		return var2;
	}

	public static Entity a(NBTCompoundTag var0, World var1) {
		Entity var2 = null;
		if ("Minecart".equals(var0.j("id"))) {
			var0.a("id", adz.a(var0.f("Type")).b());
			var0.o("Type");
		}

		try {
			Class var3 = (Class) c.get(var0.j("id"));
			if (var3 != null) {
				var2 = (Entity) var3.getConstructor(new Class[] { World.class }).newInstance(new Object[] { var1 });
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if (var2 != null) {
			var2.f(var0);
		} else {
			b.warn("Skipping Entity with id " + var0.j("id"));
		}

		return var2;
	}

	public static Entity a(int var0, World var1) {
		Entity var2 = null;

		try {
			Class var3 = a(var0);
			if (var3 != null) {
				var2 = (Entity) var3.getConstructor(new Class[] { World.class }).newInstance(new Object[] { var1 });
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if (var2 == null) {
			b.warn("Skipping Entity with id " + var0);
		}

		return var2;
	}

	public static int a(Entity var0) {
		Integer var1 = (Integer) f.get(var0.getClass());
		return var1 == null ? 0 : var1.intValue();
	}

	public static Class a(int var0) {
		return (Class) e.get(Integer.valueOf(var0));
	}

	public static String b(Entity var0) {
		return (String) d.get(var0.getClass());
	}

	public static String b(int var0) {
		return (String) d.get(a(var0));
	}

	public static void a() {
	}

	public static List b() {
		Set var0 = c.keySet();
		ArrayList var1 = Lists.newArrayList();
		Iterator var2 = var0.iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			Class var4 = (Class) c.get(var3);
			if ((var4.getModifiers() & 1024) != 1024) {
				var1.add(var3);
			}
		}

		var1.add("LightningBolt");
		return var1;
	}

	public static boolean a(Entity var0, String var1) {
		String var2 = b(var0);
		if (var2 == null && var0 instanceof ahd) {
			var2 = "Player";
		} else if (var2 == null && var0 instanceof ads) {
			var2 = "LightningBolt";
		}

		return var1.equals(var2);
	}

	public static boolean b(String var0) {
		return "Player".equals(var0) || b().contains(var0);
	}

	static {
		a(adw.class, "Item", 1);
		a(xk.class, "XPOrb", 2);
		a(adl.class, "LeashKnot", 8);
		a(adm.class, "Painting", 9);
		a(ahj.class, "Arrow", 10);
		a(ahq.class, "Snowball", 11);
		a(ahn.class, "Fireball", 12);
		a(ahp.class, "SmallFireball", 13);
		a(aht.class, "ThrownEnderpearl", 14);
		a(ahk.class, "EyeOfEnderSignal", 15);
		a(ahv.class, "ThrownPotion", 16);
		a(ahu.class, "ThrownExpBottle", 17);
		a(adk.class, "ItemFrame", 18);
		a(ahw.class, "WitherSkull", 19);
		a(aek.class, "PrimedTnt", 20);
		a(adv.class, "FallingSand", 21);
		a(ahm.class, "FireworksRocketEntity", 22);
		a(adi.class, "ArmorStand", 30);
		a(adu.class, "Boat", 41);
		a(aeg.class, adz.a.b(), 42);
		a(aea.class, adz.b.b(), 43);
		a(aee.class, adz.c.b(), 44);
		a(aej.class, adz.d.b(), 45);
		a(aef.class, adz.f.b(), 46);
		a(aeh.class, adz.e.b(), 47);
		a(aeb.class, adz.g.b(), 40);
		a(xn.class, "Mob", 48);
		a(afm.class, "Monster", 49);
		a(aep.class, "Creeper", 50, 894731, 0);
		a(afw.class, "Skeleton", 51, 12698049, 4802889);
		a(age.class, "Spider", 52, 3419431, 11013646);
		a(aff.class, "Giant", 53);
		a(agj.class, "Zombie", 54, '\uafaf', 7969893);
		a(afy.class, "Slime", 55, 5349438, 8306542);
		a(afa.class, "Ghast", 56, 16382457, 12369084);
		a(afo.class, "PigZombie", 57, 15373203, 5009705);
		a(aer.class, "Enderman", 58, 1447446, 0);
		a(aeo.class, "CaveSpider", 59, 803406, 11013646);
		a(aft.class, "Silverfish", 60, 7237230, 3158064);
		a(aem.class, "Blaze", 61, 16167425, 16775294);
		a(afl.class, "LavaSlime", 62, 3407872, 16579584);
		a(adb.class, "EnderDragon", 63);
		a(adf.class, "WitherBoss", 64);
		a(abo.class, "Bat", 65, 4996656, 986895);
		a(agi.class, "Witch", 66, 3407872, 5349438);
		a(aew.class, "Endermite", 67, 1447446, 7237230);
		a(afg.class, "Guardian", 68, 5931634, 15826224);
		a(aca.class, "Pig", 90, 15771042, 14377823);
		a(acl.class, "Sheep", 91, 15198183, 16758197);
		a(abs.class, "Cow", 92, 4470310, 10592673);
		a(abr.class, "Chicken", 93, 10592673, 16711680);
		a(aco.class, "Squid", 94, 2243405, 7375001);
		a(acu.class, "Wolf", 95, 14144467, 13545366);
		a(abx.class, "MushroomCow", 96, 10489616, 12040119);
		a(acn.class, "SnowMan", 97);
		a(aby.class, "Ozelot", 98, 15720061, 5653556);
		a(acq.class, "VillagerGolem", 99);
		a(abt.class, "EntityHorse", 100, 12623485, 15656192);
		a(acb.class, "Rabbit", 101, 10051392, 7555121);
		a(agp.class, "Villager", 120, 5651507, 12422002);
		a(ada.class, "EnderCrystal", 200);
	}
}
