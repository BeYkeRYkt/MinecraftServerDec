package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PathfinderGoalNearestAttackableTarget extends aaw {

	protected final Class a;
	private final int g;
	protected final Comparator<Entity> b;
	protected Predicate c;
	protected EntityLiving d;

	public PathfinderGoalNearestAttackableTarget(EntityCreature var1, Class var2, boolean var3) {
		this(var1, var2, var3, false);
	}

	public PathfinderGoalNearestAttackableTarget(EntityCreature var1, Class var2, boolean var3, boolean var4) {
		this(var1, var2, 10, var3, var4, (Predicate) null);
	}

	public PathfinderGoalNearestAttackableTarget(final EntityCreature var1, Class var2, int var3, boolean var4, boolean var5, Predicate var6) {
		super(var1, var4, var5);
		this.a = var2;
		this.g = var3;
		this.b = new Comparator<Entity>() {
			@Override
			public int compare(Entity entity1, Entity entity2) {
				double var3 = var1.getDistanceSquared(entity1);
				double var5 = var1.getDistanceSquared(entity2);
				return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
			}
		};
		this.a(1);
		this.c = new aar(this, var6);
	}

	public boolean a() {
		if (this.g > 0 && this.e.bb().nextInt(this.g) != 0) {
			return false;
		} else {
			double var1 = this.f();
			List var3 = this.e.world.getEntititesInAABB(this.a, this.e.getBoundingBox().grow(var1, 4.0D, var1), Predicates.and(this.c, EntityPredicates.notSpectators));
			Collections.sort(var3, this.b);
			if (var3.isEmpty()) {
				return false;
			} else {
				this.d = (EntityLiving) var3.get(0);
				return true;
			}
		}
	}

	public void c() {
		this.e.d(this.d);
		super.c();
	}
}
