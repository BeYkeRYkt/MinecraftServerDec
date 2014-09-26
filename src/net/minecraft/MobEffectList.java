package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

public class MobEffectList {

	public static final MobEffectList[] byId = new MobEffectList[32];
	private static final Map<RegistryObjectName, MobEffectList> byName = Maps.newHashMap();
	public static final MobEffectList FASTER_MOVEMENT = (new MobEffectList(1, new RegistryObjectName("speed"), false, 8171462)).c("potion.moveSpeed").b(0, 0).a(afs.d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
	public static final MobEffectList SLOWER_MOVEMENT = (new MobEffectList(2, new RegistryObjectName("slowness"), true, 5926017)).c("potion.moveSlowdown").b(1, 0).a(afs.d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448D, 2);
	public static final MobEffectList FASTER_DIG = (new MobEffectList(3, new RegistryObjectName("haste"), false, 14270531)).c("potion.digSpeed").b(2, 0).a(1.5D);
	public static final MobEffectList SLOWER_DIG = (new MobEffectList(4, new RegistryObjectName("mining_fatigue"), true, 4866583)).c("potion.digSlowDown").b(3, 0);
	public static final MobEffectList INCREASE_DAMAGE = (new MobEffectAttackDamage(5, new RegistryObjectName("strength"), false, 9643043)).c("potion.damageBoost").b(4, 0).a(afs.e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 2.5D, 2);
	public static final MobEffectList HEAL = (new InstantMobEffect(6, new RegistryObjectName("instant_health"), false, 16262179)).c("potion.heal");
	public static final MobEffectList HARM = (new InstantMobEffect(7, new RegistryObjectName("instant_damage"), true, 4393481)).c("potion.harm");
	public static final MobEffectList JUMP = (new MobEffectList(8, new RegistryObjectName("jump_boost"), false, 2293580)).c("potion.jump").b(2, 1);
	public static final MobEffectList CONFUSION = (new MobEffectList(9, new RegistryObjectName("nausea"), true, 5578058)).c("potion.confusion").b(3, 1).a(0.25D);
	public static final MobEffectList REGENERATION = (new MobEffectList(10, new RegistryObjectName("regeneration"), false, 13458603)).c("potion.regeneration").b(7, 0).a(0.25D);
	public static final MobEffectList RESISTANCE = (new MobEffectList(11, new RegistryObjectName("resistance"), false, 10044730)).c("potion.resistance").b(6, 1);
	public static final MobEffectList FIRE_RESISTANCE = (new MobEffectList(12, new RegistryObjectName("fire_resistance"), false, 14981690)).c("potion.fireResistance").b(7, 1);
	public static final MobEffectList WATER_BREATHING = (new MobEffectList(13, new RegistryObjectName("water_breathing"), false, 3035801)).c("potion.waterBreathing").b(0, 2);
	public static final MobEffectList INVISIBILITY = (new MobEffectList(14, new RegistryObjectName("invisibility"), false, 8356754)).c("potion.invisibility").b(0, 1);
	public static final MobEffectList BLINDNESS = (new MobEffectList(15, new RegistryObjectName("blindness"), true, 2039587)).c("potion.blindness").b(5, 1).a(0.25D);
	public static final MobEffectList NIGHT_VISION = (new MobEffectList(16, new RegistryObjectName("night_vision"), false, 2039713)).c("potion.nightVision").b(4, 1);
	public static final MobEffectList HUNGER = (new MobEffectList(17, new RegistryObjectName("hunger"), true, 5797459)).c("potion.hunger").b(1, 1);
	public static final MobEffectList WEAKNESS = (new MobEffectAttackDamage(18, new RegistryObjectName("weakness"), true, 4738376)).c("potion.weakness").b(5, 0).a(afs.e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0D, 0);
	public static final MobEffectList POISON = (new MobEffectList(19, new RegistryObjectName("poison"), true, 5149489)).c("potion.poison").b(6, 0).a(0.25D);
	public static final MobEffectList WITHER = (new MobEffectList(20, new RegistryObjectName("wither"), true, 3484199)).c("potion.wither").b(1, 2).a(0.25D);
	public static final MobEffectList HEALTH_BOOST = (new MobEffectHealthBoost(21, new RegistryObjectName("health_boost"), false, 16284963)).c("potion.healthBoost").b(2, 2).a(afs.a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0D, 0);
	public static final MobEffectList ABSORPTION = (new MobEffectAbsorption(22, new RegistryObjectName("absorption"), false, 2445989)).c("potion.absorption").b(2, 2);
	public static final MobEffectList SATURATION = (new InstantMobEffect(23, new RegistryObjectName("saturation"), false, 16262179)).c("potion.saturation");
	public final int id;
	private final Map J = Maps.newHashMap();
	private final boolean K;
	private final int L;
	private String M = "";
	private int N = -1;
	private double O;
	private boolean P;

	protected MobEffectList(int id, RegistryObjectName var2, boolean var3, int var4) {
		this.id = id;
		byId[id] = this;
		byName.put(var2, this);
		this.K = var3;
		if (var3) {
			this.O = 0.5D;
		} else {
			this.O = 1.0D;
		}

		this.L = var4;
	}

	public static MobEffectList getByName(String name) {
		return (MobEffectList) byName.get(new RegistryObjectName(name));
	}

	public static String[] c() {
		String[] var0 = new String[byName.size()];
		int var1 = 0;

		RegistryObjectName var3;
		for (Iterator var2 = byName.keySet().iterator(); var2.hasNext(); var0[var1++] = var3.toString()) {
			var3 = (RegistryObjectName) var2.next();
		}

		return var0;
	}

	protected MobEffectList b(int var1, int var2) {
		this.N = var1 + var2 * 8;
		return this;
	}

	public int getId() {
		return this.id;
	}

	public void tick(EntityLiving entityLiing, int var2) {
		if (this.id == REGENERATION.id) {
			if (entityLiing.getHealth() < entityLiing.bt()) {
				entityLiing.g(1.0F);
			}
		} else if (this.id == POISON.id) {
			if (entityLiing.getHealth() > 1.0F) {
				entityLiing.receiveDamage(DamageSource.MAGIC, 1.0F);
			}
		} else if (this.id == WITHER.id) {
			entityLiing.receiveDamage(DamageSource.WITHER, 1.0F);
		} else if (this.id == HUNGER.id && entityLiing instanceof EntityHuman) {
			((EntityHuman) entityLiing).a(0.025F * (float) (var2 + 1));
		} else if (this.id == SATURATION.id && entityLiing instanceof EntityHuman) {
			if (!entityLiing.world.isStatic) {
				((EntityHuman) entityLiing).ck().a(var2 + 1, 1.0F);
			}
		} else if ((this.id != HEAL.id || entityLiing.bl()) && (this.id != HARM.id || !entityLiing.bl())) {
			if (this.id == HARM.id && !entityLiing.bl() || this.id == HEAL.id && entityLiing.bl()) {
				entityLiing.receiveDamage(DamageSource.MAGIC, (float) (6 << var2));
			}
		} else {
			entityLiing.g((float) Math.max(4 << var2, 0));
		}

	}

	public void a(Entity var1, Entity var2, EntityLiving var3, int var4, double var5) {
		int var7;
		if ((this.id != HEAL.id || var3.bl()) && (this.id != HARM.id || !var3.bl())) {
			if (this.id == HARM.id && !var3.bl() || this.id == HEAL.id && var3.bl()) {
				var7 = (int) (var5 * (double) (6 << var4) + 0.5D);
				if (var1 == null) {
					var3.receiveDamage(DamageSource.MAGIC, (float) var7);
				} else {
					var3.receiveDamage(DamageSource.magic(var1, var2), (float) var7);
				}
			}
		} else {
			var7 = (int) (var5 * (double) (4 << var4) + 0.5D);
			var3.g((float) var7);
		}

	}

	public boolean b() {
		return false;
	}

	public boolean shouldTick(int var1, int var2) {
		int var3;
		if (this.id == REGENERATION.id) {
			var3 = 50 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else if (this.id == POISON.id) {
			var3 = 25 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else if (this.id == WITHER.id) {
			var3 = 40 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else {
			return this.id == HUNGER.id;
		}
	}

	public MobEffectList c(String var1) {
		this.M = var1;
		return this;
	}

	public String getName() {
		return this.M;
	}

	protected MobEffectList a(double var1) {
		this.O = var1;
		return this;
	}

	public double h() {
		return this.O;
	}

	public boolean j() {
		return this.P;
	}

	public int k() {
		return this.L;
	}

	public MobEffectList a(xy var1, String var2, double var3, int var5) {
		AttributeModifier var6 = new AttributeModifier(UUID.fromString(var2), this.getName(), var3, var5);
		this.J.put(var1, var6);
		return this;
	}

	public void a(EntityLiving var1, yc var2, int var3) {
		Iterator var4 = this.J.entrySet().iterator();

		while (var4.hasNext()) {
			Entry var5 = (Entry) var4.next();
			AttributeInstance var6 = var2.a((xy) var5.getKey());
			if (var6 != null) {
				var6.c((AttributeModifier) var5.getValue());
			}
		}

	}

	public void b(EntityLiving var1, yc var2, int var3) {
		Iterator var4 = this.J.entrySet().iterator();

		while (var4.hasNext()) {
			Entry var5 = (Entry) var4.next();
			AttributeInstance var6 = var2.a((xy) var5.getKey());
			if (var6 != null) {
				AttributeModifier var7 = (AttributeModifier) var5.getValue();
				var6.c(var7);
				var6.b(new AttributeModifier(var7.getUUID(), this.getName() + " " + var3, this.a(var3, var7), var7.getOperation()));
			}
		}

	}

	public double a(int var1, AttributeModifier var2) {
		return var2.getAmount() * (double) (var1 + 1);
	}

}
