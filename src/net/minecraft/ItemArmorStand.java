package net.minecraft;

import java.util.List;
import java.util.Random;

public class ItemArmorStand extends Item {

	public ItemArmorStand() {
		this.setCreativeModeTab(CreativeModeTab.DECORATIONS);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var5 == BlockFace.DOWN) {
			return false;
		} else {
			boolean var9 = var3.getBlockState(var4).getBlock().f(var3, var4);
			Position var10 = var9 ? var4 : var4.a(var5);
			if (!var2.a(var10, var5, var1)) {
				return false;
			} else {
				Position var11 = var10.a();
				boolean var12 = !var3.d(var10) && !var3.getBlockState(var10).getBlock().f(var3, var10);
				var12 |= !var3.d(var11) && !var3.getBlockState(var11).getBlock().f(var3, var11);
				if (var12) {
					return false;
				} else {
					double var13 = (double) var10.getX();
					double var15 = (double) var10.getY();
					double var17 = (double) var10.getZ();
					List var19 = var3.b((Entity) null, AxisAlignedBB.a(var13, var15, var17, var13 + 1.0D, var15 + 2.0D, var17 + 1.0D));
					if (var19.size() > 0) {
						return false;
					} else {
						if (!var3.isStatic) {
							var3.g(var10);
							var3.g(var11);
							EntityArmorStand var20 = new EntityArmorStand(var3, var13 + 0.5D, var15, var17 + 0.5D);
							float var21 = (float) MathHelper.d((MathHelper.g(var2.yaw - 180.0F) + 22.5F) / 45.0F) * 45.0F;
							var20.setPositionRotation(var13 + 0.5D, var15, var17 + 0.5D, var21, 0.0F);
							this.a(var20, var3.s);
							NBTCompoundTag var22 = var1.getTag();
							if (var22 != null && var22.isTagAssignableFrom("EntityTag", 10)) {
								NBTCompoundTag var23 = new NBTCompoundTag();
								var20.writeIfNoPassenger(var23);
								var23.copyFrom(var22.getCompound("EntityTag"));
								var20.load(var23);
							}

							var3.addEntity((Entity) var20);
						}

						--var1.amount;
						return true;
					}
				}
			}
		}
	}

	private void a(EntityArmorStand var1, Random var2) {
		fa var3 = var1.s();
		float var5 = var2.nextFloat() * 5.0F;
		float var6 = var2.nextFloat() * 20.0F - 10.0F;
		fa var4 = new fa(var3.b() + var5, var3.c() + var6, var3.d());
		var1.a(var4);
		var3 = var1.t();
		var5 = var2.nextFloat() * 10.0F - 5.0F;
		var4 = new fa(var3.b(), var3.c() + var5, var3.d());
		var1.b(var4);
	}
}
