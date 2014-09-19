package net.minecraft;

import com.google.common.base.Predicate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class aao extends PathfinderGoal {

	private static final Logger a = LogManager.getLogger();
	private EntityInsentient b;
	private final Predicate c;
	private final Comparator<Entity> d;
	private EntityLiving e;

	public aao(EntityInsentient var1) {
		this.b = var1;
		if (var1 instanceof EntityCreature) {
			a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
		}

		this.c = new aap(this);
		this.d = new Comparator<Entity>() {
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
		List var3 = this.b.world.getEntititesInAABB(EntityHuman.class, this.b.getBoundingBox().grow(var1, 4.0D, var1), this.c);
		Collections.sort(var3, this.d);
		if (var3.isEmpty()) {
			return false;
		} else {
			this.e = (EntityLiving) var3.get(0);
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
			ScoreboardTeamBase var2 = this.b.bN();
			ScoreboardTeamBase var3 = var1.bN();
			if (var2 != null && var3 == var2) {
				return false;
			} else {
				double var4 = this.f();
				return this.b.getDistanceSquared(var1) > var4 * var4 ? false : !(var1 instanceof EntityPlayer) || !((EntityPlayer) var1).playerInteractManager.isCreative();
			}
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

	// $FF: synthetic method
	static EntityInsentient a(aao var0) {
		return var0.b;
	}

}
