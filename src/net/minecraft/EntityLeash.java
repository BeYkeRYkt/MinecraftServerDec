package net.minecraft;

import java.util.Iterator;
import java.util.List;

public class EntityLeash extends adj {

	public EntityLeash(World var1) {
		super(var1);
	}

	public EntityLeash(World var1, Position var2) {
		super(var1, var2);
		this.b((double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D);
		float var3 = 0.125F;
		float var4 = 0.1875F;
		float var5 = 0.25F;
		this.a(new AxisAlignedBB(this.locationX - 0.1875D, this.locationY - 0.25D + 0.125D, this.locationZ - 0.1875D, this.locationX + 0.1875D, this.locationY + 0.25D + 0.125D, this.locationZ + 0.1875D));
	}

	protected void h() {
		super.h();
	}

	public void a(BlockFace var1) {
	}

	public int l() {
		return 9;
	}

	public int m() {
		return 9;
	}

	public float aR() {
		return -0.0625F;
	}

	public void b(Entity var1) {
	}

	public boolean d(NBTCompoundTag var1) {
		return false;
	}

	public void b(NBTCompoundTag var1) {
	}

	public void a(NBTCompoundTag var1) {
	}

	public boolean e(EntityHuman var1) {
		ItemStack var2 = var1.bz();
		boolean var3 = false;
		double var4;
		List var6;
		Iterator var7;
		EntityInsentient var8;
		if (var2 != null && var2.getItem() == Items.LEAD && !this.o.D) {
			var4 = 7.0D;
			var6 = this.o.a(EntityInsentient.class, new AxisAlignedBB(this.locationX - var4, this.locationY - var4, this.locationZ - var4, this.locationX + var4, this.locationY + var4, this.locationZ + var4));
			var7 = var6.iterator();

			while (var7.hasNext()) {
				var8 = (EntityInsentient) var7.next();
				if (var8.cb() && var8.cc() == var1) {
					var8.a(this, true);
					var3 = true;
				}
			}
		}

		if (!this.o.D && !var3) {
			this.J();
			if (var1.by.instabuild) {
				var4 = 7.0D;
				var6 = this.o.a(EntityInsentient.class, new AxisAlignedBB(this.locationX - var4, this.locationY - var4, this.locationZ - var4, this.locationX + var4, this.locationY + var4, this.locationZ + var4));
				var7 = var6.iterator();

				while (var7.hasNext()) {
					var8 = (EntityInsentient) var7.next();
					if (var8.cb() && var8.cc() == this) {
						var8.a(true, false);
					}
				}
			}
		}

		return true;
	}

	public boolean j() {
		return this.o.p(this.a).getBlock() instanceof BlockFence;
	}

	public static EntityLeash a(World var0, Position var1) {
		EntityLeash var2 = new EntityLeash(var0, var1);
		var2.n = true;
		var0.d((Entity) var2);
		return var2;
	}

	public static EntityLeash b(World var0, Position var1) {
		int var2 = var1.getX();
		int var3 = var1.getY();
		int var4 = var1.getZ();
		List var5 = var0.a(EntityLeash.class, new AxisAlignedBB((double) var2 - 1.0D, (double) var3 - 1.0D, (double) var4 - 1.0D, (double) var2 + 1.0D, (double) var3 + 1.0D, (double) var4 + 1.0D));
		Iterator var6 = var5.iterator();

		EntityLeash var7;
		do {
			if (!var6.hasNext()) {
				return null;
			}

			var7 = (EntityLeash) var6.next();
		} while (!var7.getPosition().equals(var1));

		return var7;
	}
}
