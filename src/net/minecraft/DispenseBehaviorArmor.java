package net.minecraft;

import com.google.common.base.Predicates;
import java.util.List;

final class DispenseBehaviorArmor extends DispenseBehaviorItem {

	protected ItemStack b(ISourceBlock var1, ItemStack var2) {
		Position var3 = var1.d().getRelative(BlockDispenser.b(var1.f()));
		int var4 = var3.getX();
		int var5 = var3.getY();
		int var6 = var3.getZ();
		AxisAlignedBB var7 = new AxisAlignedBB((double) var4, (double) var5, (double) var6, (double) (var4 + 1), (double) (var5 + 1), (double) (var6 + 1));
		List var8 = var1.i().a(EntityLiving.class, var7, Predicates.and(EntityPredicates.notSpectators, new xj(var2)));
		if (var8.size() > 0) {
			EntityLiving var9 = (EntityLiving) var8.get(0);
			int var10 = var9 instanceof EntityHuman ? 1 : 0;
			int var11 = EntityInsentient.c(var2);
			ItemStack var12 = var2.getCopy();
			var12.amount = 1;
			var9.setArmor(var11 - var10, var12);
			if (var9 instanceof EntityInsentient) {
				((EntityInsentient) var9).a(var11, 2.0F);
			}

			--var2.amount;
			return var2;
		} else {
			return super.b(var1, var2);
		}
	}
}
