package net.minecraft;

import com.google.common.base.Predicate;

public final class EntityPredicates {

	public static final Predicate<Entity> a = new Predicate<Entity>() {
		@Override
		public boolean apply(Entity entity) {
			return entity.isAlive();
		}
	};
	public static final Predicate<Entity> b = new Predicate<Entity>() {
		@Override
		public boolean apply(Entity entity) {
			return entity.isAlive() && entity.passenger == null && entity.vehicle == null;
		}
	};
	public static final Predicate<Entity> c = new Predicate<Entity>() {
		@Override
		public boolean apply(Entity entity) {
			return entity instanceof IInventory && entity.isAlive();
		}
	};
	public static final Predicate<Entity> notSpectators = new Predicate<Entity>() {
		@Override
		public boolean apply(Entity entity) {
			return !(entity instanceof EntityHuman) || !((EntityHuman) entity).isSpectator();
		}
	};

}
