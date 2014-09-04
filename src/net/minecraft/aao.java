package net.minecraft;

import com.google.common.base.Predicate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class aao extends zb {

	private static final Logger a = LogManager.getLogger();
	private xn b;
	private final Predicate c;
	private final Comparator<Entity> d;
	private EntityLiving e;

	public aao(xn var1) {
		this.b = var1;
		if (var1 instanceof EntityCreature) {
			a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
		}

		this.c = new aap(this);
		this.d = new Comparator<Entity>() {
			@Override
			public int compare(Entity entity1, Entity entity2) {
				double var3 = b.h(entity1);
				double var5 = b.h(entity2);
				return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
			}
		};
	}

	public boolean a() {
		double var1 = this.f();
		List var3 = this.b.o.a(ahd.class, this.b.aQ().b(var1, 4.0D, var1), this.c);
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
		} else if (!var1.ai()) {
			return false;
		} else {
			bsf var2 = this.b.bN();
			bsf var3 = var1.bN();
			if (var2 != null && var3 == var2) {
				return false;
			} else {
				double var4 = this.f();
				return this.b.h(var1) > var4 * var4 ? false : !(var1 instanceof EntityPlayer) || !((EntityPlayer) var1).c.d();
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
		xz var1 = this.b.a(afs.b);
		return var1 == null ? 16.0D : var1.e();
	}

	// $FF: synthetic method
	static xn a(aao var0) {
		return var0.b;
	}

}
