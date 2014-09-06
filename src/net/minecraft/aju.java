package net.minecraft;

public class aju extends Item {

	protected final Block a;

	public aju(Block var1) {
		this.a = var1;
	}

	public aju b(String var1) {
		super.c(var1);
		return this;
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
		bec var9 = var3.p(var4);
		Block var10 = var9.getBlock();
		if (var10 == Blocks.aH && ((Integer) var9.b(BlockSnow.a)).intValue() < 1) {
			var5 = PaintingDirection.b;
		} else if (!var10.f(var3, var4)) {
			var4 = var4.a(var5);
		}

		if (var1.b == 0) {
			return false;
		} else if (!var2.a(var4, var5, var1)) {
			return false;
		} else if (var4.getY() == 255 && this.a.r().isBuildable()) {
			return false;
		} else if (var3.a(this.a, var4, false, var5, (Entity) null, var1)) {
			int var11 = this.a(var1.i());
			bec var12 = this.a.a(var3, var4, var5, var6, var7, var8, var11, var2);
			if (var3.a(var4, var12, 3)) {
				var12 = var3.p(var4);
				if (var12.getBlock() == this.a) {
					a(var3, var4, var1);
					this.a.a(var3, var4, var12, (EntityLiving) var2, var1);
				}

				var3.a((double) ((float) var4.getX() + 0.5F), (double) ((float) var4.getY() + 0.5F), (double) ((float) var4.getZ() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
				--var1.b;
			}

			return true;
		} else {
			return false;
		}
	}

	public static boolean a(World var0, Position var1, ItemStack var2) {
		if (var2.hasTag() && var2.getTag().isTagAssignableFrom("BlockEntityTag", 10)) {
			TileEntity var3 = var0.s(var1);
			if (var3 != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				NBTCompoundTag var5 = (NBTCompoundTag) var4.getCopy();
				var3.write(var4);
				NBTCompoundTag var6 = (NBTCompoundTag) var2.getTag().getTag("BlockEntityTag");
				var4.copyFrom(var6);
				var4.put("x", var1.getX());
				var4.put("y", var1.getY());
				var4.put("z", var1.getZ());
				if (!var4.equals(var5)) {
					var3.read(var4);
					var3.o_();
					return true;
				}
			}
		}

		return false;
	}

	public String e_(ItemStack var1) {
		return this.a.a();
	}

	public String a() {
		return this.a.a();
	}

	public Block d() {
		return this.a;
	}

	// $FF: synthetic method
	public Item c(String var1) {
		return this.b(var1);
	}
}
