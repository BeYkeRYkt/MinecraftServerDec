package net.minecraft;

import com.google.common.base.Predicate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class aam extends zb {

	private static final Logger logger = LogManager.getLogger();
	private EntityInsentient b;
	private final Predicate<EntityLiving> predicate;
	private final Comparator<Entity> comparator;
	private EntityLiving e;
	private Class<EntityLiving> f;

	@SuppressWarnings("unchecked")
	public aam(EntityInsentient var1, Class<?> var2) {
		this.b = var1;
		this.f = (Class<EntityLiving>) var2;
		if (var1 instanceof EntityCreature) {
			logger.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
		}
		this.predicate = new Predicate<EntityLiving>() {
			@Override
			public boolean apply(EntityLiving entityLiving) {
				double var2 = f();
				if (entityLiving.aw()) {
					var2 *= 0.800000011920929D;
				}

				return entityLiving.ay() ? false : ((double) entityLiving.g(b) > var2 ? false : aaw.a(b, entityLiving, false, true));
			}
		};
		this.comparator = new Comparator<Entity>() {
			@Override
			public int compare(Entity entity1, Entity entity2) {
				double var3 = b.getDistanceSquared(entity1);
				double var5 = b.getDistanceSquared(entity2);
				return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
			}
		};
	}

	public boolean a() {
		double var1 = this.f();
		List<EntityLiving> list = this.b.world.a(this.f, this.b.getBoundingBox().grow(var1, 4.0D, var1), this.predicate);
		Collections.sort(list, this.comparator);
		if (list.isEmpty()) {
			return false;
		} else {
			this.e = list.get(0);
			return true;
		}
	}

	public boolean b() {
		EntityLiving var1 = this.b.u();
		if (var1 == null) {
			return false;
		} else if (!var1.isAlive()) {
			return false;
		} else {
			double var2 = this.f();
			return this.b.getDistanceSquared(var1) > var2 * var2 ? false : !(var1 instanceof EntityPlayer) || !((EntityPlayer) var1).playerInteractManager.isCreative();
		}
	}

	public void c() {
		this.b.d(this.e);
		super.c();
	}

	public void d() {
		this.b.d((EntityLiving) null);
		super.c();
	}

	protected double f() {
		AttributeInstance var1 = this.b.a(afs.b);
		return var1 == null ? 16.0D : var1.e();
	}

}
