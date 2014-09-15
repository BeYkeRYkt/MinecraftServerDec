package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public abstract class Enchantment {

	public static final Enchantment[] enchants;
	private static final Enchantment[] byId = new Enchantment[256];
	private static final Map<RegistryObjectName, Enchantment> byName = Maps.newHashMap();

	public static final Enchantment PROTECTION_ENVIRONMENTAL = new EnchantmentProtection(0, new RegistryObjectName("protection"), 10, 0);
	public static final Enchantment PROTECTION_FIRE = new EnchantmentProtection(1, new RegistryObjectName("fire_protection"), 5, 1);
	public static final Enchantment PROTECTION_FALLe = new EnchantmentProtection(2, new RegistryObjectName("feather_falling"), 5, 2);
	public static final Enchantment PROTECTION_EXPLOSIONS = new EnchantmentProtection(3, new RegistryObjectName("blast_protection"), 2, 3);
	public static final Enchantment PROTECTION_PROJECTILE = new EnchantmentProtection(4, new RegistryObjectName("projectile_protection"), 5, 4);
	public static final Enchantment OXYGEN = new EnchantmentOxygen(5, new RegistryObjectName("respiration"), 2);
	public static final Enchantment WATER_WORKER = new EnchantmentWaterWorker(6, new RegistryObjectName("aqua_affinity"), 2);
	public static final Enchantment THORNS = new EnchantmentThorns(7, new RegistryObjectName("thorns"), 1);
	public static final Enchantment DEPTH_STRIDER = new EnchantmentDepthStrider(8, new RegistryObjectName("depth_strider"), 2);
	public static final Enchantment DAMAGE_ALL = new EnchantmentWeaponDamage(16, new RegistryObjectName("sharpness"), 10, 0);
	public static final Enchantment DAMAGE_UNDEAD = new EnchantmentWeaponDamage(17, new RegistryObjectName("smite"), 5, 1);
	public static final Enchantment DAMAGE_ARTHROPODS = new EnchantmentWeaponDamage(18, new RegistryObjectName("bane_of_arthropods"), 5, 2);
	public static final Enchantment KNOCKBACK = new EnchantmentKnockback(19, new RegistryObjectName("knockback"), 5);
	public static final Enchantment FIRE_ASPECT = new EnchantmentFire(20, new RegistryObjectName("fire_aspect"), 2);
	public static final Enchantment LOOT_BONUS_MOBS = new EnchantmentLootBonus(21, new RegistryObjectName("looting"), 2, EnchantmentSlotType.WEAPON);
	public static final Enchantment DIG_SPEED = new EnchantmentDigging(32, new RegistryObjectName("efficiency"), 10);
	public static final Enchantment SILK_TOUCH = new EnchantmentSilkTouch(33, new RegistryObjectName("silk_touch"), 1);
	public static final Enchantment DURABILITY = new EnchantmentDurability(34, new RegistryObjectName("unbreaking"), 5);
	public static final Enchantment LOOT_BONUS_BLOCKS = new EnchantmentLootBonus(35, new RegistryObjectName("fortune"), 2, EnchantmentSlotType.DIGGER);
	public static final Enchantment ARROW_DAMAGE = new EnchantmentArrowDamage(48, new RegistryObjectName("power"), 10);
	public static final Enchantment ARROW_KNOCKBACK = new EnchantmentArrowKnockback(49, new RegistryObjectName("punch"), 2);
	public static final Enchantment ARROW_FIRE = new EnchantmentFlameArrows(50, new RegistryObjectName("flame"), 2);
	public static final Enchantment ARROW_INFINITE = new EnchantmentInfiniteArrows(51, new RegistryObjectName("infinity"), 1);
	public static final Enchantment LUCK = new EnchantmentLootBonus(61, new RegistryObjectName("luck_of_the_sea"), 2, EnchantmentSlotType.FISHING_ROD);
	public static final Enchantment LURE = new EnchantmentLure(62, new RegistryObjectName("lure"), 2, EnchantmentSlotType.FISHING_ROD);

	static {
		ArrayList<Enchantment> list = Lists.newArrayList();

		for (int i = 0; i < byId.length; ++i) {
			Enchantment ench = byId[i];
			if (ench != null) {
				list.add(ench);
			}
		}

		enchants = (Enchantment[]) list.toArray(new Enchantment[list.size()]);
	}

	public static String[] getEnchants() {
		String[] var0 = new String[byName.size()];
		int var1 = 0;

		RegistryObjectName var3;
		for (Iterator<RegistryObjectName> var2 = byName.keySet().iterator(); var2.hasNext(); var0[var1++] = var3.toString()) {
			var3 = (RegistryObjectName) var2.next();
		}

		return var0;
	}

	public final int id;
	private final int weight;
	public EnchantmentSlotType slot;
	protected String name;

	public static Enchantment getById(int id) {
		return id >= 0 && id < byId.length ? byId[id] : null;
	}

	public static Enchantment getByName(String name) {
		return (Enchantment) byName.get(new RegistryObjectName(name));
	}

	protected Enchantment(int id, RegistryObjectName name, int weight, EnchantmentSlotType slot) {
		this.id = id;
		this.weight = weight;
		this.slot = slot;
		if (byId[id] != null) {
			throw new IllegalArgumentException("Duplicate enchantment id!");
		} else {
			byId[id] = this;
			byName.put(name, this);
		}
	}

	public int getRandomWeight() {
		return this.weight;
	}

	public int getStartLevel() {
		return 1;
	}

	public int getMaxLevel() {
		return 1;
	}

	public int a(int var1) {
		return 1 + var1 * 10;
	}

	public int b(int var1) {
		return this.a(var1) + 5;
	}

	public int a(int var1, DamageSource var2) {
		return 0;
	}

	public float a(int var1, EnumMonsterType var2) {
		return 0.0F;
	}

	public boolean a(Enchantment var1) {
		return this != var1;
	}

	public Enchantment setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return "enchantment." + this.name;
	}

	public String getName(int level) {
		String name = LocaleI18n.get(this.getName());
		return name + " " + LocaleI18n.get("enchantment.level." + level);
	}

	public boolean canEnchant(ItemStack var1) {
		return this.slot.canEnchant(var1.getItem());
	}

	public void a(EntityLiving var1, Entity var2, int var3) {
	}

	public void b(EntityLiving var1, Entity var2, int var3) {
	}

}
