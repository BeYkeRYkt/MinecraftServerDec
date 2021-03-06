package net.minecraft;

import net.minecraft.util.com.mojang.authlib.GameProfile;
import java.util.UUID;

public class ItemSkull extends Item {

	private static final String[] a = new String[] { "skeleton", "wither", "zombie", "char", "creeper" };

	public ItemSkull() {
		this.setCreativeModeTab(CreativeModeTab.DECORATIONS);
		this.setDurability(0);
		this.a(true);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		if (var5 == BlockFace.DOWN) {
			return false;
		} else {
			IBlockState var9 = var3.getBlockState(var4);
			Block var10 = var9.getBlock();
			boolean var11 = var10.f(var3, var4);
			if (!var11) {
				if (!var3.getBlockState(var4).getBlock().getMaterial().isBuildable()) {
					return false;
				}

				var4 = var4.getRelative(var5);
			}

			if (!var2.a(var4, var5, var1)) {
				return false;
			} else if (!Blocks.SKULL.c(var3, var4)) {
				return false;
			} else {
				if (!var3.isStatic) {
					var3.setBlockAt(var4, Blocks.SKULL.getBlockState().a(BlockSkull.a, var5), 3);
					int var12 = 0;
					if (var5 == BlockFace.UP) {
						var12 = MathHelper.toFixedPointInt((double) (var2.yaw * 16.0F / 360.0F) + 0.5D) & 15;
					}

					TileEntity var13 = var3.getTileEntity(var4);
					if (var13 instanceof TileEntitySkull) {
						TileEntitySkull var14 = (TileEntitySkull) var13;
						if (var1.getWearout() == 3) {
							GameProfile var15 = null;
							if (var1.hasTag()) {
								NBTCompoundTag var16 = var1.getTag();
								if (var16.isTagAssignableFrom("SkullOwner", 10)) {
									var15 = GameProfileSerializer.deserialize(var16.getCompound("SkullOwner"));
								} else if (var16.isTagAssignableFrom("SkullOwner", 8) && var16.getString("SkullOwner").length() > 0) {
									var15 = new GameProfile((UUID) null, var16.getString("SkullOwner"));
								}
							}

							var14.setGameProfile(var15);
						} else {
							var14.setSkullType(var1.getWearout());
						}

						var14.setRotation(var12);
						Blocks.SKULL.a(var3, var4, var14);
					}

					--var1.amount;
				}

				return true;
			}
		}
	}

	public int a(int var1) {
		return var1;
	}

	public String getName(ItemStack var1) {
		int var2 = var1.getWearout();
		if (var2 < 0 || var2 >= a.length) {
			var2 = 0;
		}

		return super.getName() + "." + a[var2];
	}

	public String a(ItemStack var1) {
		if (var1.getWearout() == 3 && var1.hasTag()) {
			if (var1.getTag().isTagAssignableFrom("SkullOwner", 8)) {
				return LocaleI18n.a("item.skull.player.name", new Object[] { var1.getTag().getString("SkullOwner") });
			}

			if (var1.getTag().isTagAssignableFrom("SkullOwner", 10)) {
				NBTCompoundTag var2 = var1.getTag().getCompound("SkullOwner");
				if (var2.isTagAssignableFrom("Name", 8)) {
					return LocaleI18n.a("item.skull.player.name", new Object[] { var2.getString("Name") });
				}
			}
		}

		return super.a(var1);
	}

	public boolean a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("SkullOwner", 8) && var1.getString("SkullOwner").length() > 0) {
			GameProfile var2 = new GameProfile((UUID) null, var1.getString("SkullOwner"));
			var2 = TileEntitySkull.fillGameProfile(var2);
			var1.put("SkullOwner", (NBTTag) GameProfileSerializer.serialize(new NBTCompoundTag(), var2));
			return true;
		} else {
			return false;
		}
	}

}
