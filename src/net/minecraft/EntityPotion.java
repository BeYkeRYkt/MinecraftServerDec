package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class EntityPotion extends ahr {

	private ItemStack c;

	public EntityPotion(World var1) {
		super(var1);
	}

	public EntityPotion(World var1, EntityLiving var2, int var3) {
		this(var1, var2, new ItemStack(Items.POTION, 1, var3));
	}

	public EntityPotion(World var1, EntityLiving var2, ItemStack var3) {
		super(var1, var2);
		this.c = var3;
	}

	public EntityPotion(World var1, double var2, double var4, double var6, ItemStack var8) {
		super(var1, var2, var4, var6);
		this.c = var8;
	}

	protected float m() {
		return 0.05F;
	}

	protected float j() {
		return 0.5F;
	}

	protected float l() {
		return -20.0F;
	}

	public void a(int var1) {
		if (this.c == null) {
			this.c = new ItemStack(Items.POTION, 1, 0);
		}

		this.c.setWearout(var1);
	}

	public int o() {
		if (this.c == null) {
			this.c = new ItemStack(Items.POTION, 1, 0);
		}

		return this.c.getWearout();
	}

	protected void a(MovingObjectPosition var1) {
		if (!this.world.isStatic) {
			List var2 = Items.POTION.h(this.c);
			if (var2 != null && !var2.isEmpty()) {
				AxisAlignedBB var3 = this.getBoundingBox().grow(4.0D, 2.0D, 4.0D);
				List var4 = this.world.getEntititesInAABB(EntityLiving.class, var3);
				if (!var4.isEmpty()) {
					Iterator var5 = var4.iterator();

					while (var5.hasNext()) {
						EntityLiving var6 = (EntityLiving) var5.next();
						double var7 = this.getDistanceSquared(var6);
						if (var7 < 16.0D) {
							double var9 = 1.0D - Math.sqrt(var7) / 4.0D;
							if (var6 == var1.entity) {
								var9 = 1.0D;
							}

							Iterator var11 = var2.iterator();

							while (var11.hasNext()) {
								MobEffect var12 = (MobEffect) var11.next();
								int var13 = var12.getId();
								if (MobEffectList.byId[var13].b()) {
									MobEffectList.byId[var13].a(this, this.n(), var6, var12.getAmplifier(), var9);
								} else {
									int var14 = (int) (var9 * (double) var12.getDuration() + 0.5D);
									if (var14 > 20) {
										var6.c(new MobEffect(var13, var14, var12.getAmplifier()));
									}
								}
							}
						}
					}
				}
			}

			this.world.triggerEffect(2002, new Position(this), this.o());
			this.die();
		}

	}

	public void readAdditionalData(NBTCompoundTag var1) {
		super.readAdditionalData(var1);
		if (var1.isTagAssignableFrom("Potion", 10)) {
			this.c = ItemStack.fromNBT(var1.getCompound("Potion"));
		} else {
			this.a(var1.getInt("potionValue"));
		}

		if (this.c == null) {
			this.die();
		}

	}

	public void writeAdditionalData(NBTCompoundTag var1) {
		super.writeAdditionalData(var1);
		if (this.c != null) {
			var1.put("Potion", (NBTTag) this.c.write(new NBTCompoundTag()));
		}

	}
}
