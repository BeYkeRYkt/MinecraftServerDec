package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityTypes {

	private static final Logger logger = LogManager.getLogger();
	private static final Map<String, Class<? extends Entity>> nameToClass = Maps.newHashMap();
	private static final Map<Class<? extends Entity>, String> classToName = Maps.newHashMap();
	private static final Map<Integer, Class<? extends Entity>> idToClass = Maps.newHashMap();
	private static final Map<Class<? extends Entity>, Integer> classToId = Maps.newHashMap();
	private static final Map<String, Integer> nameToId = Maps.newHashMap();

	public static final Map<Integer, MonsterEggInfo> eggInfo = Maps.newLinkedHashMap();

	private static void register(Class<? extends Entity> entityClass, String name, int fixedId) {
		if (nameToClass.containsKey(name)) {
			throw new IllegalArgumentException("ID is already registered: " + name);
		} else if (idToClass.containsKey(fixedId)) {
			throw new IllegalArgumentException("ID is already registered: " + fixedId);
		} else if (fixedId == 0) {
			throw new IllegalArgumentException("Cannot register to reserved id: " + fixedId);
		} else if (entityClass == null) {
			throw new IllegalArgumentException("Cannot register null clazz for id: " + fixedId);
		} else {
			nameToClass.put(name, entityClass);
			classToName.put(entityClass, name);
			idToClass.put(fixedId, entityClass);
			classToId.put(entityClass, fixedId);
			nameToId.put(name, fixedId);
		}
	}

	static {
		register(EntityItem.class, "Item", 1);
		register(EntityExpirienceOrb.class, "XPOrb", 2);
		register(EntityLeash.class, "LeashKnot", 8);
		register(EntityPainting.class, "Painting", 9);
		register(EntityArrow.class, "Arrow", 10);
		register(EntitySnowball.class, "Snowball", 11);
		register(EntityLargeFireball.class, "Fireball", 12);
		register(EntitySmallFireball.class, "SmallFireball", 13);
		register(EntityEnderPearl.class, "ThrownEnderpearl", 14);
		register(EntityEnderSignal.class, "EyeOfEnderSignal", 15);
		register(EntityPotion.class, "ThrownPotion", 16);
		register(EntityThrownExpBottle.class, "ThrownExpBottle", 17);
		register(EntityItemFrame.class, "ItemFrame", 18);
		register(EntityWitherSkull.class, "WitherSkull", 19);
		register(EntityTNTPrimed.class, "PrimedTnt", 20);
		register(EntityFallingBlock.class, "FallingSand", 21);
		register(EntityFireworks.class, "FireworksRocketEntity", 22);
		register(EntityArmorStand.class, "ArmorStand", 30);
		register(EntityBoat.class, "Boat", 41);
		register(EntityMinecartRideable.class, MinecartType.RIDEABLE.getName(), 42);
		register(EntityMinecartChest.class, MinecartType.CHEST.getName(), 43);
		register(EntityMinecartFurnace.class, MinecartType.FURNACE.getName(), 44);
		register(EntityMinecartTNT.class, MinecartType.TNT.getName(), 45);
		register(EntityMinecartHopper.class, MinecartType.HOPPER.getName(), 46);
		register(EntityMinecartMobSpawner.class, MinecartType.SPAWNER.getName(), 47);
		register(EntityMinecartCommandBlock.class, MinecartType.COMMAND_BLOCK.getName(), 40);
		register(EntityInsentient.class, "Mob", 48);
		register(EntityMonster.class, "Monster", 49);
		register(EntityCreeper.class, "Creeper", 50, 894731, 0);
		register(EntitySkeleton.class, "Skeleton", 51, 12698049, 4802889);
		register(EntitySpider.class, "Spider", 52, 3419431, 11013646);
		register(EntityGiantZombie.class, "Giant", 53);
		register(EntityZombie.class, "Zombie", 54, '\uafaf', 7969893);
		register(EntitySlime.class, "Slime", 55, 5349438, 8306542);
		register(EntityGhast.class, "Ghast", 56, 16382457, 12369084);
		register(EntityPigZombie.class, "PigZombie", 57, 15373203, 5009705);
		register(EntityEnderman.class, "Enderman", 58, 1447446, 0);
		register(EntityCaveSpider.class, "CaveSpider", 59, 803406, 11013646);
		register(EntitySilverfish.class, "Silverfish", 60, 7237230, 3158064);
		register(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
		register(EntityMagmaCube.class, "LavaSlime", 62, 3407872, 16579584);
		register(EntityEnderDragon.class, "EnderDragon", 63);
		register(EntityWither.class, "WitherBoss", 64);
		register(EntityBat.class, "Bat", 65, 4996656, 986895);
		register(EntityWitch.class, "Witch", 66, 3407872, 5349438);
		register(EntityEndermite.class, "Endermite", 67, 1447446, 7237230);
		register(EntityGuardian.class, "Guardian", 68, 5931634, 15826224);
		register(EntityPig.class, "Pig", 90, 15771042, 14377823);
		register(EntitySheep.class, "Sheep", 91, 15198183, 16758197);
		register(EntityCow.class, "Cow", 92, 4470310, 10592673);
		register(EntityChicken.class, "Chicken", 93, 10592673, 16711680);
		register(EntitySquid.class, "Squid", 94, 2243405, 7375001);
		register(EntityWolf.class, "Wolf", 95, 14144467, 13545366);
		register(EntityMushroomCow.class, "MushroomCow", 96, 10489616, 12040119);
		register(EntitySnowman.class, "SnowMan", 97);
		register(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
		register(EntityIronGolem.class, "VillagerGolem", 99);
		register(EntityHorse.class, "EntityHorse", 100, 12623485, 15656192);
		register(EntityRabbit.class, "Rabbit", 101, 10051392, 7555121);
		register(EntityVillager.class, "Villager", 120, 5651507, 12422002);
		register(EntityEnderCrystal.class, "EnderCrystal", 200);
	}

	private static void register(Class<? extends Entity> entityClass, String name, int fixedId, int var3, int var4) {
		register(entityClass, name, fixedId);
		eggInfo.put(fixedId, new MonsterEggInfo(fixedId, var3, var4));
	}

	public static Entity createEntity(String name, World world) {
		Entity entity = null;

		try {
			Class<? extends Entity> entityClass = nameToClass.get(name);
			if (entityClass != null) {
				entity = entityClass.getConstructor(World.class).newInstance(world);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return entity;
	}

	public static Entity loadEntity(NBTCompoundTag nbt, World world) {
		Entity entity = null;
		if ("Minecart".equals(nbt.getString("id"))) {
			nbt.put("id", MinecartType.byId(nbt.getInt("Type")).getName());
			nbt.remove("Type");
		}

		try {
			Class<? extends Entity> entityClass = nameToClass.get(nbt.getString("id"));
			if (entityClass != null) {
				entity = entityClass.getConstructor(World.class).newInstance(world);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (entity != null) {
			entity.load(nbt);
		} else {
			logger.warn("Skipping Entity with id " + nbt.getString("id"));
		}

		return entity;
	}

	public static Entity createEntity(int fixedId, World world) {
		Entity entity = null;

		try {
			Class<?> entityClass = getClassById(fixedId);
			if (entityClass != null) {
				entity = (Entity) entityClass.getConstructor(World.class).newInstance(world);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (entity == null) {
			logger.warn("Skipping Entity with id " + fixedId);
		}

		return entity;
	}

	public static int getFixedId(Entity entity) {
		Integer integer = classToId.get(entity.getClass());
		return integer == null ? 0 : integer.intValue();
	}

	public static Class<? extends Entity> getClassById(int id) {
		return idToClass.get(id);
	}

	public static String getNameByClass(Entity entity) {
		return classToName.get(entity.getClass());
	}

	public static String getNameById(int id) {
		return classToName.get(getClassById(id));
	}

	public static void someEmptyMethodIDKWhyItsThere() {
	}

	public static List<String> getNonAbstractEntityNames() {
		ArrayList<String> result = Lists.newArrayList();

		for (Entry<String, Class<? extends Entity>> entry: nameToClass.entrySet()) {
			if ((entry.getValue().getModifiers() & Modifier.ABSTRACT) != Modifier.ABSTRACT) {
				result.add(entry.getKey());
			}
		}

		result.add("LightningBolt");
		return result;
	}

	public static boolean isEntityOfThatType(Entity entity, String entityName) {
		String name = getNameByClass(entity);
		if (name == null && entity instanceof EntityHuman) {
			name = "Player";
		} else if (name == null && entity instanceof EntityLightning) {
			name = "LightningBolt";
		}

		return entityName.equals(name);
	}

	public static boolean isEntity(String entityName) {
		return "Player".equals(entityName) || getNonAbstractEntityNames().contains(entityName);
	}

}
