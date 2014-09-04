package net.minecraft;

import com.google.common.base.Predicate;

public final class EntityPredicates {

	public static final Predicate<Entity> a = new Predicate<Entity>() {
		@Override
		public boolean apply(Entity entity) {
			return entity.ai();
		}
	};
	public static final Predicate<Entity> b = new Predicate<Entity>() {
		@Override
		public boolean apply(Entity entity) {
			return entity.ai() && entity.l == null && entity.m == null;
		}
	};
	public static final Predicate<Entity> c = new Predicate<Entity>() {
		@Override
		public boolean apply(Entity entity) {
			return entity instanceof vq && entity.ai();
		}
	};
	public static final Predicate<Entity> d = new Predicate<Entity>() {
		@Override
		public boolean apply(Entity entity) {
			return !(entity instanceof ahd) || !((ahd) entity).v();
		}
	};

}
