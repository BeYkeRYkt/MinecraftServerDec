package net.minecraft;

import com.google.common.collect.Maps;
import java.util.HashMap;

public class xr {

	private static final HashMap a = Maps.newHashMap();

	public static xo a(Class var0) {
		return (xo) a.get(var0);
	}

	static {
		a.put(EntityBat.class, xo.a);
		a.put(EntityChicken.class, xo.a);
		a.put(EntityCow.class, xo.a);
		a.put(EntityHorse.class, xo.a);
		a.put(EntityMushroomCow.class, xo.a);
		a.put(EntityOcelot.class, xo.a);
		a.put(EntityPig.class, xo.a);
		a.put(EntityRabbit.class, xo.a);
		a.put(EntitySheep.class, xo.a);
		a.put(EntitySnowman.class, xo.a);
		a.put(EntitySquid.class, xo.c);
		a.put(EntityIronGolem.class, xo.a);
		a.put(EntityWolf.class, xo.a);
		a.put(EntityVillager.class, xo.a);
		a.put(EntityEnderDragon.class, xo.a);
		a.put(EntityWither.class, xo.a);
		a.put(EntityBlaze.class, xo.a);
		a.put(EntityCaveSpider.class, xo.a);
		a.put(EntityCreeper.class, xo.a);
		a.put(EntityEnderman.class, xo.a);
		a.put(EntityEndermite.class, xo.a);
		a.put(EntityGhast.class, xo.a);
		a.put(EntityGiantZombie.class, xo.a);
		a.put(EntityGuardian.class, xo.c);
		a.put(EntityMagmaCube.class, xo.a);
		a.put(EntityPigZombie.class, xo.a);
		a.put(EntitySilverfish.class, xo.a);
		a.put(EntitySkeleton.class, xo.a);
		a.put(EntitySlime.class, xo.a);
		a.put(EntitySpider.class, xo.a);
		a.put(EntityWitch.class, xo.a);
		a.put(EntityZombie.class, xo.a);
	}
}
