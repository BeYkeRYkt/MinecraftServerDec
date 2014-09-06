package net.minecraft;

import java.util.List;

public class ajw extends Item {

	public ajw() {
		this.maxStackSize = 1;
		this.setCreativeModeTab(CreativeModeTab.TRANSPORTATION);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		float var4 = 1.0F;
		float var5 = var3.B + (var3.pitch - var3.B) * var4;
		float var6 = var3.A + (var3.yaw - var3.A) * var4;
		double var7 = var3.p + (var3.locationX - var3.p) * (double) var4;
		double var9 = var3.q + (var3.locationY - var3.q) * (double) var4 + (double) var3.aR();
		double var11 = var3.r + (var3.locationZ - var3.r) * (double) var4;
		Vec3D var13 = new Vec3D(var7, var9, var11);
		float var14 = DataTypesConverter.b(-var6 * 0.017453292F - 3.1415927F);
		float var15 = DataTypesConverter.a(-var6 * 0.017453292F - 3.1415927F);
		float var16 = -DataTypesConverter.b(-var5 * 0.017453292F);
		float var17 = DataTypesConverter.a(-var5 * 0.017453292F);
		float var18 = var15 * var16;
		float var20 = var14 * var16;
		double var21 = 5.0D;
		Vec3D var23 = var13.b((double) var18 * var21, (double) var17 * var21, (double) var20 * var21);
		bru var24 = var2.a(var13, var23, true);
		if (var24 == null) {
			return var1;
		} else {
			Vec3D var25 = var3.d(var4);
			boolean var26 = false;
			float var27 = 1.0F;
			List var28 = var2.b((Entity) var3, var3.aQ().a(var25.x * var21, var25.y * var21, var25.z * var21).b((double) var27, (double) var27, (double) var27));

			for (int var29 = 0; var29 < var28.size(); ++var29) {
				Entity var30 = (Entity) var28.get(var29);
				if (var30.ad()) {
					float var31 = var30.ao();
					brt var32 = var30.aQ().b((double) var31, (double) var31, (double) var31);
					if (var32.a(var13)) {
						var26 = true;
					}
				}
			}

			if (var26) {
				return var1;
			} else {
				if (var24.a == brv.b) {
					Position var33 = var24.a();
					if (var2.p(var33).getBlock() == Blocks.SNOW_LAYER) {
						var33 = var33.b();
					}

					EntityBoat var34 = new EntityBoat(var2, (double) ((float) var33.getX() + 0.5F), (double) ((float) var33.getY() + 1.0F), (double) ((float) var33.getZ() + 0.5F));
					var34.yaw = (float) (((DataTypesConverter.toFixedPointInt((double) (var3.yaw * 4.0F / 360.0F) + 0.5D) & 3) - 1) * 90);
					if (!var2.a((Entity) var34, var34.aQ().b(-0.1D, -0.1D, -0.1D)).isEmpty()) {
						return var1;
					}

					if (!var2.D) {
						var2.d((Entity) var34);
					}

					if (!var3.by.instabuild) {
						--var1.b;
					}

					var3.b(StatisticList.J[Item.getId((Item) this)]);
				}

				return var1;
			}
		}
	}
}
